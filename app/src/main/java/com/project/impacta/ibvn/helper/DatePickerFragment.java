package com.project.impacta.ibvn.helper;

import android.app.DatePickerDialog;
import android.app.Dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by proje on 11/03/2017.
 */

public  class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {


    private final EditText etToInput;

    public DatePickerFragment(EditText etToInput) {

         this.etToInput = etToInput;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {

        String data =String.format("%1$02d/%2$02d/%3$04d",day,month,year);
        etToInput.setText(data);
    }
}
