package hu.diplomatervezes.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainLayoutImpl extends Composite implements MainLayout{

	private static MainLayoutUiBinder uiBinder = GWT.create(MainLayoutUiBinder.class);
	
	@UiTemplate("MainLayout.ui.xml")
	interface MainLayoutUiBinder extends UiBinder<Widget, MainLayoutImpl> {
	}
	
	@UiField HorizontalPanel topPanel;
	@UiField VerticalPanel leftPanel;
	@UiField VerticalPanel mainPanel;
	
	private Presenter presenter;

	public MainLayoutImpl() {
		initWidget(uiBinder.createAndBindUi(this));

		}

	@Override
	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub
		this.presenter = presenter;
	}
	
	public HorizontalPanel getTopPanel() {
		return this.topPanel;
	}
	
	public VerticalPanel getLeftPanel() {
		return this.leftPanel;
	}
	
	public VerticalPanel getMainPanel() {
		return this.mainPanel;
	}
}

