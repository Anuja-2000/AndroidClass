package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.loginapplication.adapters.AdapterClass;
import com.example.loginapplication.models.ModelClass;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements AdapterClass.ViewHolder.RecyclerViewClickListener{
    RecyclerView rv_list;
    AdapterClass adapterClass;
    ArrayList<ModelClass> modelClasses;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        rv_list = findViewById(R.id.rv_list);
        initData();
        setAdapter();
    }

    private void setAdapter() {
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        adapterClass = new AdapterClass(modelClasses,ListActivity.this::onClickListener);
        rv_list.setAdapter(adapterClass);
        rv_list.setLayoutManager(linearLayoutManager);
    }

    private void initData() {
        //get data from database
        modelClasses = new ArrayList<>();
        modelClasses.add(new ModelClass(R.drawable.student,"A S R Perera","Colombo"));
        modelClasses.add(new ModelClass(R.drawable.student,"A S R Saman","Gampaha"));
        modelClasses.add(new ModelClass(R.drawable.student,"A S R Kumara","Kandy"));
        modelClasses.add(new ModelClass(R.drawable.student,"A S R Perera","Negombo"));
        modelClasses.add(new ModelClass(R.drawable.student,"A S R Perera","Galle"));
        modelClasses.add(new ModelClass(R.drawable.student,"A S R Perera","Kalutara"));
        modelClasses.add(new ModelClass(R.drawable.student,"A S R Perera","Jaffna"));
        modelClasses.add(new ModelClass(R.drawable.student,"A S R Perera","Hatton"));
    }

    @Override
    public void onClickListener(int position) {
        String name = modelClasses.get(position).getName();
        Toast.makeText(ListActivity.this,"Hello"+name,Toast.LENGTH_SHORT).show();

    }
}