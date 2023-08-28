package techx.resources;

import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(DropwizardExtensionsSupport.class)
class JobResourceTest {

    private static final ResourceExtension EXT = ResourceExtension.builder()
            .addResource(new JobResource(new HashMap<>())).build();

    @Test
    void testSubmitJob() {
        Response response = EXT.target("/job/submit").request().post(null);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
    @Test
    public void testGetAllJob() {
        Response response = EXT.target("/job/").request().get();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testGetJobStatus() {
        Response responseJob = EXT.target("/job/submit").request().post(null);
        String jobId = responseJob.readEntity(String.class);
        Response response = EXT.target("/job/" + jobId + "/status").request().get();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testGetJobStatusNotFound() {
        Response response = EXT.target("/job/nonExistentId/status").request().get();
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }
}
