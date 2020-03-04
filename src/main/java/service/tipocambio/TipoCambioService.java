package service.tipocambio;

import servicedto.request.ChangeTipoCambio;
import servicedto.response.TCResponse;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;

public interface TipoCambioService {
	    Single<String> addTipoCambio(ChangeTipoCambio changeTipoCambio);
	   
	    Single<List<TCResponse>> getTipoCambio(String MonOrigen, String MonDestino);
}
