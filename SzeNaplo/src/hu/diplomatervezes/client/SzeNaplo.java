package hu.diplomatervezes.client;


import hu.diplomatervezes.client.mvp.AppPlaceHistoryMapper;
import hu.diplomatervezes.client.mvp.CachingLeftPanelActivityMapper;
import hu.diplomatervezes.client.mvp.CenterPanelActivityMapper;
import hu.diplomatervezes.client.mvp.TopPanelActivityMapper;
import hu.diplomatervezes.client.place.StudentListPlace;
import hu.diplomatervezes.client.place.TopPanelPlace;
import hu.diplomatervezes.client.view.AppLayout;
import hu.diplomatervezes.client.view.AppLayoutImpl;
import hu.diplomatervezes.client.view.UserPanelImpl;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class SzeNaplo implements EntryPoint {

	private LoginInfo loginInfo = null;
	//private StudentListPlace defaultPlace = new StudentListPlace();
	private Place defaultPlace;
	
	@Override
	public void onModuleLoad() {
		LoginServiceAsync loginService = GWT.create(LoginService.class);
		loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
			
			@Override
			public void onSuccess(LoginInfo result) {
				loginInfo = result;
				
				if (loginInfo.isLoggedIn())
					
					defaultPlace = new StudentListPlace();
				else
					defaultPlace = new TopPanelPlace(loginInfo);
				
				loadSzeNaplo();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void loadSzeNaplo() {
		ClientFactory clientFactory = GWT.create(ClientFactoryImpl.class);
		EventBus eventBus = clientFactory.getEventBus();
		
		AppLayout appWidget = new AppLayoutImpl();
		//appWidget.getTopPanel().setWidget(new Anchor("Kijelentkezés", loginInfo.getLogoutUrl()));
		appWidget.getTopPanel().setWidget(new UserPanelImpl(loginInfo));
		
		TopPanelActivityMapper topPanelActivityMapper = new TopPanelActivityMapper(clientFactory);
		ActivityManager topPanelActivityManager = new ActivityManager(topPanelActivityMapper, eventBus);
		topPanelActivityManager.setDisplay(appWidget.getTopPanel());
		
		//Bal oldali panel
		CachingLeftPanelActivityMapper leftPanelActivityMapper = new CachingLeftPanelActivityMapper(clientFactory);
		ActivityManager leftPanelActivityManager = new ActivityManager(leftPanelActivityMapper, eventBus);
		leftPanelActivityManager.setDisplay(appWidget.getLeftPanel());
		
		//Center
		CenterPanelActivityMapper centerPanelActivityMapper = new CenterPanelActivityMapper(clientFactory);
		ActivityManager centerPanelActivityManager = new ActivityManager(centerPanelActivityMapper, eventBus);
		centerPanelActivityManager.setDisplay(appWidget.getCenterPanel());
		
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		
		PlaceController placeController = clientFactory.getPlaceController();
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);
		
		RootLayoutPanel.get().add(appWidget.getMainLayoutPanel());
		
		historyHandler.handleCurrentHistory();
		
		//scroll();
	}
	
	public static native void scroll()	/*-{
	$wnd.$('.tesztScroll').jScrollPane();	
}-*/;
	
}
