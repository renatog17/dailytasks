package renato.dailytasks.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTaskDTO(
		@NotNull
		@NotBlank
		String name) {

}
