package com.mrghz.jacksondemo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {

			// create object mapper
			ObjectMapper mapper = new ObjectMapper();

			// read JSON file and map it to Java POJO: data/sample.json
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);

			// print first name and last name
			System.out.println("First Name: " + theStudent.getFirstName());
			System.out.println("Last Name: " + theStudent.getLastName());
			System.out.println("Address: " + theStudent.getAddress());
			System.out.println("Languages: " + theStudent.getLanguages());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
