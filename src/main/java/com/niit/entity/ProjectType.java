package com.niit.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class ProjectType {
    private int projectTypeId;
    private String projectTypeName;
    private Collection<Project> projectsByProjectTypeId;

    @Id
    @Column(name = "ProjectTypeId")
    public int getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(int projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    @Basic
    @Column(name = "ProjectTypeName")
    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectType that = (ProjectType) o;
        return projectTypeId == that.projectTypeId &&
                Objects.equals(projectTypeName, that.projectTypeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(projectTypeId, projectTypeName);
    }

    @OneToMany(mappedBy = "projectTypeByPCategoryId")
    public Collection<Project> getProjectsByProjectTypeId() {
        return projectsByProjectTypeId;
    }

    public void setProjectsByProjectTypeId(Collection<Project> projectsByProjectTypeId) {
        this.projectsByProjectTypeId = projectsByProjectTypeId;
    }
}
