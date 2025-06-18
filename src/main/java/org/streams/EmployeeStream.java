package org.streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeStream {
    public static void main(String[] ags){
        List<Employee> employees = Arrays.asList(
                new Employee("Akriti", "Software", 210000, true),
                new Employee("Raj", "Finance", 75000, true),
                new Employee("Sara", "IT", 60000, false),
                new Employee("John", "HR", 40000, true),
                new Employee("Meera", "Finance", 65000, false),
                new Employee("Alex", "IT", 95000, true),
                new Employee("Tina", "HR", 30000, false),
                new Employee("Alexendra", "Management", 85000, false),
                new Employee("Neha", "Management", 105000, true),
                new Employee("Sam", "Software", 120000, true),
                new Employee("Dean", "Finance", 80000, false)
        );
//
//        //All Employees
//        System.out.println("List of all Employees");
//        employees.stream()
//                .forEach(System.out::println);
//
//        //Full-time employees
//        List<Employee> fullTimers = employees.stream()
//                .filter(Employee::isFullTime)
//                .collect(Collectors.toList());
//        System.out.println("\nFull timers:");
//        fullTimers.forEach(System.out::println);
//
//        //Unique departments
//        Set<String> uniqueDepartments = employees.stream().map(Employee::getDepartment)
//                .collect(Collectors.toSet());
//        System.out.println("\nUnique departments: "+uniqueDepartments);
//
//        //Name to Department
//        Map<String, String> empWithDepartment = employees.stream()
//                .collect(Collectors.toMap(Employee::getName, Employee::getDepartment));
//
//        System.out.println("Employee and their Department: " + empWithDepartment);
//
//        //Group by Department
//
//        Map<String, List<Employee>> groupDepartment = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment));
//        System.out.println("\nEmployees grouped by department:");
//        groupDepartment.forEach((dept, empist) ->{
//            System.out.println(dept + ": " + empist);
//        });
//
//        // Group by department with the names of employee
//        Map<String, List<String>> groupEmpByDepartment = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment,
//                        Collectors.mapping(Employee::getName, Collectors.toList())));
//        System.out.println("\nEmployees name grouped by department:");
//        groupEmpByDepartment.forEach((dept, empist) ->{
//            System.out.println(dept + ": " + empist);
//        });
//
//        //Full-time vs Part-time
//        Map<Boolean, List<Employee>> partByTime = employees.stream()
//                .collect(Collectors.partitioningBy(Employee::isFullTime));
//        System.out.println("\nEmployees parted by time: ");
//        System.out.println("Full-time employees" + partByTime.get(true));
//        System.out.println("Part-time employees" + partByTime.get(false));
//
//        Map<Boolean, List<String>> partEmpByTime = employees.stream()
//                .collect(Collectors.partitioningBy(emp -> !emp.isFullTime(),
//                        Collectors.mapping(Employee::getName, Collectors.toList())));
//        System.out.println("\nEmployees name parted by time:");
//        System.out.println("Part-time employees" + partEmpByTime.get(true));
//
//        //Salary statistics
//        DoubleSummaryStatistics statistics = employees.stream()
//                .collect(Collectors.summarizingDouble(Employee::getSalary));
//        System.out.println("\nSalary statistics in double:");
//        System.out.println("Total Salary: " + statistics.getSum());
//        System.out.println("Average Salary: " + statistics.getAverage());
//        System.out.println("Max Salary: " + statistics.getMax());
//        System.out.println("Min Salary: " + statistics.getMin());
//        System.out.println("Count of Employees: " + statistics.getCount());
//
//        IntSummaryStatistics intStatistics = employees.stream()
//                .collect(Collectors.summarizingInt(emp -> (int) emp.getSalary()));
//        System.out.println("\nSalary statistics in int:");
//        System.out.println("Total Salary: " + intStatistics.getSum());
//        System.out.println("Average Salary: " + intStatistics.getAverage());
//        System.out.println("Max Salary: " + intStatistics.getMax());
//        System.out.println("Min Salary: " + intStatistics.getMin());
//        System.out.println("Count of Employees: " + intStatistics.getCount());
//
//        //Joining names
//        String employeeNames = employees.stream()
//                .map(Employee::getName).collect(Collectors.joining(", ", "Name of the Employee: ", "."));
//        System.out.println("\n" + employeeNames);
//
//        //Total Employee Count
//        long count =  employees.stream()
//                .collect(Collectors.counting());
//        System.out.println("\nTotal Employee Count: " + count);
//
//        //Immutable list collectingAndThen
//        List<Employee> immutableList = employees.stream()
//                .filter(emp -> emp.getDepartment().equals("Software"))
//                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
//        System.out.println("\nImmutable list of Software Employees: " + immutableList);
//
//        //groupingBy department and summarizing salary
//        Map<String, DoubleSummaryStatistics> salaryByDepartment = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment,
//                        Collectors.summarizingDouble(Employee::getSalary)));
//        System.out.println("\nSalary statistics by department:");
//        salaryByDepartment.forEach((dept, salStats) -> {
//            System.out.println(""+dept + "-> Sum: " + salStats.getSum() +
//                    ", Avg: " + salStats.getAverage() +
//                    ", Max: " + salStats.getMax() +
//                    ", Min: " + salStats.getMin() +
//                    ", Count: " + salStats.getCount());
//        });

        //Questions
        //Count the number of employees in each department
        Map<String, Long> numOfEmpByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.counting()));
        System.out.println("Number of Employees by Department:");
        numOfEmpByDepartment.forEach((dept, count) -> {
            System.out.println(dept + ": " + count);
        });

        //Get a map of employee name → salary using toMap()
        Map<String, Double> empAndSalary = employees.stream()
                .collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        System.out.println("\nEmployee with their Salary:");
        empAndSalary.forEach((name, salary) -> {
            System.out.println(name + " earns $"+ salary);
        });

        //Find the highest-paid employee using max()
        Employee empWithHighestSalary = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary)).get();
        System.out.println("\nHighest-paid employee details: " + empWithHighestSalary);
        System.out.println("\nHighest-paid employee: " + empWithHighestSalary.getName());

        //Get average salary of IT department
        double avgITSalary = employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("\nAverage salary in IT department is $" + avgITSalary);



    }
}
