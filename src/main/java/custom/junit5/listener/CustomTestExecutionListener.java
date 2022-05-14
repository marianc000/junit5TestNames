package custom.junit5.listener;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.TestSource;
import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.engine.support.descriptor.ClassSource;
import org.junit.platform.engine.support.descriptor.MethodSource;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

public class CustomTestExecutionListener implements TestExecutionListener {

    public Description toDescription(TestIdentifier i) {
        Description d = new Description(i.getDisplayName());
        TestSource ts = i.getSource().orElse(null);
        if (ts instanceof MethodSource m) {
            d.setClassName(m.getJavaClass());
            d.setMethodName(m.getMethodName());
        } else if (ts instanceof ClassSource c) {
            d.setClassName(c.getJavaClass());
        } else if (ts != null) {
            throw new IllegalArgumentException("Unrecognized source");
        }
        return d;
    }

    @Override
    public void executionStarted(TestIdentifier i) {
        Description d = toDescription(i);
        if (d.getClassName() != null) {
            log(">" + d);
        }
    }

    @Override
    public void executionFinished(TestIdentifier i, TestExecutionResult testExecutionResult) {
        Description d = toDescription(i);
        if (d.getClassName() != null) {
            log("<" + d+"\n");
        }
    }

    void log(String message) {
        System.out.println("*** " + message);
        
    }
}
