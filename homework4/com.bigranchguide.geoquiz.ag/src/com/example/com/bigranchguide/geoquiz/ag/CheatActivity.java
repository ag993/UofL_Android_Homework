package com.example.com.bigranchguide.geoquiz.ag;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class CheatActivity extends Activity {
	
	private boolean mAnswerIsTrue;
	private TextView mAnswerTextView;
	private Button mShowAnswer; 
	
	public static final String EXTRA_ANSWER_IS_TRUE = "com.example.com.bigranchguide.geoquiz.ag.answer_is_true"; 
	public static final String EXTRA_ANSWER_SHOWN = "com.example.com.bigranchguide.geoquiz.ag.answer_shown";
	
	private void setAnswerShownResults(Boolean isAnswerShown) {
		Intent data = new Intent();
		data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
		setResult(RESULT_OK,data);
	}
	
	@Override
	protected void onCreate(Bundle saveInstanceState) {
		super.onCreate(saveInstanceState);
		setContentView(R.layout.activity_cheat);
		
		//Answer will not be shown until the user presses the button
		setAnswerShownResults(false);
		
		
		mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
		mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
		mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
		mShowAnswer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(mAnswerIsTrue) {
					mAnswerTextView.setText(R.string.true_button);
					} else {
						mAnswerTextView.setText(R.string.false_button);
						}
				setAnswerShownResults(true);
			}
		});
		

		
		
	}

}
