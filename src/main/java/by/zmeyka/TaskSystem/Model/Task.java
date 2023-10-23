package by.zmeyka.TaskSystem.Model;

import jakarta.persistence.*;
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
    private String header;
    @Column(name = "description")
    private String description;
    @Column(name = "deadline")
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
}
