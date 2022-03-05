package in.truemeds.assignment.beans;

public class OutputBean {

    private String output;
    private int count;

    public OutputBean(String output, int count) {
        this.output = output;
        this.count = count;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Output [count=" + count + ", output=" + output + "]";
    }

}
