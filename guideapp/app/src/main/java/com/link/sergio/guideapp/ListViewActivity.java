package com.link.sergio.guideapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Mami on 14/11/2017.
 */

public class ListViewActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    ListAdapter listAdapter;
    ListView listView;
    ArrayList<String> id;
    ArrayList<String>  titre;
    ArrayList<String>  distance;
    ArrayList<String>  description;
    int numberoflist;
    SwipeRefreshLayout mySwipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listView = (ListView) findViewById(R.id.ListView1);
        mySwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.SwipeRefreshLayout);

        id = new ArrayList<String>();
        id.add("1");
        id.add("2");
        id.add("3");
        id.add("4");
        id.add("5");
        id.add("6");
        id.add("7");

        titre = new ArrayList<String>();
        titre.add("Titre 1");
        titre.add("Titre 2");
        titre.add("Titre 3");
        titre.add("Titre 4");
        titre.add("Titre 5");
        titre.add("Titre 6");
        titre.add("Titre 7");

        distance = new ArrayList<String>();
        distance.add("2651Km");
        distance.add("2652Km");
        distance.add("2653Km");
        distance.add("2654Km");
        distance.add("2655Km");
        distance.add("2656Km");
        distance.add("2657Km");

        description = new ArrayList<String>();
        description.add("n'importe quoi 1");
        description.add("n'importe quoi 2");
        description.add("n'importe quoi 3");
        description.add("n'importe quoi 4");
        description.add("n'importe quoi 5");
        description.add("n'importe quoi 6");
        description.add("n'importe quoi 7");
        numberoflist = 8;

        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        mySwipeRefreshLayout.setRefreshing(true);
                        (new Handler()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mySwipeRefreshLayout.setRefreshing(false);
                                Toast.makeText(ListViewActivity.this, " In Refresh...", Toast.LENGTH_LONG).show();
                                id.add("8");
                                titre.add("Titre 8");
                                distance.add("2658Km");
                                description.add("n'importe quoi 8");
                                listAdapter = new ListAdapter(ListViewActivity.this,id,titre,distance,description);
                                listView.setAdapter(listAdapter);
                            }
                        },3000);

                    }
                }
        );
/*
        numberoflist = 8;
        myUpdateOperation(numberoflist);

        for(int i = 1; i > 8; i++){
            id.add(String.valueOf(i));
            titre.add("Titre "+String.valueOf(i));
            distance.add("265"+String.valueOf(i)+" Km");
            description.add("N'importe quoi "+String.valueOf(i));
        }
*/
        listAdapter = new ListAdapter(this,id,titre,distance,description);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "Click doucement "+titre.get(position).toString()+" a mal now", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera)
        {
            Intent intent = new Intent(ListViewActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_gallery)
        {

        }
        else if (id == R.id.nav_slideshow)
        {

        }
        else if (id == R.id.nav_manage)
        {

        }
        else if (id == R.id.nav_share)
        {

        }
        else if (id == R.id.nav_send)
        {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
