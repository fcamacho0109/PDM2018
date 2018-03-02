package com.example.fcamacho.sesion10_tabs_recycler;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fcamacho.sesion10_tabs_recycler.beans.ItemProduct;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ActivityMain extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = findViewById(R.id.tabs); //nuevo toolbar
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager); // agregado

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_activity_main, container, false);

            RecyclerView recyclerView = rootView.findViewById(R.id.fragment_recycler_view_main);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

            Drawable mac = getResources().getDrawable(R.drawable.mac,null);
            Drawable alien = getResources().getDrawable(R.drawable.alienware,null);
            Drawable lanix = getResources().getDrawable(R.drawable.lanix,null);

            recyclerView.setLayoutManager(mLayoutManager);
            ArrayList<ItemProduct> products = new ArrayList<>();
            products.add(new ItemProduct("Mac","BestBuy","Zapopan","3331112226",mac));
            products.add(new ItemProduct("Alienware","DELL","Tlaquepaque","7778889994",alien));
            products.add(new ItemProduct("Lanix","Saint Jhonny","Palomar","1478523690",lanix));
            AdapterProduct adapterProduct = new AdapterProduct(products);
            recyclerView.setAdapter(adapterProduct);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter { // numero de elementos del scroll tab

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) { // aqui carga el fragmento de xml
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() { // numero de tabs
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return "Tecnologia";
                case 1: return "Home";
                case 2: return "Electronics";
            }
            return null;
        }
    }
    // permisos
    public void requestPermissions(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CALL_PHONE},1999);
        }else{
            //ejecutar metodo
            call();
        }
    }
    public void call(){ // debe tener un try catch de security exception
        TextView phone = findViewById(R.id.item_product_phone);
        Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone.getText().toString()));
        try{
            startActivity(call);
        }catch (SecurityException e){

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case 1999:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    call();
                }
                break;
        }
    }
    public void dial(View view) {

        switch (view.getId()) {
            case R.id.item_product_phone:
                requestPermissions();
            break;
        }
    }
    public void infoToast(View view){
        switch (view.getId()) {
            case R.id.card_view:
                TextView title = findViewById(R.id.item_product_title);
                TextView store = findViewById(R.id.item_product_store);
                TextView location = findViewById(R.id.item_product_location);
                TextView phone = findViewById(R.id.item_product_phone);
                String info = "ItemProduct{\n" +
                                            "title: "+title.getText().toString()+"\n" +
                                            "store: "+store.getText().toString()+"\n" +
                                            "location: "+location.getText().toString()+"\n" +
                                            "phone: "+phone.getText().toString()+"\n" +
                                            "image: "+title.getText().toString()+"\n"+
                                            "}";
                Toast.makeText(this,info.toString(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
