package ru.mirea.sergeeva.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LiveData<String> myLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLiveData = new MutableLiveData();

        // Присоединяем наблюдателя к LiveData
        myLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String value) {
                // Этот блок выполнится при обновлении LiveData
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });

        // Обновляем значение LiveData
        ((MutableLiveData<String>) myLiveData).setValue("Hello, LiveData!");
    }
}