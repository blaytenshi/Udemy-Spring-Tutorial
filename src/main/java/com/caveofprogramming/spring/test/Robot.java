package com.caveofprogramming.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {
	private String id = "Default robot";
	private String speech = "hello";
	
	public void speak() {
		System.out.println(id + " : " + speech);
	}
	
	@Autowired
	public void setId(@Value("#{randomText.getText()?.length()}") String id) {
		this.id = id;
	}
	
	@Autowired
	// new java.util.Date().toString() // You can instantiate new java objects with SPEL
	// T(Math).PI // If you need to refer to something that's static, you need to surround it with T()
	// T(Math).sin(T(Math).PI/4) ^ 2 eq 0.8
	// T(Math).sin(T(Math).PI/4) ^ 2 lt 0.8
	// T(Math).sin(T(Math).PI/4) ^ 2 le 0.8
	// T(Math).sin(T(Math).PI/4) ^ 2 le 0.8 ? 'yes' : 'no'
	public void setSpeech(@Value("#{T(Math).sin(T(Math).PI/4) ^ 2 le 0.8 ? 'yes' : 'no'}") String speech) {
		this.speech = speech;
	}
}
