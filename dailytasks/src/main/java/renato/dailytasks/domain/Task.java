package renato.dailytasks.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
	private Long id;
	private String name;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

}
