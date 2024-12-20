package com.example.laba_3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onStop() {
        Log.d("SecondActivity", "onStop called");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.d("SecondActivity", "onPause called");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("SecondActivity", "onResume called");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.d("SecondActivity", "onStart called");
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        Log.d("SecondActivity", "onDestroy called");
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("SecondActivity", "onCreate called");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editTextCity = findViewById(R.id.editTextCity);
        EditText editTextStreet = findViewById(R.id.editTextStreet);
        EditText editTextHouse = findViewById(R.id.editTextHouse);

        Intent intent = new Intent();

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String city = editTextCity.getText().toString();
                final String street = editTextStreet.getText().toString();
                final String house = editTextHouse.getText().toString();

                if (!city.isEmpty() && !street.isEmpty() && !house.isEmpty()) {
                    intent.putExtra("city", city);
                    intent.putExtra("street", street);
                    intent.putExtra("house", house);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}