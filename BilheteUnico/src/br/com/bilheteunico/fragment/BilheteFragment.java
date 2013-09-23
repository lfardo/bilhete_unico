package br.com.bilheteunico.fragment;

import java.text.DecimalFormat;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import br.com.bilheteunico.BilheteUnicoActivity;
import br.com.bilheteunico.R;
import br.com.bilheteunico.dao.BilheteDAO;
import br.com.bilheteunico.domain.Bilhete;

public class BilheteFragment extends Fragment implements TabListener, OnItemClickListener, OnClickListener {
	
	private Fragment mFragment;
	private Bilhete bilhete; 
	private TextView saldo, dscBilhete;
	private Activity activity;
	private Button btnPassei;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (BilheteUnicoActivity) getActivity();
        activity.setContentView(R.layout.bilhete);
        
        Long bilheteId = Long.parseLong(activity.getIntent().getStringExtra("bilheteId"));
        
        BilheteDAO bilheteDAO = new BilheteDAO(this.getActivity());
        bilhete = bilheteDAO.getBilhete(bilheteId);
        
        saldo = (TextView) activity.findViewById(R.id.saldo);
        dscBilhete = (TextView) activity.findViewById(R.id.dscBilhete);
        
        DecimalFormat df = new DecimalFormat("0.00");
        saldo.setText(df.format(bilhete.getSaldo()));
        dscBilhete.setText(bilhete.getDscBilhete());
        
        btnPassei = (Button) activity.findViewById(R.id.passei);
        btnPassei.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				passei(v);
			}
		});
    }
 
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        mFragment = new BilheteFragment();
        ft.add(android.R.id.content, mFragment);
        ft.attach(mFragment);
    }
 
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        ft.remove(mFragment);
    }
 
    public void onTabReselected(Tab tab, FragmentTransaction ft) { 
    }
	
    public void passei(View view) {
    	AlertDialog semTaxas = criaDialogSemTaxa();
    	semTaxas.show();
    }
    
    private AlertDialog criaDialogSemTaxa() {
		AlertDialog.Builder builder = new AlertDialog.Builder(activity);
		
		builder.setMessage("Não foi encontrada nenhuma taxa cadastrada, deseja cadastrar agora?");
		builder.setPositiveButton("Sim", this);
		builder.setNegativeButton("Não", this);
		
		return builder.create();
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
    
}
