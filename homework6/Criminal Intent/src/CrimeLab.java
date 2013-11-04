import java.util.ArrayList;

import com.bignerdranch.android.criminalintent.Crime;

import android.content.Context;


public class CrimeLab {
	private ArrayList<Crime> mCrimes;
	
	private static CrimeLab sCrimeLab;
	private Context mAppContext;
	
	private CrimeLab(Context appContext){
		mAppContext = appContext;
		mCrimes = new ArrayList<Crime>();
	}
	
	public static CrimeLab get(Context c) {
		if (sCrimeLab == null) {
			sCrimeLab = new CrimeLab(c.getApplicationContext());
		}
		return sCrimeLab;
	}
}
