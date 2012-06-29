package hu.diplomatervezes.client.view.charts;

import hu.diplomatervezes.shared._OsztalyzatMOCK;
import hu.diplomatervezes.shared._RatingGen;

import java.sql.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.visualizations.Table;
import com.google.gwt.visualization.client.visualizations.Table.Options;

public class TanAtlagTable extends Composite {

	private static TanAtlagTableUiBinder uiBinder = GWT
			.create(TanAtlagTableUiBinder.class);

	interface TanAtlagTableUiBinder extends UiBinder<Widget, TanAtlagTable> {
	}

	@UiField VerticalPanel tableHolder;
	List<_OsztalyzatMOCK> jegyek;
	final int day = 86400000;

	public TanAtlagTable(_RatingGen adatok) {
		initWidget(uiBinder.createAndBindUi(this));
		jegyek = adatok.getOsztalyzat();
		
		Runnable onLoadCallback = new Runnable() {
			
			@Override
			public void run() {
				Table iTable = new Table(createTable(), createOptions());
				tableHolder.add(iTable);
			}
		};
		VisualizationUtils.loadVisualizationApi(onLoadCallback, Table.PACKAGE);
	}
	
	private Options createOptions() {
		Options options = Options.create();
		options.setWidth("500");
		
		return options;
	}

	private AbstractDataTable createTable() {
		
		int row = 0;
		
		DataTable data = DataTable.create();
		data.addColumn(ColumnType.STRING, "Dátum");
		data.addColumn(ColumnType.STRING, "Érdemjegy");
		data.addColumn(ColumnType.STRING, "Megjegyzés");	
		
		data.addRows(jegyek.size());
		
		for (_OsztalyzatMOCK jegy : jegyek) {
			data.setValue(row, 0, new Date(System.currentTimeMillis()).toString());
			data.setValue(row, 1, jegy.getOsztalyzatStr());
			data.setValue(row, 2, jegy.getTipus());		
			++row;
		}
		
		return data;
	}

}
