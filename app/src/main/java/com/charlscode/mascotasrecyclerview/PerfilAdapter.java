package com.charlscode.mascotasrecyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PerfilAdapter extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public PerfilAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas= mascotas;
        this.activity= activity;
    }

    @NonNull
    @Override
    public MascotaAdaptador.MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v=LayoutInflater.from( parent.getContext()).inflate( R.layout.cardview_perfil, parent, false );
        return new MascotaAdaptador.MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaAdaptador.MascotaViewHolder mascotaViewHolder, final int position) {
        final Mascota mascota = mascotas.get( position );
        mascotaViewHolder.imgMascota.setImageResource( mascota.getFoto() );
    //    mascotaViewHolder.tvNombre.setText( mascota.getNombre() );
        mascotaViewHolder.tvLike.setText( mascota.getLikes() );
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMascota;
       // private TextView tvNombre;
        private ImageButton btnLike;
        private TextView tvLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super( itemView );
            imgMascota = (ImageView) itemView.findViewById( R.id.imgMasc );
          //  tvNombre = (TextView) itemView.findViewById( R.id.tvNombreMasc );
            btnLike = (ImageButton) itemView.findViewById( R.id.btnLike );
            tvLike = (TextView) itemView.findViewById( R.id.tv_Likes );
        }

    }
}











  //CODIGO BASURA
//--------------------------------------------------------------------------


        //
//AppCompatActivity {
   /* private ImageView imgEstrella;
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_mascota );
        //getSupportActionBar().setDisplayHomeAsUpEnabled( true ); //<----- aquí el problema

        listaMascotas = (RecyclerView) findViewById( R.id.rvMascotas );

        LinearLayoutManager llm = new LinearLayoutManager( this );
        llm.setOrientation( LinearLayoutManager.VERTICAL );

        listaMascotas.setLayoutManager( llm );
        inicializarListaMascotas();
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador( mascotas, this );
        listaMascotas.setAdapter( adaptador );
    }

    public void inicializarListaMascotas()
    {
        mascotas = new ArrayList<Mascota>( );

        mascotas.add( new Mascota( R.drawable.cat, "Catty", "5" ,"false"));
        mascotas.add( new Mascota(R.drawable.dog, "Doggo", "5" ,"false"));
        mascotas.add( new Mascota( R.drawable.fish, "Fishy", "3" ,"false"));
        mascotas.add( new Mascota( R.drawable.rabbit, "Rabbie", "4","false" ));
        mascotas.add( new Mascota( R.drawable.dog2, "Dorothy", "2","false" ));

    }


    public void irBack(View a) {
        finish();
    }
*/
