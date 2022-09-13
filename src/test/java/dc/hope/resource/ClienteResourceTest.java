package dc.hope.resource;

import dc.hope.request.ClienteRequest;
import dc.hope.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClienteResourceTest {

    @InjectMocks
    ClienteResource clienteResource;

    @Mock
    ClienteService clienteService;

    private static final Long ID = 12345L;
    private static final String CPF = "09878976534";
    private static final String NOME = "Alguém desconhecido aqui";
    private static final String EMAIL = "email@gmail.com";
    private static final String TELEFONE = "77965865433";

    ClienteRequest clienteRequest;

    @BeforeEach
    void setUp() {
    }

    @Test
    void cadastrarCliente() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void deletar() {
    }

    private void inicializarCliente(){
        clienteRequest = new ClienteRequest(CPF, NOME, EMAIL, TELEFONE);
    }
}