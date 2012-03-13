package hu.diplomatervezes.client.view;

import java.util.Map;

import hu.diplomatervezes.client.view.decor.MenuHeader;
import hu.diplomatervezes.shared._SimpleDataBase;
import hu.diplomatervezes.shared._SimpleSchoolClass;
import hu.diplomatervezes.shared._SimpleStudent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.CheckBox;

public class StudentListViewImpl extends Composite implements StudentListView, MenuHeader.MenuHeaderPresenter {

	private static StudentListViewImplUiBinder uiBinder = GWT
			.create(StudentListViewImplUiBinder.class);

	interface StudentListViewImplUiBinder extends UiBinder<Widget, StudentListViewImpl> {
	}
	
	interface RowStyle extends CssResource {
		String selected();
		String unselected();
	}
	
	private int lastSelected = -1;
	private Presenter presenter; 
	@UiField RowStyle style;
	@UiField StackLayoutPanel studentListPanel;

	public StudentListViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		
		studentListPanel.setHeight("600px");
	}

	@Override
	public void setStudentList(_SimpleDataBase students) {
		System.out.println(studentListPanel.getWidgetCount());
		
		for (_SimpleSchoolClass schoolClass : students.getIskolaOsztalyok()) {
			final StudentContainer sc = new StudentContainer();
			sc.getScrollPanel().setStyleName("tesztScroll");
			//System.out.println(sc.getScrollContainer().getOffsetHeight());
			sc.getScrollPanel().setHeight(600-(students.getIskolaOsztalyok().size()*30) + "px");
			final FlexTable st = sc.getStudentTable();
			
			st.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					
					MenuHeader w = (MenuHeader) studentListPanel.getHeaderWidget(studentListPanel.getVisibleIndex());
					
					Cell cell = st.getCellForEvent(event);
					//Element e = cell.getElement();
					int row = cell.getRowIndex();
					int column = cell.getCellIndex();
					
																																			System.out.println("Clicked: " + column);
					
					if (column == 0) {
						CheckBox cb = (CheckBox) st.getWidget(row, column);
						
						Map<Integer, CheckBox> selected = sc.getSelectedCheckBox();
						
						if (cb.getValue())
							selected.put(row, cb);
						else {
							selected.remove(row);			
						}
						
						w.getSelectedButton().setVisible(selected.size()>0 ? true : false);
						w.getDeleteSelectedButton().setVisible(selected.size()>0 ? true : false);
						
						System.out.println(selected.size());
						
					} else {
						Label lbl = (Label) st.getWidget(row, 1);
						presenter.onStudentSelected(lbl.getText());
					}
					
				}
			});
			
			int row = 0;
				for (_SimpleStudent student : schoolClass.getStudentList()) {
					st.setWidget(row, 0, new CheckBox());
					st.setWidget(row, 1, new Label(row+1 + ". " + student.getFirstName() + " " + student.getLastName()));
					++row;
				}
			studentListPanel.add(sc, new MenuHeader(presenter, this, schoolClass.getGrade()), 30);			
		}
		System.out.println(studentListPanel.getWidgetCount());
	}
	
//	@Override
//	public void setStudentList(_SimpleDataBase students) {
//		
//		for (_SimpleSchoolClass schoolClass : students.getIskolaOsztalyok()) {
//			StudentCellContainer sc = new StudentCellContainer();
//			sc.getScrollPanel().setStyleName("tesztScroll");
//			//System.out.println(sc.getScrollContainer().getOffsetHeight());
//			//sc.getScrollPanel().setHeight(600-(students.getIskolaOsztalyok().size()*30) + "px");
//			CellTable<_SimpleStudent> st = sc.getStudentTable();
//			
//			sc.setData(schoolClass.getStudentList());
//			//st.setHeight(600-(students.getIskolaOsztalyok().size()*30) + "px");
//			st.setWidth("100%");
//			studentListPanel.add(sc, new MenuHeader(presenter, schoolClass.getGrade()), 30);
//		}
//	}


	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void clearCheckBox() {
		// TODO Auto-generated method stub
		StudentContainer sc = (StudentContainer) studentListPanel.getWidget(studentListPanel.getVisibleIndex());
		
		Map<Integer, CheckBox> selected = sc.getSelectedCheckBox();
		for (int key : selected.keySet()) {
			selected.get(key).setValue(false);
			
		}
		selected.clear();
		
		MenuHeader w = (MenuHeader) studentListPanel.getHeaderWidget(studentListPanel.getVisibleIndex());
		//w.getSelectedButton().setVisible(selected.size()>0 ? true : false);
		//w.getDeleteSelectedButton().setVisible(selected.size()>0 ? true : false);
		w.setSelectStudentsBtVisible(selected.size() > 0 ? true : false);
		w.setDeleteSelectedBtVisible(selected.size() > 0 ? true : false);
	}
}
