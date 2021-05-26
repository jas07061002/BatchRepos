package com.springbatchexample1.model;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name = "MOCK_DATA")
@AllArgsConstructor
@NoArgsConstructor
public class MockData {

    @Id
    @Column(name="id")
    public Integer id;

    @Column(name="first_name")
    public String firstName;

    @Column(name="last_name")
    public String lastName;

    @Column(name="email")
    public String email;

    @Column(name="gender")
    public String gender;

    @Column(name="ip_address")
    public String ipAddress;

}
