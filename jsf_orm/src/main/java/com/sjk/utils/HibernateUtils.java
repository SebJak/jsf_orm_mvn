package com.sjk.utils;

import com.sjk.model.Organization;
import com.sjk.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Sebastian on 2015-05-21.
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try{
            Configuration configuration = getConfiguration();
            System.out.println("Created configuration");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Created service Registry");
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            System.out.println("Created session factory");
            return sessionFactory;

        }
        catch (Throwable ex){
            System.out.println("Initial Session factory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }

    private static Configuration getConfiguration() {
        try {

            Properties properties = new Properties();
            InputStream in = HibernateUtils.class
                    .getResourceAsStream("/dataBase.properties");
            properties.load(in);
            //System.out.println(properties.getProperty("jdbc_connection"));
            in.close();
            Configuration configuration = new Configuration();
           configuration.setProperty("hibernate.connection.url",
                    properties.getProperty("jdbc_connection"));
			configuration.setProperty("hibernate.connection.username",
					properties.getProperty("user"));
			configuration.setProperty("hibernate.connection.password",
					properties.getProperty("password"));
            configuration.setProperty("hibernate.connection.driver_class",
                    "com.mysql.jdbc.Driver");
            configuration.setProperty("hibernate.connection.autocommit", "true");
            configuration.setProperty("hibernate.dialect",
                    "org.hibernate.dialect.MySQLDialect");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
			configuration.setProperty("show_sql",
					properties.getProperty("show_sql"));
            configuration.setProperty("connection.pool_size", "1");
            configuration
                    .setProperty("current_session_context_class", "thread");

//-------------------------Mapping Class---------------------------------
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Organization.class);
//            configuration.addAnnotatedClass(Product.class);
//----------------------------------------------------------------------
            return configuration;


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("IOException");
            e.printStackTrace();
        }
        return null;
    }
}
