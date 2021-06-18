package com.trivia.app.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.trivia.app.adapters.HistoryDataAdapter;
import com.trivia.app.databinding.ActivityHistoryBinding;
import com.trivia.app.models.UserData;
import com.trivia.app.viewmodels.UniversalViewModel;

import java.util.List;


public class HistoryActivity extends AppCompatActivity {

    private ActivityHistoryBinding binding;
    private UniversalViewModel viewModel;
    private HistoryDataAdapter adapter;
    private List<UserData> userDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new HistoryDataAdapter(this,userDataList);
        binding.recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(UniversalViewModel.class);
        viewModel.getMutableLiveDataObserver().observe(this,userData -> {
            if (userData!=null){
                userDataList = userData;
                adapter.setUserDataList(userDataList);
            }
        });
        viewModel.fetchDataFromDB(this);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
