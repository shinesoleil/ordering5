package com.thoughtworks.api.domain.product;

public class Product {
  private long id;
  private String name;
  private String description;
  private double price;

  public Product() {
  }

  public Product(long id, String name, String description, double price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }
}
