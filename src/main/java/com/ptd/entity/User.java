package com.ptd.entity;

import com.ptd.model.UserDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "doB")
    private String doB;

    @Column(name = "location")
    private String location;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "introduce")
    private String introduce;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "achievement")
    private float achievement;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "account_id")
    private Account account;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamPlayer> teamPlayers;

    //Được mời
    @OneToMany(mappedBy = "user_invite", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamInvitation> teamInvitedList;

    //Mình đi mời
    @OneToMany(mappedBy = "invited_by", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamInvitation> invitedTeamList;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public float getAchievement() {
        return achievement;
    }

    public void setAchievement(float achievement) {
        this.achievement = achievement;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doB='" + doB + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", introduce='" + introduce + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", achievement='" + achievement + '\'' +
                ", account=" + account +
                '}';
    }

    public UserDTO toDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(this.id);
        userDTO.setName(this.name);
        userDTO.setDoB(this.doB);
        userDTO.setLocation(this.location);
        userDTO.setEmail(this.email);
        userDTO.setPhone(this.phone);
        userDTO.setIntroduce(this.introduce);
        userDTO.setAvatarUrl(this.avatarUrl);
        userDTO.setAchievement(this.achievement);
        userDTO.setAccountDTO(this.account.toDTO());
        return userDTO;
    }
}
