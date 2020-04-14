package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.RececlerViewHolder> {

    private Context context;
    private List<TaskModel> taskModels = new ArrayList<>();

    public AdapterRecycler(Context context, List<TaskModel> taskModels) {
        this.context = context;
        this.taskModels = taskModels;
    }

    class RececlerViewHolder extends RecyclerView.ViewHolder {

        TextView idView;
        TextView nameView;
        TextView ageView;

        public RececlerViewHolder(@NonNull View itemView) {
            super(itemView);
            idView = itemView.findViewById(R.id.id);
            nameView = itemView.findViewById(R.id.name);
            ageView = itemView.findViewById(R.id.age);
        }
    }


    @NonNull
    @Override
    public RececlerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.task_list_item, parent, false);
        return new RececlerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RececlerViewHolder holder, int position) {
        if (taskModels.size() != 0) {
            TaskModel taskModel = this.taskModels.get(position);
            holder.idView.setText(taskModel.getId());
            holder.nameView.setText(taskModel.getName());
            holder.ageView.setText(taskModel.getAge());
        }

    }

    @Override
    public int getItemCount() {
        return taskModels.size();
    }

    public void onChange(List<TaskModel> taskModels) {
        this.taskModels.clear();
        this.taskModels.addAll(taskModels);
        notifyDataSetChanged();
    }


}
