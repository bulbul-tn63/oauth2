package com.tnpay.userservice.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.tnpay.userservice.exception.PsoServerException;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public enum ERole {
  SUPER_ADMIN(1),
  ADMIN(2),
  MERCHANT_USER(3),
  USER(4);

  private final Integer id;

  ERole(Integer id) {
    this.id = id;
  }

  @JsonValue
  public Integer getId() {
    return this.id;
  }

  private static final Map<Integer, ERole> eRoleMap = new HashMap<>();

  static {
    for (ERole d : ERole.values()) {
      eRoleMap.put(d.getId(), d);
    }
  }

  @JsonCreator
  public static ERole create(Integer id) {
    if (!eRoleMap.containsKey(id)) {
      throw new PsoServerException(
              ErrorId.INVALID_ROLE, HttpStatus.BAD_REQUEST, MDC.get(ApplicationConstant.TRACE_ID));
    }
    return eRoleMap.get(id);
  }
}
