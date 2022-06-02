package com.company;

public class SoftwareEngineer extends TechnicalEmployee{
    private boolean codeAccess;

    // Should start without access to code and with 0 code check ins
    public SoftwareEngineer(String name) {
        super(name);
        this.checkin = 0; // with 0 code check ins
        //this.codeAccess = false; // start without access to code
        setCodeAccess(false);
    }

    // Should return whether or not this SoftwareEngineer has access to make changes to the code base
    public boolean getCodeAccess() {
        return this.codeAccess;
    }

    // Should allow an external piece of code to update the SoftwareEngieer's code privileges
    // to either true or false
    public void setCodeAccess(boolean access) {
        this.codeAccess = access;
    }

    // Should return the current count of how many times
    // this SoftwareEngineer has successfully checked in code
    public int getSuccessfulCheckIns() {
        return this.getCheckin();
    }

    /*
    Should check if this SoftwareEngineer's manager approves of their check in.
    If the check in is approved their successful checkin count should be increased
    and the method should return "true".
    If the manager does not approve the check in
    the SoftwareEngineer's code  access should be changed to false
    and the method should return "false"
     */
    public boolean checkInCode() {
        if(((TechnicalLead) this.getManager()).approveCheckIn(this)) {
            this.checkin++;
            return true;
        }
        else {
            this.setCodeAccess(false);
            return false;
        }
    }
}
