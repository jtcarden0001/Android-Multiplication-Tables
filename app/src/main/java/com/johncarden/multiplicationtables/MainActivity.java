package com.johncarden.multiplicationtables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView multiplicationList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multiplicationList = (ListView) findViewById(R.id.multiplyList);
        final int[] multiplier = {1};
        updateDisplay(multiplier);

        SeekBar multiplyBy = (SeekBar) findViewById(R.id.seekBar);
        multiplyBy.setMax(19);
        multiplyBy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                                  @Override
                                                  public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                                      multiplier[0] = progress+1;
                                                      updateDisplay(multiplier);
                                                  }

                                                  @Override
                                                  public void onStartTrackingTouch(SeekBar seekBar) {

                                                  }

                                                  @Override
                                                  public void onStopTrackingTouch(SeekBar seekBar) {

                                                  }
                                              }


        );

        multiplicationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, Integer.toString(multiplier[0]) + " x " + Integer.toString(position + 1), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void updateDisplay(int[] multiplier){

        ArrayList<Integer> displayList = new ArrayList<>();
        for(int i = 1; i < 13; i ++){
            displayList.add(multiplier[0] * i);
        }
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, displayList);
        multiplicationList.setAdapter(arrayAdapter);
    }
}
