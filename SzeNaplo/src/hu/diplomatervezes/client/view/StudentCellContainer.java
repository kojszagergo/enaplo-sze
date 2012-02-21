package hu.diplomatervezes.client.view;

import java.util.List;

import hu.diplomatervezes.shared._SimpleStudent;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;

public class StudentCellContainer extends Composite {

	private static StudentCellContainerUiBinder uiBinder = GWT
			.create(StudentCellContainerUiBinder.class);

	interface StudentCellContainerUiBinder extends
			UiBinder<Widget, StudentCellContainer> {
	}

	final MultiSelectionModel<_SimpleStudent> selectionModel = new MultiSelectionModel<_SimpleStudent>(
			_SimpleStudent.KEY_PROVIDER);
	
	@UiField ScrollPanel scrollPanel;
	@UiField CellTable<_SimpleStudent> studentTable;
	
	public StudentCellContainer() {
		initWidget(uiBinder.createAndBindUi(this));
	
		TextColumn<_SimpleStudent> name= new TextColumn<_SimpleStudent>() {
			
			@Override
			public String getValue(_SimpleStudent object) {
				return object.getFullName();
			}
		};
		
		Column<_SimpleStudent, Boolean> checkColumn =  new Column<_SimpleStudent, Boolean>(
				new CheckboxCell(true, false)) {
			
			@Override
			public Boolean getValue(_SimpleStudent object) {
				// TODO Auto-generated method stub
				return selectionModel.isSelected(object);
			}
		};
		
		studentTable.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
		studentTable.addColumn(name, "Név");
		
//		final SingleSelectionModel<_SimpleStudent> selectionModel = new SingleSelectionModel<_SimpleStudent>();
//		studentTable.setSelectionModel(selectionModel);
//		selectionModel.addSelectionChangeHandler(new Handler() {
//			
//			@Override
//			public void onSelectionChange(SelectionChangeEvent event) {
//				// TODO Auto-generated method stub
//				_SimpleStudent student = selectionModel.getSelectedObject();
//				Window.alert(student.getFullName());
//			}
//		});
		
		studentTable.setSelectionModel(selectionModel, DefaultSelectionEventManager.<_SimpleStudent> createCheckboxManager());
		selectionModel.addSelectionChangeHandler(new Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				// TODO Auto-generated method stub
				String out = "";
				for (_SimpleStudent student : selectionModel.getSelectedSet()) {
					out += "Id: " + student.getId() + "Name: " + student.getFullName() + "; ";
				}
				Window.alert(out);
			}
		});
	}
	
	public void setData(List<_SimpleStudent> list) {
		studentTable.setRowCount(list.size());
		studentTable.setRowData(list);
	}
	
	public CellTable<_SimpleStudent> getStudentTable() {
		return studentTable;
	}
	
	public ScrollPanel getScrollPanel() {
		return scrollPanel;
	}	
}
