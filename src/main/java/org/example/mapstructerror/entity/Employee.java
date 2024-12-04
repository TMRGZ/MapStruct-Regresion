package org.example.mapstructerror.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Employee {

	private String name;
	private Employee reportsTo;
	private List<Employee> team = new ArrayList<>();

	private List<EmployeeEquipment> equipmentList = new ArrayList<>();

}
