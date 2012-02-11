package hu.diplomatervezes.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class SzeNaplo implements EntryPoint {

	@Override
	public void onModuleLoad() {
		
		StudentServiceAsync rpcService = GWT.create(StudentService.class);
		HandlerManager eventBus = new HandlerManager(null);
		AppController appViewer = new AppController(rpcService, eventBus);
		appViewer.go(RootLayoutPanel.get());
		
		//RootLayoutPanel.get().add(new Layout());
		scroll();
		//System.out.println("World");
	}
	
	public static native void scroll()	/*-{
	$wnd.$('.tesztScroll').jScrollPane();	
}-*/;
}
