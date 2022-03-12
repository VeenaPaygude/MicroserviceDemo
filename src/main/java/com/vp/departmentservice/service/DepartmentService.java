package com.vp.departmentservice.service;

import com.vp.departmentservice.controller.DepartmentController;
import com.vp.departmentservice.dao.DepartmentDao;
import com.vp.departmentservice.entity.Department;
import com.vp.departmentservice.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

    private static final Logger log =
            LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentDao deptDao;

    public Department saveDepartment(Department dept) {
        return deptDao.save(dept);

    }

    public Optional<Department> getDepartment(Long deptId) {
        return deptDao.findById(deptId);
    }

    public Department updateDepartment(Department dept) throws ResourceNotFoundException{

        Department department=deptDao.findById(dept.getDeptId()).orElseThrow(()->new ResourceNotFoundException(dept.getDeptId()+" Not Found..."));
        log.info("Department fetch for id "+dept.getDeptId()+" :: "+department);
        department.setDeptName(dept.getDeptName());
        department.setDeptAddress(dept.getDeptAddress());
        department.setDeptCode(dept.getDeptCode());
        log.info("Department Updated!!!");
        return deptDao.save(department);
    }
}
