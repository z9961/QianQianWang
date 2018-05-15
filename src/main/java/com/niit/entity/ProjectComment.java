package com.niit.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class ProjectComment {
    private int pcId;
    private Timestamp pcTime;
    private String pComment;
    private Project projectByCPid;
    private Users usersByUPhone;

    @Id
    @Column(name = "PCId")
    public int getPcId() {
        return pcId;
    }

    public void setPcId(int pcId) {
        this.pcId = pcId;
    }

    @Basic
    @Column(name = "PCTime")
    public Timestamp getPcTime() {
        return pcTime;
    }

    public void setPcTime(Timestamp pcTime) {
        this.pcTime = pcTime;
    }

    @Basic
    @Column(name = "PComment")
    public String getpComment() {
        return pComment;
    }

    public void setpComment(String pComment) {
        this.pComment = pComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectComment that = (ProjectComment) o;
        return pcId == that.pcId &&
                Objects.equals(pcTime, that.pcTime) &&
                Objects.equals(pComment, that.pComment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pcId, pcTime, pComment);
    }

    @ManyToOne
    @JoinColumn(name = "CPid", referencedColumnName = "PId")
    public Project getProjectByCPid() {
        return projectByCPid;
    }

    public void setProjectByCPid(Project projectByCPid) {
        this.projectByCPid = projectByCPid;
    }

    @ManyToOne
    @JoinColumn(name = "UPhone", referencedColumnName = "UPhone")
    public Users getUsersByUPhone() {
        return usersByUPhone;
    }

    public void setUsersByUPhone(Users usersByUPhone) {
        this.usersByUPhone = usersByUPhone;
    }
}
