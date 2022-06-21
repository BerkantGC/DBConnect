import java.sql.*;
import java.util.*;

public class convertToArray {
    private String title;
    private String description;
    private int release_year;

    public static List<convertToArray> getList()
    {
        List<convertToArray> userList = new ArrayList<>();
        convertToArray cta = null;

        try {
            Statement st = DBConnect.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT film_id, title, description, release_year " +
                                            "FROM film " +
                                            "WHERE film_id BETWEEN 0 AND 100");
            while(rs.next())
            {
                cta = new convertToArray();
                cta.setTitle(rs.getString("title"));
                cta.setDescription(rs.getString("description"));
                cta.setRelease_year(rs.getInt("release_year"));
                cta.setFilm_id(rs.getInt("film_id"));
                userList.add(cta);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        SortDesc desc = new SortDesc(userList);
        List<convertToArray> sortedList = desc.sort();

        for(convertToArray obj : sortedList)
        {
            System.out.println(obj.getFilm_id());
            System.out.println(obj.getTitle());
            System.out.println(obj.getDescription());
            System.out.println(obj.getRelease_year());
            System.out.println();
        }
        return userList;
    }

    private int film_id;

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
}
