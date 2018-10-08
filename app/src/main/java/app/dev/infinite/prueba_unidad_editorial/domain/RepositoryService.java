package app.dev.infinite.prueba_unidad_editorial.domain;

import io.reactivex.Observable;

import org.json.JSONObject;

import app.dev.infinite.prueba_unidad_editorial.domain.response.ResponseNews;

/**
 * Created by ElZhar on 05/10/2018.
 */

public interface RepositoryService {

    public Observable<ResponseNews> getData();
}
