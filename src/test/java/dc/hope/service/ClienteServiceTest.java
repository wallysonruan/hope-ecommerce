package dc.hope.service;

import dc.hope.assembler.Assembler;
import dc.hope.models.Cliente;
import dc.hope.repository.ClienteRepository;
import dc.hope.request.ClienteRequest;
import dc.hope.request.ClienteUpdateRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClienteServiceTest {

    private final Long ID = 1L;
    private final String CPF = "0000000000";
    private final String NOME = "Luke";
    private final String NOME2 = "Luke2";
    private final String EMAIL = "uke@gmail.com";
    private final String TELEFONE = "0000000000";

    @InjectMocks
    private ClienteService service;

    @Mock
    private ClienteRepository repository;

    @Mock
    Assembler assembler;
    Cliente cliente;
    ClienteRequest clienteRequest;
    ClienteUpdateRequest clienteUpdateRequest;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new ClienteService(repository, assembler);
        cliente = new Cliente(ID, CPF, NOME, EMAIL, TELEFONE);
        clienteRequest = new ClienteRequest(CPF, NOME, EMAIL, TELEFONE);
        clienteUpdateRequest = new ClienteUpdateRequest();
        clienteUpdateRequest.setNome(NOME2);
    }

    @Test
    void cadastrar() {
        when(repository.save(any())).thenReturn(cliente);

        Cliente response = service.cadastrar(clienteRequest);

        assertNotNull(response);
        assertEquals(Cliente.class, response.getClass());
        assertEquals(cliente, response);

    }

    @Test
    void findById() {
        
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(cliente));

        Cliente response = service.findById(ID);

        assertNotNull(response);
        assertEquals(Cliente.class, response.getClass());
        assertEquals(cliente, response);

    }

    @Test
    void findAllById() {
        when(repository.findAll()).thenReturn(List.of(cliente));
        List<Cliente> list = service.findAll();

        assertNotNull(list);
        assertEquals(ID, list.get(0).getId());
        assertEquals(CPF, list.get(0).getCpf());
        assertEquals(NOME, list.get(0).getNome());
        assertEquals(EMAIL, list.get(0).getEmail());
        assertEquals(TELEFONE, list.get(0).getTelefone());

    }

    @Test
    void atualizarClientes() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(cliente));
        Cliente clienteAtualizado =  service.atualizarClientes(ID, clienteUpdateRequest);
        assertEquals(clienteAtualizado.getId(), cliente.getId());
        assertEquals(clienteAtualizado.getCpf(), cliente.getCpf());
        assertEquals(clienteAtualizado.getEmail(), cliente.getEmail());
        assertEquals(clienteAtualizado.getTelefone(), cliente.getTelefone());
        assertEquals(clienteAtualizado.getNome(), clienteUpdateRequest.getNome());
    }

    @Test
    void deletar() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(cliente));
        doNothing().when(repository).deleteById(anyLong());
        service.deletar(ID);
        verify(repository, times(1)).deleteById(anyLong());
        
    }

}