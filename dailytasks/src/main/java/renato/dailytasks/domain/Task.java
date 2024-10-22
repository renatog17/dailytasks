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

//@Entity
//@NoArgsConstructor
//@Setter
//@Getter
//@EqualsAndHashCode
//@ToString
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	public Task() {
		super();
	}

	public Task(String nome) {
		super();
		this.nome = nome;
	}

	public Task(@Valid CreateTaskDTO createTaskDTO) {
		this.nome = createTaskDTO.nome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
