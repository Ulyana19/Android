package ru.mirea.sergeeva.yandexmaps;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class App extends Application {
    private final String MAPKIT_API_KEY = "cd64f875-6bd0-4f2b-8b30-a9ddd60fbf3e";
    @Override
    public void onCreate() {
        super.onCreate();
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
    }
}