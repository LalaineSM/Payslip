/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.text.DecimalFormat;
import java.util.Date;

public class Payslip_Frane {
    // Attributes
    private String employee;
    private double basicPay;
    private double allowance;
    private double deduction;
    private int overtimeHours;
    private double overtimePay;
    private double tax; 
    private double sss;
    private double pagibig;
    private double philhealth;

    // Default constructor
    public Payslip_Frane() {
        this.employee = "";
        this.basicPay = 0;
        this.allowance = 0;
        this.deduction = 0;
        this.overtimeHours = 0;
        this.overtimePay = 0;
        this.tax = 0;
        this.sss = 0;
        this.pagibig = 0;
        this.philhealth = 0;
    }

    // Getters and setters
    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double sss, double pagibig, double philhealth) {
        this.sss = sss;
        this.pagibig = pagibig;
        this.philhealth = philhealth;
        this.deduction = sss + pagibig + philhealth;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public double getSss() {
        return sss;
    }

    public void setSss(double sss) {
        this.sss = sss;
    }

    public double getPagibig() {
        return pagibig;
    }

    public void setPagibig(double pagibig) {
        this.pagibig = pagibig;
    }

    public double getPhilhealth() {
        return philhealth;
    }

    public void setPhilhealth(double philhealth) {
        if (philhealth > 2450) {
            this.philhealth = 2450;
        } else {
            this.philhealth = philhealth;
        }
    }
    
    // Method for calculating withholding tax
    public void determineWithholdingTax() {
        if (basicPay < 20000) {
            this.tax = 0;
        } else if (basicPay > 20000 && basicPay <31000) {
            this.tax  = (basicPay * 0.2);
        } else if (basicPay >31000 && basicPay < 61000) {
            this.tax = (2300 + (basicPay * 0.25));
        } else if (basicPay > 61000 && basicPay < 154000) {
            this.tax = (10000 + (basicPay * 0.3));
        } else if (basicPay >154000 && basicPay < 615000) {
            this.tax = (38000 + (basicPay * 0.32));
        } else {
            this.tax = (185000 + (basicPay * 0.35));
        }
    }

    // Method for calculating overtime pay
    public void calculateOvertimePay() {
        this.overtimePay = overtimeHours * (0.01 * basicPay); 
    }

    // Method for calculating total compensation
    public double computeGrossIncome() {
        return basicPay + overtimePay + allowance;
    }

    // Method for calculating net pay
    public double computeNetPay() {
        double grossIncome = computeGrossIncome();
        return grossIncome - tax - deduction;
    }

    // Method to display details
    public void displayPayslip() {
        Date currentDate = new Date();
        DecimalFormat pesoFormat = new DecimalFormat("#,##0.00");
        System.out.println("Date Generated: " + currentDate);
        System.out.println("Employee Name: " + employee);
        System.out.println("Basic Salary: PHP " + pesoFormat.format(basicPay));
        System.out.println("Allowance: PHP " + pesoFormat.format(allowance));
        System.out.println("No. of OT Hours: " + overtimeHours);
        System.out.println("Overtime Pay: PHP " + pesoFormat.format(overtimePay));
        System.out.println("Gross Income: PHP " + pesoFormat.format(computeGrossIncome()));
        System.out.println("Withholding Tax: PHP " + pesoFormat.format(tax));
        System.out.println("Other Deductions: SSS: PHP " + pesoFormat.format(sss));
        System.out.println("Other Deductions: Pag-ibig: PHP " + pesoFormat.format(pagibig));
        System.out.println("Other Deductions: PhilHealth: PHP " + pesoFormat.format(philhealth));
        System.out.println("Net Pay: PHP " + pesoFormat.format(computeNetPay()));
    }
}
