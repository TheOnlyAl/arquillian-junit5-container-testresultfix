package de.adtelligence.arquillian.junit5.container.testresultfix.extension.tests.lastresult.spi;

import java.lang.reflect.InvocationTargetException;

import org.jboss.arquillian.core.api.Instance;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.core.api.annotation.Observes;
import org.jboss.arquillian.test.spi.TestResult;
import org.jboss.arquillian.test.spi.event.suite.After;

import de.adtelligence.arquillian.junit5.container.testresultfix.extension.tests.lastresult.LastResult;

public class LastResultObserver {

	@Inject
	private Instance<TestResult> testResultInstance;

	public void observer(@Observes(precedence = -999999) final After afterContext) {
		try {
			afterContext.getTestClass()
				.getMethod(LastResult.class)
				.invoke(null, testResultInstance.get());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}