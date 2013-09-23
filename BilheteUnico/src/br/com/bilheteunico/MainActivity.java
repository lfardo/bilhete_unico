package br.com.bilheteunico;

import java.util.List;

import br.com.bilheteunico.dao.BilheteDAO;
import br.com.bilheteunico.domain.Bilhete;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		BilheteDAO bilheteDAO = new BilheteDAO(this);
		List<Bilhete> bilhetes = bilheteDAO.getTodosBilhetes();
		
		if (bilhetes.size() == 1) {
			Bilhete bilhete = bilhetes.get(0);
			Intent intent = new Intent(this, BilheteUnicoActivity.class);
			intent.putExtra("bilheteId", bilhete.getId().toString());
			startActivity(intent);
		}
		
		
	}

}