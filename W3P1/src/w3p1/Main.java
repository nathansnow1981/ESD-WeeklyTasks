
package w3p1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Nathaniel Snow - 12060962 (CQUniversity)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //Create an instance of book
        Book book = new Book();
        book.setTitle("Book-1");
        /*
        The constructor Float(double) is deprecated since version 9Java(67110271)
        java.lang.Float.Float(double value)
        Deprecated It is rarely appropriate to use this constructor. Instead, use the static factory method valueOf(float) method as follows: Float.valueOf((float)value).

        Constructs a newly allocated Float object that represents the argument converted to type float.

        Parameters:
        value the value to be represented by the Float.
        */
        //book.setPrice(new Float(50.50));
        book.setPrice((float) 50.5);
        book.setDescription("This book is ...");
        book.setIsbn("0-883-456"); 
        book.setPublisher("Person");
        book.setNbOfPage(521);
        book.setIllustrations(false);

        CD cd = new CD();
        cd.setTitle("CD-1");
        cd.setPrice((float) 15.50);//new Float(15.50)
        cd.setDescription("This CD is ...");
        cd.setMusicCompany("RockFly");
        cd.setNumberOfCDs(2000);
        cd.setTotalDuration((float) 52);
        cd.setGender("male");

        //Get an entity manager and a transaction
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3P1PU");
        EntityManager em = emf.createEntityManager();

        //Persist the book and CD to the database
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        em.persist(book);
        em.persist(cd);
        tx.commit();

        em.close();
        emf.close();
    }

}
