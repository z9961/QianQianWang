package com.niit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ProjectImg {
    private int imgId;
    private Integer pid;
    private String imgPath;
    private Project projectByPid;

    @Id
    @Column(name = "ImgId")
    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    @Basic
    @Column(name = "Pid")
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "ImgPath")
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectImg that = (ProjectImg) o;
        return imgId == that.imgId &&
                Objects.equals(pid, that.pid) &&
                Objects.equals(imgPath, that.imgPath);
    }

    @Override
    public int hashCode() {

        return Objects.hash(imgId, pid, imgPath);
    }

    @ManyToOne
    @JoinColumn(name = "Pid", referencedColumnName = "PId")
    public Project getProjectByPid() {
        return projectByPid;
    }

    public void setProjectByPid(Project projectByPid) {
        this.projectByPid = projectByPid;
    }
}
