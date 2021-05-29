package com.example.e_exams.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_exams.R;

public class examAdapterSt extends RecyclerView.Adapter<examAdapterSt.viewHolderExamSt> {
    Context baseContext;
    String sNumberst[];
    public examAdapterSt(Context baseContext,String sNumberst[]) {
        this.sNumberst= sNumberst;
        this.baseContext=baseContext;
    }
    @NonNull
    @Override
    public examAdapterSt.viewHolderExamSt onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.exam_recycle_student,parent,false);
        viewHolderExamSt viewHolderExamSt=new viewHolderExamSt(view);
        return viewHolderExamSt;
    }

    @Override
    public void onBindViewHolder(@NonNull  examAdapterSt.viewHolderExamSt holder, int position) {
        holder.txtSubjectName.setText("Subject Name");
        holder.txtLecName.setText("Lec One");
        holder.examCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "kkkkkk", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return sNumberst.length;
    }

    public class viewHolderExamSt extends RecyclerView.ViewHolder {
        TextView txtSubjectName;
        TextView txtLecName;
        CardView examCard;
        public viewHolderExamSt(@NonNull  View itemView) {
            super(itemView);
            txtSubjectName=itemView.findViewById(R.id.txtSubjectName);
            txtLecName=itemView.findViewById(R.id.txtLecName);
            examCard=itemView.findViewById(R.id.examNameRecycle);
        }
    }
}
