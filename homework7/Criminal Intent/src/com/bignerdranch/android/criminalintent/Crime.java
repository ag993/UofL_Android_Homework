package com.bignerdranch.android.criminalintent;

import java.util.Date;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;




public class Crime {
	
	private static final String JSON_ID = "id";
	private static final String JSON_TITLE = "title";
	private static final String JSON_SOLVED = "solved";
	private static final String JSON_DATE = "date";
	
	private UUID mId;
	private String mTitle;
	private Date mDate;
	private Boolean mSolved = false ;
	
	public Crime(){
	//Generate Unique Identifier
	mId = UUID.randomUUID();
	mDate = new Date();
	}
	
	public Crime(JSONObject json) throws JSONException {
		mId = UUID.fromString(json.getString(JSON_ID));
		mTitle = json.getString(JSON_TITLE);
		mSolved = json.getBoolean(JSON_SOLVED);
		mDate = new Date(json.getLong(JSON_DATE));
	}

	
	public JSONObject toJSON() throws JSONException {
		JSONObject json = new JSONObject();
		json.put(JSON_ID, mId.toString());
		json.put(JSON_TITLE, mTitle.toString());
		json.put(JSON_SOLVED, mSolved);
		json.put(JSON_DATE, mDate.getTime());
		return json;
	}
	
	@Override
	public String toString() {
		return mTitle;
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

	public void setmSolved(Boolean solved) {
		mSolved = solved;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String title) {
		mTitle = title;
	}

	public UUID getmId() {
		return mId;
	}
}
