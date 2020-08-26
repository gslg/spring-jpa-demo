package com.aiidc.hibernate.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "person")
@Entity
@Getter
@Setter
public class Person extends BaseIDEntity {

    private String name;

    private Integer age;

    private String profile;

    private LocalDateTime createTime;
}
