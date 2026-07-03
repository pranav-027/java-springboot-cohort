package com.codingshuttle.prav.production_ready_features.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
@Getter
@Setter
@Audited
public class PostEntity extends AuditLineEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String description;

}
