package ru.mirea.sergeevaum.dialog;


import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MyTimeDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public TimePickerDialog onCreateDialog(Bundle savedInstanceState){
        return  new TimePickerDialog(getActivity(), (TimePicker,hour, minute)->
                ((MainActivity)getActivity()).onTimeSet(hour,minute),
                0,0,true);

    }

}
