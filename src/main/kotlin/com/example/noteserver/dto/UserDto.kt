package com.example.noteserver.dto

import com.example.noteserver.model.User
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.Pattern

data class UserDto(
        val id: Long = 0L,

        @Pattern(regexp = "(^$|[0-9]{10})")
        val phone: String = "",

        val firstName: String = "",

        val lastName: String = "",

        val patronymic: String = "",

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        val password: String = ""
)

fun UserDto.asDatabaseModel() = User(id, phone, firstName, lastName, patronymic, password)