package com.api.api.repository;
import com.api.api.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    @Query(value = "select task.id,task.name, task.detail, task.status from task where task.user_id = :userId", nativeQuery = true)
    List<Task> getTasksByUserId(@Param("userId") long userId);
}
