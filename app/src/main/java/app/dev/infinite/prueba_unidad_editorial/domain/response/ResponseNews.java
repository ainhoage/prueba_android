package app.dev.infinite.prueba_unidad_editorial.domain.response;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import app.dev.infinite.prueba_unidad_editorial.domain.model.News;
import okhttp3.ResponseBody;

/**
 * Created by ElZhar on 05/10/2018.
 */

public  class ResponseNews  {

    @SerializedName("cts")
    private ArrayList<News> list;

    public ArrayList<News> getList() {
        return list;
    }

    public void setList(ArrayList<News> response) {
        this.list = response;
    }
}
