package reactive.entity;

import lombok.*;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoCambio")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambio {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "MonOrigen")
    private String MonOrigen;
    
    @Column(name = "MonDestino")
    private String MonDestino;
    
    @Column(name = "Tipo_Cambio")
    private BigDecimal Tipo_Cambio;
}
