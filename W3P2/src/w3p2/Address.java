
package w3p2;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Nathaniel Snow - 12060962 (CQUniversity)
 */

@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long    id;
    @Column(name = "street", nullable = true, updatable = true)
    private String street;
    @Column(name = "city", nullable = true, updatable = true)
    private String city;
    @Column(name = "zip_code", nullable = true, updatable = true)
    private String zipcode;
    @Column(name = "country", nullable = true, updatable = true)
    private String country;

    public Address() {
    }

    public Address(Long id, String street, String city, String zipcode, String country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street=" + street + ", city=" + city + ", zipcode=" + zipcode + ", country=" + country + '}';
    }

}
