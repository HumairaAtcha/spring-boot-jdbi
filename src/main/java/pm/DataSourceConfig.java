package pm;

import com.zaxxer.hikari.HikariDataSource;
import org.skife.jdbi.v2.DBI;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pm.animal.repository.JdbiSqlRepository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DataSourceConfig {

    @Value("${datasource.driver}")
    private String driver;

    @Value("${datasource.url}")
    private String jdbcUrl;

    @Value("${datasource.user}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    @Bean
    @Qualifier("Hikari")
    public DataSource hikariDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setJdbcUrl(jdbcUrl);

        username = "root";
        dataSource.setUsername(username);
        password = "password";
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    JdbiSqlRepository jdbiSqlRepository(@Qualifier("Hikari") DataSource dataSource) throws SQLException { // TODO: shouldn't need qualifier - get rid of spring-jdbc dependency
        DBI dbi = new DBI(dataSource);
        return dbi.onDemand(JdbiSqlRepository.class);
    }

}
