package pm;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

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

//    @Bean
//    @Qualifier("DriverManager")
//    public DataSource driverManagerDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost/zoo");
//
//        dataSource.setUsername("root");
//        dataSource.setPassword("password");
//
//        return dataSource;
//    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired @Qualifier("Hikari") DataSource dataSource) {
        return new JdbcTemplate((dataSource));
    }

}
