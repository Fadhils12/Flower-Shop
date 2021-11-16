package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication5.adapter.AdapterData;
import com.example.myapplication5.model.ModelData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String nameData[] = {
            "Bunga Mawar",
            "Bunga Raflesia",
            "Bungan Matahari",
            "Bunga Melati",
            "Bunga Kamboja",
            "Bunga Cosmos",
            "Bunga Lily",
            "Bunga  Jacob’s Ladder",
            "Bunga Lisianthus",
            "Bunga Ageratum",
    };

    private final String urlData[] = {
            "https://cdn0-production-images-kly.akamaized.net/6cszjr9F0IBFo3qoLgQDzAwAixU=/640x480/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2755890/original/084725800_1553055546-rose-3802424_1920.jpg",
            "https://mmc.tirto.id/image/otf/500x0/2018/01/09/rafflesia-arnoldii-istock_ratio-16x9.jpg",
            "https://asset.kompas.com/crops/WBpJKXQgsKjD3HSWCgEhZxTxrvY=/203x126:1717x1135/750x500/data/photo/2021/02/17/602cdadd641a9.jpg",
            "https://disdikpora.bulelengkab.go.id/upload/konten/75-sederet-manfaat-bunga-melati-bunga-yang-mewakili-karakter-indonesia.jpg",
            "https://bibitonline.com/wp-content/uploads/Bunga-adenium.jpg",
            "https://bibitonline.com/wp-content/uploads/bunga-cosmos.jpg",
            "https://bibitonline.com/wp-content/uploads/bunga-lily.jpg",
            "https://bibitonline.com/wp-content/uploads/bunga-jacobs-ladder.jpg",
            "https://bibitonline.com/wp-content/uploads/bunga-Lisianthus.jpg",
            "https://bibitonline.com/wp-content/uploads/bunga-ageratum.jpg"
    };

    private final String hargaData[] = {
            "20k",
            "50k",
            "30k",
            "1000k",
            "29k",
            "80k",
            "70k",
            "200k",
            "250k",
            "30k",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showData();


    }


    private void showData() {
        RecyclerView rvData = findViewById(R.id.rv_data);
        rvData.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplication(), 2);
        rvData.setLayoutManager(layoutManager);

        ArrayList<ModelData> modelData = preaperData();
        AdapterData adapterData = new AdapterData(getApplicationContext(), modelData);
        rvData.setAdapter(adapterData);
    }

    private ArrayList<ModelData> preaperData() {
        ArrayList<ModelData> modelDataa = new ArrayList<>();
        for (int i = 0; i < nameData.length; i++) {
            ModelData modelData = new ModelData();
            modelData.setNameData(nameData[i]);
            modelData.setHargaData(hargaData[i]);
            modelData.setUrlData(urlData[i]);
            modelDataa.add(modelData);
        }
        return modelDataa;
    }
}