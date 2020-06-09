package Test;

public class Main {

    public static void main(String[] args) {

        TestCLass testCLass = new TestCLass(5);
        System.err.println(testCLass.toString());
        ClassNum2 classNum2 = new ClassNum2(testCLass);
        classNum2.countTestClass();
        System.err.println(classNum2.getTestCLass().toString());
        System.err.println(testCLass.toString());
        testCLass.count();
        System.err.println(classNum2.getTestCLass().toString());

    }
}
