package ru.mirea.sergeeva.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

import ru.mirea.sergeeva.thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Thread mainThread = Thread.currentThread();
        binding.tv.setText("Имя текущего потока: " + mainThread.getName());
        mainThread.setName("МОЙ НОМЕР ГРУППЫ: бсбо-01-20, НОМЕР ПО СПИСКУ: 24, МОЙ ЛЮБИИМЫЙ ФИЛЬМ: человек паук");
        binding.tv.append("\n Новое имя потока: " + mainThread.getName());
        Log.d(MainActivity.class.getSimpleName(), "Stack: " + Arrays.toString(mainThread.getStackTrace()));

        binding.buttonMirea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        int numberThread = counter++;
                        Log.d("ThreadProject", String.format(
                                "Запущен поток No %d студентом группы No %s номер по списку No %s ", numberThread, "бсбо-01-20", "24"));
                        long endTime = System.currentTimeMillis() + 20 * 1000;
                        while (System.currentTimeMillis() < endTime) {
                            synchronized (this) {
                                try {
                                    wait(endTime - System.currentTimeMillis());
                                    Log.d(MainActivity.class.getSimpleName(), "Endtime: " + endTime);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            Log.d("ThreadProject", "Выполнен поток No " + numberThread);
                        }
                    }
                }).start();
            }
        });

        binding.button.setOnClickListener(v -> {
            new Thread(() -> {
                int day = Integer.parseInt(binding.editTextDay.getText().toString());
                int lesson = Integer.parseInt(binding.editTextLesson.getText().toString());
                int result = lesson / day;
                binding.textViewResult.post(() -> {
                    binding.textViewResult.setText("Среднее кол-во пар: " + result);
                });
            }).start();
        });

        Log.d(MainActivity.class.getSimpleName(), "Group: " + mainThread.getThreadGroup());
    }
}