package in.truemeds.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "miten_solanki_java_output")
public class Output {

    @Id
    @GeneratedValue()
    @Column(name = "id")
    private int id;

    @Column(name = "output")
    private int output;

    public Output(int output) {
        this.output = output;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

}