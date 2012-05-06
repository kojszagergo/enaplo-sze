package hu.diplomatervezes.client.activity;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.StudentService;
import hu.diplomatervezes.client.StudentServiceAsync;
import hu.diplomatervezes.client.place.SettingsMenuPlace;
import hu.diplomatervezes.client.view.settings.studentmanager.NewStudentView.Presenter;
import hu.diplomatervezes.client.view.settings.studentmanager.NewStudentViewImpl;
import hu.diplomatervezes.shared.Diak;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class NewStudentActivity extends AbstractActivity implements Presenter {
	
	StudentServiceAsync studentService = GWT.create(StudentService.class);

	private final NewStudentViewImpl view;
	private final PlaceController placeController;
	private final Diak newDiak;
	
	interface Driver extends SimpleBeanEditorDriver<Diak, NewStudentViewImpl> {	
	}
	
	Driver driver = GWT.create(Driver.class);
	
	public NewStudentActivity(ClientFactory clientFactory) {
		newDiak = new Diak();
		view = new NewStudentViewImpl();
		driver.initialize(view);
		driver.edit(newDiak);
		this.placeController = clientFactory.getPlaceController();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view.asWidget());
	}

	@Override
	public void saveNewStudent() {
		Diak newStudent = driver.flush();
//		Window.alert("Name: " + newStudent.getKeresztNev() + "Combo visszaadott érték típusa: " + newStudent.getNeme());
		studentService.addNewStudent(newStudent, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				Window.alert("sikeres");
				placeController.goTo(new SettingsMenuPlace());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void cancelNewStudent() {
		placeController.goTo(new SettingsMenuPlace());
	}

}
