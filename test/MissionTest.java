import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class MissionTest extends UnitTest {

    @Before
    public void setup() {
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
}
