package dc.hope.service;

import dc.hope.repository.InventarioRepository;
import dc.hope.repository.PedidosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dc.hope.models.Cliente;
import dc.hope.models.Ong;
import dc.hope.models.Pedido;
import dc.hope.request.PedidoRequest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class PedidoServiceTest {

    @InjectMocks
    private PedidoService service;

    @Mock
    private PedidosRepository pedidoRepository;

    @Mock
    private InventarioRepository inventarioRepository;

    @Mock
    private ClienteService clienteService;

    @Mock
    private OngService ongService;

    private final Long ID = 1L;

    private final String FORMA_PAGAMENTO = "pix" ;

    private final double VALOR_TOTAL = 1000.00;

    private final double VALOR_DOACAO = 100.00;

    private boolean pedido_fechado;

    private Cliente cliente;

    private Ong ong;

    private Pedido pedido;

    private PedidoRequest pedidoRequest;

    private LocalDate data;

/*     @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new PedidoService(pedidoRepository, inventarioRepository, clienteService, ongService);
        pedido = new Pedido(ID, FORMA_PAGAMENTO, VALOR_TOTAL, VALOR_DOACAO)
        ong = new Ong(1L, "222222", "ong", "ong@ong.com");
    } */

    @Test
    void salvar() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAllById() {
    }

    @Test
    void deletar() {
    }

    @Test
    void abrirPedido() {
    }

    @Test
    void fecharPedido() {
    }

    @Test
    void adicionarValorProduto() {
    }

    @Test
    void removerValorProduto() {
    }

    @Test
    void checarPedidoFechadoERetornar() {
    }
}