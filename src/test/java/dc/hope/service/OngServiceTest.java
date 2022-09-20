package dc.hope.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import dc.hope.assembler.Assembler;
import dc.hope.models.Ong;
import dc.hope.repository.OngRepository;
import dc.hope.request.OngRequest;

@SpringBootTest
class OngServiceTest {

    @InjectMocks
    private OngService service;

    @Mock
    private OngRepository repository;

    @Mock
    private Assembler assembler;

    private final Long ID = 1L;

    private final String CNPJ = "33333333";

    
    private final String NOME = "aacd";

    
    private final String EMAIL = "aacd@aacd.com";

    private Ong ong;

    private OngRequest request;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new OngService(repository, assembler);
        ong = new Ong(ID, CNPJ, NOME, EMAIL);
        request = new OngRequest(CNPJ, NOME, EMAIL);
    }

    @Test
    void deveBuscarTodasOngs() {
        when(repository.findAll()).thenReturn(List.of(ong));
        List<Ong> list = service.findAll();
        
        assertNotNull(list);
        assertEquals(ID, list.get(0).getId());
        assertEquals(CNPJ, list.get(0).getCnpj());
        assertEquals(NOME, list.get(0).getNome());
        assertEquals(EMAIL, list.get(0).getEmail());
    }

    @Test
    void deeBuscarOngPeloId() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(ong));
        Ong response = service.findById(ID);
        assertNotNull(response);
        assertEquals(Ong.class, response.getClass());
        assertEquals(ong, response);
    }


    @Test
    void cadastrar() {
        when(repository.save(any())).thenReturn(ong);

        Ong response = service.cadastrar(request);

        assertNotNull(response);
        assertEquals(Ong.class, response.getClass());
        assertEquals(ong, response);
    }

    @Test
    void deletar() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(ong));
        doNothing().when(repository).deleteById(anyLong());
        service.deletar(ID);
        verify(repository, times(1)).deleteById(anyLong());
    } 
}