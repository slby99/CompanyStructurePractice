package com.company;

import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee {
    public ArrayList<Accountant> team;

    // Should create a new BusinessLead that is a Manager.
    public BusinessLead(String name) {
        super(name);
        // The BusinessLead's base salary should be twice that of an Accountant.
        this.baseSalary = this.baseSalary * 2;

        // They should start with a head count of 10.
        this.setHeadCount(10);
        this.team = new ArrayList<Accountant>();
    }

    // Should return true if the number of direct reports
    // this manager has is less than their headcount.
    public boolean hasHeadCount() {
        if(this.team.size() < this.getHeadCount())
            return true;
        else
            return false;
    }

    /*
    Should accept the reference to an Accountant object,
    and if the BusinessLead has head count left should
    add this employee to their list of direct reports.
    If the employee is successfully added to the BusinessLead's direct reports true should be returned,
    false should be returned otherwise.
    That employee's team they are supporting should be updated
    to reflect the reference to the TechnicalLead given.
    If the employee is successfully added true should be returned, false otherwise.
     */
    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if(this.hasHeadCount()) {
            team.add(e);
            e.setManager(this);
            //Each time a report is added the BusinessLead's bonus budget
            // should be increased by 1.1 times
            //that new employee's base salary.
            this.bonusBudget += e.getBaseSalary() * 1.1;

            e.supportTeam(supportTeam);
            supportTeam.accountantSupport=e;
            return true;
        }
        else {
            return false;
        }

    }

    // Should check if the bonus amount requested would fit in current BusinessLead's budget.
    // If it is, that employee should get that bonus,
    // the BusinessLeader's budget should be deducted
    // and true should be returned.
    // False should be returned otherwise
    public boolean requestBonus(Employee e, double bonus) {
        if(bonus < this.getBonusBudget()) { //yes to give bonus
            e.bonusBudget += bonus;
            this.bonusBudget -= bonus;
            return true;
        }
        else {
            return false;
        }
    }

    /*
    This function should look through the Accountants the BusinessLead manages,
    and if any of them are supporting a the TechnicalLead that is the manager of the Employee passed
    in then the Accountant's budget should be consulted to see if the bonus could be afforded.
    If the team can afford the bonus it should be rewarded and true returned, false otherwise
     */
    public boolean approveBonus(Employee e, double bonus) {
        for (int i=0;i<team.size();i++){
            if((team.get(i).getTeamSupported()).equals(e.manager) && team.get(i).approveBonus(bonus)) {
                e.bonusBudget += bonus;
                team.get(i).bonusBudget -= bonus;
                return true;
            }
        }
        return false;

    }

    public String getTeamStatus(){
        //Should return a String that gives insight into this Manager and all their direct reports.
        // It should return a string that is a combination of the TechnicalLead's employee status followed by each of their direct employee's status on subsequent lines.
        // If the TechnicalLead has no reports it should print their employee status followed by the text " and no direct reports yet ".
        // Example: "10 Kasey has 5 successful check ins and no direct reports yet".
        // If the TechnicalLead does have reports it might look something like "10 Kasey has 5 successful check ins and is managing: /n 5 Niky has 2 successful check ins"

        if (team.size()==0){
            return this.employeeStatus()+ " and no direct reports yet";
        } else {
            String teamStatus="";
            for (int i=0;i<team.size();i++){
                teamStatus+=("    "+team.get(i).employeeStatus()+"\n");
            }
            return this.employeeStatus()+" and is managing: \n"+teamStatus;
        }

    }

}
