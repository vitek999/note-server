package com.example.noteserver.controller

import com.example.noteserver.model.Note
import com.example.noteserver.service.NoteService
import org.springframework.http.HttpStatus
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("notes")
class NoteController(private val noteService: NoteService) {

    @Secured
    @GetMapping
    fun all() = noteService.all()

    @Secured
    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody note: Note) : Note = noteService.add(note)

    @Secured
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun byId(@PathVariable id: Long) = noteService.get(id)

    @Secured
    @GetMapping("user/{userId}")
    fun byUserId(@PathVariable userId: Long) = noteService.getByUserId(userId)

    @Secured
    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody note: Note) = noteService.edit(id, note)

    @Secured
    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = noteService.remove(id)
}