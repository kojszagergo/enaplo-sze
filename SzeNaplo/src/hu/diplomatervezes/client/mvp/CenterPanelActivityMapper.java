package hu.diplomatervezes.client.mvp;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.activity.CenterPanelActivity;
import hu.diplomatervezes.client.place.StudentDetailPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class CenterPanelActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;
	
	public CenterPanelActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}
	
	@Override
	public Activity getActivity(Place place) {
		if(place instanceof StudentDetailPlace){
			System.out.println("OK?");
			return new CenterPanelActivity((StudentDetailPlace) place, clientFactory);
		}
		return null;
	}

}
