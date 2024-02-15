package de.adtelligence.arquillian.junit5.container.testresultfix.extension.spi;

import org.jboss.arquillian.core.api.InstanceProducer;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.core.api.annotation.Observes;
import org.jboss.arquillian.test.spi.TestResult;
import org.jboss.arquillian.test.spi.annotation.TestScoped;

/**
 * Event handler which updates the TestResult instance.
 * 
 * @author Alexander Wienzek (alexanderwienzek[at]adtelligence.de)
 */
public class UpdateTestResultEventHandler {

	@Inject
	@TestScoped
	private InstanceProducer<TestResult> testResultProducer;

	public void handleEvent(@Observes final UpdateTestResultEvent event) {
		event.getTestResult()
			.ifPresent(result -> testResultProducer.set(result));
	}
}