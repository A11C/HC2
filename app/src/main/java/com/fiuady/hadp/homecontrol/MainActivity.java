package com.fiuady.hadp.homecontrol;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 1;
    private static final UUID SERIAL_PORT_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
    public static final String EXTRA_ID = "com.fiuady.hadp.homecontrol.extraid";

    private BluetoothSocket connectedSocket;
    private BluetoothDevice device;


    private EditText txtState;
    private EditText txtMessages;
    private EditText txtToSend;

    // ************************************************
    // BtBackgroundTask
    // ************************************************

    private class BtBackgroundTask extends AsyncTask<BufferedReader, String, Void> {
        @Override
        protected Void doInBackground(BufferedReader... params) {
            try {
                while (!isCancelled()) {
                    publishProgress(params[0].readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            appendMessageText(values[0]);
        }
    }


    private String[] tagTitles;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence activityTitle;
    private CharSequence itemTitle;

    private int cuenta_id,perf_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemTitle = activityTitle = getTitle();
        tagTitles = getResources().getStringArray(R.array.Tags);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        ArrayList<DrawerItem> items = new ArrayList<>();
        items.add(new DrawerItem(tagTitles[0], R.drawable.ic_frente));
        items.add(new DrawerItem(tagTitles[1], R.drawable.ic_patio));
        items.add(new DrawerItem(tagTitles[2], R.drawable.ic_cochera));
        items.add(new DrawerItem(tagTitles[3], R.drawable.ic_sala));
        items.add(new DrawerItem(tagTitles[4], R.drawable.ic_hab));
        items.add(new DrawerItem(tagTitles[5], R.drawable.ic_hab2));
        items.add(new DrawerItem(tagTitles[6], R.drawable.ic_alarm));
        items.add(new DrawerItem(tagTitles[7], R.drawable.ic_action_name));
        items.add(new DrawerItem(tagTitles[8], R.drawable.ic_action_name));

        drawerList.setAdapter(new DrawerListAdapter(this, items));

        Intent i = getIntent();
        cuenta_id = i.getIntExtra(EXTRA_ID, 0);


        PerfilFragment perfilFragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putInt("userid",cuenta_id);
        perfilFragment.setArguments(args);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, perfilFragment).commit();
        drawerList.setItemChecked(7, true);
        itemTitle = tagTitles[7];
        getSupportActionBar().setTitle(itemTitle);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case (0):
                        FrenteFragment fragment = new FrenteFragment();
                        Bundle args = new Bundle();
                        args.putInt("perf", perf_id);
                        fragment.setArguments(args);

                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

                        drawerList.setItemChecked(i, true);
                        itemTitle = tagTitles[i];
                        getSupportActionBar().setTitle(itemTitle);
                        drawerLayout.closeDrawer(drawerList);
                        break;
                    case (1):
                        PatioFragment fragment1 = new PatioFragment();
                        Bundle args1 = new Bundle();
                        args1.putInt("perf", perf_id);
                        fragment1.setArguments(args1);

                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        fragmentManager1.beginTransaction().replace(R.id.content_frame, fragment1).commit();

                        drawerList.setItemChecked(i, true);
                        itemTitle = tagTitles[i];
                        getSupportActionBar().setTitle(itemTitle);
                        drawerLayout.closeDrawer(drawerList);
                        break;

                    case (2):
                        CocheraFragment fragment2 = new CocheraFragment();
                        Bundle args2 = new Bundle();
                        args2.putInt("perf", perf_id);
                        fragment2.setArguments(args2);

                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        fragmentManager2.beginTransaction().replace(R.id.content_frame, fragment2).commit();

                        drawerList.setItemChecked(i, true);
                        itemTitle = tagTitles[i];
                        getSupportActionBar().setTitle(itemTitle);
                        drawerLayout.closeDrawer(drawerList);
                        break;

                    case (3):
                        SalaFragment fragment3 = new SalaFragment();
                        Bundle args3 = new Bundle();
                        args3.putInt("perf", perf_id);
                        fragment3.setArguments(args3);

                        FragmentManager fragmentManager3 = getSupportFragmentManager();
                        fragmentManager3.beginTransaction().replace(R.id.content_frame, fragment3).commit();

                        drawerList.setItemChecked(i, true);
                        itemTitle = tagTitles[i];
                        getSupportActionBar().setTitle(itemTitle);
                        drawerLayout.closeDrawer(drawerList);
                        break;

                    case (4):
                        Hab1Fragment fragment4 = new Hab1Fragment();
                        Bundle args4 = new Bundle();
                        args4.putInt("perf", perf_id);
                        fragment4.setArguments(args4);

                        FragmentManager fragmentManager4 = getSupportFragmentManager();
                        fragmentManager4.beginTransaction().replace(R.id.content_frame, fragment4).commit();

                        drawerList.setItemChecked(i, true);
                        itemTitle = tagTitles[i];
                        getSupportActionBar().setTitle(itemTitle);
                        drawerLayout.closeDrawer(drawerList);
                        break;

                    case (5):
                        Hab2Fragment fragment5 = new Hab2Fragment();
                        Bundle args5 = new Bundle();
                        args5.putInt("perf", perf_id);
                        fragment5.setArguments(args5);

                        FragmentManager fragmentManager5 = getSupportFragmentManager();
                        fragmentManager5.beginTransaction().replace(R.id.content_frame, fragment5).commit();

                        drawerList.setItemChecked(i, true);
                        itemTitle = tagTitles[i];
                        getSupportActionBar().setTitle(itemTitle);
                        drawerLayout.closeDrawer(drawerList);
                        break;

                    case (6):
                        AlarmsFragment fragment6 = new AlarmsFragment();
                        Bundle args6 = new Bundle();
                        args6.putInt("perf", perf_id);
                        fragment6.setArguments(args6);

                        FragmentManager fragmentManager6 = getSupportFragmentManager();
                        fragmentManager6.beginTransaction().replace(R.id.content_frame, fragment6).commit();

                        drawerList.setItemChecked(i, true);
                        itemTitle = tagTitles[i];
                        getSupportActionBar().setTitle(itemTitle);
                        drawerLayout.closeDrawer(drawerList);
                        break;

                    case (7):
                        PerfilFragment fragment7 = new PerfilFragment();
                        Bundle args7 = new Bundle();
                        args7.putInt("perf", perf_id);
                        fragment7.setArguments(args7);

                        FragmentManager fragmentManager7 = getSupportFragmentManager();
                        fragmentManager7.beginTransaction().replace(R.id.content_frame, fragment7).commit();

                        drawerList.setItemChecked(i, true);
                        itemTitle = tagTitles[i];
                        getSupportActionBar().setTitle(itemTitle);
                        drawerLayout.closeDrawer(drawerList);
                        break;

                    case (8):
                        finish();
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

    private BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException {

        return device.createRfcommSocketToServiceRecord(SERIAL_PORT_UUID);
        //creates secure outgoing connecetion with BT device using UUID
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        if (drawerToggle.onOptionsItemSelected(item)) {
            // Toma los eventos de selección del toggle aquí
            return true;
        }
        if (item.getItemId() == R.id.menu_item_connect) {
            if (!btAdapter.isEnabled()) {
                // Issue a request to enable Bluetooth through the system settings (without stopping application)
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent, REQUEST_ENABLE_BT);
            } else if (btAdapter.isEnabled()) {
                device = btAdapter.getRemoteDevice("98:D3:31:30:6D:3F");
                //98:D3:31:30:6D:3F
                //74:DF:BF:36:2B:78
                BluetoothSocket tmpSocket = null;

                // Connect with BluetoothDevice
                if (connectedSocket == null) {
                    try {
                        tmpSocket = device.createRfcommSocketToServiceRecord(MainActivity.SERIAL_PORT_UUID);

                        // Connect to the remote device through the socket. This call blocks until it succeeds or throws an exception


                        tmpSocket.connect();

                        if (tmpSocket.isConnected()) {
                            Toast.makeText(getApplicationContext(), "Conexión exitosa", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "No se puedo conectar", Toast.LENGTH_SHORT).show();
                        }

                        // Acknowledge connected socket
                        connectedSocket = tmpSocket;
                        //MAC:  98:D3:31:30:6D:3F

                        // Create socket reader thread
                        BufferedReader br = new BufferedReader(new InputStreamReader(connectedSocket.getInputStream()));
                        new BtBackgroundTask().execute(br);


                    } catch (IOException e) {
                        try {
                            if (tmpSocket != null) {
                                tmpSocket.close();
                            }
                        } catch (IOException closeExceptione) {
                        }

                        e.printStackTrace();
                    }
                }
            }
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        switch (resultCode) {
            case RESULT_OK:
                if (requestCode == REQUEST_ENABLE_BT) {
                    // Get device's own Bluetooth adapter

                    BluetoothSocket tmpSocket = null;
                    device = btAdapter.getRemoteDevice("98:D3:31:30:6D:3F");

                    // Connect with BluetoothDevice
                    if (connectedSocket == null) {
                        try {
                            tmpSocket = device.createRfcommSocketToServiceRecord(MainActivity.SERIAL_PORT_UUID);

                            // Connect to the remote device through the socket. This call blocks until it succeeds or throws an exception

                            tmpSocket.connect();

                            if (tmpSocket.isConnected()) {
                                Toast.makeText(getApplicationContext(), "Conexión exitosa", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "No se puedo conectar", Toast.LENGTH_SHORT).show();
                            }

                            // Acknowledge connected socket
                            connectedSocket = tmpSocket;
                            //MAC:  98:D3:31:30:6D:3F

                            // Create socket reader thread
                            BufferedReader br = new BufferedReader(new InputStreamReader(connectedSocket.getInputStream()));
                            new BtBackgroundTask().execute(br);

                        } catch (IOException e) {
                            try {
                                if (tmpSocket != null) {
                                    tmpSocket.close();
                                }
                            } catch (IOException closeExceptione) {
                            }

                            e.printStackTrace();
                        }
                    }
                }
                break;

            case RESULT_CANCELED:
            default:
                break;
        }
    }

    public BluetoothSocket Socket() {
        return connectedSocket;
    }

    public int getuserid(){
        return cuenta_id;
    }

    public void setPerf_id(int id){
        perf_id = id;
    }

    private void appendMessageText(String text) {

        Fragment f = getSupportFragmentManager().findFragmentById(R.id.content_frame);

        if (f instanceof Hab1Fragment) {
            Hab1Fragment hab1fragment = (Hab1Fragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
            if (text.startsWith("RS")) {
                hab1fragment.state_change(text);
            } else if (!text.startsWith("PIR")) {
                hab1fragment.temp_change(text);
            }
        } else if (f instanceof Hab2Fragment) {
            Hab2Fragment hab2fragment = (Hab2Fragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
            if (text.startsWith("RS")) {
                hab2fragment.state_change(text);
            } else if (!text.startsWith("PIR")) {
                hab2fragment.temp_change(text);
            }
        } else if (f instanceof FrenteFragment) {
            FrenteFragment frenteFragment = (FrenteFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
        } else if (f instanceof PatioFragment) {
            PatioFragment patioFragment = (PatioFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
            if (text.startsWith("RS")) {
                patioFragment.state_change(text);
            } else {
                patioFragment.temp_change(text);
            }
        } else if (f instanceof SalaFragment) {
            SalaFragment salaFragment = (SalaFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
            if (text.startsWith("RS")) {
                salaFragment.state_change(text);
            } else if (text.startsWith("PIR")) {
                salaFragment.pir_change(text);
            } else {
                salaFragment.temp_change(text);
            }
        } else if (f instanceof CocheraFragment) {
            CocheraFragment cocheraFragment = (CocheraFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
            cocheraFragment.state_change(text);
        } else if (f instanceof AlarmsFragment) {
            AlarmsFragment alarmsFragment = (AlarmsFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
        }

        //Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
