package com.bakeryshop.entity;
import jakarta.persistence.*;
import java.util.*;

@Entity @Table(name="orders")
public class Order {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @ManyToOne @JoinColumn(nullable=false)
  private Customer customer;
  @OneToMany(mappedBy="order",cascade=CascadeType.ALL)
  private List<OrderItem> items = new ArrayList<>();
  private Date created = new Date();

  public Order() {}
  public Order(Customer cust){this.customer=cust;}
  public Long getId(){return id;} public Customer getCustomer(){return customer;}
  public Date getCreated(){return created;} public List<OrderItem> getItems(){return items;}
  public void addItem(OrderItem it){ items.add(it); it.setOrder(this);}
  @Override public String toString(){return "Order "+id+" for "+customer.getName()+" ("+items.size()+" items)";}
}
