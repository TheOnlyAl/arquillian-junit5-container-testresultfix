package de.adtelligence.arquillian.junit5.container.testresultfix.extension.tests.lastresult.spi;

import org.jboss.arquillian.container.test.spi.RemoteLoadableExtension;
import org.jboss.arquillian.container.test.spi.client.deployment.AuxiliaryArchiveAppender;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import de.adtelligence.arquillian.junit5.container.testresultfix.extension.tests.lastresult.LastResult;

public class LastResultAuxiliaryArchiveAppender implements AuxiliaryArchiveAppender {

	@Override
	public Archive<?> createAuxiliaryArchive() {
		return ShrinkWrap.create(JavaArchive.class, "arquillian-testresult.jar")
			.addClasses(LastResultObserver.class, LastResultRemoteExtension.class, LastResult.class)
			.addAsServiceProvider(RemoteLoadableExtension.class, LastResultRemoteExtension.class);
	}

}
