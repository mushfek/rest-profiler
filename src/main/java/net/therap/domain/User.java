package net.therap.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Mushfekur Rahman
 * @since 09/02/2013
 */

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "current_mail", nullable = false)
    private String currentMail;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserInfo> userInfoList;

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

    public String getCurrentMail() {
        return currentMail;
    }

    public void setCurrentMail(String currentMail) {
        this.currentMail = currentMail;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    @Override
    public String toString() {
        return "User [" + "id=" + id + ", name=" + name + "]";
    }
}
