package ramon.ufpb.dcx.br.FinançasPessoais;

import java.util.ArrayList;
import java.util.List;

public class SistemaFinancas {
	
	private List<Usuario> usuarios = new ArrayList<>();
	private Usuario usuarioLogado = null;
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	public void cadastraUsuario(String nomeUsuario, String emailUsuario, int rendaMensal) {
		Usuario novoUsuario = new Usuario(nomeUsuario, emailUsuario, rendaMensal);
		usuarios.add(novoUsuario);
	}
	
	public Usuario fazerLogin(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                usuarioLogado = usuario;
                return usuario;
            }
        }
        return null; // Usuário não encontrado
    }
	
	public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

	public boolean removerUsuario(String email) {
        Usuario usuarioARemover = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                usuarioARemover = usuario;
                break; // Encontrou o usuário, saia do loop
            }
        }

        if (usuarioARemover != null) {
            usuarios.remove(usuarioARemover);
            return true; // Usuário removido com sucesso
        }

        return false; // Usuário não encontrado
    }
}
