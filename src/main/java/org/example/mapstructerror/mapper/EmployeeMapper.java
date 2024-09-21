package org.example.mapstructerror.mapper;

import org.example.mapstructerror.dto.Employee;
import org.example.mapstructerror.dto.EmployeeDto;
import org.example.mapstructerror.mapper.utils.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "employeeName", target = "name")
    Employee toEmployee(EmployeeDto employeeDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    EmployeeDto fromEmployee(Employee employee, @Context CycleAvoidingMappingContext context);
}
