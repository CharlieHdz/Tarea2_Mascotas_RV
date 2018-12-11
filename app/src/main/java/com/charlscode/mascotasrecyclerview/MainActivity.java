package com.charlscode.mascotasrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v7.widget.AppCompatDrawableManager.get;

public class MainActivity extends AppCompatActivity {

    private ImageView imgEstrella;
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

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

    public void irSegAct(View v) {
        Intent ir = new Intent( this, FavouriteMascota.class );
        startActivity( ir );
    }

}
