package ru.mirea.sergeevaum.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String tag = MainActivity.class.getSimpleName().toString();
    private Button button;
    private EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
    }
    public void onClickBtn(View view){
        int S = editText.getText().length();
        Toast toast = Toast.makeText(getApplicationContext(),
                "«Сергеева № 24 ГРУППА БСБО-01-20 Количество символов - "+ S,
                Toast.LENGTH_SHORT);
        toast.show();
    }
}