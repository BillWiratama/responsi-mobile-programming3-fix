package com.example.responsi_mp3.History;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class HistoryViewModel extends AndroidViewModel {


    private LiveData<List<History>> allHistory;

    public HistoryViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<History>> getAllHistory() {
    }
}
