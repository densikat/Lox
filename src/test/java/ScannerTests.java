import com.craftinginterpreters.lox.Scanner;
import com.craftinginterpreters.lox.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ScannerTests {

    @Test
    public void scanTokenTest() {
        String s = """
                // Comment
                a(){}
                true
                false
                and
                /* abcd
                peewee
                */"test"
                1234
                3.1234
                ;
                !=""";
        Scanner scanner = new Scanner(s);
        scanner.scanTokens();
        List<Token> tokens = scanner.getTokens();
        Assertions.assertEquals(tokens.get(0).toString(), "IDENTIFIER a null");
        Assertions.assertEquals(tokens.get(1).toString(), "LEFT_PAREN ( null");
        Assertions.assertEquals(tokens.get(2).toString(), "RIGHT_PAREN ) null");
        Assertions.assertEquals(tokens.get(3).toString(), "LEFT_BRACE { null");
        Assertions.assertEquals(tokens.get(4).toString(), "RIGHT_BRACE } null");
        Assertions.assertEquals(tokens.get(5).toString(), "TRUE true null");
        Assertions.assertEquals(tokens.get(6).toString(), "FALSE false null");
        Assertions.assertEquals(tokens.get(7).toString(), "AND and null");
        Assertions.assertEquals(tokens.get(8).toString(), "STRING \"test\" test");
        Assertions.assertEquals(tokens.get(9).toString(), "NUMBER 1234 1234.0");
        Assertions.assertEquals(tokens.get(10).toString(), "NUMBER 3.1234 3.1234");
        Assertions.assertEquals(tokens.get(11).toString(), "SEMICOLON ; null");
        Assertions.assertEquals(tokens.get(12).toString(), "BANG_EQUAL != null");
    }
}
