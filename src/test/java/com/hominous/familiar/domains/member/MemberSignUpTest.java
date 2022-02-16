package com.hominous.familiar.domains.member;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hominous.familiar.domains.member.application.dto.MemberSignUpDto;
import com.hominous.familiar.domains.member.presentation.MemberSignupController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MemberSignupController.class)
//@AutoConfigureMockMvc
public class MemberSignUpTest {

  @Test
  public void hello(){
    System.out.println("hello world");
  }
//  @Autowired
//  private MockMvc mockMvc;
//
//  @Test
//  public void MemberSignUp_실패() throws Exception {
//    String json = "{\n" +
//        "    \"memberId\": \"nsg2318\",\n" +
//        "    \"password\": \"sunbaPassword\",\n" +
//        "    \"passwordCheck\": \"sunbaPasswordCheck\",\n" +
//        "    \"name\": \"남선기\",\n" +
//        "    \"birthdate\": \"19930914\"\n" +
//        "}";
//    ObjectMapper objectMapper = new ObjectMapper();
//    MemberSignUpDto memberSignUpDto = objectMapper.readValue(json, MemberSignUpDto.class);
//    mockMvc.perform(post("/member")
//            .content(json)
//            .contentType(MediaType.APPLICATION_JSON))
//        .andExpect(status().is4xxClientError());
//
//  }

}
