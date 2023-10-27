package com.demo.crud.controller;

import com.demo.crud.dto.TaskDTO;
import com.demo.crud.entity.Task;
import com.demo.crud.mapper.MapstructMapperTask;
import com.demo.crud.service.TaskService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    MapstructMapperTask mapper = Mappers.getMapper(MapstructMapperTask.class);

    @PostMapping("/task")
    public TaskDTO saveTask(@RequestBody TaskDTO task) {
        Task save = mapper.dtoToEntity(task);
        Task saveTask = taskService.saveTask(save);
        return mapper.entityToDto(saveTask);
    }

    @GetMapping("/task")
    public List<TaskDTO> fetchTaskList(){
        List<Task> task = taskService.fetchTaskList();


        return mapper.entityToDtoList(task);
    }



    @DeleteMapping("/task/{id}")
    public String deleteTask(@PathVariable("id") Long taskId){

        taskService.deleteTask(taskId);
        return "Task Deleted Successfully";
    }

}
