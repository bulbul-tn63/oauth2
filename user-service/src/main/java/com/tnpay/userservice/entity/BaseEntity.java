package com.tnpay.userservice.entity;



import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;


import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(updatable = false)
    private LocalDateTime updatedAt;

    @Column(updatable = false ,nullable = false)
    @CreatedBy
    public Long createBy;

    @Column(nullable = false)
    @LastModifiedBy
    public Long updateBy;

    @Column(name = "is_active", columnDefinition = "bit default 1", nullable = false)
    private Boolean isActive = true;


}