package renato.dailytasks.controllers;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import renato.dailytasks.controllers.dto.CreateTaskDTO;
import renato.dailytasks.domain.Task;
import renato.dailytasks.repositories.TaskRepository;

@RequestMapping("/tasks")
@RestController
public class TaskController {

	private final TaskRepository taskRepository;
	
	public TaskController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> postProject(@RequestBody @Valid CreateTaskDTO createTaskDTO,
			UriComponentsBuilder uriComponentsBuilder) {
		Task task = new Task(createTaskDTO);
		
		taskRepository.save(task);
		URI uri = uriComponentsBuilder.path("/project/{id}").buildAndExpand(task.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProject(@PathVariable Long id) {
		Optional<Task> optionalTask = taskRepository.findById(id);
		if (optionalTask.isPresent()) {
			return ResponseEntity.ok(new ReadTaskDTO(optionalTask.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> updateProject(@PathVariable Long id, @RequestBody UpdateTaskDTO updateTaskDTO){
		Optional<Task> optionalTask = taskRepository.findById(id);
		if (optionalTask.isPresent()) {
			Task task = optionalTask.get();
			task.setNome(updateTaskDTO.name());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteProject(@PathVariable Long id) {
		Optional<Task> optionalTask = taskRepository.findById(id);
		if(optionalTask.isPresent()) {
			taskRepository.delete(optionalTask.get());
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
