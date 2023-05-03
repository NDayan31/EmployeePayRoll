package com.employeepay;

import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String fileInput = "EmployeeList.txt";
        String fileOutput= "EmployeeGross";
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(fileInput));
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(fileOutput));

            String text;
            String input;

            while ((input = bufReader.readLine()) != null) {
                String[] getEmployeeInfo = input.split(Pattern.quote("|"));

                int id = Integer.parseInt(getEmployeeInfo[0]);
                String name = getEmployeeInfo[1];
                double HoursWorked = Double.parseDouble(getEmployeeInfo[2]);
                double PayRate = Double.parseDouble(getEmployeeInfo[3]);

                Employee employee = new Employee(id, name, HoursWorked, PayRate);

                System.out.printf("Employee ID: %d, Employee Name: %s, Gross Pay: $%.2f%n",
                        employee.getEmployeeID(),employee.getName(), employee.getGrossPay());

                text = String.format("Employee ID: %d, Employee Name: %s, Gross Pay: $%.2f%n",
                        employee.getEmployeeID(), employee.getName(), employee.getGrossPay());
                bufWriter.write(text);
            }
            bufReader.close();
            bufWriter.close();

        } catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
            e.getStackTrace();
            throw new RuntimeException(e);

        }
    }

}
