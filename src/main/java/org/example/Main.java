package org.example;
import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        SQLFunctions sql = new SQLFunctions();
        // Simple testing program taking user input to test each function one at a time
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while(choice != 5){
            System.out.println("1: getAllStudents()");
            System.out.println("2: addStudent()");
            System.out.println("3: updateStudentEmail()");
            System.out.println("4: deleteStudent()");
            System.out.println("5. Exit");
            System.out.println("Choose a number to test a function: ");

            choice = Integer.parseInt(input.nextLine());
            if(choice == 1){
                sql.getAllStudents();

            }
            else if(choice == 2){
                System.out.println("Enter the student's first name: ");
                String first_name = input.nextLine();
                System.out.println("Enter the student's last name:");
                String last_name = input.nextLine();
                System.out.println("Enter the student's email:");
                String email = input.nextLine();
                System.out.println("Enter the student's date of enrollment (format: YYYY-MM-DD): ");
                Date enrollment_date = Date.valueOf(input.nextLine());

                sql.addStudent(first_name, last_name, email, enrollment_date);
            }
            else if(choice == 3){
                System.out.println("Enter the student's id:");
                int id = Integer.parseInt(input.nextLine());
                System.out.println("Enter the new email: ");
                String email = input.nextLine();

                sql.updateStudentEmail(id, email);
            }
            else if(choice == 4){
                System.out.println("Enter the student's id:");
                int id = Integer.parseInt(input.nextLine());
                sql.deleteStudent(id);
            }
            else if(choice == 5){
                break;
            }
        }
    }
}
