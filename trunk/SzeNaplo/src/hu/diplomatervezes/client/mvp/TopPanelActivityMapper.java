package hu.diplomatervezes.client.mvp;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.activity.TopPanelActivity;
import hu.diplomatervezes.client.place.TopPanelPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class TopPanelActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;
	
	public TopPanelActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override
	public Activity getActivity(Place place) {
		
		if(place instanceof TopPanelPlace) {
			return new TopPanelActivity((TopPanelPlace) place, clientFactory);
		}
		return null;
	}

}
