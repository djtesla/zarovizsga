package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Collator;
import java.util.*;

public class DogTypes {

    private DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<String> getDogsByCountry(String country) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("select distinct name from dog_types where country = ?")) {
            ps.setString(1, country.toUpperCase());
            return getDogsByCountryPerPreparedStatement(ps);
        } catch (SQLException sqe) {
            throw new IllegalStateException("Cannot query", sqe);
        }
    }


    private List<String> getDogsByCountryPerPreparedStatement(PreparedStatement ps) throws SQLException {
        List<String> dogsByCountry = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String dogType = rs.getString(1);
                dogsByCountry.add(dogType.toLowerCase());
            }
        }
        Collections.sort(dogsByCountry);
        return dogsByCountry;
    }
}

