package hu.diplomatervezes.client.mvp;

import hu.diplomatervezes.client.ClientFactory;
import hu.diplomatervezes.client.place.NewAnnouncementPlace;
import hu.diplomatervezes.client.place.SettingsMenuPlace;
import hu.diplomatervezes.client.place.StudentDetailPlace;
import hu.diplomatervezes.client.place.StudentListPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.activity.shared.CachingActivityMapper;
import com.google.gwt.activity.shared.FilteredActivityMapper;
import com.google.gwt.activity.shared.FilteredActivityMapper.Filter;
import com.google.gwt.place.shared.Place;

public class CachingLeftPanelActivityMapper implements ActivityMapper {

	private ActivityMapper filteredActivityMapper;
	
	public CachingLeftPanelActivityMapper(ClientFactory clientFactory) {
		FilteredActivityMapper.Filter filter = new Filter() {
			
			@Override
			public Place filter(Place place) {
				if (place instanceof StudentDetailPlace)
					return new StudentListPlace();
				else if (place instanceof NewAnnouncementPlace)
					return new SettingsMenuPlace();
				else return place;
					
				
				//return place instanceof StudentDetailPlace ? new StudentListPlace() : place;
			}
		};
		
		LeftPanelActiviyMapper mapper = new LeftPanelActiviyMapper(clientFactory);
		CachingActivityMapper cachingActivityMapper = new CachingActivityMapper(mapper);
		filteredActivityMapper = new FilteredActivityMapper(filter, cachingActivityMapper);
	}
	
	
	@Override
	public Activity getActivity(Place place) {
		return filteredActivityMapper.getActivity(place);
	}
}
