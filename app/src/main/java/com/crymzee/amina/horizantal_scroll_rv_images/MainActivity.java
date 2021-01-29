package com.crymzee.amina.horizantal_scroll_rv_images;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_images_incident;
    Adapter_image adapter_image ;
    ArrayList<ImageModel_IncidentDetail> incidentDetailArrayList=new ArrayList();
    ImageView selected_image_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_images_incident=findViewById(R.id.rv_images_incident);
        selected_image_details = findViewById(R.id.selected_image_details);

        ImageModel_IncidentDetail imageModel_incidentDetail = new ImageModel_IncidentDetail(R.mipmap.image1,1);
        incidentDetailArrayList.add(imageModel_incidentDetail);
        ImageModel_IncidentDetail imageModel_incidentDetail_2 = new ImageModel_IncidentDetail(R.mipmap.image2,1);
        incidentDetailArrayList.add(imageModel_incidentDetail_2);
        ImageModel_IncidentDetail imageModel_incidentDetail_3 = new ImageModel_IncidentDetail(R.mipmap.image3,1);
        incidentDetailArrayList.add(imageModel_incidentDetail_3);
        ImageModel_IncidentDetail imageModel_incidentDetail_4 = new ImageModel_IncidentDetail(R.mipmap.image4,1);
        incidentDetailArrayList.add(imageModel_incidentDetail_4);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        adapter_image = new Adapter_image(incidentDetailArrayList, MainActivity.this);
        rv_images_incident.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rv_images_incident.setAdapter(adapter_image);
        registerReceiver(broadcast_receiver, new IntentFilter("list_image_click_broadcast"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcast_receiver);
    }

    BroadcastReceiver broadcast_receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context arg0, Intent intent) {
            String action = intent.getAction();
            if (action.equals("list_image_click_broadcast")) {
                int index = intent.getExtras().getInt("index");
                ImageModel_IncidentDetail model = incidentDetailArrayList.get(index);
                selected_image_details.setImageResource(model.getImage());
            }
        }
    };
}