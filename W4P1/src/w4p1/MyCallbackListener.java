
package w4p1;

import com.mysql.cj.log.Log;
import com.mysql.cj.log.LogFactory;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class MyCallbackListener {

    private final Log log = LogFactory.getLogger("Customer", "myInstance");
    
    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(Customer cust) {
        if (cust.getId() == 0) {
            log.logInfo("[Info] Addind a customer");
        } else {
            log.logInfo("[Info] About to update/delete customer: " + cust.getId());
        }
    }
    
    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(Customer cust) {
        log.logInfo("[Info] add/update/delete complete for customer: " + cust.getId());
    }
    
    @PostLoad
    private void afterLoad(Customer cust) {
        log.logInfo("[Info] customer loaded from database: " + cust.getId());
    }
}
