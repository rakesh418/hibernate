package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    static {
//        try {
//            if (sessionFactory == null) {
//                standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
//                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
//                Metadata metadata = metadataSources.getMetadataBuilder().build();
//                sessionFactory = metadata.getSessionFactoryBuilder().build();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            if(standardServiceRegistry !=null){
//                StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
//            }
//        }
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        Map<String,String> dbSettings = new HashMap<String, String>();
        dbSettings.put(Environment.URL,"jdbc:mysql://localhost:3306/jpa");
        dbSettings.put(Environment.USER,"lex418");
        dbSettings.put(Environment.PASS,"lex418");
        dbSettings.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        dbSettings.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");

        registryBuilder.applySettings(dbSettings);
        standardServiceRegistry=registryBuilder.build();
        MetadataSources sources = new MetadataSources(standardServiceRegistry);
        Metadata metadata = sources.getMetadataBuilder().build();
        sessionFactory=metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
