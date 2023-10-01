package ramon.ufpb.dcx.br.FinançasPessoais;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaFinancasTest {
    private SistemaFinancas sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaFinancas();
    }

    @Test
    public void testCadastrarUsuario() {
        Usuario usuario = new Usuario("Teste", "teste@example.com", 2000);
        sistema.cadastrarUsuario(usuario);
        assertTrue(sistema.getUsuarios().contains(usuario));
    }

    @Test
    public void testFazerLoginUsuarioExistente() {
        Usuario usuario = new Usuario("Teste", "teste@example.com", 2000);
        sistema.cadastrarUsuario(usuario);
        Usuario usuarioLogado = sistema.fazerLogin("teste@example.com");
        assertEquals(usuario, usuarioLogado);
    }

    @Test
    public void testFazerLoginUsuarioInexistente() {
        Usuario usuario = sistema.fazerLogin("naoexistente@example.com");
        assertNull(usuario);
    }
    
    // Adicione mais testes conforme necessário para outras funcionalidades da classe SistemaFinancas
}
