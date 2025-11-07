package testing.demo.computation_demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTest {
	
	private Calculator calculator;
	private static int count = 0;
	
	@BeforeAll
	static void beforeAll() {
		System.out.printf("[Before All] Calculator Test suite starting ...\n\n");
	}
	
	@BeforeEach
	void beforeEachTest(TestInfo testInfo) {
		calculator = new Calculator();
		System.out.printf("[Before Each] Starting Test #%d: %s\n", ++count, testInfo.getDisplayName());
	}
	
	// ---------- Addition ----------
	@ParameterizedTest(name = "{0} + {1} = {2}")
	@DisplayName("Add two numbers")
	@MethodSource("provideAddData")
	public void add_twoNumbers(int input1, int input2, int expected) {
		int result = calculator.add(input1, input2);
		assertEquals(expected, result);
	}
	static Stream<Arguments> provideAddData() {
		return Stream.of(
			Arguments.of(100, 2, 102),
			Arguments.of(100, -2, 98),
			Arguments.of(-100, 2, -98),
			Arguments.of(-100, -2, -102)
		);
	}

	// ---------- Subtraction ----------
	@ParameterizedTest(name = "{0} - {1} = {2}")
	@DisplayName("Subtract two numbers")
	@MethodSource("provideSubtractData")
	public void subtract_twoNumbers(int input1, int input2, int expected) {
		int result = calculator.subtract(input1, input2);
		assertEquals(expected, result);
	}
	static Stream<Arguments> provideSubtractData() {
		return Stream.of(
			Arguments.of(100, 2, 98),
			Arguments.of(100, -2, 102),
			Arguments.of(-100, 2, -102),
			Arguments.of(-100, -2, -98)
		);
	}

	// ---------- Multiplication ----------
	@ParameterizedTest(name = "{0} * {1} = {2}")
	@DisplayName("Multiply two numbers")
	@MethodSource("provideMultiplyData")
	public void multiply_twoNumbers(int input1, int input2, int expected) {
		int result = calculator.multiply(input1, input2);
		assertEquals(expected, result);
	}
	static Stream<Arguments> provideMultiplyData() {
		return Stream.of(
			Arguments.of(100, 2, 200),
			Arguments.of(100, -2, -200),
			Arguments.of(-100, 2, -200),
			Arguments.of(-100, -2, 200)
		);
	}

	// ---------- Division ----------
	@ParameterizedTest(name = "{0} / {1} = {2}")
	@DisplayName("Divide two numbers")
	@MethodSource("provideDivideData")
	public void divide_twoNumbers(int input1, int input2, int expected) {
		int result = calculator.divide(input1, input2);
		assertEquals(expected, result);
	}
	static Stream<Arguments> provideDivideData() {
		return Stream.of(
			Arguments.of(10, 2, 5),
			Arguments.of(-10, 2, -5),
			Arguments.of(10, -2, -5),
			Arguments.of(-10, -2, 5)
		);
	}

	// ---------- Division by Zero ----------
	@Test
	@DisplayName("Divide by zero should throw exception")
	public void divide_byZero() {		
		assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
	}

	@AfterEach
	void afterEachTest(TestInfo testInfo) {
		System.out.printf("[After Each] Finished Test #%d: %s\n\n", count, testInfo.getDisplayName());
	}
	
	@AfterAll
	static void afterAll() {
		System.out.printf("\n[After All] completed %d test invocations.\n", count);
	}
}
