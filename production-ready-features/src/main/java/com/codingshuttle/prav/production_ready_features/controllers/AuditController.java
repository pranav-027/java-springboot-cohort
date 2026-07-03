package com.codingshuttle.prav.production_ready_features.controllers;

import com.codingshuttle.prav.production_ready_features.entities.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/audit")
public class AuditController {


	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@GetMapping("/{postId}")
	public List<PostEntity> getAuditEntries(@PathVariable Long postId) {
		AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
		List<Number> revs = reader.getRevisions(PostEntity.class, postId);

		return revs.stream().
				map(revNum -> reader.find(PostEntity.class, postId, revNum))
				.toList();

	}


}
