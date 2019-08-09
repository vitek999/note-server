package com.example.noteserver.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class OptionService(private val passwordEncoder: PasswordEncoder) {

    fun getEncodedPassword(password: String): String = passwordEncoder.encode(password)
}