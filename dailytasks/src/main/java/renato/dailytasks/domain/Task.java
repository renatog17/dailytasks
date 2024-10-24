package renato.dailytasks.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.Valid;
import renato.dailytasks.controllers.dto.CreateTaskDTO;

@Entity
//@NoArgsConstructor
//@Setter
//@Getter
//@EqualsAndHashCode
//@ToString
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	private String name;
	@ManyToMany(mappedBy = "tasks")
	private List<Day> days = new ArrayList<>();

	public Task() {
		super();
	}

	public Task(String name) {
		super();
		this.name = name;
	}

	public Task(@Valid CreateTaskDTO createTaskDTO) {
		this.name = createTaskDTO.name();
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

}
