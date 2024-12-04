package org.example.mapstructerror.mapper;

import org.example.mapstructerror.dto.EmployeeEquipmentDto;
import org.example.mapstructerror.entity.EmployeeEquipment;
import org.example.mapstructerror.mapper.utils.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = EmployeeMapper.class)
public interface EmployeeEquipmentMapper {

    EmployeeEquipment map(EmployeeEquipmentDto employeeEquipmentDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    EmployeeEquipmentDto map(EmployeeEquipment employeeEquipment, @Context CycleAvoidingMappingContext context);
}
