package org.example.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

  public static void main(String[] args) {
    try {
      // create object mapper
      ObjectMapper mapper = new ObjectMapper();

      // read JSON file and map/convert Java POJO
      // data/sample-full.json
      Student student = mapper.readValue(
        new File("data/sample-full.json"),
        Student.class
      );

      // print first name and last name
      System.out.println("First name: " + student.getFirstName());
      System.out.println("Last name: " + student.getLastName());

      // print out address: street and city
      Address address = student.getAddress();

      System.out.println("Street: " + address.getStreet());
      System.out.println("City: " + address.getCity());

      // print out languages
      System.out.println("Languages: ");
      for (String lang : student.getLanguages()) {
        System.out.println("  " + lang);
      }
    }
    catch (Exception exc) {
      exc.printStackTrace();
    }

  }

}
