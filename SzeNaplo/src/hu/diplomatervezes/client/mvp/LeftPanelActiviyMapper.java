package hu.diplomatervezes.client.mvp;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.activity.StudentPanelActivity;
import hu.diplomatervezes.client.place.StudentListPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class LeftPanelActiviyMapper implements ActivityMapper {

	private ClientFactory clientFactory;
	
	public LeftPanelActiviyMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	public Activity getActivity(Place place) {
		
		if (place instanceof StudentListPlace) {
			return new StudentPanelActivity(clientFactory);
		}
		
		return null;
	}

}
