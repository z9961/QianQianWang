package com.niit.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Project {
    private int pId;
    private String pName;
    private String pDesc;
    private Timestamp psd;
    private Timestamp ped;
    private BigDecimal pTarget;
    private BigDecimal pnm;
    private Integer pnp;
    private String pMilestone;
    private String pRemark;
    private Integer pmf;
    private Integer pLimit;
    private String pTeam;
    private Integer pState;
    private String pPlan;

    @Id
    @Column(name = "PId")
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    @Basic
    @Column(name = "PName")
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Basic
    @Column(name = "PDesc")
    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    @Basic
    @Column(name = "PSD")
    public Timestamp getPsd() {
        return psd;
    }

    public void setPsd(Timestamp psd) {
        this.psd = psd;
    }

    @Basic
    @Column(name = "PED")
    public Timestamp getPed() {
        return ped;
    }

    public void setPed(Timestamp ped) {
        this.ped = ped;
    }

    @Basic
    @Column(name = "PTarget")
    public BigDecimal getpTarget() {
        return pTarget;
    }

    public void setpTarget(BigDecimal pTarget) {
        this.pTarget = pTarget;
    }

    @Basic
    @Column(name = "PNM")
    public BigDecimal getPnm() {
        return pnm;
    }

    public void setPnm(BigDecimal pnm) {
        this.pnm = pnm;
    }

    @Basic
    @Column(name = "PNP")
    public Integer getPnp() {
        return pnp;
    }

    public void setPnp(Integer pnp) {
        this.pnp = pnp;
    }

    @Basic
    @Column(name = "PMilestone")
    public String getpMilestone() {
        return pMilestone;
    }

    public void setpMilestone(String pMilestone) {
        this.pMilestone = pMilestone;
    }

    @Basic
    @Column(name = "PRemark")
    public String getpRemark() {
        return pRemark;
    }

    public void setpRemark(String pRemark) {
        this.pRemark = pRemark;
    }

    @Basic
    @Column(name = "PMF")
    public Integer getPmf() {
        return pmf;
    }

    public void setPmf(Integer pmf) {
        this.pmf = pmf;
    }

    @Basic
    @Column(name = "PLimit")
    public Integer getpLimit() {
        return pLimit;
    }

    public void setpLimit(Integer pLimit) {
        this.pLimit = pLimit;
    }

    @Basic
    @Column(name = "PTeam")
    public String getpTeam() {
        return pTeam;
    }

    public void setpTeam(String pTeam) {
        this.pTeam = pTeam;
    }

    @Basic
    @Column(name = "PState")
    public Integer getpState() {
        return pState;
    }

    public void setpState(Integer pState) {
        this.pState = pState;
    }

    @Basic
    @Column(name = "PPlan")
    public String getpPlan() {
        return pPlan;
    }

    public void setpPlan(String pPlan) {
        this.pPlan = pPlan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return pId == project.pId &&
                Objects.equals(pName, project.pName) &&
                Objects.equals(pDesc, project.pDesc) &&
                Objects.equals(psd, project.psd) &&
                Objects.equals(ped, project.ped) &&
                Objects.equals(pTarget, project.pTarget) &&
                Objects.equals(pnm, project.pnm) &&
                Objects.equals(pnp, project.pnp) &&
                Objects.equals(pMilestone, project.pMilestone) &&
                Objects.equals(pRemark, project.pRemark) &&
                Objects.equals(pmf, project.pmf) &&
                Objects.equals(pLimit, project.pLimit) &&
                Objects.equals(pTeam, project.pTeam) &&
                Objects.equals(pState, project.pState) &&
                Objects.equals(pPlan, project.pPlan);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pId, pName, pDesc, psd, ped, pTarget, pnm, pnp, pMilestone, pRemark, pmf, pLimit, pTeam, pState, pPlan);
    }
}
