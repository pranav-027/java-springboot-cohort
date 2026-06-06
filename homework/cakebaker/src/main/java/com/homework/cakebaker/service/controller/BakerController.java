package com.homework.cakebaker.service.controller;


import com.homework.cakebaker.CakeBaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class BakerController {

	private final CakeBaker cakeBaker;

	public BakerController(CakeBaker cakeBaker) {
		this.cakeBaker = cakeBaker;
	}


	@GetMapping("bake-cake/")
	public String bakeCake() {
		return cakeBaker.bakeCake();
	}

}
