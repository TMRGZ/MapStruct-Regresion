package org.example.mapstructerror;

import org.example.mapstructerror.dto.Employee;
import org.example.mapstructerror.dto.EmployeeDto;
import org.example.mapstructerror.mapper.EmployeeMapper;
import org.example.mapstructerror.mapper.utils.CycleAvoidingMappingContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MapstructerrorApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testMapDtoToEntity() {

        EmployeeDto teamLeader = employeeDto( "Group Leader", null );

        EmployeeDto member1 = employeeDto( "Member2", teamLeader );
        EmployeeDto member2 = employeeDto( "Member2", teamLeader );
        teamLeader = teamLeader.withTeam( Arrays.asList( member1, member2 ) );

        Employee teamLead = employeeMapper.toEmployee( teamLeader, new CycleAvoidingMappingContext() );

        assertThat( teamLead ).isNotNull();
        assertThat( teamLead.reportsTo() ).isNull();
        List<Employee> team = teamLead.team();
        assertThat( team ).hasSize( 2 );
    }

    private EmployeeDto employeeDto(String name, EmployeeDto reportsTo) {
        return new EmployeeDto(name, reportsTo, null);
    }

    @Test
    public void testMapEntityToDto() {

        Employee teamLeader = employee( "Group Leader", null );

        Employee member1 = employee( "Member2", teamLeader );
        Employee member2 = employee( "Member2", teamLeader );
        teamLeader = teamLeader.withTeam( Arrays.asList( member1, member2 ) );

        EmployeeDto teamLead = employeeMapper.fromEmployee( teamLeader, new CycleAvoidingMappingContext() );

        assertThat( teamLead ).isNotNull();
        assertThat( teamLead.reportsTo() ).isNull();
        List<EmployeeDto> team = teamLead.team();
        assertThat( team ).hasSize( 2 );
    }

    private Employee employee(String name, Employee reportsTo) {
        return new Employee(name, reportsTo, null);
    }

}
