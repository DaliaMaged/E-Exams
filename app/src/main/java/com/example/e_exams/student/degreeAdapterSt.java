package com.example.e_exams.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_exams.R;

public class degreeAdapterSt extends RecyclerView.Adapter<degreeAdapterSt.viewHolderDgreeSt> {
    @NonNull
    String DgreeSt[];
    Context context;

    public degreeAdapterSt(String DgreeSt[], Context context) {
        this.DgreeSt = DgreeSt;
        this.context = context;
    }
    @Override
    public degreeAdapterSt.viewHolderDgreeSt onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.degree_recycle_student,parent,false);
        viewHolderDgreeSt viewHolderDgreeSt= new viewHolderDgreeSt(view);
        return viewHolderDgreeSt;
    }

    @Override
    public void onBindViewHolder(@NonNull  degreeAdapterSt.viewHolderDgreeSt holder, int position) {
        holder.txtSubjectName.setText("Subject Name");
        holder.txtLecName.setText("Lecture One");
        holder.txtLecName2.setText("Lecture Two");
        holder.txtLecDegree.setText("10/15");
        holder.txtLecDegree2.setText("15/15");
    }

    @Override
    public int getItemCount() {
        return DgreeSt.length;
    }

    public class viewHolderDgreeSt extends RecyclerView.ViewHolder {
        TextView txtSubjectName;
        TextView txtLecName;
        TextView txtLecName2;
        TextView txtLecDegree;
        TextView txtLecDegree2;
        public viewHolderDgreeSt(@NonNull  View itemView) {
            super(itemView);
            txtSubjectName=itemView.findViewById(R.id.txtSubjectName);
            txtLecName=itemView.findViewById(R.id.txtLecName);
            txtLecName2=itemView.findViewById(R.id.txtLecName2);
            txtLecDegree=itemView.findViewById(R.id.txtLecDegree);
            txtLecDegree2=itemView.findViewById(R.id.txtLecDegree2);
        }
    }
}
