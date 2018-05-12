package com.niit.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ProjectImg {
    private int imgId;
    private String imgPath;

    @Id
    @Column(name = "ImgId")
    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
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
                Objects.equals(imgPath, that.imgPath);
    }

    @Override
    public int hashCode() {

        return Objects.hash(imgId, imgPath);
    }
}
