package app.dev.infinite.prueba_unidad_editorial.presentation.main;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import app.dev.infinite.prueba_unidad_editorial.R;
import app.dev.infinite.prueba_unidad_editorial.domain.model.News;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ElZhar on 05/10/2018.
 */

public class MainAdapter  extends RecyclerView.Adapter<MainAdapter.ViewHolder> {



    ArrayList<News> list;
    Context mContext;

    private static final int FIRST = 0;
    private static final int LIST= 1;
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);
        mContext = v.getContext();

        switch (viewType) {
            case FIRST:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.first_item, parent, false);
                break;
            case LIST:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.news_item, parent, false);
                break;
        }


        return new ViewHolder(v);
    }

    public void setList(ArrayList<News> listNews){
        list = listNews;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.bindItems(list.get(position), mContext);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private Context mContext;

        @BindView(R.id.titulo)
        TextView titulo;
        @BindView(R.id.antetitulo)
        TextView antetitulo;
        @BindView(R.id.date)
        TextView fecha;
        @BindView(R.id.cintillo)
        TextView cintillo;
        @BindView(R.id.imageView)
        ImageView imagen;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            mContext = v.getContext();

        }

        public void bindItems(News news, Context context) {


           // DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
           // String date = df.format(news.getFecha());

            Date convertedDate = news.parseStringtoDate();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            String date = df.format(convertedDate);
            titulo.setText(news.getTitulo());
            antetitulo.setText(news.getAntetitulo());
            fecha.setText(date);
            cintillo.setText(news.getCintillo());
            //imagen.setImageURI(Uri.parse(news.getMultimedia().get(0).getUrl()));
            Picasso.with(mContext).load(Uri.parse(news.getMultimedia().get(0).getUrl())).into(imagen);

        }

    }

    @Override
    public int getItemViewType(int position) {
        // Gestionar los tipos de vistas que van a ir en cada lado
        if (position == 0)
            return FIRST;
        else {

            return LIST;
        }
    }


}
