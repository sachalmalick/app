package org.example.androidsdk.demo;

import java.util.Hashtable;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class EmailExamp extends Activity  implements OnItemSelectedListener {
	
	public String gift;
	EditText email;
	EditText messages;
	EditText personname;
	EditText recieversname;

	
	
	
	
	
	private Spinner spinner;
	
    private static final String[]paths = {"starbucks coffee", "dunkin doughnut", "gelato icecream"};
	   public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

	        switch (position) {
	            case 0:
	                gift = "starbucks coffee";
	                break;
	            case 1:
	            	gift = "dunkin doughnut";
	                break;
	            case 2:
	                gift = "gelato icecream";
	                break;

	        }
	    }
    
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email_examp);
		
		  spinner = (Spinner)findViewById(R.id.spinner);
	        ArrayAdapter<String>adapter = new ArrayAdapter<String>(EmailExamp.this,
	                android.R.layout.simple_spinner_item,paths);

	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spinner.setAdapter(adapter);
	        spinner.setOnItemSelectedListener(this);
		
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
						
			
			@Override
			public void onClick (View v) {
				  email = (EditText) findViewById(R.id.Email);
				  String to = email.getText().toString();
				  
				  messages = (EditText) findViewById(R.id.Message);
				  String tomessage = messages.getText().toString();
				  
				  personname = (EditText) findViewById(R.id.personname);
				  String sendersName = personname.getText().toString();
				  
				  recieversname = (EditText) findViewById(R.id.recieversname);
				  String name = recieversname.getText().toString();
				
				  Intent emailIntent = new Intent(Intent.ACTION_SEND);
				  emailIntent.putExtra(Intent.EXTRA_EMAIL,new String [] {to} );

				  emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Microgift" );
				  emailIntent.putExtra(Intent.EXTRA_TEXT,"Hello " + name + ",you recieved a gift from " + sendersName + ", this is the gift you recieved, " + gift + " here is a message from " + sendersName + ": " + tomessage);
				  
				  emailIntent.setType("message/rfc822");
				  
				  /*******************************************/
				  /********* Added By Petrica Luciam *********/
				  /*******************************************/
				  
				  String destinationFile; 
				  
				  // Describe the path of qrcode image generated by Zxing
				  String destinationFile= String.format("%s/%s/%s", 
								Environment.getExternalStorageDirectory().getPath(),
								"MyQRSamples" /* directory */,
								"qrcode.png" /* file name */); 
				  
				  emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(destinationFile));//pngFile
				  
				  /*******************************************/
				  /*******************************************/
				  
				  startActivity(Intent.createChooser(emailIntent,"Choose email client..."));
				  
				  
			
				  
				  

			}
			
		});
		
	}
	


	
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}