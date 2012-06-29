package hu.diplomatervezes.client.view.charts;

import java.util.List;

import hu.diplomatervezes.shared._OsztalyzatMOCK;
import hu.diplomatervezes.shared._RatingGen;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.DataView;
import com.google.gwt.visualization.client.LegendPosition;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.visualizations.ImageChart;
import com.google.gwt.visualization.client.visualizations.ImageChart.Options;

public class TanAtlagChart extends Composite {

	private static TanAtlagChartUiBinder uiBinder = GWT
			.create(TanAtlagChartUiBinder.class);

	interface TanAtlagChartUiBinder extends UiBinder<Widget, TanAtlagChart> {
	}
	
	@UiField VerticalPanel chartHolder;
	List<_OsztalyzatMOCK> jegyek;
	String tantargy = "";
	
	public TanAtlagChart(_RatingGen adatok) {
		initWidget(uiBinder.createAndBindUi(this));
		jegyek = adatok.getOsztalyzat();
		
		Runnable onLoadCallback = new Runnable() {
			
			@Override
			public void run() {
				ImageChart iChart = new ImageChart(createTable(), createOptions());
				chartHolder.add(iChart);
			}
		};

		VisualizationUtils.loadVisualizationApi(onLoadCallback, ImageChart.PACKAGE);
	}
	
	public TanAtlagChart(String tantargy) {
		this(_RatingGen.get());
		this.tantargy = tantargy;
	}
	
	public TanAtlagChart(_RatingGen adatok, String tantargy) {
		this(adatok);
		this.tantargy = tantargy;
	}
	
	private Options createOptions() {
		Options options = Options.create();
		options.set("chg", "0,-1,0,0");
		//options.set("chxl", "0:|1|2|3|4|5");
		options.set("chm", "o,FF0000,0,-1,5");
		//&chm=o,FF0000,0,-1,5
		options.setSize(450, 150);
		options.setLegend(LegendPosition.BOTTOM);
		options.setTitle(tantargy);
		return options;
	}
	
	private AbstractDataTable createTable() {
		int row = 0;
		Double osszeg = 0.0;
		DataTable data = DataTable.create();
		data.addColumn(ColumnType.NUMBER, "Jegyek");
		data.addColumn(ColumnType.NUMBER, "Átlag");
		
		data.addRows(jegyek.size());
		
		for (_OsztalyzatMOCK jegy : jegyek) {
			osszeg += jegy.getOsztalyzat();
			System.out.println("Jegy: " + String.valueOf(jegy.getOsztalyzat()) + " Összeg: "+ osszeg + " Átlag: " + osszeg/(row+1));
			data.setValue(row, 0, jegy.getOsztalyzat());
			data.setValue(row, 1, osszeg/(row+1));
			++row;
		}
		DataView dv = DataView.create(data);
		return data;
		
	}
}
