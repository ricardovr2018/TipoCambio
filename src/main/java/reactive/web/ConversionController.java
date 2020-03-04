package reactive.web;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import service.tipocambio.TipoCambioService;
import servicedto.response.InputResponse;

@RestController
@RequestMapping(value = "/api/tipocambio")
public class ConversionController {
	//private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TipoCambioService tipoCambioService;
	
	@PostMapping("/api/tipocambio/MonOrigen/{from}/MonDestino/{to}/MontoInicio/{Montoinicio}")
	public InputResponse convertCurrency(@PathVariable String MonOrigen, @PathVariable String MonDestino,
										 @PathVariable BigDecimal MontoInicio) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("MonOrigen", MonOrigen);
		uriVariables.put("MonDestino", MonDestino);

		ResponseEntity<InputResponse> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8081/conversion/MonOrigen/{from}/MonDestino/{to}", InputResponse.class,
				uriVariables);

		InputResponse response = responseEntity.getBody();

		return new InputResponse(MonOrigen, MonDestino, response.getMontoInicio(),
				MontoInicio.multiply(response.getTipoCambio()), response.getTipoCambio());
	}
}
