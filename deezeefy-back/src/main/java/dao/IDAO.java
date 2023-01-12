package dao;

public interface IDAO<T,K> {
	
	public T findById(K id);
}
