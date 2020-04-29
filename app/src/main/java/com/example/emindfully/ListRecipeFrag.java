package com.example.emindfully;


import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.emindfully.Interfaces.ICommunicateFragments;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListRecipeFrag extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<Recipes>recipe;
    RecyclerView recyclerRecipes;

    Activity activity;
    ICommunicateFragments interfaceCommunicateFragments;


    public ListRecipeFrag() {
        // Required empty public constructor
    }

    public static ListRecipeFrag newInstance(String param1, String param2){
        ListRecipeFrag fragment = new ListRecipeFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        if (getArguments() !=null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_recipe, container, false);

        recipe = new ArrayList<>();
        recyclerRecipes = view.findViewById(R.id.recyclerId);
        recyclerRecipes.setLayoutManager(new LinearLayoutManager(getContext()));

        fillListRecipe();

        RecipeAdapter adapter=new RecipeAdapter(recipe);
        recyclerRecipes.setAdapter(adapter);

       adapter.setOnClickListener(new View.OnClickListener(){

           @Override
           public void onClick(View view) {
             Toast.makeText(getContext(), "Selection: "+
             recipe.get(recyclerRecipes.getChildAdapterPosition(view)).getName(),Toast.LENGTH_SHORT).show();

             interfaceCommunicateFragments.sendPeople(recipe.get(recyclerRecipes.getChildAdapterPosition(view)));

           }
       });

        return view;

    }

    private void fillListRecipe() {
        recipe.add(new Recipes(getString(R.string.logo_name),
                getString(R.string.logo_des), getString(R.string.logo_description),
                R.drawable.e_mindfully, R.drawable.e_mindfully));

        recipe.add(new Recipes(getString(R.string.bowl_name),
                getString(R.string.bowl_des), getString(R.string.bowl_description),
                R.drawable.acaicara, R.drawable.acaibowl));

        recipe.add(new Recipes(getString(R.string.juice_name),
                getString(R.string.juice_des), getString(R.string.juice_description),
                R.drawable.junglejuicee, R.drawable.junglejuicee));

        recipe.add(new Recipes(getString(R.string.oat_name),
                getString(R.string.oat_des), getString(R.string.oat_description),
                R.drawable.chiacara, R.drawable.chiaadetal));

        recipe.add(new Recipes(getString(R.string.lentil_name),
                getString(R.string.lentil_des), getString(R.string.lentil_description),
                R.drawable.lenzzcara, R.drawable.lenzdetal));

        recipe.add(new Recipes(getString(R.string.soup_name),
                getString(R.string.soup_des), getString(R.string.soup_description),
                R.drawable.souppcara, R.drawable.soupdetal));

        recipe.add(new Recipes(getString(R.string.salad_name),
                getString(R.string.salad_des), getString(R.string.salad_description),
                R.drawable.tacossaladcara, R.drawable.tacosaladdetal));

        recipe.add(new Recipes(getString(R.string.balls_name),
                getString(R.string.balls_des), getString(R.string.balls_description),
                R.drawable.ballscara, R.drawable.ballsdetal));

        recipe.add(new Recipes(getString(R.string.taco_name),
                getString(R.string.taco_des), getString(R.string.taco_description),
                R.drawable.tacoscara, R.drawable.tacosdetal));




    }

    public void onButtonPressed(Uri uri){
        if (mListener !=null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof Activity) {
            this.activity= (Activity) context;
            interfaceCommunicateFragments=(ICommunicateFragments) this.activity;
        }

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString()+"must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
