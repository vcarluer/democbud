import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

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
}
