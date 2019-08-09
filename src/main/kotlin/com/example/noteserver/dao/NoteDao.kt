package com.example.noteserver.dao

import com.example.noteserver.model.Note
import org.springframework.data.repository.CrudRepository

interface NoteDao : CrudRepository<Note, Long> {

    fun findAllByUserId(userId: Long): List<Note>
}