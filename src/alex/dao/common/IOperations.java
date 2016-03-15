package alex.dao.common;

import java.io.Serializable;

import java.util.List;

public interface IOperations<T extends Serializable> {
	T findOne(int id);

	List<T> findAll();

	void create(T entity);

	T update(T entity);

	void delete(T entity);

	void deleteById(int id);

}
