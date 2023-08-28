package techx.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
    public Response submitJob() {
        String jobId = UUID.randomUUID().toString();
        jobMap.put(jobId, new Job(jobId));

        executorService.execute(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            jobMap.get(jobId).setCompleted(true);
        });

        return Response.ok(jobId).build();
    }

    @GET
    @Path("/")
    public Response getAllJob() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jobMapJson = objectMapper.writeValueAsString(jobMap);
            return Response.ok(jobMapJson).build();
        } catch (JsonProcessingException e) {
            String errorMessage = "Error processing job data.";
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(errorMessage)
                    .build();
        }
    }

    @GET
    @Path("/{id}/status")
    public Response getJob(@PathParam("id") String jobId) {
        if (jobMap.containsKey(jobId)){
            Object jobStatus = jobMap.get(jobId);
            return Response.ok(jobStatus).build();
        } else {
            String errorMessage = "Job not found with ID: " + jobId;
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(errorMessage)
                    .build();
        }
    }
}
