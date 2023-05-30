package com.proyectowed.proyectowed.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users",
uniqueConstraints = {
    @UniqueConstraint(columnNames = "fullname"),
    @UniqueConstraint(columnNames = "email")
})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String fullName;

    @Column(unique = true)
    private String email;

    @Column
    private String password;


    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="user_roles",joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role>  roles = new HashSet<>();

    public User(Long id, String fullname, String email, String password){
        this.id=id;
        this.fullName=fullname;
        this.email=email;
        this.password=password;
    }

    public User(String fullname, String email, String password){
        this.fullName=fullname;
        this.email=email;
        this.password=password;
    }


    public User UpdarteWidth(User oldUser) {
        return new User(this.id,oldUser.getFullName(),oldUser.getEmail(),oldUser.getPassword());
    }
}
