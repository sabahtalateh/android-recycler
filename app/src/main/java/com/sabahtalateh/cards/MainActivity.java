package com.sabahtalateh.cards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cards = findViewById(R.id.cards);

        List<Model> mm = new ArrayList<>();
        mm.add(new Model(R.drawable.basketball, "Hockey"));
        mm.add(new Model(R.drawable.ping, "Boxing"));
        mm.add(new Model(R.drawable.volley, "Girls Sport"));
        mm.add(new Model(R.drawable.football, "Dream of Salvador Dali"));
        mm.add(new Model(R.drawable.tennis, "Barbecue"));

        Adapter adapter = new Adapter(mm);

        cards.setAdapter(adapter);

        cards.setLayoutManager(new LinearLayoutManager(this));

        adapter.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                String text = mm.get(position).getTitle();
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}