package com.bp.braapptutor.catalogo.fragment

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.airbnb.lottie.LottieAnimationView
import com.bp.braapptutor.R
import com.bp.braapptutor.catalogo.MenuCatalogo
import com.bp.braapptutor.catalogo.producto.ProdRec
import com.bp.braapptutor.conexion.ConnectivityLiveData
import com.bp.braapptutor.inicio.Splash
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.tono
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.volum
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.volum1
import com.bp.braapptutor.inicio.Splash.PreferenceHelper4.dato1
import com.bp.braapptutor.inicio.Splash.PreferenceHelper4.dato2
import com.bp.braapptutor.inicio.Splash.PreferenceHelper4.dato3
import com.bp.braapptutor.inicio.Splash.PreferenceHelper4.dato4
import kotlinx.android.synthetic.main.activity_menu_catalogo.*
import kotlinx.android.synthetic.main.activity_menu_prin.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee


class propio : Fragment() {
    var soundPool: SoundPool? = null
    var mediaPlayer: MediaPlayer? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val view = inflater.inflate(R.layout.activity_propio, container, false)
        val title: LottieAnimationView = view.findViewById(R.id.Avaz)
        val Archivo4 = "Catalogo"
        val defaultPrefs4 = Splash.PreferenceHelper4.defaultPreference4(view.context)
        defaultPrefs4.dato1 = 0
        defaultPrefs4.dato2 = 0
        val prefs4 = Splash.PreferenceHelper4.customPreference4(view.context, Archivo4)
        val Archivo1 = "Audio"
        val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(view.context)
        defaultPrefs1.tono = 1
        defaultPrefs1.melodia = 1
        defaultPrefs1.volum = 0.10f
        defaultPrefs1.volum1 = 1.00f
        val prefs1 = Splash.PreferenceHelper1.customPreference1(view.context, Archivo1)
        soundPool = SoundPool(100, AudioManager.STREAM_MUSIC, 0)
        var carga = prefs1.tono
        when (prefs1.tono) {
            1 -> {
                carga = soundPool!!.load(view.context, R.raw.ton1, 1)
            }
            2 -> {
                carga = soundPool!!.load(view.context, R.raw.ton2, 1)
            }
            3-> {
                carga = soundPool!!.load(view.context, R.raw.ton3, 1)
            }
            4 -> {
                carga = soundPool!!.load(view.context, R.raw.ton4, 1)
            }
            5 -> {
                carga = soundPool!!.load(view.context, R.raw.ton5, 1)
            }
            6 -> {
                carga = soundPool!!.load(view.context, R.raw.ton6, 1)
            }
            7 -> {
                carga = soundPool!!.load(view.context, R.raw.ton7, 1)
            }
            8 -> {
                carga = soundPool!!.load(view.context, R.raw.ton8, 1)
            }
            9 -> {
                carga = soundPool!!.load(view.context, R.raw.ton9, 1)
            }
            10 -> {
                carga = soundPool!!.load(view.context, R.raw.ton10, 1)
            }
        }
        title.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            prefs4.dato2 = 0
            startActivity(Intent(view.context, ProdRec::class.java))
            Bungee.zoom(view.context)
            MenuCatalogo().finish()
        }
        return view
    }

}