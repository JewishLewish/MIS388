package mis.jewishlewish.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSQL {
    private String dbfile;
    private Connection connection;
    
    public DataSQL(String dbfile) {
        this.dbfile = dbfile;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + this.dbfile);
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
    

    public static void main(String[] args) {
        DataSQL dataSQL = new DataSQL("database.db");
    }
}
