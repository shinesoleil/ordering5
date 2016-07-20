package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.user.UserRepository;
import com.thoughtworks.api.web.exception.InvalidParameterException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Path("users")
public class UsersApi {

  @Inject
  UserRepository userRepository;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createUser(HashMap<String, Object> info) {
    List<String> invalidParamList = new ArrayList<>();
    if (info.get("name") == null) {
      invalidParamList.add("name");
    }
    if (invalidParamList.size() > 0) {
      throw new InvalidParameterException(invalidParamList);
    }

    userRepository.create(info);

    long id = Long.valueOf(String.valueOf(info.get("id")));
    userRepository.findById(id);

    return Response.status(201).build();
  }
}
