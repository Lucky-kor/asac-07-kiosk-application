package v8.repository;

import v8.entity.Menu;

public interface MenuRepository {
    Menu[] findAll();
    Menu findById(int id);
    void save(Menu menu);
    void delete(int id);
}
