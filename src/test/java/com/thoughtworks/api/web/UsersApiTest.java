package com.thoughtworks.api.web;

import com.thoughtworks.api.support.ApiSupport;
import com.thoughtworks.api.support.ApiTestRunner;
import com.thoughtworks.api.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class UsersApiTest extends ApiSupport {

  @Test
  public void should_return_201_when_post_user_with_parameters() {
    Map<String, Object> info = TestHelper.userMap();

    Response post = post("users", info);

    assertThat(post.getStatus(), is(201));
  }

  @Test
  public void should_return_400_when_post_with_invalid_parameters() {
    Map<String, Object> info = TestHelper.userMap();
    info.replace("name", null);

    Response post = post("users", info);

    assertThat(post.getStatus(), is(400));
  }
}
