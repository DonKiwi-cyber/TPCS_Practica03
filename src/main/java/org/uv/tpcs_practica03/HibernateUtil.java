package org.uv.tpcs_practica03;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

/* @author miran */

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            
            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/ventas");
            settings.put(Environment.USER, "postgres");
            settings.put(Environment.PASS, "laptophp");
            
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            settings.put(Environment.HBM2DDL_AUTO,"create-drop");
            configuration.setProperties(settings);
            
            //agrega pojo cliente como entity
            configuration.addAnnotatedClass(Cliente.class);
            
            //agrega pojo venta como entity
            configuration.addAnnotatedClass(Venta.class);
            
            //agrega pojo DetVenta como entity
            configuration.addAnnotatedClass(Det_Venta.class);
            
            //agrega pojo Producto como entity
            configuration.addAnnotatedClass(Producto.class);
            
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            
            sessionFactory = configuration.buildSessionFactory((org.hibernate.service.ServiceRegistry)serviceRegistry);
        }
        return sessionFactory;
    }
    
}
