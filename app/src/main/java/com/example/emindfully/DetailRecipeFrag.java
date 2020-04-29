package com.example.emindfully;


import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailRecipeFrag extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    TextView textDescription;
    ImageView imageDetail;

    public DetailRecipeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_detail_recipe, container,false);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_b);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
             Snackbar.make(view,"Saved to your phone", Snackbar.LENGTH_LONG)
                     .setAction("Action", null).show();
            }
        });

        textDescription = view.findViewById(R.id.descriptions);
        imageDetail = view.findViewById(R.id.imageDetail);

        Bundle objectRecipes=getArguments();
        Recipes recipes = null;

        if (objectRecipes !=null) {
            recipes = (Recipes) objectRecipes.getSerializable("object");
            imageDetail.setImageResource(recipes.getImageDetail());
            textDescription.setText(recipes.getDescription());
        }


        return view;
    }

    public interface OnFragmentInteractionListener{
        void onFragmentInteraction(Uri uri);

    }

}
