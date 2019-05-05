package pl.edu.agh.mwo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PhotoTest {

    Photo photo;

    @Before
    public void setup() {
        photo = new Photo("photo of a cat");
    }

    @Test
    public void testDefaultConstructor() {
        Photo untitledPhoto = new Photo();
        assertEquals("untitled", untitledPhoto.getComment());
    }

    @Test
    public void testConstructorAndCommentGetter() {
        assertEquals("photo of a cat", photo.getComment());
    }

    @Test
    public void testCommentSetter() {
        photo.setComment("newcomment");
        assertEquals("newcomment", photo.getComment());
    }

}

