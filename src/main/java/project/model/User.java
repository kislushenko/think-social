package project.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;


    @ManyToOne
    @JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Role role;

    @OneToMany(mappedBy = "author")
    private List<Think> thinks;

    @ManyToMany
    @JoinTable(name = "user_subscriptions", joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "subscriber_id"))
    private List<User> subscribers;

    @ManyToMany
    @JoinTable(name = "user_subscriptions", joinColumns = @JoinColumn(name = "subscriber_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> subscriptions;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Think> getThinks() { return thinks; }

    public void setThinks(List<Think> thinks) { this.thinks = thinks; }

    public List<User> getSubscribers() { return subscribers; }

    public void setSubscribers(List<User> subscribers) { this.subscribers = subscribers; }

    public List<User> getSubscriptions() { return subscriptions; }

    public void setSubscriptions(List<User> subscriptions) { this.subscriptions = subscriptions; }
}
