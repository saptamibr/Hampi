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

public class DetailsAdapter extends ArrayAdapter<Details> {


    public DetailsAdapter(@NonNull Context context, int resource, ArrayList<Details> place) {
        super(context, resource, place);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_style, parent, false);
        }

        Details cd = getItem(position);

        TextView textView = (TextView) listItemView.findViewById(R.id.name);
        textView.setText(cd.getName());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        imageView.setImageResource(cd.getImgId());

        return listItemView;

      // return super.getView(position, convertView, parent);
    }

}

