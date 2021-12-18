package ru.netology

data class Note(
    val nid: Int,
    var title: String,
    var text: String,
    var privacy: Int = 0,
    var commentPrivacy: Int = 0,
    var privacyView: String = "",
    var privacyComment: String = ""
)
