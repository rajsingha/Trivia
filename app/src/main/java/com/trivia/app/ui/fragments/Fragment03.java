package com.trivia.app.ui.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.trivia.app.R;
import com.trivia.app.databinding.FragmentQuestion03Binding;
import com.trivia.app.utils.Util;
import com.trivia.app.viewmodels.UniversalViewModel;


public class Fragment03 extends Fragment {

    private FragmentQuestion03Binding binding;
    UniversalViewModel viewModel;

    public Fragment03(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentQuestion03Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(UniversalViewModel.class);


        binding.submitBtn.setOnClickListener(v -> {
            //Concating the string and organizing the string with comma
            String answer ="";
            if (binding.whiteCheckBox.isChecked()){
                answer +="White,";
            }
            if (binding.greenCheckBox.isChecked()){
                answer +="Green,";
            }
            if (binding.orangeCheckBox.isChecked()){
                answer +="Orange,";
            }
            if (binding.yellowCheckBox.isChecked()){
                answer +="Yellow,";
            }

            if (TextUtils.isEmpty(answer)){
                Toast.makeText(getContext(),"Please select all the options!",Toast.LENGTH_SHORT).show();
            }else {
                viewModel.setQNA03(
                        getActivity().getString(R.string.question_3),
                        Util.INSTANCE.deleteLastComma(answer)
                );

                //Pushing all the data to Db through viewModel
                viewModel.pushToDB(getContext());
                // Jumping from this fragment to next fragment
                Util.INSTANCE.replaceFragment(getActivity(),new FragmentSummary());
            }
        });
    }
}
