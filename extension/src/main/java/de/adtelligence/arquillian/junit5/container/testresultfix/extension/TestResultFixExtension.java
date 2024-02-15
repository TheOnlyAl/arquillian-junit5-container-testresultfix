package de.adtelligence.arquillian.junit5.container.testresultfix.extension;

import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.junit5.TestResultEventProducer;
import org.jboss.arquillian.test.spi.TestResult;
import org.jboss.arquillian.test.spi.event.suite.After;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;

import de.adtelligence.arquillian.junit5.container.testresultfix.extension.spi.UpdateTestResultEvent;

/**
 * This extensions fixes the missing injection of the {@link TestResult} in Arquillian for Junit5. Add it after the
 * {@link ArquillianExtension} to be sure that all relevant {@link After} events have finished.
 * 
 * @author Alexander Wienzek (alexanderwienzek[at]adtelligence.de)
 */
public class TestResultFixExtension implements AfterTestExecutionCallback, Extension {

	@Override
	public void afterTestExecution(final ExtensionContext extensionContext) throws Exception {
		// The TestResult just needs to have the correct status, this is good since we have no easy way to get to the
		// actual result before everything is finished
		final TestResult testResult = extensionContext.getExecutionException()
			.map(TestResult::failed)
			.orElse(TestResult.passed());

		final UpdateTestResultEvent updateTestResultEvent = new UpdateTestResultEvent(
				extensionContext.getRequiredTestInstance(), extensionContext.getRequiredTestMethod(), testResult);

		TestResultEventProducer.fireUpdateTestResultEvent(extensionContext, updateTestResultEvent);
	}
}