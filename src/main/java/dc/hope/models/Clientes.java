package dc.hope.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="clientes")
@Builder
@AllArgsConstructor
@Data


public class Clientes {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cpf;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String telefone;
    
    public Clientes (){}
}
