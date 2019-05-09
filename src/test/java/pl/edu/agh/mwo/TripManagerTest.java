package pl.edu.agh.mwo;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TripManagerTest {

	TripManager tripManager;
	Trip trip, trip1, trip2;
	Map<String,Trip> result = new HashMap<>();

	@Before
	public void setUp() throws PhotoAlreadyExistsException {
		tripManager = new TripManager();
		trip = new Trip("nazwa", "opis");
		trip1 = new Trip("name", "description");
		trip1.addPhoto(new Photo("comment"));

		trip2 = new Trip("comment", "comment");
		trip2.addPhoto(new Photo("comment"));
	}
	
	@Test
	public void testAdd() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
	}

	@Test(expected = TripAlreadyExistsException.class)
	public void testAddTripTwice() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.add(trip);
	}

	@Test
	public void testRemoveTrip() throws Exception {
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.remove(trip.getName());
		assertEquals(0, tripManager.getTrips().size());
//		fail("chcemy zespuc");
	}

	@Test(expected = TripNotFoundException.class)
	public void testRemoveTripTwice() throws Exception {
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.remove(trip.getName());
		assertEquals(0, tripManager.getTrips().size());
		tripManager.remove(trip.getName());
	}

	@Test
	public void testGetTrips() throws Exception {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		Trip secondTrip = new Trip("nazwa2", "opis2");
		tripManager.add(secondTrip);
		assertEquals(2, tripManager.getTrips().size());
	}

//	@Test(expected = TripNotFoundException.class)
//	public void testFindTrip() throws Exception {
//		tripManager.add(trip);
//		assertEquals(trip, tripManager.findTrip(trip.getName()));
//		assertEquals(trip, tripManager.findTrip(trip.getDescription()));
//		assertEquals(null, tripManager.findTrip("nonexistingtrip"));
//	}

	@Test
	public void testFindAllTrips() throws TripAlreadyExistsException {
		tripManager.add(trip);
		tripManager.add(trip1);
		result.put("nazwa", trip);
		result.put("name", trip1);
		assertEquals(result, tripManager.findTrip(""));
	}

	@Test
	public void testFindByTripName() throws TripAlreadyExistsException {
		tripManager.add(trip);
		tripManager.add(trip1);
		result.put("nazwa", trip);
		assertEquals(result, tripManager.findTrip("nazwa"));
	}

	@Test
	public void testFindByTripDescription() throws TripAlreadyExistsException {
		tripManager.add(trip);
		tripManager.add(trip1);
		result.put("nazwa", trip);
		assertEquals(result, tripManager.findTrip("opis"));
	}

	@Test
	public void testFindTripByPhotoComment() throws TripAlreadyExistsException {
		tripManager.add(trip);
		tripManager.add(trip1);
		result.put("name", trip1);
		assertEquals(result, tripManager.findTrip("comment"));
	}

	@Test
	public void testFindTripNotAddingSameTripTwice() throws Exception {
		tripManager.add(trip);
		tripManager.add(trip2);
		result.put("comment", trip2);
		assertEquals(result, tripManager.findTrip("comment"));
	}

}
