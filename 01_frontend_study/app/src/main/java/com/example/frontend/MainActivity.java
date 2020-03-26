package com.example.frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    public static int active_idx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);

        Button toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrameLayout frameLayout = findViewById(R.id.frameLayout);
                Log.d("onclick", String.format("%d", MainActivity.active_idx));
                for (int i = 0; i < frameLayout.getChildCount(); i++) {
                    if (i == MainActivity.active_idx) {
                        MainActivity.active_idx = (MainActivity.active_idx + 1) % 2;

                        frameLayout.getChildAt(i).setVisibility(View.INVISIBLE);
                        frameLayout.getChildAt(MainActivity.active_idx).setVisibility(View.VISIBLE);

                        break;
                    }
                }
            }
        });
    }
}