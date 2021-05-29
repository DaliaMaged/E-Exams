package com.example.e_exams.professor.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.e_exams.professor.models.mcqS;

import com.example.e_exams.R;

import java.util.ArrayList;
import java.util.List;


public class questionMCQAdapter extends RecyclerView.Adapter<questionMCQAdapter.questionMcqViewHolder>{
    private List<mcqS> mcqS;
    public questionMCQAdapter(List<mcqS> mcqS) {
        this.mcqS = mcqS;

    }

    @NonNull
    @Override
    public questionMcqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new questionMcqViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.templete_mcq_item,parent,false));
    }





    public void onBindViewHolder(@NonNull questionMcqViewHolder holder, int position) {
        holder.questionMcq.setText(mcqS.get(position).getMsqQuestion());
        holder.firstAns.setText(mcqS.get(position).getFirstAns());
        holder.secondAns.setText(mcqS.get(position).getSecondAns());
        holder.thirdAns.setText(mcqS.get(position).getThirdANs());
        holder.fourthAns.setText(mcqS.get(position).getForthAns());

    }


    @Override
    public int getItemCount() {
        return mcqS.size();
    }


    public class questionMcqViewHolder extends RecyclerView.ViewHolder{
        EditText questionMcq;
        EditText firstAns,secondAns,thirdAns,fourthAns;


        public  questionMcqViewHolder(@NonNull View itemView) {
            super(itemView);
            questionMcq = itemView.findViewById(R.id.edtQuestion);
            firstAns = itemView.findViewById(R.id.firstChoice);
            secondAns = itemView.findViewById(R.id.secondChoice);
            thirdAns = itemView.findViewById(R.id.thirdChoice);
            fourthAns = itemView.findViewById(R.id.forthChoice);


        }}}