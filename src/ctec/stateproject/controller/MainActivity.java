package ctec.stateproject.controller;

import ctec.stateproject.model.AndroidState;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity
{
	/**
	 * the text that will display the info recieved from the input screen
	 */
	private TextView displayView;
	/**
	 * the button to return you to the input screen
	 */
	private Button homeButton;
	/**
	 * creates the state so it can exchange data between screens
	 */
	private AndroidState appState;
	
/**
 * sets the screen to the activity_main.xml, sets up the button, grabs the app state, and starts the listeners
 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		displayView = (TextView) findViewById(R.id.resultsView);
		homeButton = (Button) findViewById(R.id.homeButton);
		appState = (AndroidState) this.getApplication();
		
		showTransferInput();
		
		setupListeners();
	}
	/**
	 * the text displayed after the info is recieved
	 */
	private void showTransferInput()
	{
		displayView.setText(appState.getName() + " says: ''" + appState.getPhrase()
							+ ",'' because they think: ''" + appState.getBlather()
							+ ",'' when they are " + appState.getAge() + " years old.");
		
	}
	/**
	 * makes the home button return to the input screen when tapped
	 */
	private void setupListeners()
	{
		homeButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent returnIntent = new Intent();
				setResult(RESULT_OK, returnIntent);
				finish();
				
			}
		});
	}
}
