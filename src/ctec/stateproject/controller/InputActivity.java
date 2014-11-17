package ctec.stateproject.controller;

import ctec.stateproject.model.AndroidState;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.view.View;

public class InputActivity extends Activity
{
	/**
	 * starts up the textFields that will contain the name, age, phrases, and random text the user enters
	 */
	private EditText ageTextField, nameTextField, phraseTextField, blatherField;
	/**
	 * button to switch to the screen that has the talking text
	 */
	private Button transferButton;
	/**
	 * starts the object that will hold the info across multiple screens
	 */
	private AndroidState appState;
	
	/**
	 * sets the view of the app to the activity_input.xml, and sets up all of the input bars and button
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input);
		
		ageTextField = (EditText) findViewById(R.id.ageTextField);
		nameTextField = (EditText) findViewById(R.id.nameTextField);
		phraseTextField = (EditText) findViewById(R.id.phraseTextField);
		blatherField = (EditText) findViewById(R.id.blatherField);
		transferButton = (Button) findViewById(R.id.transferButton);
		
		appState = (AndroidState) this.getApplication();
		setupListeners();
	}
	/**
	 * starts the listeners to know when to transfer the data and switch screens
	 */
	private void setupListeners()
	{
		transferButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View currentView)
			{
				gatherInformation();
				
				Intent transferIntent = new Intent(currentView.getContext(), MainActivity.class);
				startActivityForResult(transferIntent, 0);
			}
		});
	}
	/**
	 * sets the text in the input section to the state so it can be used on the other screen
	 */
	private void gatherInformation()
	{
		appState.setAge(ageTextField.getText().toString());
		appState.setName(nameTextField.getText().toString());
		appState.setPhrase(phraseTextField.getText().toString());
		appState.setBlather(blatherField.getText().toString());
	}
}
