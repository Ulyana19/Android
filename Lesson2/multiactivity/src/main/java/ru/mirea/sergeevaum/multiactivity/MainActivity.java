package ru.mirea.sergeevaum.multiactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String tag = MainActivity.class.getSimpleName().toString();
//    private Button button;
//    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        editText = findViewById(R.id.editTextPerson);
//        button = findViewById(R.id.btnSendData);
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(tag, "Invoke onResume method");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "Invoke onStart method");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(tag, "Invoke onPause method");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(tag, "Invoke onStop method");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d(tag, "Invoke onPostCreate method");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(tag, "Invoke onDestroy method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "Invoke onDestroy method");

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "Invoke onRestart method");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(tag, "Invoke onRestoreInstanceState method"+savedInstanceState.getString("value"));
        //editText.setText(savedInstanceState.getString("value"));


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(tag, "Invoke onSaveInstanceState method");
        //outState.putString("value",editText.getText().toString());
    }


    @Override
    public void onDetachedFromWindow(){
        super.onDetachedFromWindow();
        Log.d(tag, "Invoke onDetachedFromWindow method");
    }
    public void sendDataToSecondActivity(View view) {
        //String data = editText.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("key", "MIREA - Сергеева Ульяна Михайловна");
        startActivity(intent);


    }
}