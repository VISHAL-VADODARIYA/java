package com.demo.crud.service;

import com.demo.crud.entity.Department;
import com.demo.crud.entity.Employee;
import com.demo.crud.entity.Task;
import com.demo.crud.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task data = fetchTaskById(taskId);
        if (data.getEmployee().equals("")){
            taskRepository.deleteById(taskId);
        }
    }

    @Override
    public List<Task> fetchTaskList() {
        return taskRepository.findAll();
    }

    @Override
    public Task fetchTaskById(Long taskId) {
        return taskRepository.findById(taskId).get();
    }


}
