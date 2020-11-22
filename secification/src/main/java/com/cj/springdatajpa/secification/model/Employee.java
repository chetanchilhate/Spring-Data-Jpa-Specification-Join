package com.cj.springdatajpa.secification.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_employee")
@Data
@NoArgsConstructor
public class Employee {

  @Id
  private Integer id;

  private String name;

}
