package com.example.myapplication5.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication5.R;
import com.example.myapplication5.model.ModelData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//mengaambil layout dari row_item dan menampilkannya(objek) sesuai data
public class AdapterData extends RecyclerView.Adapter<AdapterData.ViewHolder> {
    private ArrayList<ModelData> modelData;
    private Context context;

    public AdapterData(Context context, ArrayList<ModelData> modelData){
        this.context = context;
        this.modelData = modelData;

    }

    @NonNull
    @Override
    public AdapterData.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterData.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvData.setText(modelData.get(position).getNameData());
        holder.tvDataHarga.setText(modelData.get(position).getHargaData());
        Picasso.with(context).load(modelData.get(position).getUrlData()).resize(240, 240).into(holder.imgData);
        holder.btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());
                View dialogView = LayoutInflater.from(v.getRootView().getContext()).inflate(R.layout.sempel, null);

                ImageView imageDialog, addShop;
                TextView nameDialog, hargaDialog, buy;

                imageDialog = dialogView.findViewById(R.id.img_dialog);
                nameDialog = dialogView.findViewById(R.id.tv_nama_dialog);
                hargaDialog = dialogView.findViewById(R.id.tv_harga_dialog);
                addShop = dialogView.findViewById(R.id.add_shop);
                buy = dialogView.findViewById(R.id.btn_buy);

                Picasso.with(context).load(modelData.get(position).getUrlData()).resize(240, 240).into(imageDialog);
                nameDialog.setText(modelData.get(position).getNameData());
                hargaDialog.setText(modelData.get(position).getHargaData());
                addShop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Item added to cart", Toast.LENGTH_LONG).show();
                    }
                });
                buy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Successful purchase, make payment immediately", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setView(dialogView);
                builder.setCancelable(true);
                builder.show();




            }
        });


    }

    @Override
    public int getItemCount() {
        return modelData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvData;
        public TextView tvDataHarga;
        public ImageView imgData;
        public ImageView imgShop;
        public TextView btnGet;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvData = itemView.findViewById(R.id.tv_data);
            tvDataHarga = itemView.findViewById(R.id.tv_data_harga);
            imgData = itemView.findViewById(R.id.img_data);
            btnGet = itemView.findViewById(R.id.btn_get);
            imgShop = itemView.findViewById(R.id.add_shop);


        }
    }
}
