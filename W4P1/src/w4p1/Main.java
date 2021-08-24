    
package w4p1;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Declare 2 addresses
        Address a1 = new Address();
        a1.setStreet1("545 Hacker Way");
        a1.setCity("Brisbane");
        a1.setZipcode("4001");
        a1.setCountry("Australia");
        
        Address a2 = new Address();
        a2.setStreet1("56 Wallaby Way");
        a2.setCity("Sydney");
        a2.setZipcode("2023");
        a2.setCountry("Australia");
        
        //Declare 2 customers
        Customer c1 = new Customer();
        c1.setFirstName("Harry");
        c1.setLastName("Hacker Jr");
        c1.setAge(24);
        c1.setEmail("harry.hacker@gmail.com");
        c1.setAddress(a1);
        
        Customer c2 = new Customer();
        c2.setFirstName("Dory");
        c2.setLastName("Fisher");
        c2.setAge(3);
        c2.setEmail("finding.nemo@sydney.com");
        c2.setAddress(a2);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPQLPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Declare a named query to query all customers.✅
        Query queryGetAllCustomers = em.createNamedQuery("getAllCustomers");
        List allCustomers = queryGetAllCustomers.getResultList();
        System.out.println("All Customers --> "+ allCustomers);
        
        //Declare a named query to query customers by first name. The name of a customer can be set by a parameter.
        String firstName = "Harry";
        //construct the query and set the parameter
        Query queryCustomerByFirstName = em.createNamedQuery(
            "getCustomersByFirstName")
                .setParameter("fName", firstName);
        
        //Get results as a list
        List customers = queryCustomerByFirstName.getResultList();
        System.out.println("Customers by first name --> "+ customers);
        
        //Declare a native query to query all customers.
        Query getAllNative = em.createNamedQuery("getAllCustomersNative");
        List allCustomers2 = getAllNative.getResultList();
        System.out.println("All Customers Native --> "+ allCustomers2);
 
        //Persist customers to the database
        tx.begin();
        em.persist(c1);
        em.persist(c2);
        tx.commit();
        
        em.close();
        emf.close();

        List harrys = new Customer().getCustomersByFirstName("Harry");
        harrys.forEach(System.out::println);
    }

}
    