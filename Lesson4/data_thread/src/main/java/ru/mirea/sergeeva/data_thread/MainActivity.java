package ru.mirea.sergeeva.data_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import ru.mirea.sergeeva.data_thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textView.setText("Метод runOnUiThread запускает код в главном потоке, метод postDelayed позволяет отложить выполнение кода на определенное время без блокирования основного потока. При использовании этих методов нет строгой последовательности запуска. Метод runOnUiThread может быть вызван внутри метода post, чтобы обновить пользовательский интерфейс на главном потоке, а метод postDelayed может использоваться после вызова runOnUiThread, чтобы установить задержку перед обновлением пользовательского интерфейса.");

        final Runnable runn1 = new Runnable() {
            public void run() {
                binding.tvInfo.setText("runn1");
            }
        };
        final Runnable runn2 = new Runnable() {
            public void run() {
                binding.tvInfo.setText("runn2");
            }
        };
        final Runnable runn3 = new Runnable() {
            public void run() {
                binding.tvInfo.setText("runn3");
            }
        };
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    runOnUiThread(runn1);
                    TimeUnit.SECONDS.sleep(1);
                    binding.tvInfo.postDelayed(runn3, 2000);
                    binding.tvInfo.post(runn2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}