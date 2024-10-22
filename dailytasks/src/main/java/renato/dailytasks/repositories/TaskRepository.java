package renato.dailytasks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import renato.dailytasks.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
