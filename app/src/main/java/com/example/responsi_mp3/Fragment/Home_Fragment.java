package com.example.responsi_mp3.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_mp3.Data.Adapter;
import com.example.responsi_mp3.Data.Data_Laptop;
import com.example.responsi_mp3.Model.Laptop;
import com.example.responsi_mp3.R;


import java.util.ArrayList;

public class Home_Fragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Laptop> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home__fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        list.addAll(Data_Laptop.getListData());
        showRecyclerList();
        return view;
    }
    private void showRecyclerList() {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        Adapter shoesAdapter = new Adapter(list);
        recyclerView.setAdapter(shoesAdapter);

}
}