package pao.biblioteca.databaseServices;

import pao.biblioteca.AuditService;
import pao.biblioteca.WriteToFileService;
import pao.biblioteca.configurations.DatabaseConfiguration;
import pao.biblioteca.exceptions.FileWritingException;

import java.sql.*;

public class ReaderDatabaseService {
    public void dropTable() {
        String createTableSql = "DROP TABLE READERS";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
            System.out.println("Table READERS dropped");
        } catch (SQLException e) {
            System.out.println("You cannot drop the READERS table!");
        }
        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("Table READERS dropped");

    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS READERS(id_reader int PRIMARY KEY AUTO_INCREMENT, " +
                "name varchar(30),age int," +
                "id_book int ," +
                "foreign key(id_book) references BOOKS(id_book))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Table READERS created");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(" ** Table READERS **");
    }
    public void insertReader(String name, int  age,int id_book) {
        String insertPersonSql = "INSERT INTO READERS(name, age,id_book) VALUES(?,?,?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, id_book);

            preparedStatement.executeUpdate();


            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row inserted in READERS ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReader(String name, int  age,int id_book,int id_reader) {
        String updateNameSql = "UPDATE READERS SET name=?, age=?,id_book=? WHERE id_book=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, id_book);
            preparedStatement.setInt(4, id_reader);

            preparedStatement.executeUpdate();

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row updated in READERS ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayReader(int id_book) {
        String selectSql = "SELECT ID_READER,NAME,AGE, B.TITLE\n" +
                "FROM READERS R, BOOKS B\n" +
                "WHERE R.ID_BOOK = B.ID_BOOK\n" +
                "AND ID_READER = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id_book);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Id: " + resultSet.getString(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("Age: " + resultSet.getString(3));
                System.out.println("Book : " + resultSet.getString(4));
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            }

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Reader displayed");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void displayAllReaders() throws FileWritingException {
        String selectSql = "SELECT ID_READER,NAME,AGE, B.TITLE\n" +
                "FROM READERS R, BOOKS B\n" +
                "WHERE R.ID_BOOK = B.ID_BOOK";
        String output = "";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        BookDatabaseService bookDatabaseService = new BookDatabaseService();

        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {


                output += "Id: " + resultSet.getString(1) + "\n";
                output += "Name: " + resultSet.getString(2)+"\n";
                output += "Age: " + resultSet.getString(3) +"\n";
                output += "Book: " + resultSet.getString(4) +"\n";
                output += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
            }

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("All readers displayed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        WriteToFileService.writeUsingFileOutputStream(output,"all_readers.txt");
    }

    public void deleteReader( int id_reader){
        String deleteSql = "DELETE FROM READERS WHERE id_reader =?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1,id_reader);
            preparedStatement.executeUpdate();

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row deleted in READERS ");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
