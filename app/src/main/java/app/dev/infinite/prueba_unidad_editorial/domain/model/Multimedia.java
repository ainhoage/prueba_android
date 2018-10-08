package app.dev.infinite.prueba_unidad_editorial.domain.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ElZhar on 05/10/2018.
 */

public class Multimedia {

    @SerializedName("url")
    private String url;
    @SerializedName("title")
    private String title;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
