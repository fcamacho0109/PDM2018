package com.example.fcamacho.sesion10_tabs_recycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fcamacho.sesion10_tabs_recycler.Adapters.AdapterProduct;
import com.example.fcamacho.sesion10_tabs_recycler.beans.ItemProduct;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by fcamacho on 3/6/18.
 */

public class FragmentTechnology extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public FragmentTechnology() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
         ArrayList<ItemProduct> products;
         AdapterProduct adapterProduct;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_activity_main, container, false);

            RecyclerView recyclerView = rootView.findViewById(R.id.fragment_recycler_view_main);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

            recyclerView.setLayoutManager(mLayoutManager);
            products = new ArrayList<>();
            products.add(new ItemProduct("Mac","BestBuy","Zapopan","3331112226",R.drawable.mac,11));
            products.add(new ItemProduct("Alienware","DELL","Tlaquepaque","7778889994",R.drawable.alienware,22));
            products.add(new ItemProduct("Lanix","Saint Jhonny","Palomar","1478523690",R.drawable.lanix,33));
            adapterProduct = new AdapterProduct(products, this.getContext());
            recyclerView.setAdapter(adapterProduct);
            return rootView;
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            ItemProduct itemProduct = data.getParcelableExtra("ITEM");
            Iterator <ItemProduct> iterator = products.iterator();
            int i = 0;
            while (iterator.hasNext()){
                ItemProduct item = iterator.next();
                if (item.getCode() == itemProduct.getCode()){
                    products.set(i,itemProduct);
                    break;
                }

                i++;
            }
            adapterProduct.notifyDataSetChanged();
        }

}
