package w2p2;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import w2p2.OrderLine;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-21T10:20:30")
@StaticMetamodel(AnOrder.class)
public class AnOrder_ { 

    public static volatile ListAttribute<AnOrder, OrderLine> orderLines;
    public static volatile SingularAttribute<AnOrder, Long> id;
    public static volatile SingularAttribute<AnOrder, Date> creationDate;

}