package org.example.mapstructerror.dto;

import lombok.Builder;
import lombok.With;

import java.util.List;

@With
@Builder
public record Employee(
        String name,

        Employee reportsTo,

        List<Employee> team


) {

}
