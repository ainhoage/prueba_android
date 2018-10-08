package app.dev.infinite.prueba_unidad_editorial.presentation.main;



import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.dev.infinite.prueba_unidad_editorial.R;
import app.dev.infinite.prueba_unidad_editorial.domain.DataManager;
import app.dev.infinite.prueba_unidad_editorial.domain.model.News;
import app.dev.infinite.prueba_unidad_editorial.domain.response.ResponseNews;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ElZhar on 05/10/2018.
 */

public class MainPresenter {

    private DataManager dataManager = new DataManager();
    private Context context;


    public void attachView(Context context){
        this.context = context;


    }

    public void getData(){

        Observable<ResponseNews> observable = dataManager.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<ResponseNews> observer = new Observer<ResponseNews>() {
            @Override
            public void onSubscribe(Disposable d) {
                //
            }

            @Override
            public void onNext(ResponseNews newsResponse) {
                if (newsResponse.getList().size() >0){
                    ArrayList<News> list = newsResponse.getList();
                    Collections.sort(list);
                    showInfo(list);
                }

            }

            @Override
            public void onError(Throwable e) {
                    showError(context.getResources().getString(R.string.error_message));
            }

            @Override
            public void onComplete() {
                //
            }
        };
        observable.subscribe(observer);

    }

    private void showInfo(ArrayList<News> newsList){



        ((MainActivity)context).showInfo(newsList);
    }

    private void showError(String message){

        ((MainActivity)context).showError(message);
    }

}
