package hu.diplomatervezes.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class AppLayoutImpl extends Composite implements AppLayout{

	private final DockLayoutPanel mainLayoutPanel;
	
	private static AppLayoutImplUiBinder uiBinder = GWT
			.create(AppLayoutImplUiBinder.class);

	interface AppLayoutImplUiBinder extends UiBinder<Widget, AppLayoutImpl> {
	}

	public AppLayoutImpl() {
		mainLayoutPanel = (DockLayoutPanel) uiBinder.createAndBindUi(this);
	}

	@UiField SimplePanel leftPanel;
	@UiField SimplePanel topPanel;
	@UiField SimplePanel centerPanel;
	
	
	@Override
	public DockLayoutPanel getMainLayoutPanel() {
		return mainLayoutPanel;
	}
	@Override
	public AcceptsOneWidget getTopPanel() {
		return new AcceptsOneWidget() {
			
			@Override
			public void setWidget(IsWidget w) {
				Widget widget = Widget.asWidgetOrNull(w);
				topPanel.setWidget(widget);
			}
		};
	}
	
	@Override
	public AcceptsOneWidget getLeftPanel() {
		return new AcceptsOneWidget() {
			
			@Override
			public void setWidget(IsWidget w) {
				Widget widget = Widget.asWidgetOrNull(w);
				leftPanel.setWidget(widget);
			}
		};
	}
	
	@Override
	public AcceptsOneWidget getCenterPanel() {
		return new AcceptsOneWidget() {
			
			@Override
			public void setWidget(IsWidget w) {
				Widget widget = Widget.asWidgetOrNull(w);
				centerPanel.setWidget(widget);
			}
		};
	}
	
}
