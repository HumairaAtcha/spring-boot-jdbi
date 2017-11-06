package pm.animal.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcTemplateRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Animal> getAll() {
        String query = "SELECT name FROM animals";

        List<Animal> animals = jdbcTemplate.query(query, new BeanPropertyRowMapper(Animal.class));

        return animals;
    }
}
