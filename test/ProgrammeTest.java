import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import models.Mission;
import models.Programme;

import org.junit.Before;
import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;


public class ProgrammeTest extends UnitTest {

	@Before
	public void setUp() throws Exception {
		Fixtures.deleteDatabase();
	}
	
	@Test
	public void CreateTest() {
		Mission mission = new Mission("m").save();
		String progName = "Programme";
		new Programme(progName, mission).save();
		
		assertEquals(1, Programme.count());
		
		List<Programme> programmes = Programme.find("byMission", mission).fetch();
		assertEquals(programmes.size(), 1);
		Programme programme = programmes.get(0);
		assertNotNull(programme);
		assertEquals(progName, programme.name);
	}
}
