package hu.diplomatervezes.client.mvp;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.place.StudentDetailPlace;
import hu.diplomatervezes.client.place.StudentPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class CenterPanelActivityMapper implements ActivityMapper {

	private final MenuActivityMapper menuActivityMapper;
	
	public CenterPanelActivityMapper(ClientFactory clientFactory) {
		menuActivityMapper = new MenuActivityMapper(clientFactory);
	}
	
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof StudentPlace)
			return menuActivityMapper.getActivity(place);
//		if (place instanceof StudentListPlace)
//			return menuActivityMapper.getActivity(place);
		return null;
	}

}
