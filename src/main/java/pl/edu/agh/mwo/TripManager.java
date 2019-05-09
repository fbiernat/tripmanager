package pl.edu.agh.mwo;

import java.util.*;

public class TripManager {
    private HashMap<String, Trip> tripList;

    public TripManager() {
        tripList = new HashMap<String, Trip>();
    }

    public void add(Trip trip) throws TripAlreadyExistsException {
        if (tripList.get(trip.getName()) != null) {
            throw new TripAlreadyExistsException();
        } else {
            tripList.put(trip.getName(), trip);
        }
    }

    public HashMap<String, Trip> getTrips() {
        return tripList;
    }

    public void remove(String name) throws TripNotFoundException {
        if (tripList.containsKey(name)) {
            tripList.remove(name);
        } else {
            throw new TripNotFoundException();
        }
    }

//    public Trip findTrip(String keyword) throws TripNotFoundException {
//        for (Map.Entry<String, Trip> entry : tripList.entrySet()) {
//            if (entry.getKey().contains(keyword) || entry.getValue().getDescription().contains(keyword)) {
//                return entry.getValue();
//            }
//        }
//        throw new TripNotFoundException();
//    }

    public Map<String, Trip> findTrip(String keyword) {
        if(keyword.equals(""))
            return tripList;

        Map<String, Trip> result = new HashMap<>();

        for (Map.Entry<String, Trip> entry : tripList.entrySet()) {
            if (entry.getKey().contains(keyword) || entry.getValue().getDescription().contains(keyword)) {
                result.put(entry.getKey(), entry.getValue());
            }
            Collection<Photo> photos = entry.getValue().getPhotos();
            for (Photo p : photos) {
                if (p.getComment().contains(keyword) && !result.containsKey(entry.getKey())) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return result.isEmpty() ? null : result;
    }

}
