package com.fiuady.hadp.homecontrol;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] tagTitles;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence activityTitle;
    private CharSequence itemTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemTitle = activityTitle = getTitle();
        tagTitles = getResources().getStringArray(R.array.Tags);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        ArrayList<DrawerItem> items = new ArrayList<>();
        items.add(new DrawerItem(tagTitles[0],R.drawable.ic_action_name));
        items.add(new DrawerItem(tagTitles[1],R.drawable.ic_action_name));
        items.add(new DrawerItem(tagTitles[2],R.drawable.ic_action_name));
        items.add(new DrawerItem(tagTitles[3],R.drawable.ic_action_name));
        items.add(new DrawerItem(tagTitles[4],R.drawable.ic_action_name));
        items.add(new DrawerItem(tagTitles[5],R.drawable.ic_action_name));

        drawerList.setAdapter(new DrawerListAdapter(this,items));
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case(0):
                        FrenteFragment fragment = new FrenteFragment();
                        Bundle args = new Bundle();
                        args.putInt("acd", i);
                        fragment.setArguments(args);

                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

                        drawerList.setItemChecked(i, true);
                        drawerLayout.closeDrawer(drawerList);
                        break;

                    case(2):
                        CocheraFragment fragment2 = new CocheraFragment();
                        Bundle args2 = new Bundle();
                        args2.putInt("acd", i);
                        fragment2.setArguments(args2);

                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        fragmentManager2.beginTransaction().replace(R.id.content_frame, fragment2).commit();

                        drawerList.setItemChecked(i, true);
                        drawerLayout.closeDrawer(drawerList);
                        break;

                    case(4):
                        Hab1Fragment fragment4 = new Hab1Fragment();
                        Bundle args4 = new Bundle();
                        args4.putInt("acd", i);
                        fragment4.setArguments(args4);

                        FragmentManager fragmentManager4 = getSupportFragmentManager();
                        fragmentManager4.beginTransaction().replace(R.id.content_frame, fragment4).commit();

                        drawerList.setItemChecked(i, true);
                        drawerLayout.closeDrawer(drawerList);
                        break;
                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // Crear ActionBarDrawerToggle para la apertura y cierre
        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(itemTitle);

                /*Usa este método si vas a modificar la action bar
                con cada fragmento
                 */
                //invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(activityTitle);

                /*Usa este método si vas a modificar la action bar
                con cada fragmento
                 */
                //invalidateOptionsMenu();
            }
        };
        //Seteamos la escucha
        drawerLayout.setDrawerListener(drawerToggle);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            // Toma los eventos de selección del toggle aquí
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        drawerToggle.onConfigurationChanged(newConfig);
    }
}
