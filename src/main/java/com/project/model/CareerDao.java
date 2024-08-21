package com.project.model;

import com.project.model.request.Career;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class CareerDao {
    private final JdbcTemplate jdbcTemplate;

    public CareerDao(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    private int getLastCareerId() {
        String sql = "SELECT NVL(MAX(career_id), 0) FROM Career";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public int insertCareer(List<Career> careers, UserDO user) {
        String sql = "INSERT INTO Career (user_id, career_id, company_name, position, joined_date, retired_date, is_employed) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int rowsAffected = 0;
        int ind = getLastCareerId() + 1;
        for (Career career : careers) {
            System.out.println(ind);
            rowsAffected += jdbcTemplate.update(sql,
                    user.getUser_id(),  // user_id
                    ind,
                    career.getCompanyName(),  // company_name
                    career.getJobTitle(),
                    Date.valueOf(career.getStartDate()),  // joined_date
                    Date.valueOf(career.getEndDate()),  // retired_date
                    career.isEmployed() ? "1" : "0"  // is_employed
            );
            ind++;
        }

        return rowsAffected;  // Return the total number of rows affected
    }
}
