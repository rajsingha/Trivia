package com.trivia.app.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.trivia.app.R;
import com.trivia.app.databinding.FragmentQuestion02Binding;
import com.trivia.app.utils.Util;
import com.trivia.app.viewmodels.UniversalViewModel;


public class Fragment02 extends Fragment {

    private FragmentQuestion02Binding binding;
    private RadioButton radioButton;
    UniversalViewModel viewModel;


    public Fragment02(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentQuestion02Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // ViewModel Initialized
        viewModel = new ViewModelProvider(requireActivity()).get(UniversalViewModel.class);
        // invoking the method onClick
        binding.nextButton.setOnClickListener(v -> {
            int radioId = binding.radioGrp.getCheckedRadioButtonId();
            radioButton = getActivity().findViewById(radioId);

            // Checking the radioButton is selected or not
            if (radioButton ==null){
                Toast.makeText(getContext(),"Please select an option!",Toast.LENGTH_SHORT).show();
            }else {
                //Set QNA02 for future use
                viewModel.setQNA02(getActivity().getString(R.string.question_2),radioButton.getText().toString());

                // Jumping from this fragment to next fragment
                Util.INSTANCE.replaceFragment(getActivity(),new Fragment03());
            }

        });
    }


}
