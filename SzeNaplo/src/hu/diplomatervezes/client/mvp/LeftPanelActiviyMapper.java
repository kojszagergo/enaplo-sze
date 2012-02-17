package hu.diplomatervezes.client.mvp;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.activity.LeftPanelActivity;
import hu.diplomatervezes.client.place.StudentListPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class LeftPanelActiviyMapper implements ActivityMapper {

	private ClientFactory clientFactory;
	
	public LeftPanelActiviyMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}
	
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof StudentListPlace)
			return new LeftPanelActivity((StudentListPlace) place, clientFactory);
		return null;
	}

}
