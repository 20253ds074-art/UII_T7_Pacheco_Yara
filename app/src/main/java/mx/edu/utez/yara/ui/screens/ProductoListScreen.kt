package mx.edu.utez.yara.ui.screens

import android.R.attr.author
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.edu.utez.yara.R
import mx.edu.utez.yara.model.Comentario
import mx.edu.utez.yara.model.ProductDetail
import mx.edu.utez.yara.ui.components.ProductoCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductoListScreen(
    onNavigateToDetail: (ProductDetail) -> Unit,
    onBack: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    val listaProductos = remember {
        mutableStateListOf(
            ProductDetail(
                brand = "The Ordinary",
                name = "Sérum Facial The Ordinary Niacinamide 10% + Zinc 1%",
                price = 550.00,
                rating = 4.8f,
                reviewCount = 120,
                isFreeShipping = true,
                description = "Fórmula concentrada con niacinamida y zinc que ayuda a reducir la apariencia de imperfecciones y el exceso de sebo en la piel.",
                image = R.drawable.producto_skin1,
                reviews = listOf(
                    Comentario(author = "Sofía M.", rating = 5f, date = "10/10/2026", comment = "Me redujo el brillo facial notablemente."),
                    Comentario(author = "Valeria G.", rating = 4.5f, date = "08/10/2026", comment = "Muy buen sérum para piel mixta."),
                    Comentario(author = "Isaak C.", rating = 4f, date = "1/05/2026", comment = "Me aclaró un poco la piel."),
                    Comentario(author = "Nina P.", rating = 5f, date = "24/08/2026", comment = "La verdad no me esperaba este gran cambio en mi piel.")

            )
            ),
            ProductDetail(
                brand = "Skincare Set",
                name = "Kit de Cuidado Facial Antiedad Tratamiento Completo",
                price = 730.00,
                rating = 4.9f,
                reviewCount = 85,
                isFreeShipping = true,
                description = "Set completo de tratamiento facial hidratante y regenerador. Incluye sérum, crema de día y contorno de ojos para todo tipo de piel.",
                image = R.drawable.producto_skin2,
                reviews = listOf(
                    Comentario(author = "Fernanda L.", rating = 5f, date = "09/10/2026", comment = "Deja la piel suave e hidratada todo el día.")
                )
            ),
            ProductDetail(
                brand = "Dermatolie",
                name = "Set de Frascos Airless Contenedores Cosméticos",
                price = 500.00,
                rating = 4.7f,
                reviewCount = 42,
                isFreeShipping = true,
                description = "Juego de dosificadores tipo airless ideal para viajar y transportar tus lociones, cremas y sueros protegiéndolos de la oxidación.",
                image = R.drawable.prducto_skin3,
                reviews = listOf(
                    Comentario(author = "Camila R.", rating = 4.5f, date = "05/10/2026", comment = "Súper prácticos para viajes.")
                )
            ),
            ProductDetail(
                brand = "Uriage",
                name = "Uriage Hyséac Gel Limpiador Purificante 150 ml",
                price = 750.00,
                rating = 4.8f,
                reviewCount = 64,
                isFreeShipping = true,
                description = "Gel limpiador purificante sin jabón que elimina impurezas y el exceso de grasa respetando la epidermis. Ideal para pieles mixtas a grasas.",
                image = R.drawable.producto_skin4,
                reviews = listOf(
                    Comentario(author = "Andrea P.", rating = 5f, date = "07/10/2026", comment = "Limpia a profundidad sin resecar la cara.")
                )
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Productos",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        containerColor = Color.White
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {
            // Buscador
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Buscar en Liverpool...", color = Color.Gray) },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp),
                    shape = RoundedCornerShape(26.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.LightGray,
                        unfocusedBorderColor = Color.LightGray,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .size(52.dp)
                        .background(Color(0xFFD01B56), shape = RoundedCornerShape(16.dp))
                ) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Buscar",
                        tint = Color.White
                    )
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(listaProductos) { producto ->
                    ProductoCard(
                        producto = producto,
                        onClick = { onNavigateToDetail(producto) },
                        onFavoriteClick = { }
                    )
                }
            }
        }
    }
}