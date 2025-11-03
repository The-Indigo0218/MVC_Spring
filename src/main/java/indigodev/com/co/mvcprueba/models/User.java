package indigodev.com.co.mvcprueba.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String name;
    private String lastName;
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String userName;

    private String password;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
