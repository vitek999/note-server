package com.example.noteserver.controller

import com.example.noteserver.dto.UserDto
import com.example.noteserver.dto.asDatabaseModel
import com.example.noteserver.model.asDataTransferObject
import com.example.noteserver.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.access.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("users", produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
class UserController(private val userService: UserService) {

    @GetMapping("login")
    fun getAuthUserCredentials() : UserDto {
        val userDetails : UserDetails = SecurityContextHolder.getContext().authentication.principal as UserDetails
        return userService.getByPhone(userDetails.username).asDataTransferObject()
    }

    @Secured
    @GetMapping
    fun all() = userService.all().asDataTransferObject()

    @Secured
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody user: UserDto) = userService.add(user.asDatabaseModel()).asDataTransferObject()

    @Secured
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun byId(@PathVariable id: Long) = userService.get(id).asDataTransferObject()

    @Secured
    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody user: UserDto) = userService.edit(id, user.asDatabaseModel()).asDataTransferObject()

    @Secured
    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = userService.remove(id)
}