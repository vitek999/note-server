package com.example.noteserver.ecxception

class NoteNotFoundException (override val message: String) : RuntimeException(message)