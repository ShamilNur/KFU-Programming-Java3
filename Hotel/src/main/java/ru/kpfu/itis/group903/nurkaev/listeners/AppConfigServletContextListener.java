package ru.kpfu.itis.group903.nurkaev.listeners;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.itis.group903.nurkaev.repositories.*;
import ru.kpfu.itis.group903.nurkaev.services.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

@WebListener
public class AppConfigServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        Properties properties = new Properties();
        try {
            properties.load(servletContext.getResourceAsStream("/WEB-INF/properties/db.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        // HikariCP for dataSource
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(properties.getProperty("db.url"));
        hikariConfig.setDriverClassName(properties.getProperty("db.driver.classname"));
        hikariConfig.setUsername(properties.getProperty("db.username"));
        hikariConfig.setPassword(properties.getProperty("db.password"));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.hikari.max-pool-size")));
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        servletContext.setAttribute("dataSource", dataSource);

        // UsersRepository
        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
        UsersService usersService = new UsersServiceImpl(usersRepository);
        servletContext.setAttribute("usersService", usersService);

        // RoomsRepository
        RoomsRepository roomsRepository = new RoomsRepositoryJdbcImpl(dataSource);
        RoomsService roomsService = new RoomsServiceImpl(roomsRepository);
        servletContext.setAttribute("roomsService", roomsService);

        // NewsRepository
        NewsRepository newsRepository = new NewsRepositoryJdbcImpl(dataSource);
        NewsService newsService = new NewsServiceImpl(newsRepository);
        servletContext.setAttribute("newsService", newsService);

        // PasswordEncoder
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        servletContext.setAttribute("passwordEncoder", passwordEncoder);
    }

}
