package pl.edu.agh.mwo;
import java.util.*;

public class TripManager {
	private HashMap<String,Trip> tripList;
	
	public TripManager() {
		tripList = new HashMap<String,Trip>();
	}
	
	public void add(Trip trip) throws TripAlreadyExistsException {
		if (tripList.get(trip.getName()) != null) {
			throw new TripAlreadyExistsException();
		}
		else {
			tripList.put(trip.getName(),trip);
		}
	}
	
	public HashMap<String,Trip> getTrips() {
		return tripList;
	}

	public void remove(String name)throws TripNotFoundException {
		if (tripList.containsKey(name)) {
			tripList.remove(name);
		} else {
			throw new TripNotFoundException();
		}
	}

	public Trip findTrip(String keyword) throws TripNotFoundException {
		for (Map.Entry<String,Trip> entry : tripList.entrySet()) {
			if (entry.getKey().contains(keyword) || entry.getValue().getDescription().contains(keyword)) {
				return entry.getValue();
			}
		}
		throw new TripNotFoundException();
	}
	
}
