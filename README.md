# COMP3005-A3Q1
https://www.youtube.com/watch?v=No7lM6MmVnk

Steps to Compile and Run this Application:
1. Download the provided files and extract them
2. Set up a database in pgAdmin and run the provided query in DDL.sql to create the students relation. Optionally, run the query from DML.sql to populate the database for testing purposes.
3. Open a project in IntelliJ and select the COMP3005-A3Q1-main folder in whichever directory you extracted it
4. When prompted with "Maven Build Script Found", select Load to let IntelliJ download the required dependencies
5. Navigate to "src/main/java/org/example/Main.java" and run it to test the database application functionality

   note: In SQLFunctions.java, the string user has been set to "postgres" and password has been set to "admin". If these do not reflect the credentials that you have in pgadmin, manually overwrite these string definitions to match your credentials to allow it to connect to the database.
