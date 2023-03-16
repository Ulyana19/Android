package ru.mirea.sergeevaum.dialog;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class MyProgressDialogFragment extends DialogFragment {
    public ProgressDialog onCreateDialog(Bundle savedInstanceState) {
        return new ProgressDialog(getActivity());
    }
}
