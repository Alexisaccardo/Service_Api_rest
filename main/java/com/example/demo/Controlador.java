package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
public class Controlador {
    @PostMapping("/register")
    public Services services(@RequestBody Services services) throws SQLException, ClassNotFoundException, ParseException {

        String code = services.getCode();
        String name = services.getName();
        String ally = services.getAlly();
        LocalDateTime activation_date = LocalDateTime.now();
        LocalDateTime inactivation_date = services.getInactivation_date();
        String status = services.getStatus();

        if (code == null || code.equals("") || code.length() < 0 || name == null || name.equals("") || name.length() < 0 ||
                ally == null || ally.equals("") || ally.length() < 0 ||
                status == null || status.equals("") || status.length() < 0) {

            return new Services(null, null, null, null, null, null);

        } else {
            BD bd = new BD();
            services = bd.register(code, name, ally, activation_date, inactivation_date, status);
        }

        return services;
    }

    @PostMapping("/edit_")
    public Services edit(@RequestBody Services services) throws SQLException, ClassNotFoundException {

        String code = services.getCode();
        String name = services.getName();
        String ally = services.getAlly();
        LocalDateTime activation_date = services.getActivation_date();
        LocalDateTime inactivation_date = LocalDateTime.now();
        String status = services.getStatus();

        if (code == null || code.equals("") || code.length() < 0 || name == null || name.equals("") || name.length() < 0 ||
                ally == null || ally.equals("") || ally.length() < 0) {

            return new Services(null, null, null, null, null, null);

        } else {
            BD bd = new BD();
            services = bd.Edit(code, name, ally, activation_date, inactivation_date, "Inactivo");
        }
        return services;
    }

    @GetMapping("/search")
    public List<Services> search() throws SQLException, ClassNotFoundException {
        BD bd = new BD();
        List<Services> list = bd.Select();

        return list;
    }

    @GetMapping("/search_inactive")
    public List<Services> search_inactive() throws SQLException, ClassNotFoundException {

        BD bd = new BD();
        List<Services> list = bd.Search_inactive();

        return list;
    }
}
