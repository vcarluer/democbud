package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Mission extends Model {
	public String name;
	
	public Mission(String name) {
		this.name = name;
	}
}