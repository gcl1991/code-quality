package com.manning.ch05.template;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class EmployeeTest2 {
    private Employees group = new Employees();

    @Test
    // 组应包含两个主管
    public void groupShouldContainTwoSupervisors() {
        List<Employee> all = group.list();
        assertContainSpecifiedNumber(all, Employee::isSupervisor, 2);
    }

    @Test
    // 组应包含五个新来者
    public void groupShouldContainFiveNewcomers() {
        List<Employee> all = group.list();
        assertContainSpecifiedNumber(all,
                x -> {
                    LocalDate oneYearAgo = LocalDate.now().minusYears(1);
                    return x.startingDate().isAfter(oneYearAgo);
                },
                5);
    }

    public <T> void assertContainSpecifiedNumber(List<T> list, Predicate<T> predicate, int number) {
        int count = (int) list.stream().filter(predicate).count();
        assertEquals(number, count);
    }
}

