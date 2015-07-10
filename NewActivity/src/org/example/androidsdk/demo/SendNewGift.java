package org.example.androidsdk.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class SendNewGift extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sendnewgift);
		
	}
	public void sendGift(View v ){
		
		Intent intent = new Intent(this, NewGift.class);
		startActivity(intent);
		
		
	}
	
	

}
