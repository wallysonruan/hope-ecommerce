package dc.hope;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import dc.hope.models.Clientes;
import dc.hope.exceptions.DefaultException;

import dc.hope.repository.ClienteRepository;
import dc.hope.request.ClienteRequest;
import dc.hope.service.ClienteService;

@SpringBootTest
public class MockTeste {

  @InjectMocks
  private ClienteService clienteService;

  @Mock
  private ClienteRepository clienteRepository;

  @Test
  public void findById(){
    var obj = mockCliente();
    when(clienteRepository.findById(any())).thenReturn(Optional.of(obj));
    var mock = clienteService.findById(1l);
    assertEquals(mock, obj);
  }

  @Test
    public void testarResgistroExistenteNoBancoAoSalvarCliente(){
        var obj = mockCliente();
        when(clienteRepository.findById(any())).thenReturn(Optional.of(obj));
        when(clienteRepository.findByClientes(any(),any(),any(),any())).thenReturn(mockClienteNomEmailExistente());

        var ex = assertThrows(DefaultException.class, () -> {
            clienteService.atualizarClientes(1l,mockClienteRequest());
        });

        assertEquals(HttpStatus.BAD_REQUEST,ex.httpStatus);
    }

  private Clientes mockCliente() {
    Clientes cliente = new Clientes();
    cliente.setId(1l);
    return cliente;
  }

  public Optional<Clientes> mockClienteNomEmailExistente(){
    Clientes cliente = new Clientes();
    cliente.setNome("teste");
    cliente.setEmail("teste@teste.com");
    cliente.setId(2l);
    return Optional.of(cliente);
}

public ClienteRequest mockClienteRequest(){
  ClienteRequest clienteRequest = new ClienteRequest();
  clienteRequest.setNome("teste");
  clienteRequest.setCpf("teste");
  clienteRequest.setEmail("teste@teste.com");
  clienteRequest.setTelefone("teste");
  return clienteRequest;
}
  
}
