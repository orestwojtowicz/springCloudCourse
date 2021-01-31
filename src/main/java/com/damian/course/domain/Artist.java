package com.damian.course.domain;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * @author Damian Wójtowicz
 * @project course
 * @date 30.01.2021
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;

    @NotNull(message = "Field lastName can not be null")
    @NotBlank(message = "Field lastName can not be blank")
    @NotEmpty(message = "empty")
    private String firstName;


    @NotNull(message = "Field lastName can not be null")
    @NotBlank(message = "Field lastName can not be blank")
    @NotEmpty(message = "{validation.mail.notEmpty}")
    private String lastName;


    @NotNull(message = "Field lastName can not be null")
    @NotBlank(message = "Field lastName can not be blank")
    @NotEmpty(message = "empty")
    @Email
    private String email;

// walidacja odbywa się w trakcie zapisu do bazy danych


}


// @Min(5)









































