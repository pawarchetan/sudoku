package com.example.sudoku;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SudokuApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnDefaultBoard() throws Exception {
        this.mockMvc.perform(get("/board"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[" +
                        "[5,3,0,0,7,0,0,0,0]," +
                        "[6,0,0,1,9,5,0,0,0]," +
                        "[0,9,8,0,0,0,0,6,0]," +
                        "[8,0,0,0,6,0,0,0,3]," +
                        "[4,0,0,8,0,3,0,0,1]," +
                        "[7,0,0,0,2,0,0,0,6]," +
                        "[0,6,0,0,0,0,2,8,0]," +
                        "[0,0,0,4,1,9,0,0,5]," +
                        "[0,0,0,0,8,0,0,7,9]" +
                        "]"));
    }

    @Test
    void boardShouldBeValid() throws Exception{

        this.mockMvc.perform(
                post("/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[" +
                                "[5,3,0,0,7,0,0,0,0]," +
                                "[6,0,0,1,9,5,0,0,0]," +
                                "[0,9,8,0,0,0,0,6,0]," +
                                "[8,0,0,0,6,0,0,0,3]," +
                                "[4,0,0,8,0,3,0,0,1]," +
                                "[7,0,0,0,2,0,0,0,6]," +
                                "[0,6,0,0,0,0,2,8,0]," +
                                "[0,0,0,4,1,9,0,0,5]," +
                                "[0,0,0,0,8,0,0,7,9]" +
                                "]")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void boardShouldBeInvalid() throws Exception{

        this.mockMvc.perform(
                        post("/board")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("[" +
                                        "[3,3,0,0,7,0,0,0,0]," +
                                        "[6,0,0,1,9,5,0,0,0]," +
                                        "[0,9,8,0,0,0,0,6,0]," +
                                        "[8,0,0,0,6,0,0,0,3]," +
                                        "[4,0,0,8,0,3,0,0,1]," +
                                        "[7,0,0,0,2,0,0,0,6]," +
                                        "[0,6,0,0,0,0,2,8,0]," +
                                        "[0,0,0,4,1,9,0,0,5]," +
                                        "[0,0,0,0,8,0,0,7,9]" +
                                        "]")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

}
