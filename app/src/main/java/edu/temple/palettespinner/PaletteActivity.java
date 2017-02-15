package edu.temple.palettespinner;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class PaletteActivity extends AppCompatActivity {

    private boolean first_fire = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        final ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("White");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Magenta");
        colors.add("Purple");

        final View layout = findViewById(R.id.activity_palette);
        Spinner spin = (Spinner) findViewById(R.id.color_spinner);
        PaletteAdapter pa = new PaletteAdapter( this, colors );
        spin.setAdapter( pa );

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if( first_fire ) {
                    first_fire = false;
                    return;
                }

                try {
                    layout.setBackgroundColor(Color.parseColor(colors.get(position)));
                } catch (Exception e ){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                layout.setBackgroundColor(Color.WHITE);
            }
        });

    }


}
