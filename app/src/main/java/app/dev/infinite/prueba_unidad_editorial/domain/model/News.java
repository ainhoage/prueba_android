package app.dev.infinite.prueba_unidad_editorial.domain.model;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ElZhar on 05/10/2018.
 */

public class News implements Comparable<News>{

    @SerializedName("id")
    private String id;
    @SerializedName("publishedAt")
    private String fecha;
    @SerializedName("url")
    private String url;
    @SerializedName("titulo")
    private String titulo;
    @SerializedName("antetitulo")
    private String antetitulo;
    @SerializedName("cintillo")
    private String cintillo;
    @SerializedName("multimedia")
    private ArrayList<Multimedia> multimedia;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCintillo() {
        return cintillo;
    }

    public void setCintillo(String cintillo) {
        this.cintillo = cintillo;
    }

    public ArrayList<Multimedia> getMultimedia() {
        return multimedia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAntetitulo() {
        return antetitulo;
    }

    public void setAntetitulo(String antetitulo) {
        this.antetitulo = antetitulo;
    }

    public void setMultimedia(ArrayList<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }




    public Date parseStringtoDate(){

        //SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss Z", Locale.FRANCE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss zzz");
        //String dateTest = "Thu, 19 Apr 2018 07:04:50";
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(getFecha());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return convertedDate;

    }

    @Override
        public int compareTo(News o) {

        Date date1 = this.parseStringtoDate();
        Date date2 = o.parseStringtoDate();
        return date1.compareTo(date2);
    }
}
