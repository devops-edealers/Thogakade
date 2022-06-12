package lk.ijse.pos.dao.custom;

import lk.ijse.pos.entity.Item;

import java.util.ArrayList;

public interface ItemDao {
    public boolean saveItem(Item item);
    public boolean updateItem(Item item);
    public boolean deleteItem(String id);
    public ArrayList<Item> searchItems(String searchText);
}
