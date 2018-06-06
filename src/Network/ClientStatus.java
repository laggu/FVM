package Network;

import java.io.Serializable;

public class ClientStatus implements Serializable {
    private String id;
    private String project;
    private String branch;
    private int version;

    public ClientStatus(String id, String project, String branch, int version) {
        this.id = id;
        this.project = project;
        this.branch = branch;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
