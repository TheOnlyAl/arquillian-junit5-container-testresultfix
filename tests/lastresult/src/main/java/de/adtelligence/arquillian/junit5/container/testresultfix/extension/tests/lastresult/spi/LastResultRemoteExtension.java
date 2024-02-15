package de.adtelligence.arquillian.junit5.container.testresultfix.extension.tests.lastresult.spi;

import org.jboss.arquillian.container.test.spi.RemoteLoadableExtension;

public class LastResultRemoteExtension implements RemoteLoadableExtension {

	@Override
	public void register(final ExtensionBuilder builder) {
		builder.observer(LastResultObserver.class);
	}

}
