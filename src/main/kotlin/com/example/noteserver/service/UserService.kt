package com.example.noteserver.service

import com.example.noteserver.dao.UserDao
import com.example.noteserver.ecxception.UserNotFoundException
import com.example.noteserver.model.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(private val userDao: UserDao, private val passwordEncoder: PasswordEncoder) {

    fun all(): Iterable<User> = userDao.findAll()

    fun get(id: Long): User = userDao.findById(id).orElseThrow { UserNotFoundException("User with id $id not found") }

    fun getByPhone(phone: String): User = userDao.findByPhone(phone).orElseThrow { UserNotFoundException("User with phone $phone not found") }

    fun add(user: User): User = userDao.save(user.copy(password = passwordEncoder.encode(user.password)))

    fun edit(id: Long, user: User): User = userDao.save(user.copy(id = id))

    fun remove(id: Long) = userDao.deleteById(id)
}