package br.com.bilheteunico;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class BilheteUnicoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bilhete_unico);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		
		     
		// Teste
		getMenuInflater().inflate(R.menu.bilhete_unico, menu);
		return true;
	}

}
