import java.sql.*;
import java.util.*;

public class DBConnect {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            st = conn.createStatement();

            String areas = new String();
            ResultSet resultSet = st.executeQuery("SELECT * " +
                                                    "FROM film " +
                                                    "WHERE film_id BETWEEN 10 AND 50");

            List<Object> titles = new ArrayList<>();
            List<List> listOfTitles = new ArrayList<>();
            int i = 0;
            //System.out.println("ID : " + resultSet.getInt("film_id"))
           while (resultSet.next()) {
               titles.clear();

               for(int j= 1; j<=4; j++)
               {
                   titles.add(resultSet.getObject(j).);
               }

               listOfTitles.add(titles);
               //System.out.println(listOfTitles);
            /*   System.out.println("Title : " + resultSet.getString("title"));
                System.out.println("Description : " + resultSet.getString("description"));
                System.out.println("Year : " + resultSet.getInt("release_year"));
                System.out.println("#################");*/
                i++;
            }

            System.out.println(listOfTitles.get(0));

            //System.out.println(stack.pop());
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
