package models;

import java.util.Date;
import java.util.Objects;

public class Project {
    private String name;
    private String announcement;
    public String getName() {
        return name;
    }
    public String getAnnouncement() {
        return announcement;
    }

    public static class Builder {
        private Project newProject;

        public Builder() {
            this.newProject = new Project();
        }
        public Builder withProjectName(String projectName) {
            newProject.name = projectName;
            return this;
        }

        public Builder withAnnouncement(String announcement) {
            newProject.announcement = announcement;
            return this;
        }

        public Project build() {
            return newProject;
        }
    }

}