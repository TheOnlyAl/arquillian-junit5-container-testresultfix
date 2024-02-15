package de.adtelligence.arquillian.junit5.container.testresultfix.extension.spi;

import org.jboss.arquillian.container.test.spi.RemoteLoadableExtension;

/**
 * Remote loadable extension which observes the test result update event.
 * 
 * @author Alexander Wienzek (alexanderwienzek[at]adtelligence.de)
 *
 */
class TestResultFixRemoteExtension implements RemoteLoadableExtension {

	@Override
	public void register(final ExtensionBuilder builder) {
		builder.observer(UpdateTestResultEventHandler.class);
	}
}
