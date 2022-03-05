package in.truemeds.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "input_details")
public class Input {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "input_string")
    private String input;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "Input [id=" + id + ", input=" + input + "]";
    }

}
