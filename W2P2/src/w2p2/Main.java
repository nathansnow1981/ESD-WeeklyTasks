
package w2p2;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
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
        //  Entity Relationship
        //implement a Java Main class to persist an order with 2 order lines, of which each is an ordered item.
        
        
        //Create the 2 order lines
        OrderLine orderLine1 = new OrderLine();
        orderLine1.setItem("Jarvis Walker 6\'2\" Bait Caster");
        orderLine1.setUnitPrice(179.95);
        orderLine1.setQuantity(35);
        
        OrderLine orderLine2 = new OrderLine();
        orderLine2.setItem("Alvey 10\' Surf Rod");
        orderLine2.setUnitPrice(125.00);
        orderLine2.setQuantity(32);
        
        //Create an order
        AnOrder order = new AnOrder();
        order.setCreationDate(new Date());
        
        List<OrderLine> lineItems = new LinkedList<>();
        lineItems.add(orderLine1);
        lineItems.add(orderLine2);
        order.setOrderLines(lineItems);
        
        //Get an entity manager and a transaction
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        // Persists the order to the database
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        em.persist(order);
        em.persist(orderLine1);
        em.persist(orderLine2);

        tx.commit();

        em.close();
        emf.close();
        
    }
}
