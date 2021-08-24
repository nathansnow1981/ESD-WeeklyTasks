
package w2p1;

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
        // Project 1 - ORM Customisation  
        
        //Create an instance of book
        Book book = new Book();
        book.setTitle("The Hitchhiker's Guide to the Galaxy");
        book.setPrice(12.5F);
        book.setDescription("Science fiction comedy series created by Douglas Adams.");
        book.setIsbn("1-84023-742-2");
        book.setNbOfPage(354);
        book.setIllustrations(false);
        
        //Get an entity manager and a transaction
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("W2P1PUx");//<-- References a database
        
        EntityManager em = emf.createEntityManager();//<-- Represents a database connection

        //Persists the book to the database
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        em.persist(book);
        
        tx.commit();
        
        em.close();
        emf.close();
        
//        System.out.println("**********Persist the book into database**********");
//            System.out.println(book);
//        System.out.println("**************************************************");
//        
    }

}
