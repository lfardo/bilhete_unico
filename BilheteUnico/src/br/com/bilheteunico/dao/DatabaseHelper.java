package br.com.bilheteunico.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	private static final String BANCO_DADOS = "BilheteUnico";
	private static int VERSAO = 1;
	
	public static class Bilhete {
		public static final String TABELA = "Bilhete";
		public static final String _ID = "_id";
		public static final String DSC_BILHETE = "dsc_bilhete";
		public static final String SALDO = "saldo";
		public static final String ULTIMA_ATUALIZACAO = "ultima_atualizacao";
		public static final String[] COLUNAS = new String[]{
			_ID, DSC_BILHETE, SALDO, ULTIMA_ATUALIZACAO 
		};
	}
	
	public static class Taxa {
		public static final String TABELA = "Bilhete";
		public static final String _ID = "_id";
		public static final String BILHETE_ID = "bilhete_id";
		public static final String DSC_TAXA = "dsc_taxa";
		public static final String VALOR = "valor";
		public static final String[] COLUNAS = new String[]{
			_ID, BILHETE_ID, DSC_TAXA, VALOR 
		};
	}
	
	public DatabaseHelper(Context context) {
		super(context, BANCO_DADOS, null, VERSAO);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
