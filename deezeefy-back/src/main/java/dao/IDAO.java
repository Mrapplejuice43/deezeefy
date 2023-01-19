package dao;

public interface IDAO<T,K> {
	
	String  loginBdd="root";
	String passwordBdd="";
	String urlBdd="jdbc:mysql://localhost:3306/hopital?characterEncoding=UTF-8";
	
	public T findById(K id);
	
}
