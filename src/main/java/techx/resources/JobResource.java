package techx.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import techx.api.Job;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Path("/job")
@Produces(MediaType.APPLICATION_JSON)
public class JobResource {
    private final Map<String, Job> jobMap;
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public JobResource(Map<String, Job> jobMap) {
        this.jobMap = jobMap;
    }

    @POST
    @Path("/submit")
    public String submitJob() {
        String jobId = UUID.randomUUID().toString();
        jobMap.put(jobId, new Job(jobId));

        executorService.execute(() -> {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            jobMap.get(jobId).setCompleted(true);
        });

        return jobId;
    }

    @GET
    @Path("/")
    public String getAllJob() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jobMap);
    }

    @GET
    @Path("/{id}/status")
    public Job getJob(@PathParam("id") String jobId) {
        return jobMap.getOrDefault(jobId, new Job());
    }
}
