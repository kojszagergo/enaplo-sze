package hu.diplomatervezes.client.mvp;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.activity.StudentDetailActivity;
import hu.diplomatervezes.client.activity.StudentPanelActivity;
import hu.diplomatervezes.client.activity.WelcomeActivity;
import hu.diplomatervezes.client.place.StudentDetailPlace;
import hu.diplomatervezes.client.place.StudentListPlace;
import hu.diplomatervezes.client.place.WelcomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class MenuActivityMapper implements ActivityMapper {
	private ClientFactory clientFactory;
	
	public MenuActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override
	public Activity getActivity(Place place) {
		
		if (place instanceof StudentListPlace) {
			return new WelcomeActivity();
			//return new StudentDetailActivity(null, clientFactory);
		}
		
		else if (place instanceof StudentDetailPlace) {
			return new StudentDetailActivity((StudentDetailPlace) place, clientFactory);
		}
		
		return null;
	}

}
