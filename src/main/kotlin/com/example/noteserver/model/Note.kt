package com.example.noteserver.model

import javax.persistence.*

@Entity
@Table(name = "Notes")
data class Note(

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0L,

        @Column(name = "user_id")
        val userId: Long = 0L,

        @Column(name = "title")
        val title: String = "",

        @Column(name = "description")
        val description : String = ""

//        @Column(name = "date")
//        val date: LocalDate
)