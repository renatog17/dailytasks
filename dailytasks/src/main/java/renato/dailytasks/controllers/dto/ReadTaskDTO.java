package renato.dailytasks.controllers.dto;

import renato.dailytasks.domain.Task;

public record ReadTaskDTO(String nome) {

	public ReadTaskDTO(Task task){
		this(task.getNome());
	}
}
