package ru.netology

fun main() {
    NotesService.add(
        1,
        "First note",
        "Text of first note"
    )

    NotesService.add(
        2,
        "Second note",
        "Text of second note"
    )

    NotesService.add(
        3,
        "Third note",
        "Text of third note"
    )

    println("Add some notes")
    getInfoAboutNotes()
    println()

    NotesService.createComment(
        1,
        1,
        1,
        1,
        "First comment for first note"
    )

    NotesService.createComment(
        2,
        1,
        1,
        1,
        "Second comment for first note"
    )

    NotesService.createComment(
        3,
        2,
        1,
        1,
        "First comment for second note"
    )

    println("Add some comments")
    getInfoAboutComments()
    println()

    NotesService.deleteNote(2)

    println("Delete some notes")
    getInfoAboutNotes()
    getInfoAboutComments()
    println()

    NotesService.deleteComment(2)
    println("Delete some comments")
    getInfoAboutComments()
    println()

    NotesService.restoreComment(2)
    println("Restore some comments")
    getInfoAboutComments()
    println()

    NotesService.edit(
        1,
        "Edited title",
        "Edited text"
    )

    println("Edit some notes")
    getInfoAboutNotes()
    println()

    NotesService.editComment(
        1,
        "Edited title"
    )

    println("Edit some comments")
    getInfoAboutComments()
    println()
}

fun getInfoAboutNotes() {
    val listOfNotes = NotesService.get()

    if (listOfNotes.isEmpty()) println("Not found any note")

    val notesIterator = listOfNotes.iterator()
    while (notesIterator.hasNext()) {
        val noteIteration: Note = notesIterator.next()
        println("Note # ${noteIteration.nid}, text: ${noteIteration.text}")
    }
}

fun getInfoAboutComments() {
    val listOfComments = NotesService.getComments()

    if (listOfComments.isEmpty()) println("Not found any comment")

    val commentsIterator = listOfComments.iterator()
    while (commentsIterator.hasNext()) {
        val commentIteration: Comment = commentsIterator.next()
        println("Comment # ${commentIteration.cid}, message: ${commentIteration.message}")
    }
}