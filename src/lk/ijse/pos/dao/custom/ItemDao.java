package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.CrudDao;
import lk.ijse.pos.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDao extends CrudDao<Item, String> {
   /* public boolean saveItem(Item item) throws SQLException, ClassNotFoundException;

    public boolean updateItem(Item item) throws SQLException, ClassNotFoundException;

    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException;
*/
    public ArrayList<Item> searchItems(String searchText) throws SQLException, ClassNotFoundException;
}
