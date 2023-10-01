package ramon.ufpb.dcx.br.FinançasPessoais;

public class Despesas{
	
	private int fatura;
	private int aluguel;
	
	public Despesas(int fatura, int aluguel) {
		this.fatura = fatura;
		this.aluguel = aluguel;
	}

	public int getFatura() {
		return fatura;
	}

	public void setFatura(int fatura) {
		this.fatura = fatura;
	}

	public int getAluguel() {
		return aluguel;
	}

	public void setAluguel(int aluguel) {
		this.aluguel = aluguel;
	}
	
	
}
