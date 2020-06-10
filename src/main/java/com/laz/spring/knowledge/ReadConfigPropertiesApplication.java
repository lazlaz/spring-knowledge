package com.laz.spring.knowledge;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.laz.spring.knowledge.domain.LibraryProperties;

@SpringBootApplication	
public class ReadConfigPropertiesApplication implements InitializingBean {
	   private final LibraryProperties library;

	    public ReadConfigPropertiesApplication(LibraryProperties library) {
	        this.library = library;
	    }

	    public static void main(String[] args) {
	        SpringApplication.run(ReadConfigPropertiesApplication.class, args);
	    }

	    @Override
	    public void afterPropertiesSet() {
	        System.out.println(library.getLocation());
	        System.out.println(library.getBooks());    }
}
