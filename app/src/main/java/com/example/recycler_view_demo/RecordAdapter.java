package com.example.recycler_view_demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.myViewHolder> {

    Context context;
    private ArrayList<Record> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView disc,amount,date , id;
        public myViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            disc= (TextView) view.findViewById( R.id.disc );
            amount= (TextView)view.findViewById( R.id.amount );
            date= (TextView)view.findViewById( R.id.date );
        }

    }

    public RecordAdapter(ArrayList<Record> dataSet) {
        this.localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder viewHolder, int position) {
      //  Record record =localDataSet.get( position );
//        viewHolder.disc.setText(localDataSet.get( position ).getDisc());
        viewHolder.disc.setText( localDataSet.get( position ).getDisc() );
        viewHolder.amount.setText( localDataSet.get( position ).getAmount() );
        viewHolder.date.setText( localDataSet.get( position ).getDate() );
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

