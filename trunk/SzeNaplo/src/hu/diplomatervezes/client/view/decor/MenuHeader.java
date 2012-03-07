package hu.diplomatervezes.client.view.decor;

import hu.diplomatervezes.client.view.StudentListView;
import hu.diplomatervezes.client.view.StudentListView.Presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;

public class MenuHeader extends Composite {

	private static MenuHeaderUiBinder uiBinder = GWT
			.create(MenuHeaderUiBinder.class);

	interface MenuHeaderUiBinder extends UiBinder<Widget, MenuHeader> {
	}
	
	public interface MenuHeaderPresenter  {
		void clearCheckBox();
	}

	public MenuHeader() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	private MenuHeaderPresenter headPresenter;
	private Presenter presenter;
	@UiField Anchor toStudentClassPage;
	@UiField PushButton selectStudents_BT;
	@UiField PushButton clearSelection_BT;

	public MenuHeader(Presenter presenter, MenuHeaderPresenter headPresenter, String headerName) {
		initWidget(uiBinder.createAndBindUi(this));
		this.presenter = presenter;
		this.headPresenter = headPresenter; 
		toStudentClassPage.setText(headerName);
	}
	
	@UiHandler("toStudentClassPage")
	void onClick(ClickEvent e) {
		headPresenter.clearCheckBox();
		presenter.onClassSelected(toStudentClassPage.getText());
	}
	
	@UiHandler("clearSelection_BT")
	void onClickDelete(ClickEvent e) {
		headPresenter.clearCheckBox();
	}
	
	public PushButton getSelectedButton() {
		return selectStudents_BT;
	}
	
	public PushButton getDeleteSelectedButton() {
		return clearSelection_BT;
	}
	
	public void setSelectStudentsBtVisible(Boolean visible) {
		selectStudents_BT.setVisible(visible);
	}
	
	public void setDeleteSelectedBtVisible(Boolean visible) {
		clearSelection_BT.setVisible(visible);
	}
	
	public void setMenuPresenterPresenter(MenuHeaderPresenter presenter){
		this.headPresenter = presenter;
	}

}
