package by.zmeyka.TaskSystem.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idrole")
    private int id;
    @Column(name = "role")
    private String name;


    public Role(String name) {
        this.name = name;
    }

    public Role() {

    }
}
