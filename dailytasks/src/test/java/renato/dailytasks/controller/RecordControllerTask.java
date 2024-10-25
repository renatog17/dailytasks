package renato.dailytasks.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import renato.dailytasks.repositories.TaskRepository;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RecordControllerTask {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private TaskRepository taskRepository;
	
	@Test
	public void testPostRecord() {
	}

	@Test
	public void testPostRecordWithNullAndEmptnessFileds() {
	}

	@Test
	public void testGetRecord() {
	}

	@Test
	public void testGetPageRecords() {
	}

	@Test
	public void testGetPageRecordsSpecificDay() {
	}

	@Test
	public void testGetPageRecordsPerMonthAndYear() {
	}

	@Test
	public void testGetPageRecordsPerYear() {
	}
	
	@Test
	public void testGetPageRecordsPerPeriodo() {
	}
	
	@Test
	public void testDeleteRecord() {
	}
}
