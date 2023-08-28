package techx;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import techx.resources.JobResource;

import java.util.HashMap;

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
        JobResource resource = new JobResource(new HashMap<>());
        environment.jersey().register(resource);

    }

}
