package hu.diplomatervezes.client.view;

import java.util.List;

import hu.diplomatervezes.client.view.charts.TanAtlagChart;
import hu.diplomatervezes.client.view.charts.TanAtlagTable;
import hu.diplomatervezes.shared._OsztalyzatMOCK;
import hu.diplomatervezes.shared._RatingGen;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;

public class StudentDetailViewImpl extends Composite implements StudentDetailView {

	private static StudentDetailViewImplUiBinder uiBinder = GWT
			.create(StudentDetailViewImplUiBinder.class);

	interface StudentDetailViewImplUiBinder extends
			UiBinder<Widget, StudentDetailViewImpl> {
	}

	public StudentDetailViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		_RatingGen adatok = _RatingGen.get();
		middle.add(new TanAtlagTable(adatok));
		middle.add(new TanAtlagChart(adatok, subjects.getItemText(subjects.getSelectedIndex())));
		jegyekSzama.setText(String.valueOf(adatok.getOsztalyzat().size()));
		tantargyiAtlag.setText(String.valueOf(adatok.getAtlag()));
	}

	private Presenter presenter;
	private List<_OsztalyzatMOCK> jegyek;
	//@UiField HorizontalPanel studentDetailHeader;
	//@UiField VerticalPanel studentDetailLeft;
	//@UiField VerticalPanel studentDetailRight;
	//@UiField VerticalPanel studentDetailFooter;
	@UiField ListBox subjects;
	@UiField Label nameLabel;
	@UiField Label jegyekSzama;
	@UiField Label tantargyiAtlag;
	
	
	@UiField VerticalPanel middle;
	//@UiField PushButton newButton;
	//@UiField FlexTable studentCredits;
	//@UiField FlexTable privateData;
	//private Presenter presenter;
	
	
	@Override
	public void setData(String className) {
		// TODO Auto-generated method stub
		nameLabel.setText(className);
	}
	
//	@UiHandler("newButton")
//	void onClick(ClickEvent e){
//		//Window.alert("Clicked!");
//		presenter.goTo(new StudentListPlace());
//	}
	
	@UiHandler("subjects")
		void onChange(ChangeEvent e) {
//			ListBox lb = (ListBox) e.getSource();
			presenter.getJegyek(subjects.getItemText(subjects.getSelectedIndex()));
			GWT.log("Rákattintott a Combo box-ra, és generálódott egy ChangeEvent.", null);
	}
	
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setSubjectChart(_RatingGen adatok) {
		middle.clear();
		this.jegyek = adatok.getOsztalyzat();
		middle.add(new TanAtlagTable(adatok));
		middle.add(new TanAtlagChart(adatok, subjects.getItemText(subjects.getSelectedIndex())));
		jegyekSzama.setText(String.valueOf(jegyek.size()));
		tantargyiAtlag.setText(String.valueOf(adatok.getAtlag()));
	}
}

