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

import com.fasterxml.jackson.databind.ObjectMapper;

import renato.dailytasks.controllers.dto.CreateTaskDTO;
import renato.dailytasks.controllers.dto.UpdateTaskDTO;
import renato.dailytasks.domain.Task;
import renato.dailytasks.repositories.TaskRepository;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TaskControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private TaskRepository taskRepository;

//	public TaskControllerTest(MockMvc mockMvc, ObjectMapper objectMapper, TaskRepository taskRepository) {
//        this.mockMvc = mockMvc;
//        this.objectMapper = objectMapper;
//        this.taskRepository = taskRepository;
//    }
	
	@Test
	public void testPostTask() throws Exception {
		// arrange
		CreateTaskDTO createTaskDTO = new CreateTaskDTO("Teste");

		// act
		mockMvc.perform(MockMvcRequestBuilders.post("/tasks").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createTaskDTO)))
				// assert
				.andExpect(MockMvcResultMatchers.status().isCreated());

	}

	@Test
	public void testPostTaskWithEmptyFildName() throws Exception {
		// arrange
		CreateTaskDTO createTaskDTO = new CreateTaskDTO("");
		// act
		mockMvc.perform(MockMvcRequestBuilders.post("/tasks").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createTaskDTO)))
				// assert
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void testGetTask() throws Exception {
		// arrange
		Task task = new Task("Teste");
		taskRepository.save(task);
		// act
		mockMvc.perform(MockMvcRequestBuilders.get("/tasks/" + task.getId()))
				// assert
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Teste"));
	}

	@Test
	public void testGetTaskNotFound() throws Exception {
		// act
		mockMvc.perform(MockMvcRequestBuilders.get("/tasks/" + 111111111))
				// assert
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void testUpdateTask() throws Exception {
		// arrange
		Task task = new Task("Teste");
		taskRepository.save(task);

		UpdateTaskDTO updateTaskDTO = new UpdateTaskDTO("Conteúdo editado");
		// act
		mockMvc.perform(MockMvcRequestBuilders.put("/tasks/" + task.getId()).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(updateTaskDTO)))
				// assert
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Conteúdo editado"));
	}
	
	@Test
	public void testUpdateTaskWithEmptyFildName() throws Exception {
		// arrange
		Task task = new Task("Teste");
		taskRepository.save(task);

		CreateTaskDTO createTaskDTO = new CreateTaskDTO("");
		// act
		mockMvc.perform(MockMvcRequestBuilders.put("/tasks/" + task.getId()).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createTaskDTO)))
				// assert
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void testUpdateProjectWithTaskNotFound() throws Exception {
		CreateTaskDTO createTaskDTO = new CreateTaskDTO("asdfasdf");
		// act
		mockMvc.perform(MockMvcRequestBuilders.put("/tasks/" + 1111111111).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createTaskDTO)))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void testDeleteTask() throws Exception {
		// arrange
		Task task = new Task("Teste");
		taskRepository.save(task);
		// act
		mockMvc.perform(MockMvcRequestBuilders.delete("/tasks/" + task.getId()))
				// assert
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}
	
	@Test
	public void testDeleteTaskNotFound() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.delete("/tasks/" + 1111111111))
		// assert
		.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
}
