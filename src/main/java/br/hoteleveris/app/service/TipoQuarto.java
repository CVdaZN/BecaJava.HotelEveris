package br.hoteleveris.app.service;

import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;

public interface TipoQuarto {
 public BaseResponse inserir (TipoQuartoRequest request);
}
