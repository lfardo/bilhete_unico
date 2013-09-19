package br.com.bilheteunico;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import br.com.bilheteunico.fragment.BilheteFragment;
import br.com.bilheteunico.fragment.TaxasFragment;

public class BilheteUnicoActivity extends Activity {	
	
	private Tab tab;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		tab = actionBar.newTab().setTabListener(new BilheteFragment());
		tab.setText("Bilhete");
		actionBar.addTab(tab);
		
		tab = actionBar.newTab().setTabListener(new TaxasFragment());
		tab.setText("Taxas");
		actionBar.addTab(tab);
		
		tab = actionBar.newTab().setTabListener(new TaxasFragment());
		tab.setText("Config");
		actionBar.addTab(tab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
