package com.homework.cakebaker;

import com.homework.cakebaker.service.Frosting;
import com.homework.cakebaker.service.Syrup;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CakeBaker {

	private final Frosting frosting;
	private final Syrup syrup;

	public CakeBaker(Frosting frosting, Syrup syrup) {
		this.frosting = frosting;
		this.syrup = syrup;
	}

	public String bakeCake(){
		return "Baking a cake with " + frosting.getFrostingType() + " and "  + syrup.getSyrupType();
	}


	@PostConstruct
	public void init(){
		log.info("baker is ready");
	}

	@PreDestroy
	public void destroy(){
		log.info("baker is destroyed");
	}
}
