package com.example.noteserver.service

import com.example.noteserver.dao.NoteDao
import com.example.noteserver.ecxception.NoteNotFoundException
import com.example.noteserver.model.Note
import org.springframework.stereotype.Service

@Service
class NoteService(private val noteDao: NoteDao) {

    fun all(): Iterable<Note> = noteDao.findAll()

    fun get(id: Long): Note = noteDao.findById(id).orElseThrow {NoteNotFoundException("Note with id $id not found")}

    fun getByUserId(id: Long) : Iterable<Note> = noteDao.findAllByUserId(id)

    fun add(note: Note) : Note = noteDao.save(note)

    fun edit(id: Long, note: Note): Note = noteDao.save(note.copy(id = id))

    fun remove(id: Long) = noteDao.deleteById(id)
}