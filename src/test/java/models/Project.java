package models;

import java.util.Date;
import java.util.Objects;

public class Project {
    private String name;
    private String announcement;
    private boolean flag;
    private int projectType;
    public String getName() {
        return name;
    }
    public String getAnnouncement() {
        return announcement;
    }
    public boolean getFlag() {
        return flag;
    }
    public int getProjectType() {
        return projectType;
    }
    public String setName(String name) {
        return name;
    }
    public String setAnnouncement(String announcement) {
        return announcement;
    }
    public boolean setFlag(boolean flag) {
        return flag;
    }
    public int setProjectType(int projectType) {
        return projectType;
    }

    public static class Builder {
        private Project newProject;

        public Builder() {
            this.newProject = new Project();
        }
        public Builder withProjectName(String projectName) {
            this.newProject.name = projectName;
            newProject.name = projectName;
            return this;
        }

        public Builder withAnnouncement(String announcement) {
            this.newProject.announcement = announcement;
            newProject.announcement = announcement;
            return this;
        }

        public Project build() {
            return this.newProject;
        }
    }

}