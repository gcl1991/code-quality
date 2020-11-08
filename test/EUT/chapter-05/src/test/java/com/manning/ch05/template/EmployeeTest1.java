package com.manning.ch05.template;

import static org.junit.Assert.*;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

class Employee {
    private boolean isSupervisor;
    private LocalDate startingDate;

    public Employee(boolean isSupervisor, LocalDate startingDate) {
        this.isSupervisor = isSupervisor;
        this.startingDate = startingDate;
    }

    public boolean isSupervisor() {
        return isSupervisor;
    }

    public LocalDate startingDate() {
        return startingDate;
    }
}

class Employees {
    public List<Employee> list() {
        Employee supervisor = new Employee(true,LocalDate.now().minusYears(2));
        Employee newcomer = new Employee(false,LocalDate.now());
        return Arrays.asList(
                supervisor,supervisor,
                newcomer,newcomer,newcomer,newcomer,newcomer
                );
    }
}

public class EmployeeTest1 {
    private Employees group = new Employees();

    @Test
    // 组应包含两个主管
    public void groupShouldContainTwoSupervisors() {
        List<Employee> all = group.list();
        List<Employee> employees = new ArrayList<Employee>(all);
        Iterator<Employee> i = employees.iterator();
        while (i.hasNext()) {
            Employee employee = i.next();
            if (!employee.isSupervisor()) {
                i.remove();
            }
        }
        assertEquals(2, employees.size());
    }

    @Test
    // 组应包含五个新来者
    public void groupShouldContainFiveNewcomers() {
        List<Employee> newcomers = new ArrayList<Employee>();
        for (Employee employee : group.list()) {
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            if (employee.startingDate().isAfter(oneYearAgo)) {
                newcomers.add(employee);
            }
        }
        assertEquals(5, newcomers.size());
    }
}
