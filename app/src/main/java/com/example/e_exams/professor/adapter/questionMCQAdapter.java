package com.example.e_exams.professor.adapter;

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


public class questionMCQAdapter extends RecyclerView.Adapter<questionMCQAdapter.questionMcqViewHolder>{
    private ArrayList<mcqS> items=new ArrayList<>();
private mcqS mcqS;

    public questionMCQAdapter(com.example.e_exams.professor.models.mcqS mcqS) {
        this.mcqS = mcqS;
    }

    @NonNull
    @Override
    public questionMcqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            return new questionMcqViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.templete_mcq_item,parent,false));
        }





    public void onBindViewHolder(@NonNull questionMcqViewHolder holder, int position) {
     holder.questionMcq.setText(items.get(position).getMsqQuestion());
        holder.firstAns.setText(items.get(position).getFirstAns());
        holder.secondAns.setText(items.get(position).getSecondAns());
        holder.thirdAns.setText(items.get(position).getThirdANs());
        holder.fourthAns.setText(items.get(position).getForthAns());

      }


    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setItems(ArrayList<mcqS> mcqList){
        this.items=mcqList;
        notifyDataSetChanged();


    }

    public class questionMcqViewHolder extends RecyclerView.ViewHolder{
         EditText questionMcq,firstAns,secondAns,thirdAns,fourthAns;
         RadioButton itemSelected;


      public  questionMcqViewHolder(@NonNull View itemView) {
            super(itemView);
            questionMcq=itemView.findViewById(R.id.edtQuestion);
            firstAns=itemView.findViewById(R.id.firstBtn);
            secondAns=itemView.findViewById(R.id.secondBtn);
            thirdAns=itemView.findViewById(R.id.thirdtBtn);
            fourthAns=itemView.findViewById(R.id.fourthtBtn);
//            itemView.setOnClickListener((View.OnClickListener) this);
        }

    }


}

