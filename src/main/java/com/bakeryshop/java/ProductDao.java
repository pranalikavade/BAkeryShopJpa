package com.bakeryshop.java;
import com.bakeryshop.entity.Product;
import org.hibernate.*;
import java.util.List;

public class ProductDao {
  private SessionFactory factory;
  public ProductDao(SessionFactory f){this.factory=f;}
  public void save(Product p){ Session s=factory.openSession(); Transaction tx=s.beginTransaction(); s.persist(p); tx.commit(); s.close(); }
  public Product find(Long id){ Session s=factory.openSession(); Product p=s.get(Product.class,id); s.close(); return p;}
  public List<Product> listAll(){ Session s=factory.openSession(); List<Product> list=s.createQuery("from Product",Product.class).list(); s.close(); return list;}
}
