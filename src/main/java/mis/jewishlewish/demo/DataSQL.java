package mis.jewishlewish.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSQL {
    //consistent 
    private static final String dbfile = "jdbc:sqlite:database.db";

    private static Connection connection;
    
    
    public DataSQL(String dbfile) {
        try {
            connection = connect();
            Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER, first_name TEXT, last_name TEXT)");
            statement.execute("CREATE TABLE IF NOT EXISTS resume (id INTEGER, question TEXT, answer TEXT)");

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(dbfile);
    }

    public static boolean add_user(String firstname, String lastname, String uuid) {
        try {
            connection = connect();
            Statement statement = connection.createStatement();

            /*
             * user Table
             * UUID  |   firstname   | lastname
             */
            statement.execute("INSERT INTO users VALUES ('"+uuid+"', '"+firstname+"', '"+lastname+"');");

            statement.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean add_question(String uuid, String question, String answer) {
        try {
            connection = connect();
            Statement statement = connection.createStatement();

            /*
             * question Table
             * UUID  |   question   | answer
             */
            statement.execute("INSERT INTO resume VALUES ('"+uuid+"', '"+question+"', '"+answer+"');");

            statement.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    

    /*
    public static void main(String[] args) {
        DataSQL dataSQL = new DataSQL("database.db");
    }
    */
}
