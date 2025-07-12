// Util class to provide SessionFactory singleton
package utill;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
  private static final SessionFactory sessionFactory = build();

  private static SessionFactory build() {
    try {
      return new Configuration().configure().buildSessionFactory();
    } catch (Throwable ex) {
      System.err.println("Failed creating SessionFactory: " + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public static void shutdown() {
    getSessionFactory().close();
  }
}
