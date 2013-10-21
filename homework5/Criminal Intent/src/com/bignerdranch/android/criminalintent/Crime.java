package com.bignerdranch.android.criminalintent;

import java.util.Date;
import java.util.UUID;




public class Crime {
	
	private UUID mId;
	private String mTitle;
	private Date mDate;
	private Boolean mSolved;
	
	public Crime(){
	//Generate Unique Identifier
	mId = UUID.randomUUID();
	mDate = new Date();
	}

	public Date getmDate() {
		return mDate;
	}

	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}

	public Boolean getmSolved() {
		return mSolved;
	}

	public void setmSolved(Boolean mSolved) {
		this.mSolved = mSolved;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public UUID getmId() {
		return mId;
	}
}
