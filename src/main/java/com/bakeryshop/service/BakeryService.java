package com.bakeryshop.service;
import com.bakeryshop.java.*;
import com.bakeryshop.entity.*;
import org.hibernate.SessionFactory;
import java.util.List;

public class BakeryService {
  private ProductDao pd; private CustomerDao cd; private OrderDao od;
  public BakeryService(SessionFactory sf){
    pd = new ProductDao(sf); cd = new CustomerDao(sf); od = new OrderDao(sf);
  }
  public Product addProduct(String name,double price){ Product p = new Product(name,price); pd.save(p); return p; }
  public Customer addCustomer(String name){ Customer c = new Customer(name); cd.save(c); return c; }
  public List<Product> listProducts(){ return pd.listAll(); }
  public List<Customer> listCustomers(){ return cd.listAll(); }
  public Order createOrder(Long custId,List<Long> prodIds,List<Integer> qtys){
    Customer c = cd.find(custId); Order o = new Order(c);
    for(int i=0;i<prodIds.size();i++){
      Product p = pd.find(prodIds.get(i));
      if(p!=null){ o.addItem(new OrderItem(p, qtys.get(i))); }
    }
    od.save(o); return o;
  }
  public List<Order> listOrders(){ return od.listAll(); }
}
