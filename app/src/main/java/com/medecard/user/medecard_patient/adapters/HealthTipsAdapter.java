package com.medecard.user.medecard_patient.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.medecard.user.medecard_patient.R;

public class HealthTipsAdapter extends ArrayAdapter {

    private final Activity context; // reference the activity
    private final Integer[] image_array; // reference the image
    private final String[] desc_array; // reference the text-description

    public HealthTipsAdapter(Activity context, Integer[] image_array, String[] desc_array) {
        super(context, R.layout.listview_health, desc_array);

        this.context = context;
        this.image_array = image_array;
        this.desc_array = desc_array;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_health, null, true);

        // getting reference to the objects in the listview
        ImageView imageView = (ImageView) rowView.findViewById(R.id.desc_image);
        TextView nameTextField = (TextView) rowView.findViewById(R.id.desc_text);

        // setting the values of the objects to the values of the array
        imageView.setImageResource(image_array[position]);
        nameTextField.setText(desc_array[position]);

        return rowView;
    }

}
