# Arquillian Junit5 Container TestResult Fix

This project fixes a problem with Arquillian and Junit5 when running in a container. It can be used as long as the underlying problem is not fixed.

## The Problem

When using Junit5 tests which run inside Arquillian there is a problem where an internal ``Instance<TestResult>`` is not set correctly in the ``After`` phase of a test.

This, for example, leads to problems with extensions like [arquillian-extension-persistence](https://github.com/arquillian/arquillian-extension-persistence/). In this specific case a transaction is always rolled back since the ``Instance<TestResult>`` is not correctly set.

## How to use

Include the following artifact after building it:

```xml
<groupId>de.adtelligence.arquillian</groupId>
<artifactId>arquillian-junit5-container-testresultfix-extension</artifactId>
```

Then add the `TestResultFixExtension` extension to your test class after the `ArquillianExtension`. Like this:

```java
import de.adtelligence.arquillian.junit5.container.testresultfix.extension.TestResultFixExtension;

// ...

@ExtendWith(ArquillianExtension.class)
@ExtendWith(TestResultFixExtension.class)
public class MyClassIT {
```

## Tests

For running the remote tests a docker environment is needed, therefore they do not run by default. 
If you want to use the remote tests you need to activate the profile ``include-remote-tests``.