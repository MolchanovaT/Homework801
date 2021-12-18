package ru.netology

object NotesService {
    private var notes: MutableList<Note> = mutableListOf()
    private var comments: MutableList<Comment> = mutableListOf()

    fun add(
        nid: Int,
        title: String,
        text: String,
        privacy: Int = 0,
        commentPrivacy: Int = 0,
        privacyView: String = "",
        privacyComment: String = ""
    ): Int {
        val note = Note(
            nid,
            title,
            text,
            privacy,
            commentPrivacy,
            privacyView,
            privacyComment
        )
        notes.add(note)
        return note.nid
    }

    fun createComment(
        cid: Int,
        noteId: Int,
        ownerId: Int,
        replyTo: Int? = null,
        message: String
    ): Int? {
        getByID(noteId) ?: return null
        val comment = Comment(
            cid,
            noteId,
            ownerId,
            replyTo,
            message,
            isDeleted = false
        )
        comments.add(comment)
        return comment.cid
    }

    fun deleteNote(nid: Int): Boolean {
        val note = getByID(nid) ?: return false
        notes.remove(note)

        val commentsIterator = comments.iterator()
        while (commentsIterator.hasNext()) {
            val comIteration: Comment = commentsIterator.next()
            if (comIteration.noteId == nid) {
                deleteComment(comIteration.cid)
                comIteration.noteIsDeleted = true
                return true
            }
        }
        return false
    }

    fun deleteComment(cid: Int): Boolean {
        val comment = getCommentByID(cid) ?: return false
        if (comment.isDeleted) {
            return false
        }
        comment.isDeleted = true
        return true
    }

    fun edit(
        nid: Int,
        title: String,
        text: String,
        privacy: Int = 0,
        commentPrivacy: Int = 0,
        privacyView: String = "",
        privacyComment: String = ""
    ): Boolean {
        val note = getByID(nid) ?: return false
        note.title = title
        note.text = text
        note.privacy = privacy
        note.commentPrivacy = commentPrivacy
        note.privacyView = privacyView
        note.privacyComment = privacyComment
        return true
    }

    fun editComment(
        cid: Int,
        message: String
    ): Boolean {
        val comment = getCommentByID(cid) ?: return false
        if (comment.isDeleted) {
            return false
        }
        comment.message = message
        return true
    }

    fun get(): List<Note> {
        val notesIterator = notes.iterator()
        val notesListResult: MutableList<Note> = mutableListOf()
        while (notesIterator.hasNext()) notesListResult.add(notesIterator.next())
        return notesListResult
    }

    private fun getByID(nid: Int): Note? {
        val notesIterator = notes.iterator()
        while (notesIterator.hasNext()) {
            val noteIteration: Note = notesIterator.next()
            if (noteIteration.nid == nid) {
                return noteIteration
            }
        }
        return null
    }

    private fun getCommentByID(cid: Int): Comment? {
        val commentsIterator = comments.iterator()
        while (commentsIterator.hasNext()) {
            val comIteration: Comment = commentsIterator.next()
            if (comIteration.cid == cid) {
                return comIteration
            }
        }
        return null
    }

    fun getComments(): List<Comment> {
        val commentsIterator = comments.iterator()
        val commentsListResult: MutableList<Comment> = mutableListOf()
        while (commentsIterator.hasNext()) {
            val comIteration: Comment = commentsIterator.next()
            if (!comIteration.isDeleted) {
                commentsListResult.add(comIteration)
            }
        }
        return commentsListResult
    }

    fun restoreComment(cid: Int): Boolean {
        val comment: Comment = getCommentByID(cid) ?: return false
        if (comment.isDeleted && !comment.noteIsDeleted) {
            comment.isDeleted = false
        }
        return true
    }
}