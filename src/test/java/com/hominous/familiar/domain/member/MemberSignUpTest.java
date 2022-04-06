package com.hominous.familiar.domain.member;


import com.hominous.familiar.domain.member.presentation.MemberSignupController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
