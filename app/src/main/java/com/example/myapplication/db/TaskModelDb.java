package com.example.myapplication.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.TaskModel;

@Database(entities = {TaskModel.class}, version = 1)
public abstract class TaskModelDb  extends RoomDatabase {
    public abstract TaskDao getTaskDao();

}
