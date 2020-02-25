package com.goit.jdbc;

import com.goit.jdbc.config.DatabaseManagerConnector;
import com.goit.jdbc.dao.LocationDAO;
import com.goit.jdbc.model.Location;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseManagerConnector db = new DatabaseManagerConnector("localhost", 5432,
                "go_it", "postgres", "admin");
        Connection connection = db.getConnection();

        Location location = new Location();
        location.setId(450);
        location.setStreetAddress("Mechnikova");
        location.setPostalCode("01111");
        location.setCity("Kyiv");
        location.setStateProvince("Kyiv region");

        LocationDAO dao = new LocationDAO(connection);
        dao.create(location);
    }
}
