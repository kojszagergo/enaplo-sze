package hu.diplomatervezes.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.FlexTable;

public class StudentDetailViewImpl extends Composite implements StudentDetailView {

	private static StudentDetailViewImplUiBinder uiBinder = GWT
			.create(StudentDetailViewImplUiBinder.class);

	interface StudentDetailViewImplUiBinder extends
			UiBinder<Widget, StudentDetailViewImpl> {
	}

	public StudentDetailViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	//@UiField HorizontalPanel studentDetailHeader;
	//@UiField VerticalPanel studentDetailLeft;
	//@UiField VerticalPanel studentDetailRight;
	//@UiField VerticalPanel studentDetailFooter;
	@UiField Label nameLabel;
	//@UiField FlexTable studentCredits;
	//@UiField FlexTable privateData;
	//private Presenter presenter;
	
	
	@Override
	public void setData(String className) {
		// TODO Auto-generated method stub
		nameLabel.setText(className);
	}
	@Override
	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub
		//this.presenter = presenter;
	}
}
