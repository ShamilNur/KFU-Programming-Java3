package ru.kpfu.itis.group903.nurkaev.models;

import lombok.*;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String hashPassword;
    private String uuid;
}
