package w3p2;

import javax.annotation.Generated;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import w3p2.Address;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-28T10:58:24")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> fisrtName;
    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile SingularAttribute<Customer, Address> address;
    public static volatile SingularAttribute<Customer, Long> id;
    public static volatile SingularAttribute<Customer, EntityManager> emgr;
    public static volatile SingularAttribute<Customer, String> email;

}