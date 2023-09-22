package com.getinfy.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDto {
	
	@NotNull(message = "user name shouldn't be null")
	@Pattern(regexp = "^(?!\\s)(?![\\d\\s]+$)(?![\\d])[^\\s]+(?<!\\s)(?<![0-9])$", message = "Invalid name format")
	private String name;

    @Email(message = "invalid email address")
	private String email;

    @NotNull
    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number")
	private String mobileNum;

    @Min(18)
    @Max(60)
	private Integer age;

    @NotBlank
	private String nationality;

}
