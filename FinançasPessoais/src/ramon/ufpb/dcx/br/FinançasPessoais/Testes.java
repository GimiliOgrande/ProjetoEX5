package ramon.ufpb.dcx.br.FinançasPessoais;

import java.io.*;
import java.util.Scanner;

public class Testes {
	private static String getNomeMes(int mes) {
	    String[] nomesMeses = {"Outubro", "Novembro", "Dezembro", "Janeiro"};
	    return nomesMeses[mes];
	}

	public static void main(String[] args) {
        SistemaFinancas sistema = new SistemaFinancas();

        // Carrega os usuários do arquivo, se existir
        carregarUsuariosDeArquivo("usuarios.txt", sistema);

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite seu email para fazer login: ");
            String emailLogin = scanner.nextLine();

            Usuario usuarioLogado = sistema.fazerLogin(emailLogin);

            if (usuarioLogado != null) {
                System.out.println("Login efetuado com sucesso para o usuário " + usuarioLogado.getNome());

                System.out.print("Digite o número de meses que deseja alterar: ");
                int numMeses = scanner.nextInt();

                for (int i = 0; i < numMeses; i++) {
                    System.out.println("Escolha o mês para alterar o valor da fatura (0 a 3): ");
                    int mes = scanner.nextInt();

                    System.out.println("Digite o novo valor da fatura para " + getNomeMes(mes) + ": ");
                    int novoValor = scanner.nextInt();

                    usuarioLogado.setValorFatura(mes, novoValor);
                }

                System.out.println("Saldo após as alterações:");

                for (int i = 0; i < 4; i++) {
                    int saldo = usuarioLogado.calcularSaldo(i);
                    System.out.println("Saldo após fatura de " + getNomeMes(i) + ": " + saldo);
                }

                // Salva os usuários no arquivo
                salvarUsuariosEmArquivo("usuarios.txt", sistema);
            } else {
                System.out.println("Email de login inválido. Usuário não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }

        scanner.close();
    }

    // Resto do código permanece o mesmo

    private static void carregarUsuariosDeArquivo(String nomeArquivo, SistemaFinancas sistema) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Divida a linha em campos e crie usuários
                String[] campos = linha.split(",");
                if (campos.length == 3) {
                    String nome = campos[0];
                    String email = campos[1];
                    int rendaMensal = Integer.parseInt(campos[2]);
                    sistema.cadastraUsuario(nome, email, rendaMensal);
                }
            }
        } catch (IOException e) {
            // Arquivo ainda não existe ou ocorreu algum erro na leitura
            // Não é um problema, apenas não há usuários para carregar
        }
    }

    private static void salvarUsuariosEmArquivo(String nomeArquivo, SistemaFinancas sistema) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Usuario usuario : sistema.getUsuarios()) {
                // Formate os dados do usuário e escreva no arquivo
                String linha = usuario.getNome() + "," + usuario.getEmail() + "," + usuario.getRendaMensal();
                writer.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Não foi possível salvar os usuários em arquivo.");
        }
    }
}
