package com.charlscode.mascotasrecyclerview;


import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaFragment extends Fragment {
    private RecyclerView listaMascotas;
    private ViewPager viewPager;
    ArrayList<Mascota> mascotas;

    public MascotaFragment() {

        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     //   ((MainActivity)getActivity()).inicializarListaMascotas();
     //   ((MainActivity)getActivity()).inicializarAdaptador();

            View rootView = inflater.inflate(R.layout.fragment_mascota, container, false);
            // 1. Setear referencia del recyclerView
            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rvMascotas);

            // 2. setea layoutManger
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            // Datos para el Recicler View
            mascotas = new ArrayList<Mascota>( );

            mascotas.add( new Mascota( R.drawable.cat, "Catty", "5" ,"false"));
            mascotas.add( new Mascota(R.drawable.dog, "Doggo", "5" ,"false"));
            mascotas.add( new Mascota( R.drawable.fish, "Fishy", "3" ,"false"));
            mascotas.add( new Mascota( R.drawable.rabbit, "Rabbie", "4","false" ));
            mascotas.add( new Mascota( R.drawable.dog2, "Dorothy", "2","false" ));


            // 3. Crear adaptador
            MascotaAdaptador adaptador = new MascotaAdaptador( mascotas, getActivity() );
            // 4. seteamos adaptador
            recyclerView.setAdapter(adaptador);
            // 5. setear el item animator a DefaultAnimator
            recyclerView.setItemAnimator(new DefaultItemAnimator());

            return rootView;

    }

    //Para tomar foto
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.fabC);

        FloatingActionButton fab = view.findViewById(R.id.fabC);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
            }
        });
    }
}
