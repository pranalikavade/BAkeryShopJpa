package com.bakeryshop.entity;
import jakarta.persistence.*;

@Entity @Table(name="order_items")
public class OrderItem {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @ManyToOne @JoinColumn(nullable=false) private Order order;
  @ManyToOne @JoinColumn(nullable=false) private Product product;
  private int quantity;

  public OrderItem() {}
  public OrderItem(Product product,int qty){this.product=product;this.quantity=qty;}
  public Long getId(){return id;} public Order getOrder(){return order;}
  public void setOrder(Order o){order=o;} public Product getProduct(){return product;}
  public int getQuantity(){return quantity;}
  @Override public String toString(){return product.getName()+" x"+quantity;}
}
