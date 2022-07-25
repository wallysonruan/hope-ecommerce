import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="produtos")
@Builder

public class Produtos {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private int estoque;

    @Column
    private double preco;

    @Column
    private double doacao;

    @OneToMany(mappedBy = "produtos")
    Set<Inventario> quantidade;
    
}
