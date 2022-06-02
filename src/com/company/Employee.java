package com.company;

public abstract class Employee {
    protected String name;
    protected double baseSalary;
    public double bonusBudget;

    protected int employeeID;

    public int headCount;

    // The first ever employee should have an ID of "1", the second "2" and so on
    private static int counter = 1;

    // Should construct a new employee object and take in two parameters,
    // one for the name of the user and one for their base salary
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.headCount = 0;

        // The first ever employee should have an ID of "1", the second "2" and so on
        this.employeeID = counter;
        counter++;
    }

    // Should return the employee's current salary
    public double getBaseSalary() {
        return this.baseSalary;
    }

    // Should return the employee's current name
    public String getName(){
        return this.name;
    }

    // Should return the employee's ID.
    // The ID should be issued on behalf of the employee
    // at the time they are constructed.
    // The first ever employee should have an ID of "1", the second "2" and so on
    public int getEmployeeID() {
        return this.employeeID;
    }

    // Should return a reference to the Employee object that represents this employee's manager
    public Employee manager;
    public Employee getManager() {
        return manager;
    }
    public void setManager(Employee e) { this.manager = e; }

    // Should return true if the two employee IDs are the same, false otherwise
    public boolean equals(Employee other) {
        return this.getEmployeeID() == other.getEmployeeID();
    }

    // Should return a String representation of the employee that is a combination of
    // their id followed by their name.
    // Example: "1 Kasey"
    public String toString() {
        return this.getEmployeeID() + " " + this.getName();
    }

    // Should return a String representation of that Employee's current status.
    // This will be different for every subclass of Employee
    public abstract String employeeStatus();

    public void setHeadCount(int headCount) {
        this.headCount = headCount;
    }

    public int getHeadCount() {
        return this.headCount;
    }

}
