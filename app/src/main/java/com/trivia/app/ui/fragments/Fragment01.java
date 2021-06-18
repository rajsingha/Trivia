package com.trivia.app.ui.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.trivia.app.R;

import com.trivia.app.databinding.FragmentQuestion01Binding;
import com.trivia.app.utils.Util;
import com.trivia.app.viewmodels.UniversalViewModel;


public class Fragment01 extends Fragment {

    private FragmentQuestion01Binding binding;
    UniversalViewModel viewModel;


    public Fragment01(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =FragmentQuestion01Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // ViewModel Initialized
        viewModel = new ViewModelProvider(requireActivity()).get(UniversalViewModel.class);


        binding.nextButton.setOnClickListener(v -> {

            //Checking the edit text is empty or not
            if (TextUtils.isEmpty(binding.answer1.getText())){
                binding.answer1.requestFocus();
            }else {
                viewModel.setQNA01(getContext().getString(R.string.question_1),binding.answer1.getText().toString());
                // Jumping from this fragment to next fragment
                Util.INSTANCE.replaceFragment(getActivity(),new Fragment02());
            }

        });


    }

}