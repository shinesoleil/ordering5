package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.user.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Path("users")
public class UsersApi {

  @Inject
  UserRepository userRepository;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createUser(HashMap<String, Object> info) {
    userRepository.create(info);

    long id = Long.valueOf(String.valueOf(info.get("id")));
    userRepository.findById(id);

    return Response.status(201).build();
  }
}
