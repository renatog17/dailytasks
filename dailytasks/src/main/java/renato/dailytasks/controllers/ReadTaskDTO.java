package renato.dailytasks.controllers;

import renato.dailytasks.domain.Task;

public record ReadTaskDTO(String nome) {

	ReadTaskDTO(Task task){
		this(task.getNome());
	}
}
