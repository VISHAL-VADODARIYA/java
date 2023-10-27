package com.demo.crud.mapper;


import com.demo.crud.dto.TaskDTO;
import com.demo.crud.entity.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MapstructMapperTask {

    Task dtoToEntity(TaskDTO dto);
    List<Task> dtoToEntityList(List<TaskDTO> dto);
    TaskDTO entityToDto(Task task);
    List<TaskDTO> entityToDtoList(List<Task> task);
}
