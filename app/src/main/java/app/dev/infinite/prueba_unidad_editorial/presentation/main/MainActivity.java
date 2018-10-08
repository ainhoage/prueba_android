package app.dev.infinite.prueba_unidad_editorial.presentation.main;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import app.dev.infinite.prueba_unidad_editorial.R;
import app.dev.infinite.prueba_unidad_editorial.domain.model.News;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list)
    RecyclerView list;



    private MainAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private MainPresenter mainPresenter = new MainPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter.attachView(this);
        mainPresenter.getData();
    }


    public void showInfo(ArrayList<News> newsList){

        mLayoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(mLayoutManager);
        mAdapter = new MainAdapter();
        mAdapter.setList(newsList);
        list.setAdapter(mAdapter);


    }



    public void showError(String mensaje){

        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }
}
