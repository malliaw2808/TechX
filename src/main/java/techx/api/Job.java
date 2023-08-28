package techx.api;

public class Job {
    private String id;
    private Boolean completed;

    public Job() {

    }

    public Job(String id) {
        this.id = id;
        this.completed = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
