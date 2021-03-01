package com.smec.template.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smec.template.controller.v1.api.StudentController;
import com.smec.template.util.Token;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.smec.template.util.Token.getToken;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentControllerTest {

    @Autowired
    StudentController controller;

    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    private ObjectMapper mapper=new ObjectMapper();


    @Test
    public void getStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.
                get("/v1/students")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .param("page","0")
                .param("size","2")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("Authorization","Basic "+getToken("test01")))
                .andExpect(MockMvcResultMatchers.status().isOk())//预期结果
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))// 预期返回值的媒体类型text/plain;charset=UTF-8
                .andReturn();
    }
}
