package com.gwegwe.springboot.sample;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
// WebMvc slice 테스트로, SmapleController만 테스트 한다. 기타 잡다한 빈설정 하나도 안해서 좀더 빠름
@WebMvcTest(SampleController.class)
public class SliceWebMvcTest {

  @Rule
  public OutputCapture outputCapture = new OutputCapture();

  @MockBean
  SampleService mockSampleService;

  @Autowired
  MockMvc mockMvc;

  @Test
  public void hello() throws Exception {
    when(mockSampleService.getName()).thenReturn(" ted");

    mockMvc.perform(get("/hello"))
        .andExpect(status().isOk())
        .andExpect(content().string("hello ted"))
        .andDo(print());
  }
}
