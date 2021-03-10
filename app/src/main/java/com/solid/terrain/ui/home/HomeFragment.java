package com.solid.terrain.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.solid.terrain.R;
import com.solid.terrain.ui.ParcelActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private CardView cardTerrain;
    private CardView cardSurvey;
    private CardView cardBuilding;
    private CardView cardControlPoint;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        cardTerrain = root.findViewById(R.id.card_terrain);
        cardSurvey = root.findViewById(R.id.card_survey);
        cardBuilding = root.findViewById(R.id.card_building);
        cardControlPoint = root.findViewById(R.id.card_control_point);

        cardTerrain.setOnClickListener(handleOnClickEvent("parcel"));

        return root;
    }

    private View.OnClickListener handleOnClickEvent(String element) {
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (element){
                    case "parcel":
                        Intent intent = new Intent(getActivity().getApplicationContext(), ParcelActivity.class);
                        startActivity(intent);
                }

            }
        };
    }
}