package dao;

import model.Contenu;

public interface IRepository<T> {
	
	public T findById(int id);
	public T save(T obj);
	public void delete(T obj);
	public void deleteById(int id);
	
}
