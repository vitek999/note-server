package com.example.noteserver.service

import com.example.noteserver.dao.UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(@Autowired private val userDao: UserDao) : UserDetailsService {


    override fun loadUserByUsername(phone: String): UserDetails {
        val user = userDao.findByPhone(phone).orElseThrow { UsernameNotFoundException("Invalid phone: $phone") }
        return User(user.phone, user.password, listOf())
    }

}