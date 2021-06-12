package io.codingdojo.bankaccount;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankAccountApplicationTests {

	@Test
	void contextLoads() {
		BankAccount chase = new BankAccount();
		chase.displayAccounts();
		chase.depositCheckings(500);
		chase.depositSavings(750);
		chase.displayAccounts();
	}

}
