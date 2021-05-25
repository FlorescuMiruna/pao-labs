package pao.biblioteca.databaseServices;

import pao.biblioteca.AuditService;
import pao.biblioteca.ReadFromCSVFileService;
import pao.biblioteca.WriteToFileService;
import pao.biblioteca.configurations.DatabaseConfiguration;
import pao.biblioteca.entity.Author;
import pao.biblioteca.entity.Book;
import pao.biblioteca.exceptions.FileReadingException;
import pao.biblioteca.exceptions.FileWritingException;

import java.sql.*;
import java.util.ArrayList;

public class AuthorDatabaseService {

    public void dropTable() {
        String createTableSql = "DROP TABLE AUTHORS";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
            System.out.println("Table AUTHORS dropped");

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Table AUTHORS dropped");

        } catch (SQLException e) {
            System.out.println("You cannot drop the AUTHORS table!");
        }


    }

    public void createTable() {
        String createTableSql =  "CREATE TABLE IF NOT EXISTS AUTHORS" +
                "(id_author int PRIMARY KEY AUTO_INCREMENT, name varchar(30),nationality varchar(30))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile(" ** AUTHORS **");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(" ** Table AUTHORS **");
    }

    public void insertAuthor(String name, String nationality) {
        String insertPersonSql = "INSERT INTO AUTHORS(name, nationality) VALUES(?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, nationality);

            preparedStatement.executeUpdate();


            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row inserted in AUTHORS ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAuthorsFromCSVFile() throws FileWritingException, FileReadingException {

        ArrayList<ArrayList<String>> myAuthors = new ArrayList<ArrayList<String>>();


        myAuthors = ReadFromCSVFileService.readFromAuthorFile("Author.csv");



        for (int i = 0; i < myAuthors.get(0).size(); ++i) {

            String name = myAuthors.get(0).get(i);
            String nationality = myAuthors.get(1).get(i);

            String insertPersonSql = "INSERT INTO AUTHORS(name, nationality) VALUES(?, ?)";

            Connection connection = DatabaseConfiguration.getDatabaseConnection();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, nationality);

                preparedStatement.executeUpdate();



            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("Inserted authors from CSV file");
}



    public void updateAuthor(String name,String nationality,int id_author) {
        String updateNameSql = "UPDATE AUTHORS SET name=?, nationality=? WHERE id_author=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, nationality);
            preparedStatement.setInt(3, id_author);

            preparedStatement.executeUpdate();

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row updated in AUTHORS ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAuthor( int id_author){
        String deleteSql = "DELETE FROM AUTHORS WHERE id_author =?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1,id_author);
            preparedStatement.executeUpdate();

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row deleted in AUTHORS ");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void displayAuthor(int id_author) {
        String selectSql = "SELECT * FROM AUTHORS WHERE id_author=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id_author);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Id: " + resultSet.getString(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("Nationality: " + resultSet.getString(3));
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            }

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Author displayed");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void displayAllAuthors() throws FileWritingException {
        String selectSql = "SELECT * FROM AUTHORS";
        String output = "";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {


                output += "Id: " + resultSet.getString(1) + "\n";
                output += "Name: " + resultSet.getString(2) + "\n";
                output += "Nationality: " + resultSet.getString(3) +"\n";
                output += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
            }

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("All authors displayed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        WriteToFileService.writeUsingFileOutputStream(output,"all_authors.txt");

    }
}
