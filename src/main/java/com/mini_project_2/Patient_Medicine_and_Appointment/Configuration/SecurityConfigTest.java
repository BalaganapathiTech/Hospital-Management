//=======================================================================
//                          For Test Purpose only                       =
//=======================================================================


package com.mini_project_2.Patient_Medicine_and_Appointment.Configuration;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class SecurityConfigTest {


    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private FilterChainProxy filterChainProxy;

    private MockMvc mockMvc;

    @Test
    public void testLoginPageAccessible() throws Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilters(filterChainProxy)
                .build();
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = "USER")
    public void testAuthenticatedAccess() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilters(filterChainProxy)
                .build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUnauthenticatedAccess() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilters(filterChainProxy)
                .build();
        mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection());
    }


}
