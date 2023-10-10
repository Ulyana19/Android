package ru.mirea.sergeevaum.mireaproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ru.mirea.sergeevaum.mireaproject.databinding.FragmentApplicationBinding;
import ru.mirea.sergeevaum.mireaproject.databinding.FragmentFirebaseBinding;
import ru.mirea.sergeevaum.mireaproject.databinding.FragmentHttpBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Application#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Application extends Fragment {

    FragmentApplicationBinding binding;
    private ListView lView;
    private ArrayList results = new ArrayList();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Application() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Application.
     */
    // TODO: Rename and change types and number of parameters
    public static Application newInstance(String param1, String param2) {
        Application fragment = new Application();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentApplicationBinding.inflate(inflater,container,false);
        View v = binding.getRoot();

        setContentView(R.layout.main);
        lView = (ListView) findViewById(R.id.list1);
        PackageManager pm = this.getPackageManager();

        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> list = pm.queryIntentActivities(intent, PackageManager.PERMISSION_GRANTED);
        for (ResolveInfo rInfo : list) {
            results.add(rInfo.activityInfo.applicationInfo.loadLabel(pm).toString());
            Log.w("Installed Applications", rInfo.activityInfo.applicationInfo.loadLabel(pm).toString());
        }
        lView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, results));
    }

        return v;

    }
}