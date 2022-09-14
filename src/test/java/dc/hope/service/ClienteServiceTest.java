package dc.hope.service;

import dc.hope.assembler.Assembler;
import dc.hope.models.Clientes;
import dc.hope.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteServiceTest {

    private final Long ID = 1L;
    private final String CPF = "0000000000";
    private final String NOME = "Luke";
    private final String EMAIL = "uke@gmail.com";
    private final String TELEFONE = "0000000000";

    @InjectMocks
    private ClienteService service;

    @Mock
    private ClienteRepository repository;

    @Mock
    Assembler assembler;

    Clientes esperado;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new ClienteService(repository, assembler);
        esperado = new Clientes(ID, CPF, NOME, EMAIL, TELEFONE);;
    }

    @Test
    void cadastrar() {
    }

    @Test
    void findById() {
        
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(esperado));

        Clientes response = service.findById(ID);

        assertNotNull(response);

        assertEquals(Clientes.class, response.getClass());
        assertEquals(esperado, response);

    }

    @Test
    void findAllById() {
    }

    @Test
    void atualizarClientes() {
    }

    @Test
    void deletar() {
    }

}