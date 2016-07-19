package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.product.ProductRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Path("products")
public class ProductsApi {

  @Context
  ProductRepository productRepository;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createProduct(HashMap<String, Object> info) {
    productRepository.create(info);
    long id = Long.valueOf(String.valueOf(info.get("id")));

    productRepository.findById(id);
    return Response.status(201).build();
  }
}
