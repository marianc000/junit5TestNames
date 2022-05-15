package custom.junit5.listener;

public class Description {

    String displayName, className, methodName;

    public Description(String displayName) {
        this.displayName = displayName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(Class<?> className) {
        this.className = className.getSimpleName();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName + "()";
    }

    @Override
    public String toString() {
        String str = className + "." + methodName;
        if (!displayName.equals(methodName)) {
            str += " - " + displayName;
        }

        return str;
    }
}
