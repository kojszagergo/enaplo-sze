package hu.diplomatervezes.client.view.decor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.UIObject;

public class CheckBox extends UIObject {
	
	interface CbStyle extends CssResource {
		String unChecked();
		String checked();
	}

	private static CheckBoxUiBinder uiBinder = GWT
			.create(CheckBoxUiBinder.class);

	interface CheckBoxUiBinder extends UiBinder<Element, CheckBox> {
	}

	@UiField Element checkBox;

	public CheckBox(String firstName) {
		setElement(uiBinder.createAndBindUi(this));
		checkBox.setAttribute("checked", "false");
	}

}
