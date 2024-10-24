package renato.dailytasks.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Day {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dayId;
	private String descricao;
	@Column(unique = true)
	private LocalDate date;
	@ManyToMany
	@JoinTable(
			name="daily_register",
			joinColumns = @JoinColumn(name="day_id"),
			inverseJoinColumns = @JoinColumn(name="task_id")
			)
	private List<Task> tasks = new ArrayList<>();

	public Day() {
		super();
	}

	public Day(String descricao, LocalDate date) {
		super();
		this.descricao = descricao;
		this.date = date;
	}

	public Long getDayId() {
		return dayId;
	}

	public void setDayId(Long dayId) {
		this.dayId = dayId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dayId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Day other = (Day) obj;
		return Objects.equals(dayId, other.dayId);
	}

	@Override
	public String toString() {
		return "Day [id=" + dayId + ", descricao=" + descricao + ", date=" + date + "]";
	}

}
