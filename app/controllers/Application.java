package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	@Before
	static void addDefaults() {
	    renderArgs.put("siteTitle", Play.configuration.getProperty("site.title"));
	    renderArgs.put("siteBaseline", Play.configuration.getProperty("site.baseline"));
	}
	
    public static void index() {
    	List<Mission> missions = Mission.find("order by name asc").fetch();
        render(missions);
    }

}