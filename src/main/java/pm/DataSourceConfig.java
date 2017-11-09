package pm;

import com.zaxxer.hikari.HikariDataSource;
import org.skife.jdbi.v2.DBI;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pm.animal.repository.JdbiSqlRepository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DataSourceConfig {

    @Bean
    @Qualifier("Hikari")
    public DataSource hikariDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost/zoo");

        dataSource.setUsername("root");
        dataSource.setPassword("password");

        return dataSource;
    }

    @Bean
    JdbiSqlRepository jdbiSqlRepository(@Qualifier("Hikari") DataSource dataSource) throws SQLException { //TODO: shouldn't need qualifier - get rid of spring-jdbc dependency
        DBI dbi = new DBI(dataSource);
        return dbi.onDemand(JdbiSqlRepository.class);
    }

}
