package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Meek on 2/28/2016.
 */
public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    private DateFormat format;
    //onCreate();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
        format = DateFormat.getDateInstance();
    }

    //onCreateView();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Create new View
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        //Attribute mDateButton to Id "crime_date"
        mDateButton = (Button)v.findViewById(R.id.crime_date);
        //Get date and set it to a string
        mDateButton.setText(format.format(mCrime.getDate()));
        //Disable button
        mDateButton.setEnabled(false);

        //Attribute mSolvedCheckBox to Id "crime_solved"
        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        //Create onClickListener for mSolvedCheckBox
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Set the crime/s solved property
                mCrime.setSolved(isChecked);
            }
        });
        //Attribute mTitleField to Id "crime_title"
        mTitleField = (EditText)v.findViewById(R.id.crime_title);
        //Listener manages what happens when text is changed
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //Intentionally left blank
            }
        });
        return v;
    }
}
