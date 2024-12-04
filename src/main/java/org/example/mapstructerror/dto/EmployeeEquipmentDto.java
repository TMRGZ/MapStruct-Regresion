package org.example.mapstructerror.dto;

import lombok.Builder;
import lombok.With;

@With
@Builder
public record EmployeeEquipmentDto(
		String name,

		EmployeeDto owner
) {

}
