package hu.diplomatervezes.client;


import hu.diplomatervezes.client.mvp.AppPlaceHistoryMapper;
import hu.diplomatervezes.client.mvp.CenterPanelActivityMapper;
import hu.diplomatervezes.client.mvp.LeftPanelActiviyMapper;
import hu.diplomatervezes.client.place.DefaultPlace;
import hu.diplomatervezes.client.place.StudentListPlace;
import hu.diplomatervezes.client.view.AppLayout;
import hu.diplomatervezes.client.view.AppLayoutImpl;
import hu.diplomatervezes.client.view.MainLayoutImpl;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class SzeNaplo implements EntryPoint {

	//private Place defaultPlace = new DefaultPlace();
	private Place defaultPlace = new StudentListPlace("start");
	private AppLayout appWidget = new AppLayoutImpl();
	
	@Override
	public void onModuleLoad() {
		
		ClientFactory clientFactory = GWT.create(ClientFactoryImpl.class);
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();
		
		//Bal oldali panel
		ActivityMapper leftPanelActivityMapper = new LeftPanelActiviyMapper(clientFactory);
		ActivityManager leftPanelActivityManager = new ActivityManager(leftPanelActivityMapper, eventBus);
		leftPanelActivityManager.setDisplay(appWidget.getLeftPanel());
		
		ActivityMapper centerPanelActivityMapper = new CenterPanelActivityMapper(clientFactory);
		ActivityManager centerPanelActivityManager = new ActivityManager(centerPanelActivityMapper, eventBus);
		centerPanelActivityManager.setDisplay(appWidget.getCenterPanel());
		
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);
		
		RootLayoutPanel.get().add(appWidget.getMainLayoutPanel());
		historyHandler.handleCurrentHistory();
		
		scroll();
	}
	
	public static native void scroll()	/*-{
	$wnd.$('.tesztScroll').jScrollPane();	
}-*/;
}
