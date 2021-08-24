
package w3p1;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Nathaniel Snow - 12060962 (CQUniversity)
 */

@Entity
public class Book extends Item implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "isbn", nullable = false, updatable = false)
    private String isbn;
    @Column(name = "publisher", nullable = false, updatable = false)
    private String publisher;
    @Column(name="number_of_pages", nullable = false, updatable = false)
    private Integer nbOfPage;
    @Column(name = "illustrations")
    private Boolean illustrations;

    public Book(){}

    public Book(String isbn, String publisher, Integer nbOfPage, Boolean illustrations, Long id, String title, Float price, String description) {
        super(id, title, price, description);
        this.isbn = isbn;
        this.publisher = publisher;
        this.nbOfPage = nbOfPage;
        this.illustrations = illustrations;
    }
    
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getNbOfPage() {
        return nbOfPage;
    }

    public void setNbOfPage(Integer nbOfPage) {
        this.nbOfPage = nbOfPage;
    }

    public Boolean getIllustrations() {
        return illustrations;
    }

    public void setIllustrations(Boolean illustrations) {
        this.illustrations = illustrations;
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
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", publisher=" + publisher + ", nbOfPage=" + nbOfPage + ", illustrations=" + illustrations + '}';
    }

    

}
