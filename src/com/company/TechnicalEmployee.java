package com.company;

public class TechnicalEmployee extends Employee {
    protected int checkin;


    // Has a default base salary of 75000
    public TechnicalEmployee(String name) {
        super(name,75000);
        this.checkin = 0;
    }

    public void setCheckin() {
        this.checkin++;
    }

    // Avoid side effects, make it atomic
    public int getCheckin() {
        return this.checkin;
    }

    // Should return a String representation of this TechnicalEmployee that includes their ID, name and how many successful check ins they have had.
    // Example: "1 Kasey has 10 successful check ins"
    public String employeeStatus() {
        return super.toString() + " has " + this.getCheckin() + " successful check ins";
    }

}
