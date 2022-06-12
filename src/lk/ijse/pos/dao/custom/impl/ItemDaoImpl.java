package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.ItemDao;
import lk.ijse.pos.dto.ItemDto;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.util.IdGenerator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean saveItem(Item item) throws SQLException, ClassNotFoundException {
        item.setCode(IdGenerator.getId());
        return CrudUtil.execute("INSERT INTO Item VALUES(?,?,?,?)",
                item.getCode(),
                item.getDescription(),
                item.getQtyOnHand(),
                item.getUnitPrice());
    }

    @Override
    public boolean updateItem(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Item SET description=?, qtyOnHand=?, unitPrice=? WHERE code=?",
                item.getDescription(),
                item.getQtyOnHand(),
                item.getUnitPrice(),
                item.getCode());
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Item WHERE code=?", id);
    }

    @Override
    public ArrayList<Item> searchItems(String searchText) throws SQLException, ClassNotFoundException {
        searchText = "%" + searchText + "%";
        ArrayList<Item> dtoList = new ArrayList<>();
        ResultSet set = CrudUtil.
                execute("SELECT * FROM Item WHERE description LIKE?",searchText);
        while (set.next()) {
            dtoList.add(
                    new Item(set.getString(1), set.getString(2),
                            set.getInt(3), set.getDouble(4))
            );
        }
        return dtoList;
    }
}
