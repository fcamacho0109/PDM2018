package com.example.fcamacho.sesion10_tabs_recycler;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fcamacho.sesion10_tabs_recycler.beans.ItemProduct;

import java.util.ArrayList;

/**
 * Created by fcamacho on 3/2/18.
 */

public class ActivityElectro extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_activity_electr, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.fragment_recycler_view_electro);
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
