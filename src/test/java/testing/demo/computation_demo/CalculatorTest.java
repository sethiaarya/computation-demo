package testing.demo.computation_demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTest {
	
	Calculator calculator;
	
	@BeforeEach
	void setup() {
		calculator = new Calculator();
	}
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("[Before All] Calculator Test starting ... by Aarya");
		
	}
	
	@AfterAll
	static void afterAll() {
		 System.out.println("[After All] completed tests by Aarya");
	}

	@ParameterizedTest
	@MethodSource("addData")
	public void addData(int input1, int input2, int expected) {
		System.out.println();
		System.out.println("[Before Each] Starting Test: " + input1 + " + " + input2);
		assertEquals(expected, calculator.add(input1, input2));
		System.out.println("[After Each] Finished Test: " + input1 + " + " + input2 + " = " + expected);
		
	}
	
	
	static Stream<Arguments> addData() {
		
		return Stream.of(
				Arguments.of(100, 2, 102),
				Arguments.of(100, -2, 98),
				Arguments.of(-100, 2, -98),
				Arguments.of(-100, -2, -102)
				);
		
	}
	
	// Subtract Test using @CsvSource
	@ParameterizedTest
	@CsvSource({
		"100, 2, 98",
        "100, -2, 102",
        "-100, 2, -102",
        "-100, -2, -98"
	})
	
	public void testSubtract(int input1, int input2, int expected) {
		System.out.println();
		System.out.println("[Before Each] Starting Test: " + input1 + " - " + input2);
		assertEquals(expected, calculator.substract(input1, input2));
		System.out.println("[After Each] Finished Test: " + input1 + " - " + input2 + " = " + expected);
		

	}
	
	//Multiply using @CsvFileSource
	@ParameterizedTest
	@CsvFileSource(resources = "/data/testMultiply.csv")
	public void testMultiply(int input1, int input2, int expected) {
		System.out.println();
		System.out.println("[Before Each] Starting Test: " + input1 + " * " + input2);
		assertEquals(expected, calculator.multiple(input1, input2));
		System.out.println("[After Each] Finished Test: " + input1 + " * " + input2 + " = " + expected);
	}
	
	//Multiply using @CsvFileSource
	@ParameterizedTest
	@CsvFileSource(resources = "/data/testMultiply.csv")
	public void testMultiply2(int input1, int input2, int expected) {
		System.out.println();
		System.out.println("[Before Each] Starting Test: " + input1 + " * " + input2);
		assertEquals(expected, calculator.multiple(input1, input2));
		System.out.println("[After Each] Finished Test: " + input1 + " * " + input2 + " = " + expected);
	}
	
	//Multiply using @CsvFileSource
		@ParameterizedTest
		@CsvFileSource(resources = "/data/testMultiply.csv")
		public void testMultiply3(int input1, int input2, int expected) {
			System.out.println();
			System.out.println("[Before Each] Starting Test: " + input1 + " * " + input2);
			assertEquals(expected, calculator.multiple(input1, input2));
			System.out.println("[After Each] Finished Test: " + input1 + " * " + input2 + " = " + expected);
		}
		
		//Multiply using @CsvFileSource
				@ParameterizedTest
				@CsvFileSource(resources = "/data/testMultiply.csv")
				public void testMultiply4(int input1, int input2, int expected) {
					System.out.println();
					System.out.println("[Before Each] Starting Test: " + input1 + " * " + input2);
					assertEquals(expected, calculator.multiple(input1, input2));
					System.out.println("[After Each] Finished Test: " + input1 + " * " + input2 + " = " + expected);
				}
	
	
	// Divide Test
	@Test
	public void testDivideByZero() {
		System.out.println();
		System.out.println("[Before Each] Starting divide by zero test");
		assertThrows(IllegalArgumentException.class, ()-> calculator.divide(10, 0));
		System.out.println("[After Each] Divide by zero threw ArithmeticException as expected");
	}
	
	

}


/* For add(int input1, int input2) , use @MethodSource
For substract(int input1, int input2), use @CsvSource
For multiple(int input1, int input2), use @CsvFileSource
For divide(int input1, int input2), just write ONE Negative Test
Use @BeforeAll, @BeforeEach, @AfterEach, @AfterAll to print with number and your username
 (100, 2), (100, -2), (-100, 2), (-100, -2) */