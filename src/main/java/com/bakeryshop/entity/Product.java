package com.bakeryshop.entity;
import jakarta.persistence.*;

@Entity @Table(name="products")
public class Product {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(nullable=false) private String name;
  private double price;

  public Product() {}
  public Product(String name,double price){this.name=name;this.price=price;}
  public Long getId(){return id;} public String getName(){return name;}
  public void setName(String n){name=n;} public double getPrice(){return price;}
  public void setPrice(double p){price=p;}
  @Override public String toString(){return id+": "+name+" ($"+price+")";}
}
