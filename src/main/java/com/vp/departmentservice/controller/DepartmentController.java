package com.vp.departmentservice.controller;

import com.vp.departmentservice.entity.Department;
import com.vp.departmentservice.exception.ResourceNotFoundException;
import com.vp.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    private static final Logger log =
            LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    DepartmentService deptService;

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department dept) {
        log.info("--->In saveDepartment :: " + dept);
        Department department = deptService.saveDepartment(dept);
        log.info("--->Return saveDepartment :: " + department);
        return department;
    }

    @GetMapping("/get/{id}")
    public Optional<Department> getDepartment(@PathVariable Long id) {
        log.info("--->In getDepartment :: " + id);
        Optional<Department> department = deptService.getDepartment(id);
        log.info("--->Return getDepartment :: " + department);
        return department;
    }

    @PutMapping("/update")
    public Department updateDepartment(@RequestBody Department dept)throws ResourceNotFoundException {
        log.info("--->In updateDepartment :: " +dept);
        Department department = deptService.updateDepartment(dept);
        log.info("--->In updateDepartment :: " +dept);
        return department;
    }
}
