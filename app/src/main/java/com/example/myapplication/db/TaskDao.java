package com.example.myapplication.db;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.myapplication.TaskModel;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM taskModel")
    List<TaskModel> getAll();

    @Query("SELECT * FROM taskmodel WHERE id = :ids")
    TaskModel getBuId(long ids);

}
