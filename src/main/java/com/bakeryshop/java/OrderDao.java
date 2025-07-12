package com.bakeryshop.java;
import com.bakeryshop.entity.Order;
import org.hibernate.*;
import java.util.List;

public class OrderDao {
  private SessionFactory factory;
  public OrderDao(SessionFactory f){this.factory=f;}
  public void save(Order o){ Session s=factory.openSession(); Transaction tx=s.beginTransaction(); s.persist(o); tx.commit(); s.close(); }
  public Order find(Long id){ Session s=factory.openSession(); Order o=s.get(Order.class,id); s.close(); return o;}
  public List<Order> listAll(){ Session s=factory.openSession(); List<Order> list=s.createQuery("from Order",Order.class).list(); s.close(); return list;}
}
