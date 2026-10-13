package mx.edu.utez.yara.ui.navigation

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.yara.model.ProductDetail
import mx.edu.utez.yara.ui.screens.DetallesProductoLiverpoolScreen
import mx.edu.utez.yara.ui.screens.ProductoListScreen
import mx.edu.utez.yara.ui.screens.TiendaMenuScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    var productoSeleccionado by remember { mutableStateOf<ProductDetail?>(null) }

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            TiendaMenuScreen(
                onNavigateToList = { navController.navigate("productos") }
            )
        }
        composable("productos") {
            ProductoListScreen(
                onNavigateToDetail = { producto ->
                    productoSeleccionado = producto
                    navController.navigate("detalle")
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable("detalle") {
            productoSeleccionado?.let { producto ->
                DetallesProductoLiverpoolScreen(
                    producto = producto,
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}