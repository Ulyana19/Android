package ru.mirea.sergeevaum.lesson3;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String data = (String) getIntent().getSerializableExtra("key");
        textView= findViewById(R.id.textView);
        textView.setText(data);

    }


}