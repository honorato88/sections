package io.csce741;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.csce741.controller.Extractor;

@SpringBootApplication
public class SectionApiApp {
	public static void main(String[] args) {
		try {
			Extractor.extractData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		SpringApplication.run(SectionApiApp.class, args);
	}
}
