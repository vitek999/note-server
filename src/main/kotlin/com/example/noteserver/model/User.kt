package com.example.noteserver.model


import com.example.noteserver.dto.UserDto
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0L,

        @Column(name = "phone", length = 11, unique = true)
        val phone: String = "",

        @Column(name = "first_name")
        val firstName: String = "",

        @Column(name = "last_name")
        val lastName: String = "",

        @Column(name = "patronymic")
        val patronymic: String = "",

        @Column(name = "password")
        val password: String = ""
)

fun User.asDataTransferObject() : UserDto = UserDto(id, phone, firstName, lastName, patronymic)

fun Iterable<User>.asDataTransferObject() : Iterable<UserDto> = map {it.asDataTransferObject()}