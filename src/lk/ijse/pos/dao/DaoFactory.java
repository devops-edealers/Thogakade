package lk.ijse.pos.dao;

import lk.ijse.pos.dao.custom.impl.CustomerDaoImpl;
import lk.ijse.pos.dao.custom.impl.ItemDaoImpl;
import lk.ijse.pos.dao.custom.impl.SystemUserDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public enum DaoType {
        CUSTOMER, ITEM, ORDER, ORDER_DETAIL, SYSTEM_USER
    }

    public static DaoFactory getInstance() {
        return ((daoFactory == null) ? new DaoFactory() : daoFactory);
    }

    public <T> T getDao(DaoType type) {
        switch (type) {
            case CUSTOMER:
                return (T) new CustomerDaoImpl();
            case ITEM:
                return (T) new ItemDaoImpl();
            case ORDER:
                return null;
            case ORDER_DETAIL:
                return null;
            case SYSTEM_USER:
                return (T) new SystemUserDaoImpl();
            default:
                return null;
        }
    }
}
