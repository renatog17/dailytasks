package renato.dailytasks.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import renato.dailytasks.controllers.dto.CreateRecordDTO;
import renato.dailytasks.domain.Task;
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
	public void testPostRecord() throws JsonProcessingException, Exception {
		//arrange
		Task task = new Task("Estudar inglês");
		taskRepository.save(task);
		CreateRecordDTO createRecordDTO = new CreateRecordDTO(task.getTaskId());
		//act
		mockMvc.perform(MockMvcRequestBuilders.post("/records")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createRecordDTO)))
		//assert
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(null));
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
