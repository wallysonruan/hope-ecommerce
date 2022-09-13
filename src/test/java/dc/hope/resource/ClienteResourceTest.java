package dc.hope.resource;

import dc.hope.models.Clientes;
import dc.hope.request.ClienteRequest;
import dc.hope.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
@ContextConfiguration(locations = "classpath:app-context.xml")
class ClienteResourceTest {

    private Clientes cliente;
    private ClienteRequest clienteRequest;

    @InjectMocks
    ClienteResource clienteResource;

    @Mock
    ClienteService clienteService;

    private static final Long ID = 12345L;
    private static final String CPF = "09878976534";
    private static final String NOME = "Alguém desconhecido aqui";
    private static final String EMAIL = "email@gmail.com";
    private static final String TELEFONE = "77965865433";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        inicializarCliente();
    }

    @Test
    void deveCadastrarClienteApenasUmaVez() {
        when(clienteService.cadastrar(clienteRequest)).thenReturn(cliente);
        clienteResource.cadastrarCliente(clienteRequest);

        verify(clienteService, atMostOnce()).atualizarClientes(ID, clienteRequest);
    }

    @Test
    void whenFindByIdReturnSuccess() {
        when(clienteResource.findById(anyLong())).thenReturn(cliente);

        Clientes response = clienteResource.findById(ID);

        assertNotNull(response);
        assertEquals(Clientes.class, response.getClass());

        assertEquals(ID, response.getId());
        assertEquals(CPF, response.getCpf());
        assertEquals(NOME, response.getNome());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(TELEFONE, response.getTelefone());
    }

    @Test
    void update() {
    }

    @Test
    void deletar() {
    }

    private void inicializarCliente(){
        cliente = new Clientes(ID, CPF, NOME, EMAIL, TELEFONE);
        clienteRequest = new ClienteRequest(CPF, NOME, EMAIL, TELEFONE);
    }
}