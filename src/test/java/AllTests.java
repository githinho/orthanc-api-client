import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import services.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ServiceTestSystemService.class,
        ServiceTestInstanceService.class,
        ServiceTestPatientService.class,
        ServiceTestSeriesService.class,
        ServiceTestStudyService.class })
public class AllTests {
}
