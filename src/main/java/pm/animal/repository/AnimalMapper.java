package pm.animal.repository;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimalMapper implements ResultSetMapper<Animal> {
    @Override
    public Animal map(int index, ResultSet resultSet, StatementContext ctx) throws SQLException {
        return new Animal()
                .withName(resultSet.getString("name"));
    }
}
