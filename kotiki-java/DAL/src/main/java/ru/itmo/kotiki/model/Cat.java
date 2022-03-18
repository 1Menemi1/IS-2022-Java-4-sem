package ru.itmo.kotiki.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "cats")
public class Cat {
    @OneToMany(targetEntity = Cat.class)
    private List<Cat> friends;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(name = "birth_date")
    private Date birthDate;
    private Type type;
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Cat() {
    }

    public Cat(String name, Date birthDate, Type type, Color color) {
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
        this.color = color;
        friends = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Cat> getFriends() {
        return Collections.unmodifiableList(friends);
    }

    public void addFriend(Cat friend) {
        if (friend != null && !friends.contains(friend)) {
            friends.add(friend);
            friend.addFriend(this);
        }
    }
}