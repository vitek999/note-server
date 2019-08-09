package com.example.noteserver.ecxception

class UserNotFoundException(override val message : String) : RuntimeException(message)