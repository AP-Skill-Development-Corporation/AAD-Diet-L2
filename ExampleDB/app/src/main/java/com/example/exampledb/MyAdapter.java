package com.example.exampledb;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exampledb.rdb.Rtable;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.HoldView> {
    Context ct;
    List<Rtable> list;

    public MyAdapter(Context ct, List<Rtable> list) {
        this.ct = ct;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter.HoldView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HoldView(LayoutInflater.from(ct)
                .inflate(R.layout.row,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.HoldView holder, int position) {
        holder.rollno.setText(list.get(position).getRollno());
        holder.name.setText(list.get(position).getName());
        holder.number.setText(list.get(position).getNumber());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.rviewmodel.delete(list.get(position));
                Toast.makeText(ct, "Data deleted", Toast.LENGTH_SHORT).show();
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ct);
                View view = LayoutInflater.from(ct)
                        .inflate(R.layout.update,null,false);
                final EditText r = view.findViewById(R.id.roll);
                final EditText n = view.findViewById(R.id.name);
                final EditText num = view.findViewById(R.id.number);
                builder.setView(view);
                builder.setCancelable(false);

                r.setText(list.get(position).getRollno());
                r.setEnabled(false);
                n.setText(list.get(position).getName());
                num.setText(list.get(position).getNumber());

                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Rtable rtable = new Rtable();
                        rtable.setRollno(r.getText().toString());
                        rtable.setName(n.getText().toString());
                        rtable.setNumber(num.getText().toString());
                        MainActivity.rviewmodel.update(rtable);
                        dialog.dismiss();
                        Toast.makeText(ct, "updated",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HoldView extends RecyclerView.ViewHolder {
        TextView rollno,name,number;
        ImageView edit,delete;
        public HoldView(@NonNull View itemView) {
            super(itemView);
            rollno=itemView.findViewById(R.id.sroll);
            name=itemView.findViewById(R.id.sname);
            number=itemView.findViewById(R.id.snumber);
            edit=itemView.findViewById(R.id.edit);
            delete=itemView.findViewById(R.id.delete);
        }
    }
}
