package com.niit.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProjectCommentPK implements Serializable {
    private int pid;
    private int uid;

    @Column(name = "Pid")
    @Id
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Column(name = "Uid")
    @Id
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectCommentPK that = (ProjectCommentPK) o;
        return pid == that.pid &&
                uid == that.uid;
    }

    @Override
    public int hashCode() {

        return Objects.hash(pid, uid);
    }
}
