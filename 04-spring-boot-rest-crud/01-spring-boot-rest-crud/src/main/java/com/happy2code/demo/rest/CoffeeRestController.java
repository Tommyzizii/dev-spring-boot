package com.happy2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happy2code.demo.entity.Coffee;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class CoffeeRestController {

	private List<Coffee> myCoffee = new ArrayList<>();

	@PostConstruct
	public void loadData() {
		myCoffee.add(new Coffee("Signature Iced Coffee", "True", "50%"));
		myCoffee.add(new Coffee("Signature Iced Coffee", "Punthai", "25%"));
		myCoffee.add(new Coffee("Iced Latte", "Hugo Brew", "50%"));

	}

	@GetMapping("/coffee")
	public List<Coffee> getCoffee() {
		return myCoffee;
	}

	@GetMapping("/coffee/{coffeeId}")
	public Coffee getTheCoffee(@PathVariable int coffeeId) {

		if (coffeeId >= myCoffee.size() || coffeeId < 0) {
			throw new CoffeeNotFoundException("Coffee id not found - " + coffeeId);
		}

		return myCoffee.get(coffeeId);
	}

}
