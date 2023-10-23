package by.zmeyka.TaskSystem.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "deadline")
    private String deadline;
    @Column(name = "priority")
    private String priority;
    @Column(name = "status")
    private String status;
}
