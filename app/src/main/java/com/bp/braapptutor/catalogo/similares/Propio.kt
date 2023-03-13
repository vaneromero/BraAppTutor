package com.bp.braapptutor.catalogo.similares

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Propio(
    val nombre: String? = null,
    val descripción: String? = null,
    val url: String? = null,
    val nombresito: String? = null,
    @Exclude val key: String? = null
)