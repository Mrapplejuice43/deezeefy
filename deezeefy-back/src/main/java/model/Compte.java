package model;

public abstract class Compte {
	
	protected int id;
	protected String login; 
	protected String password;
	protected String email; 
	protected String nom; 
	protected String prenom; 
	protected String pseudo; 

	
	
	public Compte(int id, String login, String password, String email, String nom, String prenom, String pseudo) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getPseudo() {
		return pseudo;
	}



	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}





}
