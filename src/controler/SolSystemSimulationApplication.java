package controler;

import hochberger.utilities.application.ApplicationProperties;
import hochberger.utilities.application.BasicLoggedApplication;
import hochberger.utilities.application.session.BasicSession;
import hochberger.utilities.eventbus.SimpleEventBus;

public class SolSystemSimulationApplication extends BasicLoggedApplication {

    private final BasicSession session;

    public SolSystemSimulationApplication(final ApplicationProperties applicationProperties) {
        super();
        this.session = new BasicSession(applicationProperties, new SimpleEventBus(), getLogger());

        // try {
        // final String file = ClassLoader.getSystemResource("data/sol-system.xml").getFile();
        // final File data = new File(file);
        // final var documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        // final var document = documentBuilder.parse(data);
        // document.getDocumentElement().normalize();
        // System.out.println(document.getDocumentElement().getNodeName());
        // } catch (final ParserConfigurationException e) {
        // logger().fatal(e);
        // } catch (final SAXException e) {
        // logger().fatal(e);
        // } catch (final IOException e) {
        // logger().fatal(e);
        // }

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
    }

    @Override
    public void stop() {
        super.stop();
    }
}
