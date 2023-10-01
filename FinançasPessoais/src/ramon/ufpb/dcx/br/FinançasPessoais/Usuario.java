package ramon.ufpb.dcx.br.FinançasPessoais;

import java.util.Objects;

public class Usuario implements Comparable<Usuario> {
	
	private String email;
	private String nome;
	private int rendaMensal;
	private int[] valoresFaturas = new int[4]; // Valores das faturas para os 4 meses

	public Usuario(String nomeUsuario, String emailUsuario, int rendaMensal) {
		this.nome = nomeUsuario;
		this.email = emailUsuario;
		this.rendaMensal = rendaMensal;
	}
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(int rendaMensal) {
		this.rendaMensal = rendaMensal;
	}
	
	public void setValorFatura(int mes, int valor) {
        if (mes >= 0 && mes < valoresFaturas.length) {
            valoresFaturas[mes] = valor;
        }
    }

    public int getValorFatura(int mes) {
        if (mes >= 0 && mes < valoresFaturas.length) {
            return valoresFaturas[mes];
        }
        return 0; // Valor padrão se o mês for inválido
    }

    public int calcularSaldo(int mes) {
        return rendaMensal - getValorFatura(mes);
    }

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email);
	}


	@Override
	public int compareTo(Usuario o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
