package com.oybek.rest.webservices.restwebservices.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerisoningClassController {
	
@GetMapping("/v1/person")
public Person1 getPersonVersion1() {
	return new Person1("Bob Jackson");
}

@GetMapping("/v2/person")
public Person2 getPersonVersion2() {
	return new Person2("Bob", "Jackson");
}

}
