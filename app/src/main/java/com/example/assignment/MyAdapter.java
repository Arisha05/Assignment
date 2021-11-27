package com.example.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);

        holder.product.setText(listItem.getPname());
        holder.tQuan.setText(listItem.gettQuan());
        holder.cDate.setText(listItem.getcDate());
        holder.cTime.setText(listItem.getcTime());
        holder.amount.setText(listItem.getAmount());
        holder.unit.setText(listItem.getUnit());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView    product,amount,unit;
        public TextView tQuan,cDate,cTime;

        public ViewHolder( View itemView) {
            super(itemView);

            product = (TextView)itemView.findViewById(R.id.product);
            tQuan = (TextView)itemView.findViewById(R.id.tQuan);
            cDate = (TextView)itemView.findViewById(R.id.cDate);
            cTime = (TextView)itemView.findViewById(R.id.cTime);
            amount = (TextView)itemView.findViewById(R.id.amount);
            unit = (TextView)itemView.findViewById(R.id.unit);
        }
    }

}
