package pao.biblioteca.databaseServices;

import pao.biblioteca.AuditService;
import pao.biblioteca.ReadFromCSVFileService;
import pao.biblioteca.WriteToFileService;
import pao.biblioteca.configurations.DatabaseConfiguration;
import pao.biblioteca.exceptions.FileReadingException;
import pao.biblioteca.exceptions.FileWritingException;

import java.sql.*;
import java.util.ArrayList;

public class SectionDatabaseService {

    public void dropTable() {


        String createTableSql = "DROP TABLE SECTIONS";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
            System.out.println("Table SECTIONS dropped");

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Table SECTIONS dropped");

        } catch (SQLException e) {
            System.out.println("You cannot drop the SECTIONS table!");
        }


    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS SECTIONS" +
                "(id_section int PRIMARY KEY AUTO_INCREMENT, name varchar(30))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);


            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Table SECTIONS created");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(" ** Table SECTIONS ** ");

    }
    public void insertSection(String name) {
        String insertPersonSql = "INSERT INTO SECTIONS(name) VALUES(?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();


            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row inserted in SECTIONS ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateSection(String name,int id_section) {
        String updateNameSql = "UPDATE SECTIONS SET name =? WHERE id_section=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id_section);

            preparedStatement.executeUpdate();

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row updated in SECTIONS ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteSection( int id_section){
        String deleteSql = "DELETE FROM SECTIONS WHERE id_section =?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1,id_section);
            preparedStatement.executeUpdate();

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row deleted in SECTIONS ");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void displaySection(int id_section) {
        String selectSql = "SELECT * FROM SECTIONS WHERE id_section=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id_section);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Id: " + resultSet.getString(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            }
            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Section displayed");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void displayAllSections() throws FileWritingException{
        String selectSql = "SELECT * FROM SECTIONS";
        String output = "";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {


                output += "Id: " + resultSet.getString(1) + "\n";
                output += "Name: " + resultSet.getString(2) + "\n";
                output += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
            }

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("All sections displayed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        WriteToFileService.writeUsingFileOutputStream(output,"all_sections.txt");
    }
}