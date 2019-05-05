package pl.edu.agh.mwo;

import java.util.ArrayList;
import java.util.Collection;

public class Trip {
	private String name;
	private String description;

	private ArrayList<Photo> photos = new ArrayList<>();

	public Trip(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Photo> getPhotos() {
		return this.photos;
	}

	public void addPhoto(Photo photo) throws PhotoAlreadyExistsException{
		if (photos.contains(photo)) {
			throw new PhotoAlreadyExistsException();
		} else {
			photos.add(photo);
		}
	}
}
