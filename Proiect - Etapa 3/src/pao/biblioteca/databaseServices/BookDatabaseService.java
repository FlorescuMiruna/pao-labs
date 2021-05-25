package pao.biblioteca.databaseServices;

import pao.biblioteca.AuditService;
import pao.biblioteca.WriteToFileService;
import pao.biblioteca.configurations.DatabaseConfiguration;
import pao.biblioteca.exceptions.FileWritingException;

import java.sql.*;

public class BookDatabaseService {

    public void dropTable() {
        String createTableSql = "DROP TABLE BOOKS";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
            System.out.println("Table BOOKS dropped");

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Table BOOKS dropped");

        } catch (SQLException e) {
            System.out.println("You cannot drop the BOOKS table!");
        }


    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS BOOKS(id_book int PRIMARY KEY AUTO_INCREMENT, " +
                "year int,title varchar(30)," +
                "id_section int ,id_author int," +
                "foreign key(id_section) references SECTIONS(id_section)," +
                "foreign key(id_author) references AUTHORS(id_author))";



        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Table BOOKS created");

        } catch (SQLException e) {
            e.printStackTrace();
        }



        System.out.println(" ** Table BOOKS ** ~");
    }
    public void insertBook(int year, String title,int id_section,int id_author) {
        String insertPersonSql = "INSERT INTO BOOKS(year, title,id_section,id_author) VALUES(?,?,?,?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setInt(1, year);
            preparedStatement.setString(2, title);
            preparedStatement.setInt(3, id_section);
            preparedStatement.setInt(4, id_author);

            preparedStatement.executeUpdate();


            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row inserted in BOOKS ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(int year,String title,int id_section, int id_author, int id_book) {
        String updateNameSql = "UPDATE BOOKS SET year=?, title=?,id_section=?,id_author=? WHERE id_book=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1, year);
            preparedStatement.setString(2, title);
            preparedStatement.setInt(3, id_section);
            preparedStatement.setInt(4, id_author);
            preparedStatement.setInt(5, id_book);

            preparedStatement.executeUpdate();

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row updated in BOOKS ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayBook(int id_book) {
        String selectSql = "SELECT ID_BOOK, YEAR, TITLE, S.name, A.NAME\n" +
                "FROM BOOKS B, SECTIONS S, AUTHORS A\n" +
                "WHERE  B.ID_SECTION = S.ID_SECTION\n" +
                "AND B.ID_AUTHOR = A.ID_AUTHOR\n" +
                "AND ID_BOOK = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id_book);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Id: " + resultSet.getString(1));
                System.out.println("Year: " + resultSet.getString(2));
                System.out.println("Title: " + resultSet.getString(3));
                System.out.println("Section: " + resultSet.getString(4));
                System.out.println("Author: " + resultSet.getString(5));
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            }
            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Book displayed");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void displayAllBooks() throws FileWritingException {
        String selectSql = "SELECT ID_BOOK, YEAR, TITLE, S.name, A.NAME\n" +
                "FROM BOOKS B, SECTIONS S, AUTHORS A\n" +
                "WHERE  B.ID_SECTION = S.ID_SECTION\n" +
                "AND B.ID_AUTHOR = A.ID_AUTHOR\n";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        String output = "";
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {


                output += "Id: " + resultSet.getString(1) + "\n";
                output += "Year: " + resultSet.getString(2)+"\n";
                output += "Title: " + resultSet.getString(3)+"\n";
                output += "Section: " + resultSet.getString(4) +"\n";
                output += "Author: " + resultSet.getString(5) + "\n";
                output += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
            }
            WriteToFileService.writeUsingFileOutputStream(output,"all_books.txt");


            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("All books displayed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook( int id_book){
        String deleteSql = "DELETE FROM BOOKS WHERE id_book =?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1,id_book);
            preparedStatement.executeUpdate();

            AuditService auditService = new AuditService();
            auditService.WriteActionsToCSVFile("Row deleted in BOOKS ");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
