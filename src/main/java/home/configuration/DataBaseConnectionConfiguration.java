package home.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataBaseConnectionConfiguration {


//    @Value("${db.driver}")
//    private String driver;
//    @Value("${db.url}")
//    private String url;
//    @Value("${db.username}")
//    private String username;
//    @Value("${db.password}")
//    private String password;


    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("org.postgresql.Driver");
        source.setUrl("jdbc:postgresql://localhost:7474/smarthome");
        source.setUsername("smarthome");
        source.setPassword("Microlab");
//        source.setDriverClassName(driver);
//        source.setUrl(url);
//        source.setUsername(username);
//        source.setPassword(password);
        return source;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
        return new NamedParameterJdbcTemplate(this.dataSource());
    }
}
