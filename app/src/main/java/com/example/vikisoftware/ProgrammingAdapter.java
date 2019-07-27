package com.example.vikisoftware;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.programmingadaper> {
    private OnNotekListener onNotekListener;
    private String[] data;
    public ProgrammingAdapter(String[] data, OnNotekListener onNotekListener) {
        this.data = data;
        this.onNotekListener=onNotekListener;
    }
    public class programmingadaper extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgeIcon;
        TextView textTitle;
        OnNotekListener onNotekListener;
        Button btntakephoto;
        public programmingadaper(View itemView,OnNotekListener onNotekListener) {
            super(itemView);
            imgeIcon=itemView.findViewById(R.id.imgIcon);
            textTitle=itemView.findViewById(R.id.textTitle);
            btntakephoto =itemView.findViewById(R.id.btntakephoto);
            this.onNotekListener=onNotekListener;
            btntakephoto.setOnClickListener(this) ;
        }
        @Override
        public void onClick(View view) {
            onNotekListener.onNoteClick(getAdapterPosition());
        }
    }
    @Override
    public programmingadaper onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout, parent, false);


        return new programmingadaper(view,onNotekListener);
    }
    @Override
    public void onBindViewHolder(programmingadaper holder, int position) {
        holder.textTitle.setText(data[position]);
        //holder.btntakephoto.setText(data[position]);
    }
    @Override
    public int getItemCount() {
        return data.length;
    }
    public interface OnNotekListener{
        void onNoteClick(int position);
    }
}
