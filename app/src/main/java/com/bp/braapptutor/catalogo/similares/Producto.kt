package com.bp.braapptutor.catalogo.similares

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Producto(
    val nombre: String? = null, val precio: String? = null, val sitio: String? = null,
    val descripción: String? = null, val url: String? = null,
    val link: String? = null, val nombresito: String? = null, @Exclude val key: String? = null
)