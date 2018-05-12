package com.niit.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProjectCommentPK implements Serializable {
    private int pid;
    private String uPhone;

    @Column(name = "Pid")
    @Id
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Column(name = "UPhone")
    @Id
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
        ProjectCommentPK that = (ProjectCommentPK) o;
        return pid == that.pid &&
                Objects.equals(uPhone, that.uPhone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pid, uPhone);
    }
}
