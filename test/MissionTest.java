import java.util.List;

import models.Mission;
import models.Programme;

import org.junit.Before;
import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;

public class MissionTest extends UnitTest {

    @Before
    public void setUp() throws Exception {
        Fixtures.deleteDatabase();
    }
	
	@Test
	public void MissionCreateTest() {
		String missionName = "missionTest";
		new Mission(missionName).save();
		Mission mission = Mission.find("byName", missionName).first();
		assertNotNull(mission);
		assertEquals(missionName, mission.name);
	}
	
	@Test
	public void AddProgrammeTest() {
		String progName = "Programme";
		String misName = "Mission";
		Mission mission = new Mission(misName);
		mission.addProgramme(progName);
		mission.save();
		
		Mission mis = Mission.find("byName", misName).first();
		assertNotNull(mis);
		assertEquals(misName, mis.name);
		assertEquals(1, Programme.count());
		List<Programme> progMis = Programme.find("byMission", mission).fetch();
		assertEquals(1, progMis.size());
		Programme prog = progMis.get(0);
		assertNotNull(prog);
		assertEquals(progName, prog.name);
	}
	
	@Test
	public void MiniModelTest() {
		Fixtures.loadModels("data.yml");
		
		assertEquals(2, Mission.count());
		assertEquals(3, Programme.count());
		
		Mission m2 = Mission.find("byName", "Mission2").first();
		assertNotNull(m2);
		assertEquals(2, m2.programmes.size());
	}
}