package com.example.e_exams.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_exams.R;

public class numberQuestionAdapterSt  extends RecyclerView.Adapter<numberQuestionAdapterSt.viewHolder> {
    @NonNull
    String qNumber[];
    Context context;
    public numberQuestionAdapterSt(Context context, String[] qNumber) {
        this.qNumber= qNumber;
        this.context=context;
    }
    @Override
    public numberQuestionAdapterSt.viewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.numberquestionstudent,parent,false);
        viewHolder viewHolder=new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  numberQuestionAdapterSt.viewHolder holder, int position) {
        holder.txtNumber.setText(qNumber[position]);
        holder.txtNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "click me", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return qNumber.length;

    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView txtNumber;
        public viewHolder(@NonNull  View itemView) {
            super(itemView);
            txtNumber=itemView.findViewById(R.id.QNumber);
        }
    }
}
