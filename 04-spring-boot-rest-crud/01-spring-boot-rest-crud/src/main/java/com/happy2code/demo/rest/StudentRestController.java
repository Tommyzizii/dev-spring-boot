package com.happy2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happy2code.demo.entity.Coffee;


@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/coffee")
	public List<Coffee> getCoffee(){
	
		List<Coffee> myCoffee = new ArrayList();
		
		myCoffee.add(new Coffee("Signature Iced Coffee", "True", "50%"));
		myCoffee.add(new Coffee("Signature Iced Coffee", "Punthai", "25%"));
		myCoffee.add(new Coffee("Iced Latte", "Hugo Brew", "50%"));
		
		return myCoffee;
	}
}
