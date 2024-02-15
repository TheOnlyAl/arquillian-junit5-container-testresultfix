package de.adtelligence.arquillian.junit5.container.testresultfix.extension.tests.lastresult;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jboss.arquillian.test.spi.TestResult;

/**
 * This annotation can be used to inject the last TestResult into a test. It needs to be used on a <code>void</code>
 * method which has exactly one {@link TestResult} parameter.
 * 
 * @author Alexander Wienzek (alexanderwienzek[at]adtelligence.de)
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LastResult {
}