package hu.diplomatervezes.client.view;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockLayoutPanel;

public interface AppLayout {

	DockLayoutPanel getMainLayoutPanel();
	AcceptsOneWidget getTopPanel();
	AcceptsOneWidget getLeftPanel();
	AcceptsOneWidget getCenterPanel();
}
