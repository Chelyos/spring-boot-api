package com.api.api.service;

import com.api.api.model.User;
import com.api.api.repository.TaskRepository;
import com.api.api.model.Task;
import com.api.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Task> getTask(final long id) {

        return taskRepository.getTasksByUserId(id);
    }

    public void deleteTask(long taskId, long userId) {

        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            User u = user.get();
            List<Task> tasks = u.getTasks();
            tasks.forEach(task -> {
                if(task.getId().equals(taskId)){
                    tasks.remove(task);
                    taskRepository.deleteById(taskId);
                }
            });
        }
    }

    public void saveTask(Task task, Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User u = user.get();
            u.addTask(task);
            userRepository.save(u);
        }
    }
}
