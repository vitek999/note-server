package com.example.noteserver.dao

import com.example.noteserver.model.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserDao : CrudRepository<User, Long> {
    fun findByPhone(phone : String) : Optional<User>
}