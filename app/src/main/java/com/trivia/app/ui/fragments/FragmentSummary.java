package com.trivia.app.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.trivia.app.databinding.FragmentSummaryBinding;
import com.trivia.app.ui.activities.HistoryActivity;
import com.trivia.app.utils.Util;
import com.trivia.app.viewmodels.UniversalViewModel;

public class FragmentSummary extends Fragment {

    private FragmentSummaryBinding binding;
    UniversalViewModel viewModel;

    public FragmentSummary() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSummaryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(UniversalViewModel.class);

        if (!TextUtils.isEmpty(viewModel.getTheUserData().getAnswer1())){
            binding.userGreetTv.setText("Hi "+viewModel.getTheUserData().getAnswer1()+",");
        }
        if (!TextUtils.isEmpty(viewModel.getTheUserData().getAnswer2())){
            binding.answer2.setText("Answer: "+viewModel.getTheUserData().getAnswer2());
        }
        if (!TextUtils.isEmpty(viewModel.getTheUserData().getAnswer3())){
            binding.answer3.setText("Answer: "+viewModel.getTheUserData().getAnswer3());
        }

        binding.finishBtn.setOnClickListener(v -> {
            viewModel.resetData();
            Util.INSTANCE.replaceFragment(getActivity(),new Fragment01());
        });

        binding.historyBtn.setOnClickListener(v -> startActivity(new Intent(getContext(),HistoryActivity.class)));
    }
}
