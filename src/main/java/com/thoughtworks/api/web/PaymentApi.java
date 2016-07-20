package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.order.Order;
import com.thoughtworks.api.domain.product.ProductRepository;
import com.thoughtworks.api.domain.user.User;
import com.thoughtworks.api.domain.user.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Path("users/{userId}/orders/{orderId}/payment")
public class PaymentApi {

  @Inject
  ProductRepository productRepository;

  @Inject
  UserRepository userRepository;


  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createPayment(HashMap<String, Object> info,
                                @PathParam("userId") long userId,
                                @PathParam("orderId") long orderId) {
    User user = userRepository.findById(userId).get();
    Order order = user.findOrderById(orderId).get();

    order.pay(info);
    if (order.findPaymentById(orderId).isPresent()) {
      return Response.status(201).build();
    } else {
      return Response.status(400).build();
    }

  }
}
