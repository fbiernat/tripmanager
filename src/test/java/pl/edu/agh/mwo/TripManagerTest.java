package pl.edu.agh.mwo;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class TripManagerTest {

	TripManager tripManager;
	Trip trip;
	
	@Before
	public void setUp() {
		tripManager = new TripManager();
		trip = new Trip("nazwa", "opis");
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

	@Test(expected = TripNotFoundException.class)
	public void testFindTrip() throws Exception {
		tripManager.add(trip);
		assertEquals(trip, tripManager.findTrip(trip.getName()));
		assertEquals(null, tripManager.findTrip("nonexistingtrip"));
	}
}
