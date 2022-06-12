package lk.ijse.pos.bo;

import lk.ijse.pos.bo.custom.ItemBo;
import lk.ijse.pos.bo.custom.impl.CustomerBoImpl;
import lk.ijse.pos.bo.custom.impl.ItemBoImpl;
import lk.ijse.pos.dao.DaoFactory;
import lk.ijse.pos.dao.custom.impl.CustomerDaoImpl;
import lk.ijse.pos.dao.custom.impl.ItemDaoImpl;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory(){}

    public enum BoType{
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL
    }
    public static BoFactory getInstance(){
        return ((boFactory==null)? new BoFactory():boFactory);
    }
    public <T> T getDao(BoType type){
        switch (type){
            case CUSTOMER:
                return (T) new CustomerBoImpl();
            case ITEM:
                return (T) new ItemBoImpl();
            case ORDER:
                return null;
            case ORDER_DETAIL:
                return null;
            default:
                return null;
        }
    }
}
