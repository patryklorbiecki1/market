package com.example.market.controllers;

import com.example.market.dtos.response.CurrencyResponse;
import com.example.market.services.CurrencyService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureJsonTesters
@WebMvcTest(CurrencyController.class)
public class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CurrencyService currencyService;
    @Autowired
    private JacksonTester<CurrencyResponse> tester;
    @WithMockUser("spring")
    @Test
    public void retriveAllCurrencies() throws Exception {
        when(currencyService.getAll()).thenReturn(
                Arrays.asList(new CurrencyResponse("BLA",1,20),new CurrencyResponse("WA",12,20))
        );
        RequestBuilder builder = get("/currency/all")
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{name:BLA,price:1,capitalization:20},{name:WA,price:12,capitalization:20}]"))
                .andReturn();
    }
    @WithMockUser("spring")
    @Test
    public void retriveCurrencyByName() throws Exception{
        BDDMockito.given(currencyService.getByName("BTC")).willReturn(new CurrencyResponse("BTC",111,111));
        MockHttpServletResponse response = mockMvc.perform(
                get("/currency/BTC")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(tester.write(new CurrencyResponse("BTC",111,111)).getJson());
    }
    @WithMockUser("spring")
    @Test
    public void retriveCurrencyByNameWhenDoesNotExists() throws Exception{
        BDDMockito.given(currencyService.getByName("ETH")).willReturn(null);
        MockHttpServletResponse response = mockMvc.perform(
                get("/currency/ETH")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("");
    }
}
