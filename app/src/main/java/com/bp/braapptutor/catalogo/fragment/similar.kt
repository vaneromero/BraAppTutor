package com.bp.braapptutor.catalogo.fragment


import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.bp.braapptutor.R
import com.bp.braapptutor.catalogo.MenuCatalogo
import com.bp.braapptutor.catalogo.similares.Produc
import com.bp.braapptutor.inicio.Splash
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.tono
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.volum
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.volum1
import spencerstudios.com.bungeelib.Bungee

class similar : Fragment() {
    var soundPool: SoundPool? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.activity_similar, container, false)

        val title: LottieAnimationView = view.findViewById(R.id.Avaz2)
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
            startActivity(Intent(view.context, Produc::class.java))
            Bungee.zoom(view.context)
            MenuCatalogo().finish()
        }
        return view
    }

}