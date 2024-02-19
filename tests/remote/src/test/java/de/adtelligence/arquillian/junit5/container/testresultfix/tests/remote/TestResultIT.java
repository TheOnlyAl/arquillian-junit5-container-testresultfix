package de.adtelligence.arquillian.junit5.container.testresultfix.tests.remote;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.spi.TestResult;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import de.adtelligence.arquillian.junit5.container.testresultfix.extension.TestResultFixExtension;
import de.adtelligence.arquillian.junit5.container.testresultfix.extension.tests.lastresult.LastResult;

@ExtendWith(ArquillianExtension.class)
@ExtendWith(TestResultFixExtension.class)
public class TestResultIT {
	private static TestResult lastResult;

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class);
	}

	@LastResult
	public static void setLastResult(final TestResult testResult) {
		lastResult = testResult;
	}

	@Test
	@Order(1)
	void testResult1() {
		assertNull(lastResult);
	}

	@Test
	@Order(2)
	void testResult2() {
		assertNotNull(lastResult);
	}
}
