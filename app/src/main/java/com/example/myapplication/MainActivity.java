package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import com.example.myapplication.db.TaskModelDb;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    Disposable disposable = null;

    AdapterRecycler adapterRecycler;

    private TaskApi taskApiService(){
        return RetrofitClient.getApi();
    }

    private List<TaskModel> taskModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TaskModelDb taskModelDb = Room.databaseBuilder(this, TaskModelDb.class,"taskModels").build();

        initRecyclerView();

        disposable = taskApiService().getTask()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> adapterRecycler.onChange(list));



    }

    public void initRecyclerView() {
        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterRecycler = new AdapterRecycler(this,taskModels);
        recyclerView.setAdapter(adapterRecycler);

    }

}
