package reactive.web;

import service.tipocambio.TipoCambioService;
import servicedto.request.ChangeTipoCambio;
import servicedto.response.TCResponse;
import webdto.request.CambioWebRequest;
import webdto.response.BaseWebResponse;
import webdto.response.TCWebResponse;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/tipocambio")
public class TipoCambioController {

    @Autowired
    private TipoCambioService tipoCambioService;
    
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Single<ResponseEntity<BaseWebResponse>> addTipoCambio(@RequestBody CambioWebRequest cambioWebRequest) {
        return tipoCambioService.addTipoCambio(toChangeTipoCambio(cambioWebRequest))
                .subscribeOn(Schedulers.io())
                .map(s -> ResponseEntity
                        .created(URI.create("/api/tipocambio/" + s))
                        .body(BaseWebResponse.successNoData()));
    }

    private ChangeTipoCambio toChangeTipoCambio(CambioWebRequest cambioWebRequest) {
    	ChangeTipoCambio changeTipoCambio = new ChangeTipoCambio();
        BeanUtils.copyProperties(cambioWebRequest, changeTipoCambio);
        return changeTipoCambio;
    }
    
    @GetMapping(
            value = "/MonOrigen/{MonOrigen}/MonDestino/{MonDestino}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Single<ResponseEntity<BaseWebResponse>> getTipoCambio(@PathVariable(value = "MonOrigen") String MonOrigen,
    										                     @PathVariable(value = "MonDestino") String MonDestino) {
    	return tipoCambioService.getTipoCambio(MonOrigen, MonDestino)
    			.subscribeOn(Schedulers.io())
    			.map(TCResponses -> ResponseEntity.ok(BaseWebResponse.successWithData(toTCWebResponseList(TCResponses))));
    }

    private List<TCWebResponse> toTCWebResponseList(List<TCResponse> tCResponses) {
    	return tCResponses
    			.stream()
    			.map(this::toTCWebResponse)
    			.collect(Collectors.toList());
    }

    private TCWebResponse toTCWebResponse(TCResponse tCResponse) {
    	TCWebResponse tCWebResponse = new TCWebResponse();
    	BeanUtils.copyProperties(tCResponse, tCWebResponse);
    	return tCWebResponse;
    }
}
