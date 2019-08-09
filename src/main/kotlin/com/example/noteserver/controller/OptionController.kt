package com.example.noteserver.controller

import com.example.noteserver.service.OptionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("options")
class OptionController (private val optionService: OptionService) {

    @GetMapping("password/{password}")
    fun getEncodedPassword(@PathVariable("password") password: String): String = optionService.getEncodedPassword(password)
}