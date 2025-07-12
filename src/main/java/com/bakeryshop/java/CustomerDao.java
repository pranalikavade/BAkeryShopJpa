package com.bakeryshop.java;
import com.bakeryshop.entity.Customer;
import org.hibernate.*;
import java.util.List;

public class CustomerDao {
  private SessionFactory factory;
  public CustomerDao(SessionFactory f){this.factory=f;}
  public void save(Customer c){ Session s=factory.openSession(); Transaction tx=s.beginTransaction(); s.persist(c); tx.commit(); s.close(); }
  public Customer find(Long id){ Session s=factory.openSession(); Customer c=s.get(Customer.class,id); s.close(); return c;}
  public List<Customer> listAll(){ Session s=factory.openSession(); List<Customer> list=s.createQuery("from Customer",Customer.class).list(); s.close(); return list;}
}
