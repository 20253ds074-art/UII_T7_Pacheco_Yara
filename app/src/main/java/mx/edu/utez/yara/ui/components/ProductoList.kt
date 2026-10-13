package mx.edu.utez.yara.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mx.edu.utez.yara.model.ProductDetail

@Composable
fun ProductoList(
    productos: List<ProductDetail>,
    onProductoClick: (ProductDetail) -> Unit,
    onFavoriteClick: (ProductDetail) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(productos) { producto ->
            ProductoCard(
                producto = producto,
                onClick = { onProductoClick(producto) },
                onFavoriteClick = { onFavoriteClick(producto) }
            )
        }
    }
}
