package com.crymzee.amina.horizantal_scroll_rv_images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class Holder_image_incidentDetail extends RecyclerView.ViewHolder implements View.OnClickListener {

    Context context;
    ImageModel_IncidentDetail yourIncidents;
    ImageView iv_item;

    public Holder_image_incidentDetail(Context context, View itemView) {
        super(itemView);
        this.iv_item = (ImageView) itemView.findViewById(R.id.iv_item);
        this.context=context;
    }

    public void bindHolderRV(final ImageModel_IncidentDetail modelRecyclerView) {

        // 4. Bind the data to the ViewHolder

        this.iv_item.setImageResource(modelRecyclerView.image);
    }

    @Override
    public void onClick(View view) {
        if (this.yourIncidents != null) {

            //Toast.makeText(this.context, "Clicked on " + this.modelRecyclerView.bakeryName, Toast.LENGTH_SHORT ).show();
        }
    }
}
