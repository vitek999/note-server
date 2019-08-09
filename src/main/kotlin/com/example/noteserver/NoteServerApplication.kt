package com.example.noteserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import javax.annotation.PostConstruct

@SpringBootApplication
open class NoteServerApplication{

	@PostConstruct
	fun started(){
		val pe: PasswordEncoder = BCryptPasswordEncoder()
		println(pe.encode("password"))
	}

}

fun main(args: Array<String>) {
	runApplication<NoteServerApplication>(*args)
}
