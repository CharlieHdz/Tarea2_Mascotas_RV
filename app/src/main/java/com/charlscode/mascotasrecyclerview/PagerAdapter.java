package com.charlscode.mascotasrecyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class PagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public PagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super( fm );
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int posicion) {
        switch (posicion){
            case 0:
                return new MascotaFragment();
            case 1:
                return new PerfilFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}

//Hola de Nuevo:
//PENDIENTES:
//ARREGLAR PAGE ADAPTER PARA QUE SE MUEVAN LAS COSAS EN DIFERENTES TABS
//HACER LA ULTIMA TAB
