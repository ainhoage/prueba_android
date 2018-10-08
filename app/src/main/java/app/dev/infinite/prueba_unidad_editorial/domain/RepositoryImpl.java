package app.dev.infinite.prueba_unidad_editorial.domain;

import io.reactivex.Observable;

import app.dev.infinite.prueba_unidad_editorial.domain.response.ResponseNews;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ElZhar on 05/10/2018.
 */

public class RepositoryImpl implements DataRepository {

    APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

    @Override
    public Observable<ResponseNews> getData() {

        return apiInterface.getInfo();
/*        call.enqueue(new Callback<ResponseNews>() {
            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                    ResponseNews responseNews = response.body();


            }

            @Override
            public void onFailure(Call<ResponseNews> call, Throwable t) {
                call.cancel();
            }
        });
*/
    }

}
