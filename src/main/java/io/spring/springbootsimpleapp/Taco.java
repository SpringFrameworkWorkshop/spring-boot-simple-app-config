package io.spring.springbootsimpleapp;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Taco {
    @Id
    private Long id;
    private String name;
}
