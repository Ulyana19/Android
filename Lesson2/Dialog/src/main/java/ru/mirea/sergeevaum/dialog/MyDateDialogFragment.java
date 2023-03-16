package ru.mirea.sergeevaum.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class MyDateDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public DatePickerDialog onCreateDialog(Bundle savedInstanceState){
        return  new DatePickerDialog(getActivity(), (DatePicker, year, month, day)->
                ((MainActivity)getActivity()).onDateSet(year, month, day),
                2023,01,01);

    }
}
