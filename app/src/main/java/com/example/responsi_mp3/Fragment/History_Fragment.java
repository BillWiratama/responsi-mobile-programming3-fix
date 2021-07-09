package com.example.responsi_mp3.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_mp3.History.History;
import com.example.responsi_mp3.History.HistoryAdapter;
import com.example.responsi_mp3.History.HistoryViewModel;
import com.example.responsi_mp3.R;

import java.util.List;


public class History_Fragment extends AppCompatActivity {
    private HistoryViewModel historyViewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, Context getContext){
        View view = inflater.inflate(R.layout.activity_history__fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_vListHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext));
        recyclerView.setHasFixedSize(true);

        HistoryAdapter adapter = new HistoryAdapter();
        recyclerView.setAdapter(adapter);

        historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        historyViewModel.getAllHistory().observe((), new Observer<List<History>>() {
            @Override
            public void onChanged(List<History> histories) {
                adapter.setHistoryList(histories);
            }
        });
        return view;
    }
}