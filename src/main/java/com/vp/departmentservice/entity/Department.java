package com.vp.departmentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptId;
    private String deptName;
    private String deptAddress;
    private int deptCode;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }

    public int getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(int deptCode) {
        this.deptCode = deptCode;
    }
}
