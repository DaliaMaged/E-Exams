package com.example.e_exams.professor.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_exams.R;
import com.example.e_exams.professor.models.trueAndfalses;

import java.util.ArrayList;
import java.util.List;


public class questionTFAdapter extends RecyclerView.Adapter<questionTFAdapter.questionTrueNFasleViewHolder>{

    private List<trueAndfalses> trueAndfalses;

    public questionTFAdapter(List<trueAndfalses> trueAndfalses) {
        this.trueAndfalses=trueAndfalses;
    }


    @NonNull
    @Override
    public questionTrueNFasleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new questionTrueNFasleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.templete_tf_item,parent,false));
    }





    public void onBindViewHolder(@NonNull questionTFAdapter.questionTrueNFasleViewHolder holder, int position) {
        holder.questionTF.setText(trueAndfalses.get(position).gettNfQuestion());
        holder.firstAns.setText(trueAndfalses.get(position).getFirstAns());
        holder.secondAns.setText(trueAndfalses.get(position).getSecondAns());


    }


    @Override
    public int getItemCount() {
        return trueAndfalses.size();
    }

    static class questionTrueNFasleViewHolder extends RecyclerView.ViewHolder{
        private EditText questionTF;
        private RadioButton firstAns,secondAns;


        questionTrueNFasleViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTF=itemView.findViewById(R.id.edtQuestion);
            firstAns=itemView.findViewById(R.id.trueBtn);
            secondAns=itemView.findViewById(R.id.falseBtn);



        }

    }}
