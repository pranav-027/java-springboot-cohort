package com.codingshuttle.prav.production_ready_features.entities;

import jakarta.persistence.Access;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Audited
public class AuditLineEntity {


	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	@CreatedBy
	private String createBy;

	@LastModifiedBy
	private String updatedBy;


}
