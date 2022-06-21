import java.sql.*;
import java.util.*;

public class DBConnect {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "root";

    private Connection connect = null;

    public Connection connectDB()
    {
        try {
            this.connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.connect;
    }

    public static Connection getInstance()
    {
        DBConnect db = new DBConnect();
        return db.connectDB();
    }

    public static void main(String[] args) {
        convertToArray.getList();
    }
}
