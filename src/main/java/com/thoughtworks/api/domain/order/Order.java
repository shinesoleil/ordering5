package com.thoughtworks.api.domain.order;

import com.thoughtworks.api.infrastructure.records.Record;
import com.thoughtworks.api.web.jersey.Routes;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order implements Record{
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

  @Override
  public Map<String, Object> toRefJson(Routes routes) {
    return new HashMap<String, Object>() {{
      put("uri", "orders/" + getId());
      put("name", getName());
      put("address", getAddress());
      put("phone", getPhone());
      put("created_at", getTime());
    }};
  }

  @Override
  public Map<String, Object> toJson(Routes routes) {
    return null;
  }
}
