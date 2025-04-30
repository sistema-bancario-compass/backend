package uol.compass.hackathon.Banking.System.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerTests {

    @Test
    void testCustomerBuilder() {
        Customer customer = Customer.builder()
                .id(1L)
                .name("John Doe")
                .cpf("12345678900")
                .build();

        assertNotNull(customer);
        assertEquals(1L, customer.getId());
        assertEquals("John Doe", customer.getName());
        assertEquals("12345678900", customer.getCpf());
    }

    @Test
    void testCustomerSettersAndGetters() {
        Customer customer = new Customer();
        customer.setId(2L);
        customer.setName("Jane Doe");
        customer.setCpf("09876543211");

        assertEquals(2L, customer.getId());
        assertEquals("Jane Doe", customer.getName());
        assertEquals("09876543211", customer.getCpf());
    }
}