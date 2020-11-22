package com.cj.springdatajpa.secification.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_department")
@Data
@NoArgsConstructor
public class Department {

  @Id
  private Integer id;

  private String name;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id")
  private List<Employee> employees;

}
