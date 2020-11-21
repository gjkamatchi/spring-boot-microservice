package com.ps.verizon.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ps.verizon.service.impl.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
public class EmployeeControllerTests {

	@InjectMocks
	private EmployeeController employeeController;
	
	@Mock
	private EmployeeServiceImpl employeeService;
	
	private MockMvc mockMvc;
	
	@Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }
		
	@Test
	public void testUpdateEmployeeSuccess() throws Exception {
		this.mockMvc.perform(put("/api/employee/place/{place}/salary/{percentage}","Chennai","5")
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testGetEmployeeListSuccess() throws Exception {
		this.mockMvc.perform(get("/api/employee/place/{place}/{pageSize}","Chennai","5")
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testGetSalaryRange() throws Exception {
		this.mockMvc.perform(get("/api/employee/{competency}","CORE")
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
