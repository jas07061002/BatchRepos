package com.springbatchexample1.model;


import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MockData {

    public Integer id;

    public String firstName;

    public String lastName;

    public String email;

    public String gender;

    public String ipAddress;

}
