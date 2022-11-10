package repository;


import java.util.List;

public interface CRUDRepository<T> {

    T create(T entity);

    T update(T entity);

    void delete(T entity);

    List<T> findAll();

    T getByID(Integer id);
}