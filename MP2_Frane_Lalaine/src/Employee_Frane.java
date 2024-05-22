/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Date;
import java.util.Scanner;

public class Employee_Frane {
    // Main method to test the class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a scanner object

        // Read employee name
        System.out.println("Enter your full name: ");
        String employee = scanner.nextLine();

        // Read basic pay
        System.out.println("Enter your basic salary: ");
        double basicPay = scanner.nextDouble();

        // Read allowance
        System.out.println("Enter your allowance: ");
        double allowance = scanner.nextDouble();

        // Read overtime hours
        System.out.println("Enter your overtime hours: ");
        int overtimeHours = scanner.nextInt();

        // Close the scanner
        scanner.close();

        // Create a Payslip object and set values
        Payslip_Frane payslip = new Payslip_Frane();
        payslip.setEmployee(employee);
        payslip.setBasicPay(basicPay);
        payslip.setAllowance(allowance);
        payslip.setOvertimeHours(overtimeHours);

        // Calculate deductions
        payslip.setSss(basicPay * 0.13);
        payslip.setPagibig(basicPay * 0.02);
        payslip.setPhilhealth(basicPay * 0.035);

        // Calculate tax, overtime pay, and display payslip
        payslip.determineWithholdingTax();
        payslip.calculateOvertimePay();
        payslip.displayPayslip();
    }
}
