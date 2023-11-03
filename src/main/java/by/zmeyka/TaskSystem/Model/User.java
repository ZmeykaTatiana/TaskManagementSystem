package by.zmeyka.TaskSystem.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "password")
    private String password;
    @Column(name="login")
    private String login;

//    @Column(name="role_id")
//    private String role;
    @OneToOne
    @JoinColumn(name="role_id",referencedColumnName = "idrole")
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Task> taskList;


    public User(){

    }


}
