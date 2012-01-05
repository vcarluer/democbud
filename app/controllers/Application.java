package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	List<Mission> missions = Mission.find("order by name asc").fetch();
        render(missions);
    }

}