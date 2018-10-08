package app.dev.infinite.prueba_unidad_editorial.domain;

import io.reactivex.Observable;

import org.json.JSONObject;

import app.dev.infinite.prueba_unidad_editorial.domain.response.ResponseNews;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.Callback;

/**
 * Created by ElZhar on 05/10/2018.
 */

public interface APIInterface {

    @GET("/bins/18a62k")
    Observable<ResponseNews> getInfo();
}
