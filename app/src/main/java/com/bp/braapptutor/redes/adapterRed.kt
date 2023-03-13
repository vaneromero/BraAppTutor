package com.bp.braapptutor.redes

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class adapterRed(
    val Facebook: String? = null,
    val Instagram: String? = null,
    val Telegram: String? = null,
    val Twitter: String? = null,
    val Whatsapp: String? = null,
    val Pagina: String? = null,
    val VerMas: String? = null,
    val DescarHis: String? = null,
    val VerMasM: String? = null,
    val DescarHis3: String? = null,
    val Spotify: String? = null,
    val Tiktok: String? = null,
    val Figma: String? = null,

) {
}