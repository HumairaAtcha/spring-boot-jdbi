package pm.animal.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.Before;
import org.junit.Test;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JdbiSqlRepositoryTest {

    private JdbiSqlRepository jdbiSqlRepository;
    private DBI dbi;

    @Before
    public void setUp() throws IOException, URISyntaxException {
        DataSource dataSource = testDataSource();
        dbi = new DBI(dataSource);
        jdbiSqlRepository = dbi.onDemand(JdbiSqlRepository.class);

        createDBTables();
    }

    @Test
    public void getsAllAnimals() {
        List<Animal> animals = Arrays.asList(
                new Animal().withName("tiger"),
                new Animal().withName("bear")
        );
        animals.forEach(this::insertAnimal);

        List<Animal> result = jdbiSqlRepository.getAll();

        assertThat(result).containsOnlyElementsOf(animals);
    }

    private void insertAnimal(Animal animal) {
        String sql = String.format("INSERT INTO animals (name) VALUES ('%s')", animal.getName());
        try (Handle handle = dbi.open()) {
            handle.execute(sql);
            handle.commit();
        }
    }

    private DataSource testDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setJdbcUrl("jdbc:h2:mem:testDb");
        ds.setUsername("sa");
        //ds.setPassword(password);
        return ds;
    }

    private void createDBTables() throws IOException, URISyntaxException {
        URL resource = this.getClass().getResource("create_tables.sql");

        Path path = Paths.get(resource.toURI());

        String sql = new String(Files.readAllBytes(path));

        try (Handle handle = dbi.open()) {
            handle.execute(sql);
            handle.commit();
        }
    }

}