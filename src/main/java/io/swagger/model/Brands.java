package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "brands")
public class Brands {

  @Id
  @Column(nullable = false)
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
  @GenericGenerator(name = "native", strategy = "native")
  private Integer id;

  @NotBlank(message="Brand Name must not be blank")
  @Column(nullable = false)
  private String name;

}
