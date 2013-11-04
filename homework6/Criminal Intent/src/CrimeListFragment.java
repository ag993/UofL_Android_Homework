import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.bignerdranch.android.ciminalintent.R;
import com.bignerdranch.android.criminalintent.Crime;


public class CrimeListFragment extends ListFragment {
	private ArrayList<Crime> mCrimes;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.crimes_title);
		mCrimes = CrimeLab.get(getActivity()).getCrimes();
	}
	
}
