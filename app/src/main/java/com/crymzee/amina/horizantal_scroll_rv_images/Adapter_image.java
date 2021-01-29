package com.crymzee.amina.horizantal_scroll_rv_images;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class Adapter_image extends RecyclerView.Adapter {
    private List<ImageModel_IncidentDetail> imageModels;
    private Context context;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);

        return new Holder_image_incidentDetail(this.context, view);
    }


    public Adapter_image(List<ImageModel_IncidentDetail> yourIncidents_list, Context context) {

        this.imageModels = yourIncidents_list;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final ImageModel_IncidentDetail imageModel_incidentDetail = this.imageModels.get(position);
        Holder_image_incidentDetail bh = ((Holder_image_incidentDetail) holder);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("list_image_click_broadcast");
                intent.putExtra("index", position);
                context.sendBroadcast(intent);
            }
        });

        bh.bindHolderRV(imageModel_incidentDetail);
    }
    @Override
    public int getItemCount() {
        return imageModels.size();
    }
}