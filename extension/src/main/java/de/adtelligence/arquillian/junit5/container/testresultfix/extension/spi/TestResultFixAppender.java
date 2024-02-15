package de.adtelligence.arquillian.junit5.container.testresultfix.extension.spi;

import org.jboss.arquillian.container.test.spi.RemoteLoadableExtension;
import org.jboss.arquillian.container.test.spi.client.deployment.CachedAuxilliaryArchiveAppender;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import de.adtelligence.arquillian.junit5.container.testresultfix.extension.TestResultFixExtension;

/**
 * Appender which creates the arquillian-testresultfix.jar which contains all needed classes.
 * 
 * @author Alexander Wienzek (alexanderwienzek[at]adtelligence.de)
 *
 */
class TestResultFixAppender extends CachedAuxilliaryArchiveAppender {

	@Override
	protected Archive<?> buildArchive() {
		return ShrinkWrap.create(JavaArchive.class, "arquillian-testresultfix.jar")
			.addClasses(TestResultFixRemoteExtension.class, TestResultFixExtension.class, UpdateTestResultEvent.class,
					UpdateTestResultEventHandler.class)
			.addAsServiceProvider(RemoteLoadableExtension.class, TestResultFixRemoteExtension.class);
	}
}
