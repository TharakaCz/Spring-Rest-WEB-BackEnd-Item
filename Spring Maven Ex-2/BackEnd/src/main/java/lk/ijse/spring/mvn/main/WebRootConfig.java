package lk.ijse.spring.mvn.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@PropertySource("classpath:application.properties")
@Configuration
public class WebRootConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean embf = new LocalContainerEntityManagerFactoryBean();
        embf.setDataSource(ds);
        embf.setJpaVendorAdapter(jpaVendorAdapter);
        embf.setPackagesToScan("lk.ijse.spring.mvn.entity");
        return embf;
    }

    @Bean
    public DataSource dataSource(){

        DriverManagerDataSource dms = new DriverManagerDataSource();
        dms.setDriverClassName("com.mysql.jdbc.Driver");
        dms.setUsername(env.getRequiredProperty("spring.datasource.username"));
        dms.setPassword(env.getRequiredProperty("password"));
        dms.setUrl(env.getRequiredProperty("url"));
        return dms;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter jpa = new HibernateJpaVendorAdapter();
        jpa.setDatabase(Database.MYSQL);
        jpa.setGenerateDdl(true);
        jpa.setShowSql(true);
        jpa.setDatabasePlatform(env.getRequiredProperty("dialect"));
        return jpa;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }
}
