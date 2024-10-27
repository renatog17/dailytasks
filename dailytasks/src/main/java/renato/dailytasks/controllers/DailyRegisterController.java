package renato.dailytasks.controllers;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import renato.dailytasks.controllers.dto.TaskRegisterDTO;
import renato.dailytasks.domain.Day;
import renato.dailytasks.domain.Task;
import renato.dailytasks.repositories.DayRepository;
import renato.dailytasks.repositories.TaskRepository;

@RestController
@RequestMapping("/dailyregister")
public class DailyRegisterController {

	private final TaskRepository taskRepository;
	private final DayRepository dayRepository;

	public DailyRegisterController(TaskRepository taskRepository, DayRepository dayRepository) {
		this.taskRepository = taskRepository;
		this.dayRepository = dayRepository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> postDailyRegister(@RequestBody TaskRegisterDTO taskRegisterDTO) {
		Day day = new Day("evento em salvador gdg, por isso não tive tanto tempo", LocalDate.now());
		Task task = taskRepository.getReferenceById(taskRegisterDTO.id());
		
		day.getTasks().add(task);
		task.getDays().add(day);
		
		taskRepository.save(task);
		dayRepository.save(day);
		
		return null;

	}

	@GetMapping("{date}")
	public ResponseEntity<?> getRegisterPerDay(@RequestParam LocalDate date) {
		return null;
	}
}
