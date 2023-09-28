package com.turkcell.spring.starter;

import com.turkcell.spring.starter.business.exceptions.BusinessException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	// Global Exception Handling

	// exception fırlayabilir
	// runtime exception -> kod çalışırken fırlayan hatalar

	// global noktalarda yakalayıp


	// uygulamanın neresinde olursa olsun runtime exceptionlarını yakalamak için kullandığımız yöntem..

}

