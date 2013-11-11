package com.ag.hellomoon;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AudioPlayback extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_audio_playback);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.audio_playback, menu);
		return true;
	}

}
