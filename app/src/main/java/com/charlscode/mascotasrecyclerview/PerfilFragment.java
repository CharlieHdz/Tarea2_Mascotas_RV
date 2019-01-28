package com.charlscode.mascotasrecyclerview;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    private RecyclerView listaMascotas;
    private RecyclerView recyclerView;
    ArrayList<Mascota> listFotos;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate( R.layout.fragment_perfil, container, false );

        View rootView = inflater.inflate(R.layout.fragment_perfil, container, false);
        // 1. Setear referencia del recyclerView
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rvPerfil);

        // 2. setea layoutManger
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        // Datos para el Recicler View
        listFotos = new ArrayList<Mascota>();
        listFotos.add(new Mascota(R.drawable.cat,"Catty","20","false"));
        listFotos.add(new Mascota(R.drawable.cat,"Catty","20","false"));
        listFotos.add(new Mascota(R.drawable.cat,"Catty","20","false"));
        listFotos.add(new Mascota(R.drawable.cat,"Catty","20","false"));
        listFotos.add(new Mascota(R.drawable.cat,"Catty","20","false"));
        listFotos.add(new Mascota(R.drawable.cat,"Catty","20","false"));
        listFotos.add(new Mascota(R.drawable.cat,"Catty","20","false"));
        listFotos.add(new Mascota(R.drawable.cat,"Catty","20","false"));
        listFotos.add(new Mascota(R.drawable.cat,"Catty","20","false"));
        listFotos.add(new Mascota(R.drawable.cat,"Catty","20","false"));

        // 3. Crear adaptador
        PerfilAdapter adaptador = new PerfilAdapter( listFotos, getActivity() );
        // 4. seteamos adaptador
        recyclerView.setAdapter(adaptador);
        // 5. setear el item animator a DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;

    }

}
