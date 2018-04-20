package com.qusf.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SiFan on 2018/4/17.
 */
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String photo;
    private Date create_date;



    @OneToMany(cascade = CascadeType.ALL,targetEntity = Role.class,mappedBy = "movie",fetch = FetchType.EAGER)
    private List<Role> roles=new ArrayList<Role>();

    public Movie(String name, String photo, Date create_date) {
        this.name = name;
        this.photo = photo;
        this.create_date = create_date;
    }

    public Role addRole(Actor actor, String name){
        Role role=new Role(actor,name,this);
        this.roles.add(role);
        return role;
    }

    public Movie() {

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getCreateDate() {
        return create_date;
    }

    public void setCreateDate(Date createDate) {
        this.create_date = create_date;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
