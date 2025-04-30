package uol.compass.hackathon.Banking.System.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TransactionTests {

    @Test
    void testTransactionBuilder() {
        Transaction transaction = Transaction.builder()
                .id(1L)
                .type("deposit")
                .amount(100.0)
                .build();

        assertNotNull(transaction);
        assertEquals(1L, transaction.getId());
        assertEquals("deposit", transaction.getType());
        assertEquals(100.0, transaction.getAmount());
    }

    @Test
    void testTransactionSettersAndGetters() {
        Transaction transaction = new Transaction();
        transaction.setId(2L);
        transaction.setType("withdraw");
        transaction.setAmount(50.0);

        assertEquals(2L, transaction.getId());
        assertEquals("withdraw", transaction.getType());
        assertEquals(50.0, transaction.getAmount());
    }
}