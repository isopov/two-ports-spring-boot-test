package com.example.parenttest.external;

import com.example.parenttest.parent.ParentModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(print = MockMvcPrint.NONE)
@ContextHierarchy({
		@ContextConfiguration(classes = ParentModule.class),
		@ContextConfiguration(classes = ExternalModule.class)
})
@ActiveProfiles({ParentModule.PARENT_PROFILE, ExternalModule.EXTERNAL_PROFILE})
@RunWith(SpringRunner.class)
public class ExternalTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testAccessExternal() throws Exception {
		mockMvc.perform(get("/foobar"))
				.andExpect(status().isOk())
				.andExpect(content().string("[]"));
	}

	@Test
	public void testNoAccessInternal() throws Exception {
		mockMvc.perform(delete("/foobar"))
				.andExpect(status().isMethodNotAllowed());
	}
}
