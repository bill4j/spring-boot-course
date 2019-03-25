package com.dynamic.bill4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootTestNGShowcaseApplicationTests extends AbstractTestNGSpringContextTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testHome() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("/helloTestNG", String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).isEqualTo("hello TestNG !");
	}
}
