package org.uv.TPCS_Practica03.hibernate;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.uv.TPCS_Practica03.domain.Cliente;
import org.uv.TPCS_Practica03.domain.Det_Venta;
import org.uv.TPCS_Practica03.domain.Producto;
import org.uv.TPCS_Practica03.domain.Venta;

/* @author miran */

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            
            //DB de ejemplo
            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/ventas");
            settings.put(Environment.USER, "postgres");
            settings.put(Environment.PASS, "laptophp");
            
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            settings.put(Environment.HBM2DDL_AUTO,"create-drop");
            configuration.setProperties(settings);
            
            //Declaración de entidades
            configuration.addAnnotatedClass(Cliente.class);            
            configuration.addAnnotatedClass(Venta.class);           
            configuration.addAnnotatedClass(Det_Venta.class);
            configuration.addAnnotatedClass(Producto.class);
            
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            
            sessionFactory = configuration.buildSessionFactory((org.hibernate.service.ServiceRegistry)serviceRegistry);
        }
        return sessionFactory;
    }
    
    //Inicio de conexión
    public static Session getSession() throws HibernateException{
        if(sessionFactory==null){
            getSessionFactory();
        }
        return sessionFactory.openSession();
    }
}
