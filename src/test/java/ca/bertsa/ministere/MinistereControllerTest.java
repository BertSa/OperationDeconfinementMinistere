package ca.bertsa.ministere;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MinistereControllerTest {
    private static final String API_MINISTERE = "/ministere";
    private static final String PARAM_NASSM = "nassm";
    @Autowired
    private MockMvc mockMvc;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotNull(mockMvc);
    }

    @Test
    void getBasicInformationForNegative() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_MINISTERE + "/info/")
                        .param(PARAM_NASSM, "eeee11112222"))//valid negative_test
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_MINISTERE + "/info/")
                        .param(PARAM_NASSM, "eeee11112223"))//not valid
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_MINISTERE + "/info/")
                        .param(PARAM_NASSM, "eeee11112220"))//valid vaccine
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_MINISTERE + "/info/")
                        .param(PARAM_NASSM, "ZZZZ99990000"))//Doesnt exist
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").doesNotExist());
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_MINISTERE + "/info/")
                        .param(PARAM_NASSM, "fefnafewfafasfasf"))//Invalid NASSM
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").doesNotExist());
    }



    @Test
    void checkCitizenValidityForVaccine() throws Exception {
        assertTrue(this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_MINISTERE + "/validate/vaccine")
                        .param(PARAM_NASSM, "eeee11112220"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString().equalsIgnoreCase("true"));
        assertTrue(this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_MINISTERE + "/validate/vaccine")
                        .param(PARAM_NASSM, "eeee11112221"))//not valid
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString().equalsIgnoreCase("false"));
        assertTrue(this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_MINISTERE + "/validate/vaccine")
                        .param(PARAM_NASSM, "eeee11112222"))//valid for negative
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString().equalsIgnoreCase("false"));
        assertTrue(this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_MINISTERE + "/validate/vaccine")
                        .param(PARAM_NASSM, "ZZZZ99990000"))//Doesnt exist
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString().equalsIgnoreCase("false"));
        assertTrue(this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_MINISTERE + "/validate/vaccine")
                        .param(PARAM_NASSM, "fefnafewfafasfasf"))//Invalid
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString().equalsIgnoreCase("false"));
    }

    @Test
    void checkCitizenValidityForNegativeTest() throws Exception {
        assertTrue(this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_MINISTERE + "/validate/negative")
                        .param(PARAM_NASSM, "eeee11112222"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString().equalsIgnoreCase("true"));
        assertTrue(this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_MINISTERE + "/validate/negative")
                        .param(PARAM_NASSM, "eeee11112223"))//not valid
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString().equalsIgnoreCase("false"));
        assertTrue(this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_MINISTERE + "/validate/negative")
                        .param(PARAM_NASSM, "eeee11112220"))//valid for vaccine
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString().equalsIgnoreCase("false"));
        assertTrue(this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_MINISTERE + "/validate/negative")
                        .param(PARAM_NASSM, "ZZZZ99990000"))//Doesnt exits
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString().equalsIgnoreCase("false"));
        assertTrue(this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_MINISTERE + "/validate/negative")
                        .param(PARAM_NASSM, "fefnafewfafasfasf"))//Invalid
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString().equalsIgnoreCase("false"));
    }
}