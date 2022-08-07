package LuckyTickets;

import junit.framework.TestCase;
import org.junit.Assert;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LuckyTicketsCalculatorTest extends TestCase {
    public void testGetCountLuckyTickets() {
        for(int i = 0; i < 9; i++) {
            //Arrange
            var inFileName = String.format("Tests\\LuckyTickets\\LuckyTicketsCalculatorTestData\\test.%d.in", i);
            var outFileName = String.format("Tests\\LuckyTickets\\LuckyTicketsCalculatorTestData\\test.%d.out", i);

            long N = getNumberFromFile(inFileName);
            long resultFromFile = getNumberFromFile(outFileName);

            LuckyTicketsCalculator calc = new LuckyTicketsCalculator();

            //Act
            var resultCalculated = calc.getCountLuckyTickets(N);

            //Assert
            Assert.assertEquals(resultFromFile, resultCalculated);
        }
    }

    private long getNumberFromFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            return Long.parseLong(lines.get(0).trim());
        } catch (java.io.IOException e) {
            return 0;
        }
    }
}