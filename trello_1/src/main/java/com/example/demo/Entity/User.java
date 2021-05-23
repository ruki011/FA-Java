package com.example.demo.Entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="S_USERS")
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rowId;

    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String firstName;
    private String middleName;
    @Column(nullable = false)
    private String lastName;
    private String passwordHash;

    @ManyToMany
    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name ="role_id"),
            inverseJoinColumns =@JoinColumn(name="user_id"))
            private Set<Role> roles;

    @OneToMany(mappedBy = "developer")
    private Set<Task> developerTask;
    @OneToMany(mappedBy = "analyst")
    private Set<Task> analystTask;
    @OneToMany(mappedBy = "tester")
    private Set<Task> testerTask;




}
