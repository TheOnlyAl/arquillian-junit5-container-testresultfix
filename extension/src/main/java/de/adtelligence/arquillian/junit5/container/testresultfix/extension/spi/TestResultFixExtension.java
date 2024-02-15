package de.adtelligence.arquillian.junit5.container.testresultfix.extension.spi;

import org.jboss.arquillian.container.test.spi.client.deployment.AuxiliaryArchiveAppender;
import org.jboss.arquillian.core.spi.LoadableExtension;

/**
 * Extension which is registered using the Arquillian SPI. This will mainly package the remote extension.
 * 
 * @author Alexander Wienzek (alexanderwienzek[at]adtelligence.de)
 */
class TestResultFixExtension implements LoadableExtension {

	@Override
	public void register(final ExtensionBuilder builder) {
		builder.service(AuxiliaryArchiveAppender.class, TestResultFixAppender.class);
	}
}
