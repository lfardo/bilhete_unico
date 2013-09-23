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
		public static final String TABELA = "Taxa";
		public static final String _ID = "_id";
		public static final String BILHETE_ID = "bilhete_id";
		public static final String DSC_TAXA = "dsc_taxa";
		public static final String VALOR = "valor";
		public static final String TIPO = "tipo";
		public static final String[] COLUNAS = new String[]{
			_ID, BILHETE_ID, DSC_TAXA, VALOR, TIPO
		};
	}
	
	public static class Movimentacao {
		public static final String TABELA = "Movimentacao";
		public static final String _ID = "_id";
		public static final String BILHETE_ID = "bilhete_id";
		public static final String TAXA_ID = "taxa_id";
		public static final String TIPO = "tipo";
		public static final String VALOR = "valor";
		public static final String SALDO = "saldo";
		public static final String DATA = "data";
		public static final String[] COLUNAS = new String[]{
			_ID, BILHETE_ID, TAXA_ID, TIPO, VALOR, SALDO, DATA
		};
	}
	
	public DatabaseHelper(Context context) {
		super(context, BANCO_DADOS, null, VERSAO);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE bilhete (" +
				" _id INTEGER PRIMARY KEY," +
				" dsc_bilhete TEXT, " +
				" saldo DOUBLE, " +
				" ultima_atualizacao DATE);");
		
		db.execSQL("CREATE TABLE taxa (" +
				" _id INTEGER PRIMARY KEY," +
				" bilhete_id INTEGER, " +
				" dsc_taxa TEXT, " +
				" valor DOUBLE," +
				" tipo INTEGER);");
		
		db.execSQL("CREATE TABLE movimentacao (" +
				" _id INTEGER PRIMARY KEY," +
				" bilhete_id INTEGER, " +
				" taxa_id INTEGER, " +
				" tipo INTEGER, " +
				" valor  DOUBLE, " +
				" saldo DOUBLE" +
				" data DATE);");
		
		db.execSQL("INSERT INTO bilhete VALUES (1, 'Bilhete Único', 0.00, date('now'));");
		db.execSQL("INSERT INTO taxa VALUES (null, 1, 'crédito', 0.00, 1);");
		db.execSQL("INSERT INTO taxa VALUES (null, 1, 'débito', 0.00, 2);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
