package renato.dailytasks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import renato.dailytasks.domain.Day;

public interface DayRepository extends JpaRepository<Day, Long>{

}
