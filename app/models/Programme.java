package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Programme extends Model {
	public String name;
	@ManyToOne
	public Mission mission;
	
	public Programme(String name, Mission mission) {
		this.name = name;
		this.mission = mission;
	}
}
