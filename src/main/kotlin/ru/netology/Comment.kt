package ru.netology

data class Comment(
    val cid: Int,
    val noteId: Int,
    val ownerId: Int,
    val replyTo: Int? = null,
    var message: String,
    var isDeleted: Boolean = false,
    var noteIsDeleted: Boolean = false
)
