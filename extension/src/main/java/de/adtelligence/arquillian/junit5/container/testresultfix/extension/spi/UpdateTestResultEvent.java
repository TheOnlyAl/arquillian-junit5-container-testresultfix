package de.adtelligence.arquillian.junit5.container.testresultfix.extension.spi;

import java.lang.reflect.Method;
import java.util.Optional;

import org.jboss.arquillian.test.spi.TestResult;
import org.jboss.arquillian.test.spi.event.suite.AfterTestLifecycleEvent;

/**
 * Event which is fired when the TestResult should be updated.
 * 
 * @author Alexander Wienzek (alexanderwienzek[at]adtelligence.de)
 */
public class UpdateTestResultEvent extends AfterTestLifecycleEvent {
	private TestResult testResult;

	public UpdateTestResultEvent(final Object testInstance, final Method testMethod, final TestResult testResult) {
		super(testInstance, testMethod);
		this.testResult = testResult;
	}

	public Optional<TestResult> getTestResult() {
		return Optional.ofNullable(testResult);
	}
}