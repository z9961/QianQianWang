package com.niit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(ProjectCommentPK.class)
public class ProjectComment {
    private int pid;
    private String pComment;
    private String uPhone;

    @Id
    @Column(name = "Pid")
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "PComment")
    public String getpComment() {
        return pComment;
    }

    public void setpComment(String pComment) {
        this.pComment = pComment;
    }

    @Id
    @Column(name = "UPhone")
    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectComment that = (ProjectComment) o;
        return pid == that.pid &&
                Objects.equals(pComment, that.pComment) &&
                Objects.equals(uPhone, that.uPhone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pid, pComment, uPhone);
    }
}
