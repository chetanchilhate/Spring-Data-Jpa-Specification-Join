package com.cj.springdatajpa.secification.controller;

import javax.persistence.criteria.JoinType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cj.springdatajpa.secification.model.Department;
import com.cj.springdatajpa.secification.repository.DepartmentRepository;

@RestController
public class HomeController {

  @Autowired
  private DepartmentRepository repository;

  @GetMapping("/departments")
  public Page<Department> getDepartments() {

    Specification<Department> spec1 = (root, query, cb) -> {
      root.fetch("employees", JoinType.INNER);
      return null;
    };
    
    Specification<Department> spec2 = (root, query, cb) -> {
      return cb.equal(root.get("name"), "IT");
    };
    

    Pageable pageable = PageRequest.of(0, 10);

    return repository.findAll(Specification.where(spec1).and(spec2), pageable);

  }

}
