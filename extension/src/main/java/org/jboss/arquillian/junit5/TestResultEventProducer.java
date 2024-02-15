package org.jboss.arquillian.junit5;

import org.jboss.arquillian.core.spi.Manager;
import org.junit.jupiter.api.extension.ExtensionContext;

import de.adtelligence.arquillian.junit5.container.testresultfix.extension.spi.UpdateTestResultEvent;

/**
 * We use this class to have an easy way to fire a custom life cycle event using the
 * {@link JUnitJupiterTestClassLifecycleManager}.
 * 
 * @author Alexander Wienzek (alexanderwienzek[at]adtelligence.de)
 */
public abstract class TestResultEventProducer {

	/**
	 * Fire an {@link UpdateTestResultEvent}.
	 * 
	 * @param extensionContext
	 *            is the context needed to obtain a {@link Manager} to fire the event
	 * @param updateTestResultEvent
	 *            is the event to fire
	 * @throws Exception
	 *             if there was any problem firing the event
	 */
	public static void fireUpdateTestResultEvent(final ExtensionContext extensionContext,
			final UpdateTestResultEvent updateTestResultEvent) throws Exception {
		JUnitJupiterTestClassLifecycleManager.getManager(extensionContext)
			.getAdaptor()
			.fireCustomLifecycle(updateTestResultEvent);
	}

	private TestResultEventProducer() {
	}
}