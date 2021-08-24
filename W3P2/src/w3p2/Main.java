
package w3p2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * @author Nathaniel Snow - 12060962 (CQUniversity)
 */
public class Main {

    /* TODO
    * Declare the Customer class and Address class as entities and establish a one-to-one relationship between them.
    * Declare ‘persist’ and ‘remove’ cascading event from Customer to Address.
    * Implement a Java Mainclass to persist 2 customerswith their addresses into the database. 
        Note: in the main class, you will only persist the Customer entities.
    * Check whether a Customer entity is in the persistence context.
    * Delete a Customer and its address. 
        Note: in the main class, you will only remove the Customer entity.
    * Check whetherthe Customer entity is still in the persistence context.
    */
    public static void main(String[] args) {
        
        
         //Create 2 adresses 
        Address address1 = new Address();
        address1.setStreet("Customer Street...");
        address1.setCity("Rockhampton");
        address1.setZipcode("QLD 4702");
        address1.setCountry("Auatralia");

        Address address2 = new Address();
        address2.setStreet("another Customer Street...");
        address2.setCity("Rockhampton");
        address2.setZipcode("QLD 4701");
        address2.setCountry("Auatralia");
        
        //Create 2 customers        
        Customer customer1 = new Customer();
        customer1.setFisrtName("Wei");
        customer1.setLastName("Li");
        customer1.setEmail("w.li@cqu.edu.au");
        customer1.setAddress(address1);

        Customer customer2 = new Customer();
        customer2.setFisrtName("John");
        customer2.setLastName("Smith");
        customer2.setEmail("j.smith@cqu.edu.au");
        customer2.setAddress(address2);
        
        

        //One entity manager per app
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3P2PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
//        tx.begin();
//        em.persist(customer1);
//        em.persist(customer2);
//        tx.commit();
        
        int res = removeCustomerById(651);
        showResult(res);
        
        em.close();
        emf.close();
        
    }
    
    static int removeCustomerById(long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3P2PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Customer cust = em.find(Customer.class, id);
            if(cust != null){
                em.remove(cust);
                tx.commit();
                return 1;
            }
            else
                return -1;
        }
        finally{
            em.close();
            emf.close();
        }
    }
    static void showResult(int res){
        System.out.println(res > 0? "Success!":"Fail :-(");
    }
}
