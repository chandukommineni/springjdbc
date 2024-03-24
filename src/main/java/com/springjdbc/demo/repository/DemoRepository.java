package com.springjdbc.demo.repository;

import com.springjdbc.demo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DemoRepository {
    @Autowired
    JdbcTemplate template;

    public int setData(Alien a){
        String sql="insert into alien(id,name,tech) values(?,?,?)";
        System.out.println("data inserted");
       return  template.update(sql,a.getId(),a.getName(),a.getTech());
    }

    public List<Alien> getData(){
        String sql="Select * from alien";
        RowMapper<Alien> mapper=new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien a=new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setTech(rs.getString(3));
                return a;
            }
        };
        List<Alien> l=template.query(sql,mapper);
        return l;
    }


}
