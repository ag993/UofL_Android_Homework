package com.bignerdranch.android.ciminalintent;

import java.util.UUID;




public class Crime {
	
	private UUID mId;
	private String mTitle;
	
	public Crime(){
	//Generate Unique Identifier
	mId = UUID.randomUUID();
	}
}
