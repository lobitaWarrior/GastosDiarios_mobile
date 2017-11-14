package com.example.gastordiarios.model;

import android.provider.BaseColumns;

public class CategoriasContract {

	public CategoriasContract(){}
	public abstract class TableCategoria implements BaseColumns{
		 public static final String TABLE_NAME = "Categorias";
		 public static final String COLUMN_NAME__ID = "id";
		 public static final String COLUMN_NAME_DESCRIPCION = "nombre";
	}
	
}
