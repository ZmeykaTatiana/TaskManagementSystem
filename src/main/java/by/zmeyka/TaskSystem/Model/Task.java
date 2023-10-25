package by.zmeyka.TaskSystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "header")
    @NotEmpty(message = "can't be empty")
    @Size(min=2, max=15, message = "should be longer than 2 letters and shorter than 15 letters")
    private String header;
    @Column(name = "description")
    @NotEmpty(message = "can't be empty")
    private String description;
    @Column(name = "deadline")
    @NotEmpty(message = "can't be empty")
    private String deadline;
    @Column(name = "priority")

    private String priority;
    @Column(name = "status")

    private String status;

    public Task(int id, String description, String deadline, String priority, String status) {
        this.id = id;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
    }
    public Task() {

    }
    public Task( String description, String deadline, String priority, String status) {

        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
    }
}
