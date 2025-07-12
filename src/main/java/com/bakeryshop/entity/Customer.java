package com.bakeryshop.entity;
import jakarta.persistence.*;
import java.util.*;

@Entity @Table(name="customers")
public class Customer {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(nullable=false) private String name;
  @OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
  private List<Order> orders = new ArrayList<>();

  public Customer() {} public Customer(String name){this.name=name;}
  public Long getId(){return id;} public String getName(){return name;}
  public void setName(String n){name=n;} public List<Order> getOrders(){return orders;}
  @Override public String toString(){return id+": "+name;}
}
