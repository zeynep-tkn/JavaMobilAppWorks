package com.zeyneptekin.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.zeyneptekin.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
   ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList =new ArrayList<>();
        //DATA
        Landmark pisa=new Landmark("Pisa","Italy",R.drawable.indir);
        Landmark eiffel=new Landmark("Eiffel","France",R.drawable.eyfel);
        Landmark colosseum=new Landmark("Colosseum","Italy",R.drawable.resim1);
        Landmark londonBridge=new Landmark("London Bridge","UK",R.drawable.towerbridge);

        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(colosseum);
        landmarkArrayList.add(londonBridge);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter=new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);

        /*   Adapter   -  ListView
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList())
        );
        //map:neyi neye çavireyim

        binding.ListView.setAdapter(arrayAdapter);

        binding.ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, landmarkArrayList.get(position).name,Toast.LENGTH_LONG).show();
                Intent intent =new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("Landmark",landmarkArrayList.get(position));
                startActivity(intent);
            }
        });
        */
    }
}