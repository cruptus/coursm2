package com.link.sergio.guideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mami on 14/11/2017.
 */

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> ID;
    ArrayList<String> Images;
    ArrayList<String> Titre;
    ArrayList<String> Distance;
    ArrayList<String> Description;

    public ListAdapter(Context context,ArrayList<String> ID,ArrayList<String> images, ArrayList<String> titre, ArrayList<String> Distance, ArrayList<String> Description){
        this.context = context;
        this.ID = ID;
        this.Images = images;
        this.Titre = titre;
        this.Description = Description;
        this.Distance = Distance;
    }


    @Override
    public int getCount() {
        return ID.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;

        LayoutInflater layoutInflater;

        if (convertView == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listitem,null);

            holder = new Holder();

            holder.images = (ImageView) convertView.findViewById(R.id.photo);
            holder.titre = (TextView) convertView.findViewById(R.id.PhotoTitre);
            holder.distance = (TextView) convertView.findViewById(R.id.PhotoDistance);
            holder.description = (TextView) convertView.findViewById(R.id.PhotoDescription);

            convertView.setTag(holder);
        }else{
            holder = (Holder)convertView.getTag();

        }

        holder.titre.setText(Titre.get(position));
        Picasso.with(context).load(Images.get(position)).into(holder.images);
        holder.distance.setText(Distance.get(position));
        holder.description.setText(Description.get(position));

        return convertView;
    }

    public class Holder{
        ImageView images;
        TextView titre;
        TextView distance;
        TextView description;
    }
}
