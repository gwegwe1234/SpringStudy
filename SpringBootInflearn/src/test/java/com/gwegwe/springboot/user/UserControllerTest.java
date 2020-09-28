package com.gwegwe.springboot.user;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  public void hello() throws Exception {
    mockMvc.perform(get("/helloUser"))
        .andExpect(status().isOk())
        .andExpect(content().string("hello"));
  }

  @Test
  public void createUser_JSON() throws Exception {
    User user = new User();
    user.setUsername("biglight");
    String jsonUser = objectMapper.writeValueAsString(user);

    mockMvc.perform(post("/users/create")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON_VALUE)
        .content(jsonUser))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.username", is(equalTo("biglight"))));
  }

  // contentnegotiation 에서 accept를 보고 맞는 view 를 설정해 준다.
  // 없으면 형식보고 찾아준다.. 아마도?
  @Test
  public void createUser_XML() throws Exception {
    User user = new User();
    user.setUsername("biglight");
    String jsonUser = objectMapper.writeValueAsString(user);

    mockMvc.perform(post("/users/create")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_XML)
        .content(jsonUser))
        .andExpect(status().isOk())
        .andExpect(xpath("/User/username").string("biglight"));
  }
}
