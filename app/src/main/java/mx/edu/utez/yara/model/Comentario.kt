package mx.edu.utez.yara.model

import java.util.UUID

data class Comentario(
    val id: String = UUID.randomUUID().toString(),
    val author: String,
    val rating: Float,
    val date: String,
    val comment: String
)