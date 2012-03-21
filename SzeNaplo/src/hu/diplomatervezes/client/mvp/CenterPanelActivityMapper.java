package hu.diplomatervezes.client.mvp;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.activity.NewAnnouncementActivity;
import hu.diplomatervezes.client.activity.WelcomeActivity;
import hu.diplomatervezes.client.place.NewAnnouncementPlace;
import hu.diplomatervezes.client.place.StudentPlace;
import hu.diplomatervezes.client.place.TopPanelPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class CenterPanelActivityMapper implements ActivityMapper {

	private final MenuActivityMapper menuActivityMapper;
	private final ClientFactory clientFactory;
	
	public CenterPanelActivityMapper(ClientFactory clientFactory) {
		menuActivityMapper = new MenuActivityMapper(clientFactory);
		this.clientFactory = clientFactory;
	}
	
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof StudentPlace)
			return menuActivityMapper.getActivity(place);
		if (place instanceof TopPanelPlace)
			return new WelcomeActivity(clientFactory);
		if (place instanceof NewAnnouncementPlace)
			return new NewAnnouncementActivity(clientFactory);
		return null;
	}

}
