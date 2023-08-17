package com.tnpay.userservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tnpay.userservice.constant.ERole;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {
  @Id
  private Integer id;
  private String roleName;
  @Column(name = "is_active", columnDefinition="bit default 1", nullable = false)
  private Boolean isActive = true;

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (!(object instanceof Role)) return false;
    return this.getId() != 0 && this.getId().equals(((Role) object).getId());
  }

  @Override
  public int hashCode() {
    if (Objects.isNull(this.getId())) {
      return this.getClass().hashCode();
    }
    return this.getId().hashCode();
  }

}