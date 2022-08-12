package com.kitapyurdu.log;

import java.util.Optional;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestResultsLogger implements TestWatcher {
    Log log = new Log();

    public TestResultsLogger() {
    }

    public void testDisabled(ExtensionContext context, Optional<String> reason) {
    }

    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        this.log.info(testName + " PASSED");
    }

    public void testAborted(ExtensionContext context, Throwable cause) {
    }

    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String testCause = cause.getMessage();
        this.log.error(testName + " FAILED with cause : " + testCause);
    }
}