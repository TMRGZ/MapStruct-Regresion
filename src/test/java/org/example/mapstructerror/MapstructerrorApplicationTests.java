package org.example.mapstructerror;

import org.example.mapstructerror.dto.EmployeeDto;
import org.example.mapstructerror.entity.Employee;
import org.example.mapstructerror.mapper.EmployeeMapper;
import org.example.mapstructerror.mapper.utils.CycleAvoidingMappingContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MapstructerrorApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testMapEntityToDto() {

        Employee teamLeader = new Employee();
        teamLeader.setName("Group Leader");

        Employee member1 = new Employee();
        member1.setName("Member2");
        member1.setReportsTo(teamLeader);

        Employee member2 = new Employee();
        member2.setName("Member2");
        member2.setReportsTo(teamLeader);

        teamLeader.getTeam().add(member1);
        teamLeader.getTeam().add(member2);

        EmployeeDto teamLead = employeeMapper.map( teamLeader, new CycleAvoidingMappingContext() );

        assertThat( teamLead ).isNotNull();
        assertThat( teamLead.reportsTo() ).isNull();
        List<EmployeeDto> team = teamLead.team();
        assertThat( team ).hasSize( 2 );
    }



}
