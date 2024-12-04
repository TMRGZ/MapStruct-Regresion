package org.example.mapstructerror.mapper;

import org.example.mapstructerror.dto.EmployeeDto;
import org.example.mapstructerror.entity.Employee;
import org.example.mapstructerror.mapper.utils.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = EmployeeEquipmentMapper.class)
public interface EmployeeMapper {

    Employee map(EmployeeDto employeeDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    EmployeeDto map(Employee employee, @Context CycleAvoidingMappingContext context);
}
