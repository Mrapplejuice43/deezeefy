package formation.sopra.deezeefy.exception;

public class CompteException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public CompteException() {
		
	}
	public CompteException(String msg) {
		super(msg);
	}
}
