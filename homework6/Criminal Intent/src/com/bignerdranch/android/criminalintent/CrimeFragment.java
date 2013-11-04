package com.bignerdranch.android.criminalintent;


import java.util.UUID;

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
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

import com.bignerdranch.android.ciminalintent.R;

public class CrimeFragment extends Fragment {
	
	private Crime mCrime;
	private Button mDateButton;
	private CheckBox mSolvedCheckBox;
	public static final String EXTRA_CRIME_ID = "com.bignerdranch.android.criminalintent";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		UUID crimeID = (UUID)getArguments().getSerializable(EXTRA_CRIME_ID);
		
		mCrime = CrimeLab.get(getActivity()).getCrime(crimeID);
	}
	
	public static CrimeFragment newInstance(UUID crimeID) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_CRIME_ID, crimeID);
		
		CrimeFragment fragment = new CrimeFragment();
		fragment.setArguments(args);
		
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_crime, parent, false);
		
		EditText mTitleField = (EditText)v.findViewById(R.id.crime_title);
		mTitleField.setText(mCrime.getmTitle());
		mTitleField.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(
					CharSequence c, int start, int before, int count) {
				mCrime.setmTitle(c.toString());
			}
			@Override
			public void afterTextChanged(Editable c) {
				//Left Blank				
			}
			@Override
			public void beforeTextChanged(CharSequence c, int start, int count, int after) {
				//Space left blank
			}
		});	
		
		mDateButton = (Button) v.findViewById(R.id.crime_date);
		mDateButton.setText(mCrime.getmDate().toString());
		mDateButton.setEnabled(false);
		
		mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
		mSolvedCheckBox.setChecked(mCrime.getmSolved());
		mSolvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@SuppressWarnings("unused")
			public void onCheckedChange(CompoundButton buttonView, boolean isChecked) {
				//set the crime's solved property
				mCrime.setmSolved(isChecked);
			}

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return v;
		
		
	}

}
