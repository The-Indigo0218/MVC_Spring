package indigodev.com.co.mvcprueba.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String userName;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private String password;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }


    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }
}
