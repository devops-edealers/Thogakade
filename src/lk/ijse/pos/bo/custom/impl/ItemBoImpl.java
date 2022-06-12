package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.ItemBo;
import lk.ijse.pos.dao.DaoFactory;
import lk.ijse.pos.dao.custom.ItemDao;
import lk.ijse.pos.dto.ItemDto;
import lk.ijse.pos.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {

    private ItemDao itemDao= DaoFactory.getInstance().getDao(DaoFactory.DaoType.ITEM);

    @Override
    public boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.save(
                new Item(dto.getCode(),
                        dto.getDescription(),
                        dto.getQtyOnHand(),
                        dto.getUnitPrice())
        );
    }

    @Override
    public boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.update(
                new Item(dto.getCode(),
                        dto.getDescription(),
                        dto.getQtyOnHand(),
                        dto.getUnitPrice())
        );
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return itemDao.delete(id);
    }

    @Override
    public ArrayList<ItemDto> searchItem(String searchText) throws SQLException, ClassNotFoundException {
        ArrayList<ItemDto> dtoList = new ArrayList<>();
        for (Item i : itemDao.searchItems(searchText)
        ) {
            dtoList.add(
                    new ItemDto(
                            i.getCode(), i.getDescription(), i.getQtyOnHand(), i.getUnitPrice()
                    )
            );
        }
        return dtoList;
    }
}
