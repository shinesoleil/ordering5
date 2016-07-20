package com.thoughtworks.api.domain.order;

import java.util.Date;
import java.util.List;

public class Order {
  private long id;
  private long userId;
  private String name;
  private String address;
  private String phone;
  private Date time;
  private List<OrderItem> orderItemList;

  public Order() {
  }

  public Order(long id, long userId, String name, String address, String phone, Date time, List<OrderItem> orderItemList) {
    this.id = id;
    this.userId = userId;
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.time = time;
    this.orderItemList = orderItemList;
  }

  public long getId() {
    return id;
  }

  public long getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public Date getTime() {
    return time;
  }

  public List<OrderItem> getOrderItemList() {
    return orderItemList;
  }
}
