package TECHX;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class TechXApplication extends Application<TechXConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TechXApplication().run(args);
    }

    @Override
    public String getName() {
        return "TechX";
    }

    @Override
    public void initialize(final Bootstrap<TechXConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final TechXConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
