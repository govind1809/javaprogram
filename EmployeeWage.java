package com.employeeswage;
import java.util.Random;
import java.util.Scanner;
public class EmployeeWage {
    int fullTime;
    int partTime;
    int wagePerHour ;
    static int empHour ;
    static int wage = 0;
    int monthlyWage =0;
    int monthlyHour =0;
    String companyName ;
    int noOfWorkingDays;
    int noOfWorkingHours;
    EmployeeWage(String companyName,int wagePerHour, int noOfWorkingDays, int noOfWorkingHours, int partTime,int fullTime) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.noOfWorkingDays = noOfWorkingDays;
        this.noOfWorkingHours = noOfWorkingDays;
        this.partTime = partTime;
        this.fullTime = fullTime;

        System.out.println("Company Name : " + companyName + "\t Wage Per Hour : " + wagePerHour + "\t Number of Minimum Working Days in a month : " + noOfWorkingDays);
//        System.out.println();
        System.out.println("Number of minimum Working Hours in a month:" + noOfWorkingHours+"\t Part Time Hours : "+partTime+"\t Full Time Hours : "+fullTime);
    }

    void WageCalculation() {
        Random r = new Random();
        int n = r.nextInt(3);
        switch (n) {
            case 0:
                empHour = fullTime;
                System.out.println();
                System.out.println("Employee is Present for " + empHour + " hours. ");
                break;
            case 1:
                empHour = partTime;
                System.out.println();
                System.out.println("Employee present for part time for " + empHour + " hours. ");
                break;
            default:
                empHour = 0;
                System.out.println();
                System.out.println("Employee is Absent so no salary for him...");
        }

        wage = wagePerHour * empHour;
        System.out.println("Employee Wage for one day is: " + wage);

    }
    int MonthlyWageCalculation(int workDays) {

        this.monthlyWage = wage * workDays;
        int monthlyHour = empHour * workDays;
        System.out.println("Employee working hours in one month is: "+monthlyHour);
        System.out.println("Employee this month salary will be : " + monthlyWage);
        return monthlyWage;
    }
    void WorkPolicy(int workDays){

        System.out.println("");
        if (workDays >= noOfWorkingDays || monthlyHour >=noOfWorkingHours){
            System.out.println("Worker Satisfies the payscale condition.");
            System.out.println("The Final Salary will be credited to Workers bank account is: " + monthlyWage);
        }
        else{
            System.out.println("Worker did not satisfies the payscale condition.");
            System.out.println("Worker needs to work for more hour or minimum for "+noOfWorkingDays+" days or minimum of "+noOfWorkingHours+" hours ");
        }

    }
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Calculation Program");
        System.out.println();
        EmployeeWage emp = new EmployeeWage("Bajaj",20,20,100,3,8);
        Scanner sc = new Scanner(System.in);
        emp.WageCalculation();
        System.out.print("Enter Employee WorkDays: ");
        int workDays = sc.nextInt();
        emp.MonthlyWageCalculation(workDays);
        emp.WorkPolicy(workDays);
    }
}
