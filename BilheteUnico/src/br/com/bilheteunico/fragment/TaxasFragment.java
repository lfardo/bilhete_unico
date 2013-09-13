package br.com.bilheteunico.fragment;

import br.com.bilheteunico.R;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class TaxasFragment extends Fragment implements TabListener {

	private Fragment mFragment;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.taxas);
    }
 
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        mFragment = new TaxasFragment();
        ft.add(android.R.id.content, mFragment);
        ft.attach(mFragment);
    }
 
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        ft.remove(mFragment);
    }
 
    public void onTabReselected(Tab tab, FragmentTransaction ft) { 
    }

}
