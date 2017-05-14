import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import services.*;

/**
 * Created by eugen on 14/05/2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ServiceTestSystemService.class,
        ServiceTestInstanceService.class,
        ServiceTestPatientService.class,
        ServiceTestSeriesService.class,
        ServiceTestStudyService.class })
public class AllTests {
}
