package hu.diplomatervezes.client;

import hu.diplomatervezes.client.ui.Layout;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class SzeNaplo implements EntryPoint {

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		RootLayoutPanel.get().add(new Layout());
		scroll();
	}
	
	
	public static native void scroll()
	/*-{
	$wnd.$('.tesztScroll').jScrollPane();	
}-*/;
}
