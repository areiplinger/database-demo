package com.in28minutes.database.databasedemo.jdbc;

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person>{

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirth_date(rs.getTimestamp("birth_date"));
            return person;
        }
    }

    // select * from Person table
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from Person",
                new PersonRowMapper());
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from Person where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person findByName(String name) {
        return jdbcTemplate.queryForObject(
                "select * from Person where name=?",
                new Object[]{name},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int insertValues(Person person) {
        return jdbcTemplate.update(
                "insert into person(id,name,location,birth_date)" +
                        "values (?,?,?,?)",
                new Object[]{person.getId(), person.getName(),
                        person.getLocation(), new Timestamp(person.getBirth_date().getTime())});
    }

    public int updateValues(Person person) {
        return jdbcTemplate.update(
                "update person set name=?, location=?, birth_date=? " +
                        "where id =?",
                new Object[]{person.getName(), person.getLocation(),
                        new Timestamp(person.getBirth_date().getTime()), person.getId()});
    }

    public int deleteById(int id) {
        return jdbcTemplate.update(
                "delete from Person where id=?",
                new Object[]{id});
    }


}
