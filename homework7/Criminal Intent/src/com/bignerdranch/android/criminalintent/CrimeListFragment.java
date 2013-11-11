package com.bignerdranch.android.criminalintent;
import java.util.ArrayList;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.bignerdranch.android.ciminalintent.R;


public class CrimeListFragment extends ListFragment {
	private ArrayList<Crime> mCrimes;

	@Override
	public void onResume() {
		super.onResume();
		((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
	}
	
	@Override
	public void onCreateOptionsMenu (Menu menu, MenuInflater inflater){
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_crime_list, menu);
	}
	
	@TargetApi(11)
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.menu_item_new_crime:
			Crime crime = new Crime();
			CrimeLab.get(getActivity()).addCrime(crime);
			Intent i = new Intent(getActivity(), CrimePagerActivity.class);
			i.putExtra(CrimeFragment.EXTRA_CRIME_ID, crime.getmId());
			startActivityForResult(i,0);
			return true;
		case R.id.menu_item_show_subtitle:
			if (getActivity().getActionBar().getSubtitle() == null) {
			getActivity().getActionBar().setSubtitle(R.string.subtitle);
			
			item.setTitle(R.string.hide_subtitle);
			}
			else {
				getActivity().getActionBar().setSubtitle(null);
				item.setTitle(R.string.show_subtitle);
			}
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Crime c = (Crime)getListAdapter().getItem(position);
		
		//Start CrimePagerActivity with this crime
		Intent i = new Intent(getActivity(),CrimePagerActivity.class);
		i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getmId());
		startActivity(i);
	}
	
	private class CrimeAdapter extends ArrayAdapter<Crime>{
		public CrimeAdapter(ArrayList<Crime> crimes) {
			super(getActivity(), 0, crimes);
		}
		
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			//If we weren't given a view, inflate one
			if (convertView == null){
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.list_item_crime, null);
			}
			//Configure the view for this crime
			Crime c = getItem(position);
			
			TextView titleTextView =
					(TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
			titleTextView.setText(c.getmTitle());
			
			TextView dateTextView =
					(TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
			dateTextView.setText(c.getmDate().toString());
			
			CheckBox solvedCheckBox =
					(CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
			solvedCheckBox.setChecked(c.getmSolved());
			
			return convertView;
	}
		}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		getActivity().setTitle(R.string.crimes_title);
		mCrimes = CrimeLab.get(getActivity()).getCrimes();
		
		CrimeAdapter adapter = new CrimeAdapter(mCrimes);
		setListAdapter(adapter);
	}
	
}
