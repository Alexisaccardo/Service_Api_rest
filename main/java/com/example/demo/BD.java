package com.example.demo;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BD {
    public BD() {
    }


    public Services register(String code, String name, String ally, LocalDateTime convert, LocalDateTime inactivation_date, String status) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/services";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM service");


            // Sentencia INSERT
            String sql = "INSERT INTO service (code, name, ally, creation_date, inactivation_date, status) VALUES (?, ?, ?, ?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, ally);
            preparedStatement.setString(4, String.valueOf(convert));
            preparedStatement.setString(5, "");
            preparedStatement.setString(6, status);


            // Ejecutar la sentencia
            int files = preparedStatement.executeUpdate();

            if (files > 0) {
                System.out.println("Registrado realizado de manera exitosa.");
                return new Services(code, name, ally, convert , inactivation_date, status);
            } else {
                System.out.println("No se puedo realizar el registro");
            }

            preparedStatement.close();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Services(null, null, null, null, null, null);
    }

    public Services Edit(String code, String name, String ally, LocalDateTime activation_date, LocalDateTime inactivation_date, String status) throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/services";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        String consult = "UPDATE service SET name = ?, ally = ?, creation_date = ?, inactivation_date = ?, status = ? WHERE code = ?";
        PreparedStatement preparedStatement = connection2.prepareStatement(consult);

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, ally);
        preparedStatement.setString(3, String.valueOf(activation_date));
        preparedStatement.setString(4, String.valueOf(LocalDateTime.now()));
        preparedStatement.setString(5, "Inactivo");
        preparedStatement.setString(6,code);


        int files = preparedStatement.executeUpdate();
        if (files > 0) {
            System.out.println("Registro actualizado de manera exitosa");
            return new Services(code, name, ally, activation_date, inactivation_date, status);
        } else {
            System.out.println("El registro no se pudo actualizar");
        }

        preparedStatement.close();
        connection2.close();
        return new Services(null, null, null, null, null, null);
    }

    public List<Services> Select() throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/services";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM service");

        List<Services> list = new ArrayList<>();

        while (resultSet2.next()) {
            String code = resultSet2.getString("code");
            String name = resultSet2.getString("code");
            String ally = resultSet2.getString("code");
            LocalDateTime activation_date = LocalDateTime.parse((resultSet2.getString("creation_date")));
            LocalDateTime inactivation_date = LocalDateTime.parse((resultSet2.getString("creation_date")));
            String status = resultSet2.getString("status");

            Services services = new Services(code, name, ally, activation_date, inactivation_date, status);

            list.add(services);

        }
        return list;
    }

    public List<Services> Search_inactive() throws ClassNotFoundException, SQLException {
        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/services";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM service WHERE status = 'Inactivo'");

        List<Services> list = new ArrayList<>();

        while (resultSet2.next()) {
            String code = resultSet2.getString("code");
            String name = resultSet2.getString("name");
            String ally = resultSet2.getString("ally");
            LocalDateTime activation_date = LocalDateTime.parse((resultSet2.getString("creation_date")));
            LocalDateTime inactivation_date = LocalDateTime.parse((resultSet2.getString("creation_date")));
            String status = resultSet2.getString("status");

            Services services = new Services(code, name, ally, activation_date, inactivation_date, status);

            list.add(services);

        }
        return list;
    }
    }




