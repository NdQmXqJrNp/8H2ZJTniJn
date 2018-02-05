package javahello.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import javahello.entity.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloAPITest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	HelloAPI c;

	// URLルートハンドラ
	// URLからアクセス出来る事を確認
	@Test
	public void testHello() {
		String expected = "hello";
		String actual = c.hello();
		assertEquals(expected, actual);
		String url = "http://localhost:" + port + "/";
		String response = this.restTemplate.getForObject(url, String.class);
		System.out.println(response);
		assertThat(response).contains(expected);
	}

	// URLからidを受け取り
	// DIされたIHelloService#findEmpを呼び出し
	// JSON返却する
	@Test
	public void testEmp() {
		Integer expected = 20;
		Emp e = c.emp(expected);
		assertEquals(expected, e.getId());
		String url = "http://localhost:" + port + "/emp/" + expected;
		String response = this.restTemplate.getForObject(url, String.class);
		System.out.println(response);
		String expectedJson = "\"id\":" + expected;
		assertThat(response).contains(expectedJson);
	}

}
