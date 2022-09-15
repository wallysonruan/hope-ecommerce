package dc.hope.resource;

import dc.hope.models.Cliente;
import dc.hope.request.ClienteRequest;
import dc.hope.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ContextConfiguration(locations = "classpath:app-context.xml")
class ClienteResourceTest {

    private Cliente cliente;
    private ClienteRequest clienteRequest;
    private MockMvc mockMvc;

    @InjectMocks
    ClienteResource clienteResource;

    @Mock
    ClienteService clienteService;

    private static final Long ID = 1L;
    private static final String CPF = "27535742190";
    private static final String NOME = "Alguém desconhecido aqui";
    private static final String EMAIL = "email@gmail.com";
    private static final String TELEFONE = "77965865433";
    private static final String ENDPOINT = "/cliente";
    private static final String CLIENTE_REQUEST_BODY = """
          {
            "cpf":"%s",
            "nome":"%s",
            "email":"%s",
            "telefone":"%s"
            }
            """;

    @BeforeEach
    void setUp() {
        try {
            MockitoAnnotations.openMocks(this);
        }catch (Exception e){}
        inicializarCliente();
        mockMvc = MockMvcBuilders.standaloneSetup(clienteResource).build();
    }

    @Test
    void deveriaRetornarSucesso_QuandoCadastrar() throws Exception {
        String clienteFormatoJson = String.format(CLIENTE_REQUEST_BODY, CPF, NOME, EMAIL, TELEFONE);

        mockMvc.perform(
                post(ENDPOINT + "/cadastrar")
                        .content(clienteFormatoJson)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void deveriaRetornarBadRequest_QuandoEmailInvalido() throws Exception {
        String clienteFormatoJson = String.format(CLIENTE_REQUEST_BODY, CPF, NOME, "email.com", TELEFONE);

        mockMvc.perform(
                post(ENDPOINT + "/cadastrar")
                        .content(clienteFormatoJson)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest());
    }

    @Test
    void deveriaRetornarSucesso_QuandoProcurarQualquerIdLongOuInt() throws Exception{
        mockMvc.perform(
                get(ENDPOINT + "/" + ID)
        ).andExpect(status().isOk());
    }

    @Test
    void deveriaRetornarBadRequest_QuandoProcurarQualquerIdNaN() throws Exception{
        mockMvc.perform(
                get(ENDPOINT + "/" + "a")
        ).andExpect(status().isBadRequest());
    }

    private void inicializarCliente(){
        cliente = new Cliente(ID, CPF, NOME, EMAIL, TELEFONE);
        clienteRequest = new ClienteRequest(CPF, NOME, EMAIL, TELEFONE);
    }
}