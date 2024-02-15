package de.adtelligence.arquillian.junit5.container.testresultfix.extension.tests.lastresult.spi;

import org.jboss.arquillian.container.test.spi.client.deployment.AuxiliaryArchiveAppender;
import org.jboss.arquillian.core.spi.LoadableExtension;

class LastResultExtension implements LoadableExtension {

	@Override
	public void register(final ExtensionBuilder builder) {
		builder.service(AuxiliaryArchiveAppender.class, LastResultAuxiliaryArchiveAppender.class);
	}
}