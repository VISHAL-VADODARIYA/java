package com.demo.crud.service;

import com.demo.crud.entity.Asset;
import com.demo.crud.entity.Employee;
import com.demo.crud.entity.Task;

import java.util.List;

public interface TaskService {
    public Task saveTask(Task task);

    public void deleteTask(Long taskId);

    public List<Task> fetchTaskList();

    public Task fetchTaskById(Long taskId);


}
