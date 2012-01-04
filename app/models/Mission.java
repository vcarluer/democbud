package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Mission extends Model {
	public String name;
	@OneToMany(mappedBy="mission", cascade=CascadeType.ALL)
	public List<Programme> programmes;
	
	public Mission(String name) {
		this.programmes = new ArrayList<Programme>();
		this.name = name;
	}

	public void addProgramme(String progName) {
		Programme programme = new Programme(progName, this);
		this.programmes.add(programme);		
	}
}