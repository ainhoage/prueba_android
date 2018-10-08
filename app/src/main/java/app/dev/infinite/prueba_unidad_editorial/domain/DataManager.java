package app.dev.infinite.prueba_unidad_editorial.domain;

import io.reactivex.Observable;

import app.dev.infinite.prueba_unidad_editorial.domain.response.ResponseNews;

/**
 * Created by ElZhar on 05/10/2018.
 */

public class DataManager implements RepositoryService {

    DataRepository dataRepository = new RepositoryImpl();
    @Override
    public Observable<ResponseNews> getData() {
        return dataRepository.getData();
    }
}
