package ramon.ufpb.dcx.br.FinançasPessoais;

@SuppressWarnings("serial")
public class UsuarioInexistenteException extends Exception {
	public UsuarioInexistenteException(String msg) {
		super(msg);
	}
}
