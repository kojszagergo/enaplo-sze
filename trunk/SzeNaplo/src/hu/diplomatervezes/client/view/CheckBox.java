package hu.diplomatervezes.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class CheckBox extends Composite {
	
	interface CbStyle extends CssResource {
		String Main();
		String checked();
		String unChecked();
	}

	private static CheckBoxUiBinder uiBinder = GWT
			.create(CheckBoxUiBinder.class);

	interface CheckBoxUiBinder extends UiBinder<Widget, CheckBox> {
	}
	
	@UiField CbStyle style;
	@UiField HTMLPanel checkBox;
	Element e;
	Element m;

	public CheckBox() {
		initWidget(uiBinder.createAndBindUi(this));
		e = checkBox.getElement();
		m = e.getFirstChildElement(); 
		e.setAttribute("checked", "false");
		m.setClassName(style.unChecked());
		
	}
	
	public void setChecked() {
		e.setAttribute("checked", "true");
		m.setClassName(style.checked());
		
	}
	public void setUnChecked() {
		e.setAttribute("checked", "false");
		m.setClassName(style.unChecked());
	}
	
	public Boolean isChecked() {
		return Boolean.parseBoolean(e.getAttribute("checked"));
	}
}
