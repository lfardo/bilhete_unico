package br.com.bilheteunico.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.bilheteunico.domain.Bilhete;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class BilheteDAO {

	private DatabaseHelper helper;
	private SQLiteDatabase db;
	
	/**
	 * Construtor de BilheteDAO
	 * @param context
	 */
	public BilheteDAO(Context context) {
		helper = new DatabaseHelper(context);
	}
	
	/**
	 * Retorna instancia do bando de dados
	 * @return SQLiteDatabase
	 */
	private SQLiteDatabase getDb() {
		
		if (db == null) {
			db = helper.getWritableDatabase();
		}
	
		return db;
	}
	
	/**
	 * Fecha conexao com o banco de dados
	 */
	public void close(){
		helper.close();
	}
	
	/**
	 * Retorna um objeto Bilhete apartir de um id (chave primaria)
	 * @param id
	 * @return Bilhete
	 */
	public Bilhete getBilhete(Long id) {
		
		String selection = DatabaseHelper.Bilhete._ID + " = ?";
		
		Cursor cursor = getDb().query(DatabaseHelper.Bilhete.TABELA, DatabaseHelper.Bilhete.COLUNAS, 
				selection, new String[] {String.valueOf(id)}, null, null, null);
				
		if (cursor != null) {
			cursor.moveToFirst();
		}
		
		Bilhete bilhete = assembleBilhete(cursor);
		
		cursor.close();
		return bilhete;
		
	}
	
	/**
	 * Retorno uma lista de todos os bilhetes do banco de dados
	 * @return List<Bilhete>
	 */
	public List<Bilhete> getTodosBilhetes() {
		Cursor cursor = getDb().query(DatabaseHelper.Bilhete.TABELA, DatabaseHelper.Bilhete.COLUNAS, 
				null, null, null, null, null);
		
		List<Bilhete> bilhetes = new ArrayList<Bilhete>();
		while (cursor.moveToNext()) {
			Bilhete bilhete = assembleBilhete(cursor);
			bilhetes.add(bilhete);
		}
		
		cursor.close();
		return bilhetes;
	}
	
	/**
	 * Monta objeto bilhete apartir de um cursos retornado no banco
	 * @param cursor
	 * @return Bilhete
	 */
	private Bilhete assembleBilhete(Cursor cursor) {
		Bilhete bilhete = new Bilhete(
				cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Bilhete._ID)), 
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Bilhete.DSC_BILHETE)), 
				cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.Bilhete.SALDO)), 
				new Date(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Bilhete.ULTIMA_ATUALIZACAO)))
		);
		
		return bilhete;
	}
	
}
