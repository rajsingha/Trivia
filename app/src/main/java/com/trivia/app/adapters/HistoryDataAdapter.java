package com.trivia.app.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trivia.app.databinding.GameItemsBinding;
import com.trivia.app.models.UserData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HistoryDataAdapter extends RecyclerView.Adapter<HistoryDataAdapter.ViewHolder> {

    private Context context;
    private List<UserData> userDataList;

    public HistoryDataAdapter(Context context,List<UserData> userData){
        this.context =context;
        this.userDataList =userData;
    }
    public void setUserDataList(List<UserData> userDataList){
        this.userDataList =userDataList;
        notifyDataSetChanged();
    }

    @Override
    public HistoryDataAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(GameItemsBinding
                .inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HistoryDataAdapter.ViewHolder holder, int position) {
        UserData userData = userDataList.get(position);
        //Set the id and date-time
        holder.binding.gameIdDateTime.setText("GAME "+userData.getID()+" : "+userData.getDateTime());
        //Set the answer01 aka Name
        holder.binding.userName.setText("Name : "+userData.getAnswer1());
        //Set the answer02
        holder.binding.answer2.setText("Answer : "+userData.getAnswer2());
        //Set the answer03
        holder.binding.answer3.setText("Answer : "+userData.getAnswer3());
    }

    @Override
    public int getItemCount() {
        if (this.userDataList!=null){
            return this.userDataList.size();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        GameItemsBinding binding;
        public ViewHolder(@NonNull @NotNull GameItemsBinding binding) {
            super(binding.getRoot());
            this.binding =binding;
        }
    }
}
