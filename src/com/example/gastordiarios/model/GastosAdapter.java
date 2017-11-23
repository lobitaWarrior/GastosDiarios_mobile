package com.example.gastordiarios.model;

import com.example.gastosdiarios.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class GastosAdapter extends ArrayAdapter<Gastos>{	
	
	public GastosAdapter(Context context, Gastos[] datos) {
		super(context,0,datos);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Get the data item for this position
		Gastos gasto=getItem(position);
		// Check if an existing view is being reused, otherwise inflate the view
		 if (convertView == null) {
	          convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_gastos, parent, false);
		 }
	       // Lookup view for data population
	       TextView txtPrecio = (TextView) convertView.findViewById(R.id.TxtGastoPrecio);
	       TextView txtFecha = (TextView) convertView.findViewById(R.id.TxtGastoFecha);
	       TextView txtDescripcion = (TextView) convertView.findViewById(R.id.TxtGastoDescripcion);
	       TextView txtCategoria = (TextView) convertView.findViewById(R.id.TxtGastoCategoria);
	       
	       // Populate the data into the template view using the data object
	       txtPrecio.setText(Float.toString(gasto.monto));
	       txtFecha.setText(gasto.fecha);
	       txtDescripcion.setText(gasto.descripcion);
	       txtCategoria.setText(gasto.categoria);
	       // Return the completed view to render on screen
	       return convertView;
	}
	
}
