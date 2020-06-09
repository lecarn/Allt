package Test;

public class ClassNum2 {
    private TestCLass testCLass;

    public ClassNum2(TestCLass testCLass){
        this.testCLass = testCLass;
    }

    public void countTestClass(){
        testCLass.count();
    }

    public TestCLass getTestCLass() {
        return testCLass;
    }

    public void setTestCLass(TestCLass testCLass) {
        this.testCLass = testCLass;
    }
}
