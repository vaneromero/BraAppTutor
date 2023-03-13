package com.bp.braapptutor.catalogo.producto

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Recomendacion(
    val nombre: String? = null,
    val imagen: String? = null,
    val descripcion: String? = null,
    val nombresito: String? = null,
    @Exclude val key: String? = null
)