package webdto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CambioWebRequest {
	private String Moneda_Origen;
	private String Moneda_Destino;
	private Double Tipo_Cambio;

}
