package uol.compass.hackathon.Banking.System.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountTests {

    @Test
    void testAccountBuilder() {
        Customer customer = Customer.builder().id(1L).build();
        Account account = Account.builder()
                .id(1L)
                .type("savings")
                .balance(1000.0)
                .status("active")
                .customer(customer)
                .build();

        assertNotNull(account);
        assertEquals(1L, account.getId());
        assertEquals("savings", account.getType());
        assertEquals(1000.0, account.getBalance());
        assertEquals("active", account.getStatus());
        assertEquals(customer, account.getCustomer());
    }

    @Test
    void testAccountSettersAndGetters() {
        Customer customer = new Customer();
        customer.setId(2L);

        Account account = new Account();
        account.setId(2L);
        account.setType("checking");
        account.setBalance(500.0);
        account.setStatus("inactive");
        account.setCustomer(customer);

        assertEquals(2L, account.getId());
        assertEquals("checking", account.getType());
        assertEquals(500.0, account.getBalance());
        assertEquals("inactive", account.getStatus());
        assertEquals(customer, account.getCustomer());
    }
}