package pl.edu.agh.mwo;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TripTest {

	Trip trip;
	TripManager tripManager;
	Photo photo;

	@Before
	public void setup() {
		trip = new Trip("nazwa", "opis");
		tripManager = new TripManager();
		photo = new Photo("photo of a cat");
	}

	@Test
	public void testConstructor() {
		Trip trip = new Trip("nazwa", "opis");
		assertEquals("nazwa", trip.getName());
		assertEquals("opis", trip.getDescription());
	}

	@Test
	public void testAddPhoto() throws Exception {
		trip.addPhoto(photo);
		assertEquals(1, trip.getPhotos().size());
	}

	@Test(expected = PhotoAlreadyExistsException.class)
	public void testAddPhotoTwice() throws Exception {
		trip.addPhoto(photo);
		trip.addPhoto(photo);
		assertEquals(1, trip.getPhotos().size());
	}
}
