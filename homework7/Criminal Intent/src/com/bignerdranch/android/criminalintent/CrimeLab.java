package com.bignerdranch.android.criminalintent;
import java.util.ArrayList;
import java.util.UUID;


import android.content.Context;


public class CrimeLab {
	private ArrayList<Crime> mCrimes;
	
	private static CrimeLab sCrimeLab;
	private Context mAppContext;
	
	private CrimeLab(Context appContext){
		setmAppContext(appContext);
		mCrimes = new ArrayList<Crime>();
	}
	
public void addCrime(Crime c) {
	mCrimes.add(c);
}
	
	public static CrimeLab get(Context c) {
		if (sCrimeLab == null) {
			sCrimeLab = new CrimeLab(c.getApplicationContext());
		}
		return sCrimeLab;
	}
	
	public ArrayList<Crime> getCrimes(){
		return mCrimes;
	}
	
	public Crime getCrime(UUID id) {
		for (Crime c : mCrimes) {
			if (c.getmId().equals(id))
				return c;
		}
		return null;
	}

	public Context getmAppContext() {
		return mAppContext;
	}

	public void setmAppContext(Context mAppContext) {
		this.mAppContext = mAppContext;
	}
	
}
