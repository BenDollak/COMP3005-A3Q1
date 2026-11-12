package org.example;
import java.sql.*;

public class SQLFunctions {
    // Defines arguments used to connect to the database
    String url = "jdbc:postgresql://localhost:5432/Assignment 3 Question 1";
    String user = "postgres";
    String password = "admin";

    // Function to establish a connection to the database used in all four required functions
    public Connection connect(){
        try { // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    // Prints the details of every student in the students relation in the database
    public void getAllStudents() {
        try {
            // Connect to the database and store the entire students relation in a ResultSet
            Connection conn = connect();
            Statement statement = conn.createStatement();
            ResultSet students = statement.executeQuery("SELECT * FROM students");

            // Print all students with a new line for each attribute
            while (students.next()) {
                System.out.println("Student ID: " + students.getInt("student_id"));
                System.out.println("First Name: " + students.getString("first_name"));
                System.out.println("Last Name: " + students.getString("last_name"));
                System.out.println("Email: " + students.getString("email"));
                System.out.println("Enrollment Date: " + students.getDate("enrollment_date"));
            }
            System.out.println("Students returned succesfully");

            students.close();
            statement.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to get all students");
        }
    }
    // Adds a new tuple to the student relation in the database
    public void addStudent(String first_name, String last_name, String email, Date enrollment_date){

        try{
            // Establish a connection to the database and create an INSERT template
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO students(first_name, last_name, email, enrollment_date) " +
                    "VALUES(?, ?, ?, ?)");
            // Specify the placeholders within the INSERT template with the arguments specified during the function call
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setDate(4, enrollment_date);

            // Execute the INSERT statement with the provided values
            pstmt.executeUpdate();
            System.out.println("Student added successfully");

            pstmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add student");
        }
    }
    // Updates a specific student's email attribute within the student relation, using their unique student_id
    public void updateStudentEmail(int student_id, String new_email){
        try{
            // Establish a connection to the database and specify the template's placeholder values with the provided arguments in the function call
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE students SET email = ? WHERE student_id = ?");
            pstmt.setString(1, new_email);
            pstmt.setInt(2, student_id);

            // Executes the update, and uses the return value of .executeUpdate() to verify whether any rows were actually affected
            int updatedStudent = pstmt.executeUpdate();
            if(updatedStudent == 0){
                System.out.println("Student with specified ID not found");
            }
            else{
                System.out.println("Email updated successfully");
            }
            pstmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update student email");
        }
    }
    // Deletes a specific tuple in the students relation using their unique student_id as identifier
    public void deleteStudent(int student_id){
        try{
            // Establish a connection and create a DELETE statement using student_id as the identifier for which tuple to delete
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM students WHERE student_id = ?");
            pstmt.setInt(1, student_id);
            // Executes the DELETE statement, and uses .executeUpdate()'s return value to verify if a deletion actually took place
            int deletedStudent = pstmt.executeUpdate();
            if(deletedStudent == 0){
                System.out.println("Could not find student to delete");
            }
            else{
                System.out.println("Student deleted successfully");
            }
            pstmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to delete student");
        }
    }
}
