package com.example.hampi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class MainhomeAdapter extends ArrayAdapter<Details> {


    public MainhomeAdapter(@NonNull Context context, int resource, ArrayList<Details> place) {
        super(context, resource, place);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridItemView = convertView;
        if(gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_grid, parent, false);
        }

        Details cd = getItem(position);

        TextView textView = (TextView) gridItemView.findViewById(R.id.grid_txt);
        textView.setText(cd.getName());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageView = (ImageView) gridItemView.findViewById(R.id.grid_img);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        imageView.setImageResource(cd.getImgId());

        return gridItemView;

        // return super.getView(position, convertView, parent);
    }

}
