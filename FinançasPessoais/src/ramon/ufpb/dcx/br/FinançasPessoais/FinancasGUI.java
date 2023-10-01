package ramon.ufpb.dcx.br.FinançasPessoais;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinancasGUI extends JFrame {
    private SistemaFinancas sistema;
    private Usuario usuarioLogado;

    // Componentes da GUI
    private JTextField emailField;
    private JButton loginButton;
    private JButton cadastrarButton;
    private JTextArea resultadoTextArea;

    public FinancasGUI(SistemaFinancas sistema) {
        this.sistema = sistema;

        // Configurar a janela
        setTitle("Sistema de Controle de Finanças");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centralizar a janela

        // Configurar componentes da GUI
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        loginButton = new JButton("Login");
        cadastrarButton = new JButton("Cadastrar");
        resultadoTextArea = new JTextArea(10, 30);
        resultadoTextArea.setEditable(false);

        JPanel loginPanel = new JPanel(new FlowLayout());
        loginPanel.add(emailLabel);
        loginPanel.add(emailField);
        loginPanel.add(loginButton);
        loginPanel.add(cadastrarButton);

        panel.add(loginPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(resultadoTextArea), BorderLayout.CENTER);

        // Configurar ação do botão de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                usuarioLogado = sistema.fazerLogin(email);

                if (usuarioLogado != null) {
                    resultadoTextArea.setText("Login efetuado com sucesso para o usuário " + usuarioLogado.getNome());
                    exibirOpcoes();
                } else {
                    resultadoTextArea.setText("Email de login inválido. Usuário não encontrado.");
                }
            }
        });

        // Configurar ação do botão de cadastro
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicione a lógica para cadastro aqui, se desejar
                resultadoTextArea.setText("Cadastro de novos usuários não implementado nesta versão.");
            }
        });

        add(panel, BorderLayout.NORTH);
    }

    private void exibirOpcoes() {
        // Adicione aqui as opções que deseja exibir após o login
        resultadoTextArea.append("\nOpções disponíveis após o login:\n");
        resultadoTextArea.append("- Alterar Fatura\n");
        resultadoTextArea.append("- Ver Saldo\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SistemaFinancas sistema = new SistemaFinancas();
                FinancasGUI gui = new FinancasGUI(sistema);
                gui.setVisible(true);
            }
        });
    }
}

