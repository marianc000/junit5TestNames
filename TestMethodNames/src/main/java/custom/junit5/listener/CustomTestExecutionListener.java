package custom.junit5.listener;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
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
        if (d.getMethodName() != null) {
            log(">" + d);
        }
    }

    @Override
    public void executionFinished(TestIdentifier i, TestExecutionResult r) {
        Description d = toDescription(i);
        if (d.getMethodName() != null) {

            if (r.getThrowable().isPresent()) {
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                r.getThrowable().get().printStackTrace(new PrintStream(os));
                log(os.toString(StandardCharsets.UTF_8).lines().limit(6).collect(Collectors.joining("\n"))+"\n\t...");
            }
            log("<" + d + "\n");
        }
    }

    void log(String message) {
        System.out.println("*** " + message);

    }
}
