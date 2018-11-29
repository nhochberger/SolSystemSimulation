package controler;

import hochberger.utilities.application.ApplicationProperties;
import hochberger.utilities.application.BasicLoggedApplication;
import hochberger.utilities.application.session.BasicSession;
import hochberger.utilities.eventbus.SimpleEventBus;
import model.CelestialBody;

public class SolSystemSimulationApplication extends BasicLoggedApplication {

	private final BasicSession session;

	public SolSystemSimulationApplication(final ApplicationProperties applicationProperties) {
		super();
		this.session = new BasicSession(applicationProperties, new SimpleEventBus(), getLogger());
	}

	public static void main(final String[] args) {

		setUpLoggingServices(SolSystemSimulationApplication.class);
		try {
			final ApplicationProperties applicationProperties = new ApplicationProperties();
			final SolSystemSimulationApplication application = new SolSystemSimulationApplication(applicationProperties);
			application.start();
		} catch (final Exception e) {
			getLogger().fatal("Error while starting application. Shutting down.", e);
			System.exit(0);
		}
	}

	@Override
	public void start() {
		super.start();
		var sun = new CelestialBody("sun", 696_342, 0, 0, 0, 0, 0, 0, 609.12);
		sun.addChild(new CelestialBody("mercury", 4_879.4, 57_909_050, 0.205_630, 48.331, 7.005, 29.124, 174.796, 1_407.5));
		sun.addChild(new CelestialBody("venus", 6_051.8, 108_208_000, 0.006_772, 76.680, 3.394_58, 3.394_5, 50.115, -5_832.6));
		var earth = new CelestialBody("earth", 6_371.0, 149_598_023, 0.016_708_6, -11.260_64, 7.155, 114.207_83, 358.617, 23.934_472_32);
		sun.addChild(earth);
		earth.addChild(new CelestialBody("luna", 1_737.1, 384_399, 0.054_9, 0, 5.145, 0, 0, 655.719_864));
		var mars = new CelestialBody("mars", 3_389.5, 227_939_200, 0.093_4, 49.558, 1.850, 286.502, 320.457_76, 24.622_968);
		sun.addChild(mars);
		mars.addChild(new CelestialBody("phobos", 11.266_7, 9_376, 0.015_1, 0, 26.04, 0, 0, 7.653_845_52));
		mars.addChild(new CelestialBody("deimos", 6.2, 23_463.2, 0.000_33, 0, 0.93, 0, 0, 30.312));
	}

	@Override
	public void stop() {
		super.stop();
	}
}
