package org.example.mapstructerror.dto;

import lombok.Builder;
import lombok.With;

import java.util.List;


@With
@Builder
public record EmployeeDto(
        String name,

        EmployeeDto reportsTo,

				List<EmployeeDto> team,

				List<EmployeeEquipmentDto> equipmentList
) {

}
