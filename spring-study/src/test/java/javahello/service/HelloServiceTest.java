package javahello.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javahello.entity.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {

	@Autowired
	IHelloService service;

	// BindされたEmpDaoへIDを指定しEntityを受け取る
	// 受け取ったidが2^n −1の時はEntityのNameに値を設定し返却する
	// ↑どんな方式でも良いけどloopとifが書けること
	@Test
	public void testFindEmp() {
		{
			Integer expected = 2;
			Emp e = service.findEmp(expected);
			assertNull(e.getName());
			assertEquals(expected, e.getId());

		}
		{
			Integer expected = 3;
			Emp e = service.findEmp(expected);
			assertNotNull(e.getName());
			assertEquals(expected, e.getId());

		}

	}

	// testHelloService#getAOPValueのリターンをAOPで差し替え
	// コード上はnopのnull返却でinterceptorで返却差し替え
	@Test
	public void testGetAOPValue() {
		Integer actual = service.getAOPValue();
		assertNotNull(actual);
	}

}
