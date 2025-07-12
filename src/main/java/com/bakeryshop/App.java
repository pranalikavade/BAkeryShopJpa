package com.bakeryshop;
import com.bakeryshop.service.BakeryService;
import com.bakeryshop.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class App {
  private static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    SessionFactory sf = new Configuration().configure().buildSessionFactory();
    BakeryService svc = new BakeryService(sf);
    while(true){
      System.out.println("\n1) Add prod 2) List prods 3) Add cust 4) List custs 5) Create order 6) List orders 0) Exit");
      System.out.print("> "); int opt = sc.nextInt(); sc.nextLine();
      switch(opt){
        case 1:
          System.out.print("Name: "); String pname=sc.nextLine();
          System.out.print("Price: "); double price=sc.nextDouble(); sc.nextLine();
          System.out.println("=> " + svc.addProduct(pname,price));
          break;
        case 2:
          svc.listProducts().forEach(System.out::println); break;
        case 3:
          System.out.print("Customer name: "); String cname=sc.nextLine();
          System.out.println("=> " + svc.addCustomer(cname)); break;
        case 4:
          svc.listCustomers().forEach(System.out::println); break;
        case 5:
          svc.listCustomers().forEach(System.out::println);
          System.out.print("Customer ID: "); Long cid=sc.nextLong();
          svc.listProducts().forEach(System.out::println);
          System.out.print("Product IDs (comma): ");
          String[] parts = sc.next().split(",");
          List<Long> pids = new ArrayList<>(); List<Integer> qtys = new ArrayList<>();
          for(String s:parts){
            System.out.print("Qty for product "+s+": ");
            pids.add(Long.valueOf(s)); qtys.add(sc.nextInt());
          }
          Order o = svc.createOrder(cid,pids,qtys);
          System.out.println("Created "+o);
          break;
        case 6:
          svc.listOrders().forEach(System.out::println);
          break;
        case 0:
          sf.close(); System.out.println("Bye!"); return;
      }
    }
  }
}
