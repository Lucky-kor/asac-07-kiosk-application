package v9.repository;

import v9.entity.Menu;

import java.util.List;

public interface MenuRepository<T> {
    T findAll();
    Menu findById(int id);
    void save(Menu menu);
    void delete(int id);
}
