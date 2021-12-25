package com.company;

import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Database_our {
    public static OffersOperations ops;

    static {
        try {
            ops = new OffersOperations("Переводы.csv");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Connection connection;
    public static Statement statement;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:users.db");
        statement = connection.createStatement();
    }
    public static void createTable() throws SQLException {
        //System.out.print(statement.execute("SELECT * FROM Offers"));
        statement.execute("CREATE TABLE Offers (\n" +
                "    ID               INT (4)  PRIMARY KEY,\n" +
                "    Series_reference CHAR,\n" +
                "    Period           DATE,\n" +
                "    Data_value       DOUBLE,\n" +
                "    Suppressed       CHAR,\n" +
                "    STATUS           CHAR (1),\n" +
                "    UNITS            CHAR,\n" +
                "    Magnitude        INT,\n" +
                "    Subject          CHAR,\n" +
                "    [Group]          CHAR,\n" +
                "    Series_title_1   CHAR,\n" +
                "    Series_title_2   CHAR\n" +
                ")");
    }

    public static void dataToBD() throws SQLException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Offer i : ops.getOffersList().subList(1, ops.getOffersList().size())) {
            StringBuilder command = new StringBuilder();
            command.append("INSERT INTO Offers VALUES (");
            command.append(i.getID()).append(", ");
            command.append("'").append(i.getSeries_reference()).append("', ");
            command.append("'").append(dateFormat.format(i.getPeriod())).append("', ");
            command.append(i.getData_value()).append(", ");
            command.append("'").append(i.getSuppressed()).append("', ");
            command.append("'").append(i.getSTATUS()).append("', ");
            command.append("'").append(i.getUNITS()).append("', ");
            command.append(i.getMagnitude()).append(", ");
            command.append("'").append(i.getSubject()).append("', ");
            command.append("'").append(i.getGroup()).append("', ");
            command.append("'").append(i.getSeries_title_1()).append("', ");
            command.append("'").append(i.getSeries_title_2()).append("')");
            statement.execute(command.toString());
        }
    }

    public static ResultSet getData(String command) throws SQLException {
        return statement.executeQuery(command);
    }
}
