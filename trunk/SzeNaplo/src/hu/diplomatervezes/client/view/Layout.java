package hu.diplomatervezes.client.view;

import hu.diplomatervezes.client.view.decor.MenuHeader;
import hu.diplomatervezes.shared._SimpleDataBase;
import hu.diplomatervezes.shared._SimpleSchoolClass;
import hu.diplomatervezes.shared._SimpleStudent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Layout extends Composite {

	private static LayoutUiBinder uiBinder = GWT.create(LayoutUiBinder.class);
	
	@UiField HorizontalPanel topPanel;
	@UiField VerticalPanel leftPanel;
	@UiField VerticalPanel mainPanel;
	@UiField StackLayoutPanel menu;

	interface LayoutUiBinder extends UiBinder<Widget, Layout> {
	}

	public Layout() {
		initWidget(uiBinder.createAndBindUi(this));

		menu.setHeight("600px");
	
		_SimpleDataBase sdb = _SimpleDataBase.get();
		System.out.println("Osztályok száma: " + sdb.getIskolaOsztalyok().size());
		for (_SimpleSchoolClass schoolClass : sdb.getIskolaOsztalyok()) {
			StudentContainer sc = new StudentContainer();
			sc.getScrollPanel().setStyleName("tesztScroll");
			//System.out.println(sc.getScrollContainer().getOffsetHeight());
			sc.getScrollPanel().setHeight(600-(sdb.getIskolaOsztalyok().size()*30) + "px");
			FlexTable st = sc.getStudentTable();
			int row = 0;
				for (_SimpleStudent student : schoolClass.getStudentList()) {
					st.setWidget(row, 0, new Label(row+1 + ". " + student.getFirstName() + " " + student.getLastName()));
					++row;
				}
			//menu.add(sc, schoolClass.getGrade(), 30);
			menu.add(sc, new MenuHeader(schoolClass.getGrade() + " Osztály"), 30);
			
		}
	}
}
