
package w3p1;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Nathaniel Snow - 12060962 (CQUniversity)
 */

@Entity
public class CD extends Item implements Serializable {

    private static final long serialVersionUID = 1L;
    //id not needed as it is inherited from Item
    @Column(name = "music_company", updatable = false, nullable = false)
    private String musicCompany;
    @Column(name = "number_of_cds", updatable = true)
    private Integer numberOfCDs;
    @Column(name = "total_duration", updatable = false)
    private Float totalDuration;
    @Column(name = "gender")
    private String gender;

    public CD(){}
    
    public CD(String musicCompany, Integer numberOfCDs, Float totalDuration, String gender, Long id, String title, Float price, String description) {
        super(id, title, price, description);
        this.musicCompany = musicCompany;
        this.numberOfCDs = numberOfCDs;
        this.totalDuration = totalDuration;
        this.gender = gender;
    }

    public String getMusicCompany() {
        return musicCompany;
    }

    public void setMusicCompany(String musicCompany) {
        this.musicCompany = musicCompany;
    }

    public Integer getNumberOfCDs() {
        return numberOfCDs;
    }

    public void setNumberOfCDs(Integer numberOfCDs) {
        this.numberOfCDs = numberOfCDs;
    }

    public Float getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Float totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        if (!(object instanceof CD)) {
            return false;
        }
        CD other = (CD) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CD{" + "musicCompany=" + musicCompany + ", numberOfCDs=" + numberOfCDs + ", totalDuration=" + totalDuration + ", gender=" + gender + '}';
    }

    

    

}
