package ru.netology

import org.junit.Test

import org.junit.Assert.*

class NotesServiceTest {

    @Test
    fun shouldAdd() {
        val result: Int = NotesService.add(
            1,
            "First note",
            "Text of first note"
        )
        assertEquals(result, 1)
    }

    @Test
    fun shouldCreateComment()
    {
        NotesService.add(
            1,
            "First note",
            "Text of first note"
        )

        val result: Int? = NotesService.createComment(
            1,
            1,
            1,
            1,
            "First comment for first note")
        assertEquals(result, 1)
    }

    @Test
    fun shouldNotCreateComment() {
        val result: Int? = NotesService.createComment(
            1,
            25,
            1,
            1,
            "")
        assertEquals(result, null)
    }

    @Test
    fun shouldDeleteNote() {
        val result = NotesService.deleteNote(1)
        assertTrue(result)
    }

    @Test
    fun shouldNotDeleteNote() {
        val result = NotesService.deleteNote(115)
        assertFalse(result)
    }

    @Test
    fun shouldDeleteComment() {
        NotesService.add(
            1,
            "First note",
            "Text of first note"
        )

        NotesService.createComment(
            1,
            1,
            1,
            1,
            "First comment for first note")

        NotesService.deleteComment(1)
        val result = NotesService.restoreComment(1)
        assertTrue(result)
    }

    @Test
    fun shouldNotDeleteComment() {
        val result = NotesService.restoreComment(125)
        assertFalse(result)
    }

    @Test
    fun shouldEdit() {
        val result = NotesService.edit(
            1,
            "Edited title",
            "Edited text"
        )
        assertTrue(result)
    }

    @Test
    fun shouldNotEdit() {
        val result = NotesService.edit(
            114,
            "Edited title",
            "Edited text"
        )
        assertFalse(result)
    }

    @Test
    fun shouldEditComment() {
        NotesService.add(
            1,
            "First note",
            "Text of first note"
        )

        NotesService.createComment(
            1,
            1,
            1,
            1,
            "First comment for first note")

        val result = NotesService.editComment(
            1,
            "Edited title"
        )
        assertTrue(result)
    }

    @Test
    fun shouldNotEditComment() {
        val result = NotesService.editComment(
            234,
            "Edited title"
        )
        assertFalse(result)
    }

    @Test
    fun shouldRestoreComment() {
        NotesService.createComment(
            2,
            1,
            1,
            1,
            "Second comment for first note"
        )
        NotesService.deleteComment(2)
        val result = NotesService.restoreComment(2)
        assertTrue(result)
    }

    @Test
    fun shouldNotRestoreComment() {
        val result = NotesService.restoreComment(45)
        assertFalse(result)
    }
}