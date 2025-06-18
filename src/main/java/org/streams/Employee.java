package org.streams;

public class Employee {
    String name;
    String department;
    double salary;
    boolean isFullTime;

    public Employee(String name, String department, double salary, boolean isFullTime) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.isFullTime = isFullTime;
    }

    public String getName() {return name;}
    public String getDepartment() {return department;}
    public double getSalary() {return salary;}
    public boolean isFullTime() {return isFullTime;}

    public String toString(){
        return name + " (" + department + ", $" + salary + ", " + (isFullTime ? "Full-Time" : "Part-Time") + ")";
    }
}
