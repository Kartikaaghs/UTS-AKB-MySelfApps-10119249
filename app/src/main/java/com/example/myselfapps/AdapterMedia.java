package com.example.myselfapps;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myselfapps.R;
import java.util.ArrayList;

public class AdapterMedia extends RecyclerView.Adapter<AdapterMedia.myviewholder> {

    ArrayList<MediaModel> musicModel;

    public AdapterMedia(ArrayList<MediaModel> musicModel) {
        this.musicModel = musicModel;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_music, parent, false);
        return new AdapterMedia.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.logoMusic.setImageResource(musicModel.get(position).getImage());
        holder.titleFavorite.setText(musicModel.get(position).getTitle());
        holder.singerFavorite.setText(musicModel.get(position).getPenyanyi());
    }

    @Override
    public int getItemCount() {
        return musicModel.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        ImageView logoMusic;
        TextView titleFavorite, singerFavorite;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            logoMusic = itemView.findViewById(R.id.img_list_music);
            titleFavorite = itemView.findViewById(R.id.judul_music);
            singerFavorite = itemView.findViewById(R.id.penyanyi_music);
        }
    }
}