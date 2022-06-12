package lk.ijse.pos.bo;

import lk.ijse.pos.bo.custom.impl.CustomerBoImpl;
import lk.ijse.pos.bo.custom.impl.ItemBoImpl;
import lk.ijse.pos.bo.custom.impl.SystemUserBoImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public enum BoType {
        CUSTOMER, ITEM, ORDER, ORDER_DETAIL, SYSTEM_USER
    }

    public static BoFactory getInstance() {
        return ((boFactory == null) ? new BoFactory() : boFactory);
    }

    public <T> T getBo(BoType type) {
        switch (type) {
            case CUSTOMER:
                return (T) new CustomerBoImpl();
            case ITEM:
                return (T) new ItemBoImpl();
            case ORDER:
                return null;
            case ORDER_DETAIL:
                return null;
            case SYSTEM_USER:
                return (T) new SystemUserBoImpl();
            default:
                return null;
        }
    }
}
