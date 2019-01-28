package com.charlscode.mascotasrecyclerview;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Scanner;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas= mascotas;
        this.activity= activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v=LayoutInflater.from( parent.getContext()).inflate( R.layout.cardview_mascotas, parent, false );
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, final int position) {
        final Mascota mascota = mascotas.get( position );
        mascotaViewHolder.imgMascota.setImageResource( mascota.getFoto() );
        mascotaViewHolder.tvNombre.setText( mascota.getNombre() );
        mascotaViewHolder.tvLike.setText( mascota.getLikes() );


        mascotaViewHolder.btnLike.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //MSG de Like
                //Toast.makeText(activity, "Diste Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();

                int contador = Integer.parseInt(mascota.getLikes());
                Button sumar;

                //SETEA LOS LIKES
                if (mascotas.get(position).getLiked().equals("true")) {
                    contador--;
                    //SE HA DADO DISLIKE
                    mascotaViewHolder.btnLike.setImageResource(R.drawable.bone);
                    Toast.makeText(activity, "Removiste el Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    mascotas.get( position ).setLiked( "false" );
                    mascotaViewHolder.tvLike.setText(String.valueOf(contador));
                    mascota.setLikes( String.valueOf( contador )); //Reemplaza valores
                } else {
                   // mascotaViewHolder.btnLike.setImageResource(R.drawable.bone);
                    contador++;
                    //SE HA DADO LIKE mascotaViewHolder.tvLike.setText("Esta publicación ahora tiene " + contador +"likes");
                    mascotaViewHolder.btnLike.setImageResource(R.drawable.bone_dorado);
                    Toast.makeText(activity, "Diste el Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    mascotas.get( position ).setLiked( "true" );
                    mascotaViewHolder.tvLike.setText(String.valueOf(contador));
                    mascota.setLikes( String.valueOf( contador )); //Reemplaza valores
                }

            }
        } );
        //Pendiente ver si se agrega viewholder de set on click <----------------------------
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imgMascota;
        private TextView tvNombre;
        private ImageButton btnLike;
        protected TextView tvLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super( itemView );
            imgMascota = (ImageView) itemView.findViewById( R.id.imgMasc );
            tvNombre = (TextView) itemView.findViewById( R.id.tvNombreMasc );
            btnLike = (ImageButton) itemView.findViewById( R.id.btnLike );
            tvLike = (TextView) itemView.findViewById( R.id.tv_Likes );
        }

    }
}
