package lk.ijse.pos.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDao<T,ID> {
         public boolean save(T t) throws SQLException, ClassNotFoundException;
        public boolean update(T t) throws SQLException, ClassNotFoundException;
        public boolean delete(ID id) throws SQLException, ClassNotFoundException;
        public T get(ID id);
        public List<T> getAll() throws SQLException, ClassNotFoundException;
}
