package com.hominous.familiar.domain.member;


import com.hominous.familiar.domain.auth.controller.AuthController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AuthController.class)
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
//        "    \"memberId\": \"test0101\",\n" +
//        "    \"password\": \"test1234\",\n" +
//        "    \"passwordCheck\": \"sunbaPasswordCheck\",\n" +
//        "    \"name\": \"홍길동\",\n" +
//        "    \"birthdate\": \"19990909\"\n" +
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
