package com.charlscode.mascotasrecyclerview;

import android.content.Intent;
import android.support.constraint.Placeholder;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import static android.support.v7.widget.AppCompatDrawableManager.get;

public class MainActivity extends AppCompatActivity {

    private ImageView imgEstrella;
   /*  ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas; */
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = (Toolbar) findViewById( R.id.miActionBar );
        CoordinatorLayout linearLayout = findViewById(R.id.coordinator);
        tabLayout = (TabLayout) findViewById( R.id.tabLayout );
        viewPager = (ViewPager) findViewById( R.id.viewPager );
       // ViewPager miViewPager = (ViewPager) findViewById( R.id.viewPager );
       // setSupportViewPager(miViewPager);
        setSupportActionBar( toolbar );

      /*  listaMascotas = (RecyclerView) findViewById( R.id.rvMascotas );

        LinearLayoutManager llm = new LinearLayoutManager( this );
        llm.setOrientation( LinearLayoutManager.VERTICAL );

        listaMascotas.setLayoutManager( llm );*/
      /*  inicializarListaMascotas();
        inicializarAdaptador(); */
        setUpViewPager();

    }

    //Va a inflar el menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_opciones,menu );
        //va a retornar algo ya existente
        //getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu( menu );

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mContacto:
                Intent mA = new Intent(this, ActivityContacto.class );
                startActivity(mA);
                break;

            case R.id.mAbout:
                Intent mS = new Intent( this, ActivityAbout.class );
                startActivity(mS);
                break;
        }
        return super.onOptionsItemSelected( item );
    }

    //Manda los fragments
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>( );

        fragments.add(new MascotaFragment() );
        fragments.add(new PerfilFragment() );
        return fragments;
    }



    private void setUpViewPager(){
        viewPager.setAdapter( new PagerAdapter( getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.perromascota);
        tabLayout.getTabAt(1).setIcon(R.drawable.perrocara);
    }



/*    public void inicializarAdaptador(){
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

    }*/

    public void irSegAct(View v) {
        Intent ir = new Intent( this, FavouriteMascota.class );
        startActivity( ir );
    }

}
