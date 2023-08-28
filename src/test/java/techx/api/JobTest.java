package techx.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static io.dropwizard.jackson.Jackson.newObjectMapper;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class JobTest {
    private static final ObjectMapper MAPPER = newObjectMapper();

    @Test
    void seralizesToJSON() throws Exception {
        final Job job = new Job("1");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(getClass().getResource("/fixtures/job.json"), Job.class));

        assertThat(MAPPER.writeValueAsString(job)).isEqualTo(expected);
    }
}
