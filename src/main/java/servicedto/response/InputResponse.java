package servicedto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InputResponse {
	  private String MonOrigen;
	  private String MonDestino;
	  private BigDecimal  MontoInicio;
	  private BigDecimal  MontoConvertido;
	  private BigDecimal  TipoCambio;

	  public InputResponse() {

	  }

	  public InputResponse(String MonOrigen, String MonDestino, BigDecimal  MontoInicio,
			  BigDecimal  MontoConvertido, BigDecimal  TipoCambio) {
	    super();
	    this.MonOrigen = MonOrigen;
	    this.MonDestino = MonDestino;
	    this.MontoInicio = MontoInicio;
	    this.MontoConvertido = MontoConvertido;
	    this.TipoCambio = TipoCambio;
	  }

	  public String getMonOrigen() {
	    return MonOrigen;
	  }

	  public void setMonOrigen(String MonOrigen) {
	    this.MonOrigen = MonOrigen;
	  }

	  public String getMonDestino() {
	    return MonDestino;
	  }

	  public void setMonDestino(String MonDestino) {
	    this.MonDestino = MonDestino;
	  }

	  public BigDecimal getMontoInicio() {
	    return MontoInicio;
	  }

	  public void setMontoInicio(BigDecimal  MontoInicio) {
	    this.MontoInicio = MontoInicio;
	  }

	  public BigDecimal getMontoConvertido() {
	    return MontoConvertido;
	  }

	  public void setMontoConvertido(BigDecimal  MontoConvertido) {
	    this.MontoConvertido = MontoConvertido;
	  }

	  public BigDecimal getTipoCambio() {
	    return TipoCambio;
	  }

	  public void setTipoCambio(BigDecimal TipoCambio) {
	    this.TipoCambio = TipoCambio;
	  }
}
