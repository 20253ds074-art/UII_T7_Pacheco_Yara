package mx.edu.utez.yara.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mx.edu.utez.yara.model.Comentario

@Composable
fun ComentarioList(
    comentarios: List<Comentario>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(comentarios) { comentario ->
            ComentarioItem(comentario = comentario)
        }
    }
}