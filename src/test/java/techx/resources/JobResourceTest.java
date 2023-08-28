package techx.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import techx.api.Job;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(DropwizardExtensionsSupport.class)
class JobResourceTest {
    private JobResource jobResource;
    private Map<String, Job> jobMap;

    @BeforeEach
    void setup() {
        jobMap = new HashMap<>();
        jobResource = new JobResource(jobMap);
    }

    @Test
    void testSubmitJob() {
        String jobId = jobResource.submitJob();
        assertTrue(jobMap.containsKey(jobId));
    }

    @Test
    void testGetAllJob() throws JsonProcessingException {
        String jobId1 = jobResource.submitJob();
        String jobId2 = jobResource.submitJob();

        String response = jobResource.getAllJob();
        assertNotNull(response);
        assertTrue(response.contains(jobId1));
        assertTrue(response.contains(jobId2));
    }

    @Test
    void testGetJobStatus() {
        String jobId1 = jobResource.submitJob();
        Job jobStatus = jobResource.getJob(jobId1);

        assertNotNull(jobStatus);
        assertFalse(jobStatus.getCompleted());
    }
}