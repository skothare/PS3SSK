package CISC181.Week3.Package4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 

public class CheckingAccountTest{
	
	
	Account account = new Account(1122, 20000);
	
	CheckingAccount c;
	
	
	@Before
	public void setUp() throws Exception {
		c = new CheckingAccount(101);
		account.setAnnualInterestRate(0.045);
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}
	/**
	 * 
	 * @throws InsufficientFundsException
	 */
	@Test(expected=InsufficientFundsException.class)
	public final void testwithdraw() throws InsufficientFundsException {
		c.deposit(500.00);
		assertEquals("$400 Expected, actual is $500",(long)c.getBalance(),(long)500.00);
        c.withdraw(900);
	}

	@Test
	public final void testDeposit() {
		int x = 0;
		
		while (x < 20) {
			c.deposit(1000000000);
			x++;  // Had to be incremented to end the infinite loop. Didn't have it before.
		}
	}

	
	
	/**
	 * Tests if the withdraw method successfully withdraws from the account and updates it.
	 * @throws InsufficientFundsException
	 */
	@Test
	public final void testWithdraw() throws InsufficientFundsException{
		
		assertTrue(account.getBalance() - 2500.00 == account.withdraw(2500.00));
		System.out.println(account.getBalance());
		System.out.println(account.getMonthlyInterestRate());
		System.out.println(account.getDateCreated());
	}
	
	@Test
	public final void testGetBalance() throws InsufficientFundsException{
		assertTrue(account.getBalance() == account.withdraw(0));
	}
	

	@Test
	public final void testdeposit() {
		
		assertTrue(account.getBalance() + 3000.00 == account.deposit(3000.00));	
	}
	
	@Test
	public final void testGetNumber() {
		assertFalse( account.getId() == 1112 );
	}

}
