package com.example.emindfully;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.emindfully.Interfaces.ICommunicateFragments;

public class MainActivity extends AppCompatActivity implements ListRecipeFrag.OnFragmentInteractionListener, DetailRecipeFrag.OnFragmentInteractionListener, ICommunicateFragments {

    ListRecipeFrag listRecipeFrag;
    DetailRecipeFrag detailRecipeFrag;
    ImageView shareImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listRecipeFrag = new ListRecipeFrag();

        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.containerFragment, listRecipeFrag).commit();
    }

    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void sendPeople(Recipes recipes) {
        detailRecipeFrag = new DetailRecipeFrag();
        Bundle bundleSend = new Bundle();
        bundleSend.putSerializable("object", recipes);
        detailRecipeFrag.setArguments(bundleSend);

        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.containerFragment, detailRecipeFrag).addToBackStack(null).commit();
    }


}





