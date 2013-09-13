package br.com.bilheteunico;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import br.com.bilheteunico.fragment.BilheteFragment;
import br.com.bilheteunico.fragment.TaxasFragment;

public class BilheteUnicoActivity extends Activity {	
	
	Tab tab;
	
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
	/*
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}

	
	@SuppressWarnings("unused")
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Fragment f = null;
		TabFragment tf = null;

		if (fragList.size() > tab.getPosition())
				fragList.get(tab.getPosition());

		if (f == null) {
			tf = new TabFragment();
			Bundle data = new Bundle();
			data.putInt("idx",  tab.getPosition());
			tf.setArguments(data);
			fragList.add(tf);
		} else {
			tf = (TabFragment) f;
		}
		
		ft.replace(android.R.id.content, tf);

	}*/
/*
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		if (fragList.size() > tab.getPosition()) {
			ft.remove(fragList.get(tab.getPosition()));
		}

	}
	*/
}
