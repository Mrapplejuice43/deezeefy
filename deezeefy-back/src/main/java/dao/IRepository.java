package dao;

public interface IRepository<T> {
	
	public T findById(int id);
	public T save(int id);
	public void delete(T obj);
	public void deleteById(int id);
}
