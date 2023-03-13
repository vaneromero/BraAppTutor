package com.bp.braapptutor.audio

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.bp.braapptutor.R
import com.bp.braapptutor.inicio.Splash
import com.bp.braapptutor.inicio.Splash.PreferenceHelper.password
import com.bp.braapptutor.inicio.Splash.PreferenceHelper.userId
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.activi
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.tono
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.volum
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.volum1
import com.bp.braapptutor.inicio.Usuarios
import com.bp.braapptutor.menuprincipal.MenuPrin
import com.ramotion.fluidslider.FluidSlider
import kotlinx.android.synthetic.main.activity_audio.*
import spencerstudios.com.bungeelib.Bungee
import java.lang.Exception
import java.lang.String
import java.util.concurrent.TimeUnit
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.melodia1
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.panel
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.tono1
class Audio : AppCompatActivity() {
    var mediaPlayer1: MediaPlayer? = null
    private var oTime1T = 0
    private var sTime1T: Int = 0
    private var eTime1T: Int = 0
    var mediaPlayer2: MediaPlayer? = null
    private var oTime2T = 0
    private var sTime2T: Int = 0
    private var eTime2T: Int = 0
    var mediaPlayer3: MediaPlayer? = null
    private var oTime3T = 0
    private var sTime3T: Int = 0
    private var eTime3T: Int = 0
    var mediaPlayer4: MediaPlayer? = null
    private var oTime4T = 0
    private var sTime4T: Int = 0
    private var eTime4T: Int = 0
    var mediaPlayer5: MediaPlayer? = null
    private var oTime5T = 0
    private var sTime5T: Int = 0
    private var eTime5T: Int = 0
    var mediaPlayer6: MediaPlayer? = null
    private var oTime6T = 0
    private var sTime6T: Int = 0
    private var eTime6T: Int = 0
    var mediaPlayer7: MediaPlayer? = null
    private var oTime7T = 0
    private var sTime7T: Int = 0
    private var eTime7T: Int = 0
    var mediaPlayer8: MediaPlayer? = null
    private var oTime8T = 0
    private var sTime8T: Int = 0
    private var eTime8T: Int = 0
    var mediaPlayer9: MediaPlayer? = null
    private var oTime9T = 0
    private var sTime9T: Int = 0
    private var eTime9T: Int = 0
    var mediaPlayer10: MediaPlayer? = null
    private var oTime10T = 0
    private var sTime10T: Int = 0
    private var eTime10T: Int = 0


    var mediaPlayer11: MediaPlayer? = null
    private var oTime1 = 0
    private var sTime1: Int = 0
    private var eTime1: Int = 0
    private val hdlr1: Handler = Handler()
    var mediaPlayer21: MediaPlayer? = null
    private var oTime2 = 0
    private var sTime2: Int = 0
    private var eTime2: Int = 0
    private val hdlr2: Handler = Handler()
    var mediaPlayer31: MediaPlayer? = null
    private var oTime3 = 0
    private var sTime3: Int = 0
    private var eTime3: Int = 0
    private val hdlr3: Handler = Handler()
    var mediaPlayer41: MediaPlayer? = null
    private var oTime4 = 0
    private var sTime4: Int = 0
    private var eTime4: Int = 0
    private val hdlr4: Handler = Handler()
    var mediaPlayer51: MediaPlayer? = null
    private var oTime5 = 0
    private var sTime5: Int = 0
    private var eTime5: Int = 0
    private val hdlr5: Handler = Handler()
    var mediaPlayer61: MediaPlayer? = null
    private var oTime6 = 0
    private var sTime6: Int = 0
    private var eTime6: Int = 0
    private val hdlr6: Handler = Handler()
    var mediaPlayer71: MediaPlayer? = null
    private var oTime7 = 0
    private var sTime7: Int = 0
    private var eTime7: Int = 0
    private val hdlr7: Handler = Handler()
    var mediaPlayer81: MediaPlayer? = null
    private var oTime8 = 0
    private var sTime8: Int = 0
    private var eTime8: Int = 0
    private val hdlr8: Handler = Handler()
    var mediaPlayer91: MediaPlayer? = null
    private var oTime9 = 0
    private var sTime9: Int = 0
    private var eTime9: Int = 0
    private val hdlr9: Handler = Handler()
    var mediaPlayer101: MediaPlayer? = null
    private var oTime10 = 0
    private var sTime10: Int = 0
    private var eTime10: Int = 0
    private val hdlr10: Handler = Handler()


    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)
        mediaPlayer1 = MediaPlayer()
        mediaPlayer1 = MediaPlayer.create(this, R.raw.ton1)
        eTime1T = mediaPlayer1!!.duration.toLong().toInt()
        sTime1T = mediaPlayer1!!.currentPosition.toLong().toInt()
        mediaPlayer2 = MediaPlayer()
        mediaPlayer2 = MediaPlayer.create(this, R.raw.ton2)
        eTime2T = mediaPlayer2!!.duration.toLong().toInt()
        sTime2T = mediaPlayer2!!.currentPosition.toLong().toInt()
        mediaPlayer3 = MediaPlayer()
        mediaPlayer3 = MediaPlayer.create(this, R.raw.ton3)
        eTime3T = mediaPlayer3!!.duration.toLong().toInt()
        sTime3T = mediaPlayer3!!.currentPosition.toLong().toInt()
        mediaPlayer4 = MediaPlayer()
        mediaPlayer4 = MediaPlayer.create(this, R.raw.ton4)
        eTime4T = mediaPlayer4!!.duration.toLong().toInt()
        sTime4T = mediaPlayer4!!.currentPosition.toLong().toInt()
        mediaPlayer5 = MediaPlayer()
        mediaPlayer5 = MediaPlayer.create(this, R.raw.ton5)
        eTime5T = mediaPlayer5!!.duration.toLong().toInt()
        sTime5T = mediaPlayer5!!.currentPosition.toLong().toInt()
        mediaPlayer6 = MediaPlayer()
        mediaPlayer6 = MediaPlayer.create(this, R.raw.ton6)
        eTime6T = mediaPlayer6!!.duration.toLong().toInt()
        sTime6T = mediaPlayer6!!.currentPosition.toLong().toInt()
        mediaPlayer7 = MediaPlayer()
        mediaPlayer7 = MediaPlayer.create(this, R.raw.ton7)
        eTime7T = mediaPlayer7!!.duration.toLong().toInt()
        sTime7T = mediaPlayer7!!.currentPosition.toLong().toInt()
        mediaPlayer8 = MediaPlayer()
        mediaPlayer8 = MediaPlayer.create(this, R.raw.ton8)
        eTime8T = mediaPlayer8!!.duration.toLong().toInt()
        sTime8T = mediaPlayer8!!.currentPosition.toLong().toInt()
        mediaPlayer9 = MediaPlayer()
        mediaPlayer9 = MediaPlayer.create(this, R.raw.ton9)
        eTime9T = mediaPlayer9!!.duration.toLong().toInt()
        sTime9T = mediaPlayer9!!.currentPosition.toLong().toInt()
        mediaPlayer10 = MediaPlayer()
        mediaPlayer10 = MediaPlayer.create(this, R.raw.ton10)
        eTime10T = mediaPlayer10!!.duration.toLong().toInt()
        sTime10T = mediaPlayer10!!.currentPosition.toLong().toInt()

        mediaPlayer11 = MediaPlayer()
        mediaPlayer11 = MediaPlayer.create(this, R.raw.melo1)
        eTime1 = mediaPlayer11!!.duration.toLong().toInt()
        sTime1 = mediaPlayer11!!.currentPosition.toLong().toInt()
        mediaPlayer21 = MediaPlayer()
        mediaPlayer21 = MediaPlayer.create(this, R.raw.melo2)
        eTime2 = mediaPlayer21!!.duration.toLong().toInt()
        sTime2 = mediaPlayer21!!.currentPosition.toLong().toInt()
        mediaPlayer31 = MediaPlayer()
        mediaPlayer31 = MediaPlayer.create(this, R.raw.melo3)
        eTime3 = mediaPlayer31!!.duration.toLong().toInt()
        sTime3 = mediaPlayer31!!.currentPosition.toLong().toInt()
        mediaPlayer41 = MediaPlayer()
        mediaPlayer41 = MediaPlayer.create(this, R.raw.melo4)
        eTime4 = mediaPlayer41!!.duration.toLong().toInt()
        sTime4 = mediaPlayer41!!.currentPosition.toLong().toInt()
        mediaPlayer51 = MediaPlayer()
        mediaPlayer51 = MediaPlayer.create(this, R.raw.melo5)
        eTime5 = mediaPlayer51!!.duration.toLong().toInt()
        sTime5 = mediaPlayer51!!.currentPosition.toLong().toInt()
        mediaPlayer61 = MediaPlayer()
        mediaPlayer61 = MediaPlayer.create(this, R.raw.melo6)
        eTime6 = mediaPlayer61!!.duration.toLong().toInt()
        sTime6 = mediaPlayer61!!.currentPosition.toLong().toInt()
        mediaPlayer71 = MediaPlayer()
        mediaPlayer71 = MediaPlayer.create(this, R.raw.melo7)
        eTime7 = mediaPlayer71!!.duration.toLong().toInt()
        sTime7 = mediaPlayer71!!.currentPosition.toLong().toInt()
        mediaPlayer81 = MediaPlayer()
        mediaPlayer81 = MediaPlayer.create(this, R.raw.melo8)
        eTime8 = mediaPlayer81!!.duration.toLong().toInt()
        sTime8 = mediaPlayer81!!.currentPosition.toLong().toInt()
        mediaPlayer91 = MediaPlayer()
        mediaPlayer91 = MediaPlayer.create(this, R.raw.melo9)
        eTime9 = mediaPlayer91!!.duration.toLong().toInt()
        sTime9 = mediaPlayer91!!.currentPosition.toLong().toInt()
        mediaPlayer101 = MediaPlayer()
        mediaPlayer101 = MediaPlayer.create(this, R.raw.melo10)
        eTime10 = mediaPlayer101!!.duration.toLong().toInt()
        sTime10 = mediaPlayer101!!.currentPosition.toLong().toInt()

        val Archivo = "Usuario"
        val defaultPrefs = Splash.PreferenceHelper.defaultPreference(this)
        defaultPrefs.password = "Admin"
        defaultPrefs.userId = 0
        val prefs = Splash.PreferenceHelper.customPreference(this, Archivo)
        val Archivo1 = "Audio"
        val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this)
        defaultPrefs1.tono = 1
        defaultPrefs1.melodia = 1
        defaultPrefs1.volum = 0.10f
        defaultPrefs1.volum1 = 1.00f
        val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
        val texto1: ConstraintLayout = findViewById(R.id.cont44)
        val texto2: LinearLayout = findViewById(R.id.contenedora)
        //Asignacioón de las animaciones
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto1.startAnimation(anim1)
        texto2.startAnimation(anim1)
        if (prefs1.panel==1){
            melodiasa.visibility=View.VISIBLE
            meloda.visibility=View.VISIBLE
            tonoss.visibility=View.GONE
            tonas.visibility=View.GONE
        }else if (prefs1.panel==2){
            tonoss.visibility=View.VISIBLE
            tonas.visibility=View.VISIBLE
            melodiasa.visibility=View.GONE
            meloda.visibility=View.GONE
        }
        izf.setOnClickListener {
            if (prefs1.panel==2){
                prefs1.panel=prefs1.panel-1
            }else{
                prefs1.panel=prefs1.panel+1
            }
            if (prefs1.panel==1){
                melodiasa.visibility=View.VISIBLE
                meloda.visibility=View.VISIBLE
                tonoss.visibility=View.GONE
                tonas.visibility=View.GONE
            }else if (prefs1.panel==2){
                tonoss.visibility=View.VISIBLE
                tonas.visibility=View.VISIBLE
                melodiasa.visibility=View.GONE
                meloda.visibility=View.GONE
            }
        }
        deF.setOnClickListener {
            if (prefs1.panel==1){
                prefs1.panel=prefs1.panel+1
            }else{
                prefs1.panel=prefs1.panel-1
            }
            if (prefs1.panel==1){
                melodiasa.visibility=View.VISIBLE
                meloda.visibility=View.VISIBLE
                tonoss.visibility=View.GONE
                tonas.visibility=View.GONE
            }else if (prefs1.panel==2){
                tonoss.visibility=View.VISIBLE
                tonas.visibility=View.VISIBLE
                melodiasa.visibility=View.GONE
                meloda.visibility=View.GONE
            }
        }

        //Asignacion principal de la favorita y menu
        when (prefs1.melodia) {
            1 -> {

                    ele1.setBackgroundResource(R.drawable.elegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

            }
            2 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.elegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

            }
            3 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.elegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


            }
            4 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.elegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


            }
            5 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.elegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


            }
            6 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.elegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


            }
            7 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.elegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


            }
            8 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.elegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


            }
            9 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.elegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


            }
            10 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.elegida)


            }
        }
        when (prefs1.tono) {
            1 -> {

                ele1T.setBackgroundResource(R.drawable.elegida)
                ele2T.setBackgroundResource(R.drawable.noelegida)
                ele3T.setBackgroundResource(R.drawable.noelegida)
                ele4T.setBackgroundResource(R.drawable.noelegida)
                ele5T.setBackgroundResource(R.drawable.noelegida)
                ele6T.setBackgroundResource(R.drawable.noelegida)
                ele7T.setBackgroundResource(R.drawable.noelegida)
                ele8T.setBackgroundResource(R.drawable.noelegida)
                ele9T.setBackgroundResource(R.drawable.noelegida)
                ele10T.setBackgroundResource(R.drawable.noelegida)

            }
            2 -> {

                ele1T.setBackgroundResource(R.drawable.noelegida)
                ele2T.setBackgroundResource(R.drawable.elegida)
                ele3T.setBackgroundResource(R.drawable.noelegida)
                ele4T.setBackgroundResource(R.drawable.noelegida)
                ele5T.setBackgroundResource(R.drawable.noelegida)
                ele6T.setBackgroundResource(R.drawable.noelegida)
                ele7T.setBackgroundResource(R.drawable.noelegida)
                ele8T.setBackgroundResource(R.drawable.noelegida)
                ele9T.setBackgroundResource(R.drawable.noelegida)
                ele10T.setBackgroundResource(R.drawable.noelegida)

            }
            3 -> {

                ele1T.setBackgroundResource(R.drawable.noelegida)
                ele2T.setBackgroundResource(R.drawable.noelegida)
                ele3T.setBackgroundResource(R.drawable.elegida)
                ele4T.setBackgroundResource(R.drawable.noelegida)
                ele5T.setBackgroundResource(R.drawable.noelegida)
                ele6T.setBackgroundResource(R.drawable.noelegida)
                ele7T.setBackgroundResource(R.drawable.noelegida)
                ele8T.setBackgroundResource(R.drawable.noelegida)
                ele9T.setBackgroundResource(R.drawable.noelegida)
                ele10T.setBackgroundResource(R.drawable.noelegida)


            }
            4 -> {

                ele1T.setBackgroundResource(R.drawable.noelegida)
                ele2T.setBackgroundResource(R.drawable.noelegida)
                ele3T.setBackgroundResource(R.drawable.noelegida)
                ele4T.setBackgroundResource(R.drawable.elegida)
                ele5T.setBackgroundResource(R.drawable.noelegida)
                ele6T.setBackgroundResource(R.drawable.noelegida)
                ele7T.setBackgroundResource(R.drawable.noelegida)
                ele8T.setBackgroundResource(R.drawable.noelegida)
                ele9T.setBackgroundResource(R.drawable.noelegida)
                ele10T.setBackgroundResource(R.drawable.noelegida)


            }
            5 -> {

                ele1T.setBackgroundResource(R.drawable.noelegida)
                ele2T.setBackgroundResource(R.drawable.noelegida)
                ele3T.setBackgroundResource(R.drawable.noelegida)
                ele4T.setBackgroundResource(R.drawable.noelegida)
                ele5T.setBackgroundResource(R.drawable.elegida)
                ele6T.setBackgroundResource(R.drawable.noelegida)
                ele7T.setBackgroundResource(R.drawable.noelegida)
                ele8T.setBackgroundResource(R.drawable.noelegida)
                ele9T.setBackgroundResource(R.drawable.noelegida)
                ele10T.setBackgroundResource(R.drawable.noelegida)


            }
            6 -> {

                ele1T.setBackgroundResource(R.drawable.noelegida)
                ele2T.setBackgroundResource(R.drawable.noelegida)
                ele3T.setBackgroundResource(R.drawable.noelegida)
                ele4T.setBackgroundResource(R.drawable.noelegida)
                ele5T.setBackgroundResource(R.drawable.noelegida)
                ele6T.setBackgroundResource(R.drawable.elegida)
                ele7T.setBackgroundResource(R.drawable.noelegida)
                ele8T.setBackgroundResource(R.drawable.noelegida)
                ele9T.setBackgroundResource(R.drawable.noelegida)
                ele10T.setBackgroundResource(R.drawable.noelegida)


            }
            7 -> {

                ele1T.setBackgroundResource(R.drawable.noelegida)
                ele2T.setBackgroundResource(R.drawable.noelegida)
                ele3T.setBackgroundResource(R.drawable.noelegida)
                ele4T.setBackgroundResource(R.drawable.noelegida)
                ele5T.setBackgroundResource(R.drawable.noelegida)
                ele6T.setBackgroundResource(R.drawable.noelegida)
                ele7T.setBackgroundResource(R.drawable.elegida)
                ele8T.setBackgroundResource(R.drawable.noelegida)
                ele9T.setBackgroundResource(R.drawable.noelegida)
                ele10T.setBackgroundResource(R.drawable.noelegida)


            }
            8 -> {

                ele1T.setBackgroundResource(R.drawable.noelegida)
                ele2T.setBackgroundResource(R.drawable.noelegida)
                ele3T.setBackgroundResource(R.drawable.noelegida)
                ele4T.setBackgroundResource(R.drawable.noelegida)
                ele5T.setBackgroundResource(R.drawable.noelegida)
                ele6T.setBackgroundResource(R.drawable.noelegida)
                ele7T.setBackgroundResource(R.drawable.noelegida)
                ele8T.setBackgroundResource(R.drawable.elegida)
                ele9T.setBackgroundResource(R.drawable.noelegida)
                ele10T.setBackgroundResource(R.drawable.noelegida)


            }
            9 -> {

                ele1T.setBackgroundResource(R.drawable.noelegida)
                ele2T.setBackgroundResource(R.drawable.noelegida)
                ele3T.setBackgroundResource(R.drawable.noelegida)
                ele4T.setBackgroundResource(R.drawable.noelegida)
                ele5T.setBackgroundResource(R.drawable.noelegida)
                ele6T.setBackgroundResource(R.drawable.noelegida)
                ele7T.setBackgroundResource(R.drawable.noelegida)
                ele8T.setBackgroundResource(R.drawable.noelegida)
                ele9T.setBackgroundResource(R.drawable.elegida)
                ele10T.setBackgroundResource(R.drawable.noelegida)


            }
            10 -> {

                ele1T.setBackgroundResource(R.drawable.noelegida)
                ele2T.setBackgroundResource(R.drawable.noelegida)
                ele3T.setBackgroundResource(R.drawable.noelegida)
                ele4T.setBackgroundResource(R.drawable.noelegida)
                ele5T.setBackgroundResource(R.drawable.noelegida)
                ele6T.setBackgroundResource(R.drawable.noelegida)
                ele7T.setBackgroundResource(R.drawable.noelegida)
                ele8T.setBackgroundResource(R.drawable.noelegida)
                ele9T.setBackgroundResource(R.drawable.noelegida)
                ele10T.setBackgroundResource(R.drawable.elegida)
            }
        }
        ele1.setOnClickListener {
            prefs1.melodia = 1
            when (prefs1.melodia) {
                1 -> {

                    ele1.setBackgroundResource(R.drawable.elegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.elegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.elegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.elegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.elegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.elegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.elegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.elegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.elegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele2.setOnClickListener {
            prefs1.melodia = 2
            when (prefs1.melodia) {
                1 -> {

                    ele1.setBackgroundResource(R.drawable.elegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.elegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.elegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.elegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.elegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.elegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.elegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.elegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.elegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele3.setOnClickListener {
            prefs1.melodia = 3
            when (prefs1.melodia) {
                1 -> {

                    ele1.setBackgroundResource(R.drawable.elegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.elegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.elegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.elegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.elegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.elegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.elegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.elegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.elegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele4.setOnClickListener {
            prefs1.melodia = 4
            when (prefs1.melodia) {
                1 -> {

                    ele1.setBackgroundResource(R.drawable.elegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.elegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.elegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.elegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.elegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.elegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.elegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.elegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.elegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele5.setOnClickListener {
            prefs1.melodia = 5
            when (prefs1.melodia) {
                1 -> {

                    ele1.setBackgroundResource(R.drawable.elegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.elegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.elegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.elegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.elegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.elegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.elegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.elegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.elegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele6.setOnClickListener {
            prefs1.melodia = 6
            when (prefs1.melodia) {
                1 -> {

                    ele1.setBackgroundResource(R.drawable.elegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.elegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.elegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.elegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.elegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.elegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.elegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.elegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.elegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele7.setOnClickListener {
            prefs1.melodia = 7
            when (prefs1.melodia) {
                1 -> {

                    ele1.setBackgroundResource(R.drawable.elegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.elegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.elegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.elegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.elegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.elegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.elegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.elegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.elegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele8.setOnClickListener {
            prefs1.melodia = 8
            when (prefs1.melodia) {
                1 -> {

                    ele1.setBackgroundResource(R.drawable.elegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.elegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.elegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.elegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.elegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.elegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.elegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.elegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.elegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele9.setOnClickListener {
            prefs1.melodia = 9
            when (prefs1.melodia) {
                1 -> {

                    ele1.setBackgroundResource(R.drawable.elegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.elegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.elegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.elegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.elegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.elegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.elegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.elegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.elegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele10.setOnClickListener {
            prefs1.melodia = 10
            when (prefs1.melodia) {
                1 -> {

                    ele1.setBackgroundResource(R.drawable.elegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.elegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.elegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.elegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.elegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.elegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.elegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.elegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.elegida)
                    ele10.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1.setBackgroundResource(R.drawable.noelegida)
                    ele2.setBackgroundResource(R.drawable.noelegida)
                    ele3.setBackgroundResource(R.drawable.noelegida)
                    ele4.setBackgroundResource(R.drawable.noelegida)
                    ele5.setBackgroundResource(R.drawable.noelegida)
                    ele6.setBackgroundResource(R.drawable.noelegida)
                    ele7.setBackgroundResource(R.drawable.noelegida)
                    ele8.setBackgroundResource(R.drawable.noelegida)
                    ele9.setBackgroundResource(R.drawable.noelegida)
                    ele10.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele1T.setOnClickListener {
            prefs1.tono = 1
            when (prefs1.tono) {
                1 -> {

                    ele1T.setBackgroundResource(R.drawable.elegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.elegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.elegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.elegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.elegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.elegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.elegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.elegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.elegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele2T.setOnClickListener {
            prefs1.tono = 2
            when (prefs1.tono) {
                1 -> {

                    ele1T.setBackgroundResource(R.drawable.elegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.elegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.elegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.elegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.elegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.elegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.elegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.elegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.elegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.elegida)


                }
            } }
        ele3T.setOnClickListener {
            prefs1.tono = 3
            when (prefs1.tono) {
                1 -> {

                    ele1T.setBackgroundResource(R.drawable.elegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.elegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.elegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.elegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.elegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.elegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.elegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.elegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.elegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele4T.setOnClickListener {
            prefs1.tono = 4
            when (prefs1.tono) {
                1 -> {

                    ele1T.setBackgroundResource(R.drawable.elegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.elegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.elegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.elegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.elegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.elegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.elegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.elegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.elegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele5T.setOnClickListener {
            prefs1.tono = 5
            when (prefs1.tono) {
                1 -> {

                    ele1T.setBackgroundResource(R.drawable.elegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.elegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.elegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.elegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.elegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.elegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.elegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.elegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.elegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele6T.setOnClickListener {
            prefs1.tono = 6
            when (prefs1.tono) {
                1 -> {

                    ele1T.setBackgroundResource(R.drawable.elegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.elegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.elegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.elegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.elegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.elegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.elegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.elegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.elegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele7T.setOnClickListener {
            prefs1.tono = 7
            when (prefs1.tono) {
                1 -> {

                    ele1T.setBackgroundResource(R.drawable.elegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.elegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.elegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.elegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.elegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.elegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.elegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.elegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.elegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele8T.setOnClickListener {
            prefs1.tono = 8
            when (prefs1.tono) {
                1 -> {

                    ele1T.setBackgroundResource(R.drawable.elegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.elegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.elegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.elegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.elegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.elegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.elegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.elegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.elegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele9T.setOnClickListener {
            prefs1.tono = 9
            when (prefs1.tono) {
                1 -> {

                    ele1T.setBackgroundResource(R.drawable.elegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.elegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.elegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.elegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.elegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.elegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.elegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.elegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.elegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        ele10T.setOnClickListener {
            prefs1.tono = 10
            when (prefs1.tono) {
                1 -> {

                    ele1T.setBackgroundResource(R.drawable.elegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                2 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.elegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)

                }
                3 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.elegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                4 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.elegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                5 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.elegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                6 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.elegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                7 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.elegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                8 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.elegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                9 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.elegida)
                    ele10T.setBackgroundResource(R.drawable.noelegida)


                }
                10 -> {

                    ele1T.setBackgroundResource(R.drawable.noelegida)
                    ele2T.setBackgroundResource(R.drawable.noelegida)
                    ele3T.setBackgroundResource(R.drawable.noelegida)
                    ele4T.setBackgroundResource(R.drawable.noelegida)
                    ele5T.setBackgroundResource(R.drawable.noelegida)
                    ele6T.setBackgroundResource(R.drawable.noelegida)
                    ele7T.setBackgroundResource(R.drawable.noelegida)
                    ele8T.setBackgroundResource(R.drawable.noelegida)
                    ele9T.setBackgroundResource(R.drawable.noelegida)
                    ele10T.setBackgroundResource(R.drawable.elegida)


                }
            }
        }
        aplicarr1.setOnClickListener {
            prefs1.tono = 1
            prefs1.melodia = 1
            prefs1.tono1 = 1
            prefs1.melodia1 = 1
            prefs1.volum = 0.10f
            prefs1.volum1 = 1.00f
            if (prefs1.activi == "UsuA") {
                prefs1.activi = "UsuA"
                finish()
                startActivity(Intent(this, Usuarios::class.java))
                Bungee.zoom(this)
            } else if (prefs1.activi == "MenuP") {
                prefs1.activi = "MenuP"
                finish()
                startActivity(Intent(this, MenuPrin::class.java))
                Bungee.zoom(this)
            }

        }
        //Volumen melodia
        val max = 100
        val min = 0
        val total = max - min
             val slider = findViewById<FluidSlider>(R.id.fluidSlider)
        slider.positionListener = { pos -> slider.bubbleText = "${min + (total * pos).toInt()}" }
        slider.position = prefs1.volum
        slider.startText = "$min"
        slider.endText = "$max"

        slider.endTrackingListener = {
            prefs1.volum = slider.position

        }
        //Volumen Tono
        val max1 = 100
        val min1 = 0
        val total1 = max1 - min1

        val slider1 = findViewById<FluidSlider>(R.id.fluidSliderT)
        slider1.positionListener = { pos1 -> slider1.bubbleText = "${min1 + (total1 * pos1).toInt()}" }
        slider1.position = prefs1.volum1
        slider1.startText = "$min1"
        slider1.endText = "$max1"

        slider1.endTrackingListener = {
            prefs1.volum1 = slider1.position

        }
        //tono1
        player_image1T.cancelAnimation()
        song_time1T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime1T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime1T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime1T.toLong())
            )
        )

        start_time11T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime1T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime1T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime1T.toLong())
            )
        )
        buttonPlay1T!!.setOnClickListener {
            mediaPlayer1!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay1T!!.visibility = View.GONE
            if (oTime1T == 0) {
                oTime1T = 1
            }

            player_image1T.playAnimation()
            buttonPlay1T!!.isEnabled = false


            player_image2T.cancelAnimation()
            buttonPlay2T!!.isEnabled = false

            player_image3T.cancelAnimation()
            buttonPlay3T!!.isEnabled = false

            player_image4T.cancelAnimation()
            buttonPlay4T!!.isEnabled = false

            player_image5T.cancelAnimation()
            buttonPlay5T!!.isEnabled = false

            player_image6T.cancelAnimation()
            buttonPlay6T!!.isEnabled = false

            player_image7T.cancelAnimation()
            buttonPlay7T!!.isEnabled = false

            player_image8T.cancelAnimation()
            buttonPlay8T!!.isEnabled = false

            player_image9T.cancelAnimation()
            buttonPlay9T!!.isEnabled = false

            player_image10T.cancelAnimation()
            buttonPlay10T!!.isEnabled = false
        }
        mediaPlayer1!!.setOnCompletionListener {
            try {
                player_image1T.cancelAnimation()
                izf!!.isEnabled = true
                deF!!.isEnabled = true
                buttonPlay1T!!.isEnabled = true
                buttonPlay2T!!.isEnabled = true
                buttonPlay3T!!.isEnabled = true
                buttonPlay4T!!.isEnabled = true
                buttonPlay5T!!.isEnabled = true
                buttonPlay6T!!.isEnabled = true
                buttonPlay7T!!.isEnabled = true
                buttonPlay8T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay10T!!.isEnabled = true
                buttonPlay1T!!.visibility = View.VISIBLE
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //tono2
        player_image2T.cancelAnimation()
        song_time2T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime2T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime2T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime2T.toLong())
            )
        )

        start_time12T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime2T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime2T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime2T.toLong())
            )
        )
        buttonPlay2T!!.setOnClickListener {
            mediaPlayer2!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay2T!!.visibility = View.GONE
            if (oTime2T == 0) {
                oTime2T = 1
            }

            player_image2T.playAnimation()
            buttonPlay2T!!.isEnabled = false


            player_image1T.cancelAnimation()
            buttonPlay1T!!.isEnabled = false

            player_image3T.cancelAnimation()
            buttonPlay3T!!.isEnabled = false

            player_image4T.cancelAnimation()
            buttonPlay4T!!.isEnabled = false

            player_image5T.cancelAnimation()
            buttonPlay5T!!.isEnabled = false

            player_image6T.cancelAnimation()
            buttonPlay6T!!.isEnabled = false

            player_image7T.cancelAnimation()
            buttonPlay7T!!.isEnabled = false

            player_image8T.cancelAnimation()
            buttonPlay8T!!.isEnabled = false

            player_image9T.cancelAnimation()
            buttonPlay9T!!.isEnabled = false

            player_image10T.cancelAnimation()
            buttonPlay10T!!.isEnabled = false
        }
        mediaPlayer2!!.setOnCompletionListener {
            try {
                player_image2T.cancelAnimation()
                izf!!.isEnabled = true
                deF!!.isEnabled = true
                buttonPlay1T!!.isEnabled = true
                buttonPlay2T!!.isEnabled = true
                buttonPlay3T!!.isEnabled = true
                buttonPlay4T!!.isEnabled = true
                buttonPlay5T!!.isEnabled = true
                buttonPlay6T!!.isEnabled = true
                buttonPlay7T!!.isEnabled = true
                buttonPlay8T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay10T!!.isEnabled = true
                buttonPlay2T!!.visibility = View.VISIBLE
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //tono3
        player_image3T.cancelAnimation()
        song_time3T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime3T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime3T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime3T.toLong())
            )
        )

        start_time13T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime3T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime3T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime3T.toLong())
            )
        )
        buttonPlay3T!!.setOnClickListener {
            mediaPlayer3!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay3T!!.visibility = View.GONE
            if (oTime3T == 0) {
                oTime3T = 1
            }

            player_image3T.playAnimation()
            buttonPlay3T!!.isEnabled = false


            player_image2T.cancelAnimation()
            buttonPlay2T!!.isEnabled = false

            player_image1T.cancelAnimation()
            buttonPlay1T!!.isEnabled = false

            player_image4T.cancelAnimation()
            buttonPlay4T!!.isEnabled = false

            player_image5T.cancelAnimation()
            buttonPlay5T!!.isEnabled = false

            player_image6T.cancelAnimation()
            buttonPlay6T!!.isEnabled = false

            player_image7T.cancelAnimation()
            buttonPlay7T!!.isEnabled = false

            player_image8T.cancelAnimation()
            buttonPlay8T!!.isEnabled = false

            player_image9T.cancelAnimation()
            buttonPlay9T!!.isEnabled = false

            player_image10T.cancelAnimation()
            buttonPlay10T!!.isEnabled = false
        }
        mediaPlayer3!!.setOnCompletionListener {
            try {
                player_image3T.cancelAnimation()
                izf!!.isEnabled = true
                deF!!.isEnabled = true
                buttonPlay1T!!.isEnabled = true
                buttonPlay2T!!.isEnabled = true
                buttonPlay3T!!.isEnabled = true
                buttonPlay4T!!.isEnabled = true
                buttonPlay5T!!.isEnabled = true
                buttonPlay6T!!.isEnabled = true
                buttonPlay7T!!.isEnabled = true
                buttonPlay8T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay10T!!.isEnabled = true
                buttonPlay3T!!.visibility = View.VISIBLE
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //tono4
        player_image4T.cancelAnimation()
        song_time4T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime4T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime4T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime4T.toLong())
            )
        )

        start_time14T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime4T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime4T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime4T.toLong())
            )
        )
        buttonPlay4T!!.setOnClickListener {
            mediaPlayer4!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay4T!!.visibility = View.GONE
            if (oTime4T == 0) {
                oTime4T = 1
            }

            player_image4T.playAnimation()
            buttonPlay4T!!.isEnabled = false


            player_image2T.cancelAnimation()
            buttonPlay2T!!.isEnabled = false

            player_image3T.cancelAnimation()
            buttonPlay3T!!.isEnabled = false

            player_image1T.cancelAnimation()
            buttonPlay1T!!.isEnabled = false

            player_image5T.cancelAnimation()
            buttonPlay5T!!.isEnabled = false

            player_image6T.cancelAnimation()
            buttonPlay6T!!.isEnabled = false

            player_image7T.cancelAnimation()
            buttonPlay7T!!.isEnabled = false

            player_image8T.cancelAnimation()
            buttonPlay8T!!.isEnabled = false

            player_image9T.cancelAnimation()
            buttonPlay9T!!.isEnabled = false

            player_image10T.cancelAnimation()
            buttonPlay10T!!.isEnabled = false
        }
        mediaPlayer4!!.setOnCompletionListener {
            try {
                player_image4T.cancelAnimation()
                izf!!.isEnabled = true
                deF!!.isEnabled = true
                buttonPlay4T!!.visibility = View.VISIBLE
                buttonPlay1T!!.isEnabled = true
                buttonPlay2T!!.isEnabled = true
                buttonPlay3T!!.isEnabled = true
                buttonPlay4T!!.isEnabled = true
                buttonPlay5T!!.isEnabled = true
                buttonPlay6T!!.isEnabled = true
                buttonPlay7T!!.isEnabled = true
                buttonPlay8T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay10T!!.isEnabled = true
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //tono5
        player_image5T.cancelAnimation()
        song_time5T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime5T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime5T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime5T.toLong())
            )
        )

        start_time15T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime5T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime5T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime5T.toLong())
            )
        )
        buttonPlay5T!!.setOnClickListener {
            mediaPlayer5!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay5T!!.visibility = View.GONE
            if (oTime5T == 0) {
                oTime5T = 1
            }

            player_image5T.playAnimation()
            buttonPlay5T!!.isEnabled = false


            player_image2T.cancelAnimation()
            buttonPlay2T!!.isEnabled = false

            player_image3T.cancelAnimation()
            buttonPlay3T!!.isEnabled = false

            player_image4T.cancelAnimation()
            buttonPlay4T!!.isEnabled = false

            player_image1T.cancelAnimation()
            buttonPlay1T!!.isEnabled = false

            player_image6T.cancelAnimation()
            buttonPlay6T!!.isEnabled = false

            player_image7T.cancelAnimation()
            buttonPlay7T!!.isEnabled = false

            player_image8T.cancelAnimation()
            buttonPlay8T!!.isEnabled = false

            player_image9T.cancelAnimation()
            buttonPlay9T!!.isEnabled = false

            player_image10T.cancelAnimation()
            buttonPlay10T!!.isEnabled = false
        }
        mediaPlayer5!!.setOnCompletionListener {
            try {
                player_image5T.cancelAnimation()
                izf!!.isEnabled = true
                deF!!.isEnabled = true
                buttonPlay1T!!.isEnabled = true
                buttonPlay2T!!.isEnabled = true
                buttonPlay3T!!.isEnabled = true
                buttonPlay4T!!.isEnabled = true
                buttonPlay5T!!.isEnabled = true
                buttonPlay6T!!.isEnabled = true
                buttonPlay7T!!.isEnabled = true
                buttonPlay8T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay10T!!.isEnabled = true
                buttonPlay5T!!.visibility = View.VISIBLE
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //tono6
        player_image6T.cancelAnimation()
        song_time6T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime6T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime6T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime6T.toLong())
            )
        )

        start_time16T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime6T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime6T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime6T.toLong())
            )
        )
        buttonPlay6T!!.setOnClickListener {
            mediaPlayer6!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay6T!!.visibility = View.GONE
            if (oTime6T == 0) {
                oTime6T = 1
            }

            player_image6T.playAnimation()
            buttonPlay6T!!.isEnabled = false


            player_image2T.cancelAnimation()
            buttonPlay2T!!.isEnabled = false

            player_image3T.cancelAnimation()
            buttonPlay3T!!.isEnabled = false

            player_image4T.cancelAnimation()
            buttonPlay4T!!.isEnabled = false

            player_image5T.cancelAnimation()
            buttonPlay5T!!.isEnabled = false

            player_image1T.cancelAnimation()
            buttonPlay1T!!.isEnabled = false

            player_image7T.cancelAnimation()
            buttonPlay7T!!.isEnabled = false

            player_image8T.cancelAnimation()
            buttonPlay8T!!.isEnabled = false

            player_image9T.cancelAnimation()
            buttonPlay9T!!.isEnabled = false

            player_image10T.cancelAnimation()
            buttonPlay10T!!.isEnabled = false
        }
        mediaPlayer6!!.setOnCompletionListener {
            try {
                player_image6T.cancelAnimation()
                izf!!.isEnabled = true
                deF!!.isEnabled = true
                buttonPlay1T!!.isEnabled = true
                buttonPlay2T!!.isEnabled = true
                buttonPlay3T!!.isEnabled = true
                buttonPlay4T!!.isEnabled = true
                buttonPlay5T!!.isEnabled = true
                buttonPlay6T!!.isEnabled = true
                buttonPlay7T!!.isEnabled = true
                buttonPlay8T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay10T!!.isEnabled = true
                buttonPlay6T!!.visibility = View.VISIBLE
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //tono7
        player_image7T.cancelAnimation()
        song_time7T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime7T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime7T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime7T.toLong())
            )
        )

        start_time17T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime7T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime7T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime7T.toLong())
            )
        )
        buttonPlay7T!!.setOnClickListener {
            mediaPlayer7!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay7T!!.visibility = View.GONE
            if (oTime7T == 0) {
                oTime7T = 1
            }

            player_image7T.playAnimation()
            buttonPlay7T!!.isEnabled = false


            player_image2T.cancelAnimation()
            buttonPlay2T!!.isEnabled = false

            player_image3T.cancelAnimation()
            buttonPlay3T!!.isEnabled = false

            player_image4T.cancelAnimation()
            buttonPlay4T!!.isEnabled = false

            player_image5T.cancelAnimation()
            buttonPlay5T!!.isEnabled = false

            player_image6T.cancelAnimation()
            buttonPlay6T!!.isEnabled = false

            player_image1T.cancelAnimation()
            buttonPlay1T!!.isEnabled = false

            player_image8T.cancelAnimation()
            buttonPlay8T!!.isEnabled = false

            player_image9T.cancelAnimation()
            buttonPlay9T!!.isEnabled = false

            player_image10T.cancelAnimation()
            buttonPlay10T!!.isEnabled = false
        }
        mediaPlayer7!!.setOnCompletionListener {
            try {
                player_image7T.cancelAnimation()
                izf!!.isEnabled = true
                deF!!.isEnabled = true
                buttonPlay7T!!.visibility = View.VISIBLE
                buttonPlay1T!!.isEnabled = true
                buttonPlay2T!!.isEnabled = true
                buttonPlay3T!!.isEnabled = true
                buttonPlay4T!!.isEnabled = true
                buttonPlay5T!!.isEnabled = true
                buttonPlay6T!!.isEnabled = true
                buttonPlay7T!!.isEnabled = true
                buttonPlay8T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay10T!!.isEnabled = true
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //tono8
        player_image8T.cancelAnimation()
        song_time8T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime8T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime8T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime8T.toLong())
            )
        )

        start_time18T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime8T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime8T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime8T.toLong())
            )
        )
        buttonPlay8T!!.setOnClickListener {
            mediaPlayer8!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay8T!!.visibility = View.GONE
            if (oTime8T == 0) {
                oTime8T = 1
            }

            player_image8T.playAnimation()
            buttonPlay8T!!.isEnabled = false


            player_image2T.cancelAnimation()
            buttonPlay2T!!.isEnabled = false

            player_image3T.cancelAnimation()
            buttonPlay3T!!.isEnabled = false

            player_image4T.cancelAnimation()
            buttonPlay4T!!.isEnabled = false

            player_image5T.cancelAnimation()
            buttonPlay5T!!.isEnabled = false

            player_image6T.cancelAnimation()
            buttonPlay6T!!.isEnabled = false

            player_image7T.cancelAnimation()
            buttonPlay7T!!.isEnabled = false

            player_image1T.cancelAnimation()
            buttonPlay1T!!.isEnabled = false

            player_image9T.cancelAnimation()
            buttonPlay9T!!.isEnabled = false

            player_image10T.cancelAnimation()
            buttonPlay10T!!.isEnabled = false
        }
        mediaPlayer8!!.setOnCompletionListener {
            try {
                player_image8T.cancelAnimation()
                izf!!.isEnabled = true
                deF!!.isEnabled = true
                buttonPlay8T!!.visibility = View.VISIBLE
                buttonPlay1T!!.isEnabled = true
                buttonPlay2T!!.isEnabled = true
                buttonPlay3T!!.isEnabled = true
                buttonPlay4T!!.isEnabled = true
                buttonPlay5T!!.isEnabled = true
                buttonPlay6T!!.isEnabled = true
                buttonPlay7T!!.isEnabled = true
                buttonPlay8T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay10T!!.isEnabled = true
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //tono9
        player_image9T.cancelAnimation()
        song_time9T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime9T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime9T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime9T.toLong())
            )
        )

        start_time19T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime9T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime9T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime9T.toLong())
            )
        )
        buttonPlay9T!!.setOnClickListener {
            mediaPlayer9!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay9T!!.visibility = View.GONE
            if (oTime9T == 0) {
                oTime9T = 1
            }

            player_image9T.playAnimation()
            buttonPlay9T!!.isEnabled = false


            player_image2T.cancelAnimation()
            buttonPlay2T!!.isEnabled = false

            player_image3T.cancelAnimation()
            buttonPlay3T!!.isEnabled = false

            player_image4T.cancelAnimation()
            buttonPlay4T!!.isEnabled = false

            player_image5T.cancelAnimation()
            buttonPlay5T!!.isEnabled = false

            player_image6T.cancelAnimation()
            buttonPlay6T!!.isEnabled = false

            player_image7T.cancelAnimation()
            buttonPlay7T!!.isEnabled = false

            player_image8T.cancelAnimation()
            buttonPlay8T!!.isEnabled = false

            player_image1T.cancelAnimation()
            buttonPlay1T!!.isEnabled = false

            player_image10T.cancelAnimation()
            buttonPlay10T!!.isEnabled = false
        }
        mediaPlayer9!!.setOnCompletionListener {
            try {
                player_image9T.cancelAnimation()
                izf!!.isEnabled = true
                deF!!.isEnabled = true
                buttonPlay1T!!.isEnabled = true
                buttonPlay2T!!.isEnabled = true
                buttonPlay3T!!.isEnabled = true
                buttonPlay4T!!.isEnabled = true
                buttonPlay5T!!.isEnabled = true
                buttonPlay6T!!.isEnabled = true
                buttonPlay7T!!.isEnabled = true
                buttonPlay8T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay10T!!.isEnabled = true
                buttonPlay9T!!.visibility = View.VISIBLE
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //tono10
        player_image10T.cancelAnimation()
        song_time10T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime10T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime10T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime10T.toLong())
            )
        )

        start_time110T!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime10T.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime10T.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime10T.toLong())
            )
        )
        buttonPlay10T!!.setOnClickListener {
            mediaPlayer10!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay10T!!.visibility = View.GONE
            if (oTime10T == 0) {
                oTime10T = 1
            }

            player_image10T.playAnimation()
            buttonPlay10T!!.isEnabled = false


            player_image2T.cancelAnimation()
            buttonPlay2T!!.isEnabled = false

            player_image3T.cancelAnimation()
            buttonPlay3T!!.isEnabled = false

            player_image4T.cancelAnimation()
            buttonPlay4T!!.isEnabled = false

            player_image5T.cancelAnimation()
            buttonPlay5T!!.isEnabled = false

            player_image6T.cancelAnimation()
            buttonPlay6T!!.isEnabled = false

            player_image7T.cancelAnimation()
            buttonPlay7T!!.isEnabled = false

            player_image8T.cancelAnimation()
            buttonPlay8T!!.isEnabled = false

            player_image9T.cancelAnimation()
            buttonPlay9T!!.isEnabled = false

            player_image1T.cancelAnimation()
            buttonPlay1T!!.isEnabled = false
        }
        mediaPlayer10!!.setOnCompletionListener {
            try {
                player_image10T.cancelAnimation()
                izf!!.isEnabled = true
                deF!!.isEnabled = true
                buttonPlay1T!!.isEnabled = true
                buttonPlay2T!!.isEnabled = true
                buttonPlay3T!!.isEnabled = true
                buttonPlay4T!!.isEnabled = true
                buttonPlay5T!!.isEnabled = true
                buttonPlay6T!!.isEnabled = true
                buttonPlay7T!!.isEnabled = true
                buttonPlay8T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay9T!!.isEnabled = true
                buttonPlay10T!!.isEnabled = true
                buttonPlay10T!!.visibility = View.VISIBLE
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        //Melodia1
        seekbar1!!.setClickable(false)
        buttonPause1!!.isEnabled = false
        player_image1.cancelAnimation()
        song_time1!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime1.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime1.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime1.toLong())
            )
        )

        start_time11!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime1.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime1.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime1.toLong())
            )
        )
        buttonPlay1!!.setOnClickListener {
            mediaPlayer11!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay1!!.visibility = View.GONE
            buttonPause1!!.visibility = View.VISIBLE
            if (oTime1 == 0) {
                seekbar1!!.setMax(eTime1)
                oTime1 = 1
            }
            player_image1.playAnimation()
            seekbar1?.setProgress(sTime1)
            hdlr1.postDelayed(updateSongTime1, 100)
            buttonPause1!!.isEnabled = true
            buttonPlay1!!.isEnabled = false


            player_image2.cancelAnimation()
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = false

            player_image3.cancelAnimation()
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = false

            player_image4.cancelAnimation()
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = false

            player_image5.cancelAnimation()
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = false

            player_image6.cancelAnimation()
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = false

            player_image7.cancelAnimation()
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = false

            player_image8.cancelAnimation()
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = false

            player_image9.cancelAnimation()
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = false

            player_image10.cancelAnimation()
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = false
        }
        buttonPause1!!.setOnClickListener {
            mediaPlayer11!!.pause()
            buttonPlay1!!.visibility = View.VISIBLE
            buttonPause1!!.visibility = View.GONE
            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = true
            player_image1.cancelAnimation()
            izf!!.isEnabled = true
            deF!!.isEnabled =true
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = true
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = true
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = true
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = true
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = true
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = true
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = true
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = true
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = true


        }
        seekbar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {


            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer11!!.seekTo(progress)

                }


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        mediaPlayer11!!.setOnCompletionListener {
            try {
                mediaPlayer11!!.start()
                seekbar1.progress = sTime1
                mediaPlayer11!!.isLooping = true
                player_image1.cancelAnimation()
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //Melodia2
        seekbar2!!.setClickable(false)
        buttonPause2!!.isEnabled = false
        player_image2.cancelAnimation()
        song_time2!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime2.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime2.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime2.toLong())
            )
        )

        start_time12!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime2.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime2.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime2.toLong())
            )
        )
        buttonPlay2!!.setOnClickListener {
                izf!!.isEnabled = false
            deF!!.isEnabled = false
            mediaPlayer21!!.start()
            buttonPlay2!!.visibility = View.GONE
            buttonPause2!!.visibility = View.VISIBLE
            if (oTime2 == 0) {
                seekbar2!!.setMax(eTime2)
                oTime2 = 1
            }
            player_image2.playAnimation()
            seekbar2?.setProgress(sTime2)
            hdlr2.postDelayed(updateSongTime2, 100)
            buttonPause2!!.isEnabled = true
            buttonPlay2!!.isEnabled = false


            player_image1.cancelAnimation()
            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = false

            player_image3.cancelAnimation()
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = false

            player_image4.cancelAnimation()
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = false

            player_image5.cancelAnimation()
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = false

            player_image6.cancelAnimation()
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = false

            player_image7.cancelAnimation()
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = false

            player_image8.cancelAnimation()
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = false

            player_image9.cancelAnimation()
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = false

            player_image10.cancelAnimation()
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = false
        }
        buttonPause2!!.setOnClickListener {
            izf!!.isEnabled = true
            deF!!.isEnabled = true
            mediaPlayer21!!.pause()
            buttonPlay2!!.visibility = View.VISIBLE
            buttonPause2!!.visibility = View.GONE
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = true
            player_image2.cancelAnimation()

            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = true
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = true
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = true
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = true
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = true
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = true
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = true
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = true
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = true
        }
        seekbar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {


            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer21!!.seekTo(progress)

                }


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        mediaPlayer21!!.setOnCompletionListener {
            try {
                mediaPlayer21!!.start()
                seekbar2.progress = sTime2
                mediaPlayer21!!.isLooping = true
                player_image2.cancelAnimation()
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //Melodia3
        seekbar3!!.setClickable(false)
        buttonPause3!!.isEnabled = false
        player_image3.cancelAnimation()
        song_time3!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime3.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime3.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime3.toLong())
            )
        )

        start_time13!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime3.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime3.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime3.toLong())
            )
        )
        buttonPlay3!!.setOnClickListener {
            mediaPlayer31!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay3!!.visibility = View.GONE
            buttonPause3!!.visibility = View.VISIBLE
            if (oTime3 == 0) {
                seekbar3!!.setMax(eTime3)
                oTime3 = 1
            }
            player_image3.playAnimation()
            seekbar3?.setProgress(sTime3)
            hdlr3.postDelayed(updateSongTime3, 100)
            buttonPause3!!.isEnabled = true
            buttonPlay3!!.isEnabled = false


            player_image1.cancelAnimation()
            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = false

            player_image2.cancelAnimation()
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = false
      player_image4.cancelAnimation()
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = false

            player_image5.cancelAnimation()
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = false

            player_image6.cancelAnimation()
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = false

            player_image7.cancelAnimation()
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = false

            player_image8.cancelAnimation()
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = false

            player_image9.cancelAnimation()
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = false

            player_image10.cancelAnimation()
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = false
        }
        buttonPause3!!.setOnClickListener {
            mediaPlayer31!!.pause()
            izf!!.isEnabled = true
            deF!!.isEnabled = true
            buttonPlay3!!.visibility = View.VISIBLE
            buttonPause3!!.visibility = View.GONE
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = true
            player_image3.cancelAnimation()
            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = true
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = true
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = true
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = true
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = true
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = true
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = true
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = true
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = true
        }
        seekbar3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {


            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer31!!.seekTo(progress)

                }


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        mediaPlayer31!!.setOnCompletionListener {
            try {
                mediaPlayer31!!.start()
                seekbar3.progress = sTime3
                mediaPlayer31!!.isLooping = true
                player_image3.cancelAnimation()
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //Melodia4
        seekbar4!!.setClickable(false)
        buttonPause4!!.isEnabled = false
        player_image4.cancelAnimation()
        song_time4!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime4.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime4.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime4.toLong())
            )
        )

        start_time14!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime4.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime4.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime4.toLong())
            )
        )
        buttonPlay4!!.setOnClickListener {
            mediaPlayer41!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay4!!.visibility = View.GONE
            buttonPause4!!.visibility = View.VISIBLE
            if (oTime4 == 0) {
                seekbar4!!.setMax(eTime4)
                oTime4 = 1
            }
            player_image4.playAnimation()
            seekbar4?.setProgress(sTime4)
            hdlr4.postDelayed(updateSongTime4, 100)
            buttonPause4!!.isEnabled = true
            buttonPlay4!!.isEnabled = false


            player_image1.cancelAnimation()
            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = false

            player_image2.cancelAnimation()
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = false

            player_image3.cancelAnimation()
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = false

            player_image5.cancelAnimation()
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = false

            player_image6.cancelAnimation()
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = false

            player_image7.cancelAnimation()
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = false

            player_image8.cancelAnimation()
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = false

            player_image9.cancelAnimation()
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = false

            player_image10.cancelAnimation()
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = false
        }
        buttonPause4!!.setOnClickListener {
            mediaPlayer41!!.pause()
            izf!!.isEnabled = true
            deF!!.isEnabled = true
            buttonPlay4!!.visibility = View.VISIBLE
            buttonPause4!!.visibility = View.GONE
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = true
            player_image4.cancelAnimation()


            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = true
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = true
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = true
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = true
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = true
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = true
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = true
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = true
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = true
        }
        seekbar4.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {


            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer41!!.seekTo(progress)

                }


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        mediaPlayer41!!.setOnCompletionListener {
            try {
                mediaPlayer41!!.start()
                seekbar4.progress = sTime4
                mediaPlayer41!!.isLooping = true
                player_image4.cancelAnimation()
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //Melodia5
        seekbar5!!.setClickable(false)
        buttonPause5!!.isEnabled = false
        player_image5.cancelAnimation()
        song_time5!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime5.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime5.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime5.toLong())
            )
        )

        start_time15!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime5.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime5.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime5.toLong())
            )
        )
        buttonPlay5!!.setOnClickListener {
            mediaPlayer51!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay5!!.visibility = View.GONE
            buttonPause5!!.visibility = View.VISIBLE
            if (oTime5 == 0) {
                seekbar5!!.setMax(eTime5)
                oTime5 = 1
            }
            player_image5.playAnimation()
            seekbar5?.setProgress(sTime5)
            hdlr5.postDelayed(updateSongTime5, 100)
            buttonPause5!!.isEnabled = true
            buttonPlay5!!.isEnabled = false


            player_image1.cancelAnimation()
            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = false

            player_image2.cancelAnimation()
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = false

            player_image3.cancelAnimation()
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = false

            player_image4.cancelAnimation()
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = false
           player_image6.cancelAnimation()
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = false

            player_image7.cancelAnimation()
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = false

            player_image8.cancelAnimation()
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = false

            player_image9.cancelAnimation()
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = false

            player_image10.cancelAnimation()
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = false
        }
        buttonPause5!!.setOnClickListener {
            mediaPlayer51!!.pause()
            izf!!.isEnabled = true
            deF!!.isEnabled = true
            buttonPlay5!!.visibility = View.VISIBLE
            buttonPause5!!.visibility = View.GONE
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = true
            player_image5.cancelAnimation()

            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = true
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = true
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = true
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = true
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = true
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = true
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = true
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = true
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = true
        }
        seekbar5.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {


            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer51!!.seekTo(progress)

                }


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        mediaPlayer51!!.setOnCompletionListener {
            try {
                mediaPlayer51!!.start()
                seekbar5.progress = sTime5
                mediaPlayer51!!.isLooping = true
                player_image5.cancelAnimation()
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //Melodia6
        seekbar6!!.setClickable(false)
        buttonPause6!!.isEnabled = false
        player_image6.cancelAnimation()
        song_time6!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime6.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime6.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime6.toLong())
            )
        )

        start_time16!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime6.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime6.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime6.toLong())
            )
        )
        buttonPlay6!!.setOnClickListener {
            mediaPlayer61!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay6!!.visibility = View.GONE
            buttonPause6!!.visibility = View.VISIBLE
            if (oTime6 == 0) {
                seekbar6!!.setMax(eTime6)
                oTime6 = 1
            }
            player_image6.playAnimation()
            seekbar6?.setProgress(sTime6)
            hdlr6.postDelayed(updateSongTime6, 100)
            buttonPause6!!.isEnabled = true
            buttonPlay6!!.isEnabled = false

         player_image1.cancelAnimation()
            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = false

            player_image2.cancelAnimation()
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = false

            player_image3.cancelAnimation()
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = false

            player_image4.cancelAnimation()
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = false

            player_image5.cancelAnimation()
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = false

            player_image7.cancelAnimation()
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = false

            player_image8.cancelAnimation()
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = false

            player_image9.cancelAnimation()
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = false

            player_image10.cancelAnimation()
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = false
        }
        buttonPause6!!.setOnClickListener {
            mediaPlayer61!!.pause()
            izf!!.isEnabled = true
            deF!!.isEnabled = true
            buttonPlay6!!.visibility = View.VISIBLE
            buttonPause6!!.visibility = View.GONE
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = true
            player_image6.cancelAnimation()

            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = true
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = true
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = true
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = true
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = true
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = true
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = true
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = true
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = true
        }
        seekbar6.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {


            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer61!!.seekTo(progress)

                }


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        mediaPlayer61!!.setOnCompletionListener {
            try {
                mediaPlayer61!!.start()
                seekbar6.progress = sTime6
                mediaPlayer61!!.isLooping = true
                player_image6.cancelAnimation()
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //Melodia7
        seekbar7!!.setClickable(false)
        buttonPause7!!.isEnabled = false
        player_image7.cancelAnimation()
        song_time7!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime7.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime7.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime7.toLong())
            )
        )

        start_time17!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime7.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime7.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime7.toLong())
            )
        )
        buttonPlay7!!.setOnClickListener {
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            mediaPlayer71!!.start()
            buttonPlay7!!.visibility = View.GONE
            buttonPause7!!.visibility = View.VISIBLE
            if (oTime7 == 0) {
                seekbar7!!.setMax(eTime7)
                oTime7 = 1
            }
            player_image7.playAnimation()
            seekbar7?.setProgress(sTime7)
            hdlr7.postDelayed(updateSongTime7, 100)
            buttonPause7!!.isEnabled = true
            buttonPlay7!!.isEnabled = false


            player_image1.cancelAnimation()
            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = false

            player_image2.cancelAnimation()
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = false
                  player_image3.cancelAnimation()
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = false

            player_image4.cancelAnimation()
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = false

            player_image5.cancelAnimation()
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = false

            player_image6.cancelAnimation()
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = false

            player_image8.cancelAnimation()
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = false

            player_image9.cancelAnimation()
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = false

            player_image10.cancelAnimation()
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = false
        }
        buttonPause7!!.setOnClickListener {
            izf!!.isEnabled = true
            deF!!.isEnabled = true
            mediaPlayer71!!.pause()
            buttonPlay7!!.visibility = View.VISIBLE
            buttonPause7!!.visibility = View.GONE
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = true
            player_image7.cancelAnimation()

            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = true
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = true
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = true
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = true
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = true
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = true
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = true
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = true
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = true
        }
        seekbar7.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {


            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer71!!.seekTo(progress)

                }


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        mediaPlayer71!!.setOnCompletionListener {
            try {
                mediaPlayer71!!.start()
                seekbar7.progress = sTime7
                mediaPlayer71!!.isLooping = true
                player_image7.cancelAnimation()
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //Melodia8
        seekbar8!!.setClickable(false)
        buttonPause8!!.isEnabled = false
        player_image8.cancelAnimation()
        song_time8!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime8.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime8.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime8.toLong())
            )
        )

        start_time18!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime8.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime8.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime8.toLong())
            )
        )
        buttonPlay8!!.setOnClickListener {
            mediaPlayer81!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay8!!.visibility = View.GONE
            buttonPause8!!.visibility = View.VISIBLE
            if (oTime8 == 0) {
                seekbar8!!.setMax(eTime3)
                oTime8 = 1
            }
            player_image8.playAnimation()
            seekbar8?.setProgress(sTime8)
            hdlr8.postDelayed(updateSongTime8, 100)
            buttonPause8!!.isEnabled = true
            buttonPlay8!!.isEnabled = false



            player_image1.cancelAnimation()
            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = false

            player_image2.cancelAnimation()
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = false

            player_image3.cancelAnimation()
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = false

            player_image4.cancelAnimation()
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = false

            player_image5.cancelAnimation()
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = false

            player_image6.cancelAnimation()
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = false

            player_image7.cancelAnimation()
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = false

            player_image9.cancelAnimation()
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = false
             player_image10.cancelAnimation()
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = false
        }
        buttonPause8!!.setOnClickListener {
            mediaPlayer81!!.pause()
            izf!!.isEnabled = true
            deF!!.isEnabled = true
            buttonPlay8!!.visibility = View.VISIBLE
            buttonPause8!!.visibility = View.GONE
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = true
            player_image8.cancelAnimation()

            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = true
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = true
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = true
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = true
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = true
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = true
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = true
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = true
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = true
        }
        seekbar8.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {


            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer81!!.seekTo(progress)

                }


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        mediaPlayer81!!.setOnCompletionListener {
            try {
                mediaPlayer81!!.start()
                seekbar8.progress = sTime8
                mediaPlayer81!!.isLooping = true
                player_image8.cancelAnimation()
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //Melodia9
        seekbar9!!.setClickable(false)
        buttonPause9!!.isEnabled = false
        player_image9.cancelAnimation()
        song_time9!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime9.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime9.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime9.toLong())
            )
        )

        start_time19!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime9.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime9.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime9.toLong())
            )
        )
        buttonPlay9!!.setOnClickListener {
            mediaPlayer91!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay9!!.visibility = View.GONE
            buttonPause9!!.visibility = View.VISIBLE
            if (oTime9 == 0) {
                seekbar9!!.setMax(eTime9)
                oTime9 = 1
            }
            player_image9.playAnimation()
            seekbar9?.setProgress(sTime9)
            hdlr9.postDelayed(updateSongTime9, 100)
            buttonPause9!!.isEnabled = true
            buttonPlay9!!.isEnabled = false

            player_image1.cancelAnimation()
            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = false

            player_image2.cancelAnimation()
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = false

            player_image3.cancelAnimation()
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = false

            player_image4.cancelAnimation()
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = false

            player_image5.cancelAnimation()
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = false

            player_image6.cancelAnimation()
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = false

            player_image7.cancelAnimation()
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = false

            player_image8.cancelAnimation()
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = false

            player_image10.cancelAnimation()
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = false
        }
        buttonPause9!!.setOnClickListener {
            mediaPlayer91!!.pause()
            izf!!.isEnabled = true
            deF!!.isEnabled = true
            buttonPlay9!!.visibility = View.VISIBLE
            buttonPause9!!.visibility = View.GONE
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = true
            player_image9.cancelAnimation()

            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = true
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = true
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = true
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = true
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = true
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = true
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = true
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = true
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = true
        }
        seekbar9.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {


            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer91!!.seekTo(progress)

                }


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        mediaPlayer91!!.setOnCompletionListener {
            try {
                mediaPlayer91!!.start()
                seekbar9.progress = sTime9
                mediaPlayer91!!.isLooping = true
                player_image9.cancelAnimation()
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        //Melodia10
        seekbar10!!.setClickable(false)
        buttonPause10!!.isEnabled = false
        player_image10.cancelAnimation()
        song_time10!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime10.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(eTime10.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(eTime10.toLong())
            )
        )

        start_time110!!.text = String.format(
            "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime10.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(sTime10.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(sTime10.toLong())
            )
        )
        buttonPlay10!!.setOnClickListener {
            mediaPlayer101!!.start()
            izf!!.isEnabled = false
            deF!!.isEnabled = false
            buttonPlay10!!.visibility = View.GONE
            buttonPause10!!.visibility = View.VISIBLE
            if (oTime10 == 0) {
                seekbar10!!.setMax(eTime10)
                oTime10 = 1
            }
            player_image10.playAnimation()
            seekbar10?.setProgress(sTime10)
            hdlr10.postDelayed(updateSongTime10, 100)
            buttonPause10!!.isEnabled = true
            buttonPlay10!!.isEnabled = false

            player_image1.cancelAnimation()
            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = false

            player_image2.cancelAnimation()
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = false

            player_image3.cancelAnimation()
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = false

            player_image4.cancelAnimation()
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = false

            player_image5.cancelAnimation()
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = false

            player_image6.cancelAnimation()
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = false

            player_image7.cancelAnimation()
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = false

            player_image8.cancelAnimation()
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = false

            player_image9.cancelAnimation()
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = false
        }
        buttonPause10!!.setOnClickListener {
            mediaPlayer101!!.pause()
            izf!!.isEnabled = true
            deF!!.isEnabled = true
            buttonPlay10!!.visibility = View.VISIBLE
            buttonPause10!!.visibility = View.GONE
            buttonPause10!!.isEnabled = false
            buttonPlay10!!.isEnabled = true
            player_image10.cancelAnimation()
            buttonPause1!!.isEnabled = false
            buttonPlay1!!.isEnabled = true
            buttonPause2!!.isEnabled = false
            buttonPlay2!!.isEnabled = true
            buttonPause3!!.isEnabled = false
            buttonPlay3!!.isEnabled = true
            buttonPause4!!.isEnabled = false
            buttonPlay4!!.isEnabled = true
            buttonPause5!!.isEnabled = false
            buttonPlay5!!.isEnabled = true
            buttonPause6!!.isEnabled = false
            buttonPlay6!!.isEnabled = true
            buttonPause7!!.isEnabled = false
            buttonPlay7!!.isEnabled = true
            buttonPause8!!.isEnabled = false
            buttonPlay8!!.isEnabled = true
            buttonPause9!!.isEnabled = false
            buttonPlay9!!.isEnabled = true
        }
        seekbar10.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {


            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer101!!.seekTo(progress)

                }


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        mediaPlayer101!!.setOnCompletionListener {
            try {
                mediaPlayer101!!.start()
                seekbar10.progress = sTime10
                mediaPlayer101!!.isLooping = true
                player_image10.cancelAnimation()
            } catch (e: Exception) {
                Toast.makeText(this@Audio, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val updateSongTime1: Runnable = object : Runnable {
        @SuppressLint("DefaultLocale")
        override fun run() {
            sTime1 = mediaPlayer11!!.currentPosition
            start_time11!!.text = String.format(
                "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime1.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(sTime1.toLong()) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(sTime1.toLong())
                )
            )
            seekbar1!!.progress = sTime1
            hdlr1.postDelayed(this, 100)
        }
    }
    private val updateSongTime2: Runnable = object : Runnable {
        @SuppressLint("DefaultLocale")
        override fun run() {
            sTime2 = mediaPlayer21!!.currentPosition
            start_time12!!.text = String.format(
                "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime2.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(sTime2.toLong()) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(sTime2.toLong())
                )
            )
            seekbar2!!.progress = sTime2
            hdlr2.postDelayed(this, 100)
        }
    }
    private val updateSongTime3: Runnable = object : Runnable {
        @SuppressLint("DefaultLocale")
        override fun run() {
            sTime3 = mediaPlayer31!!.currentPosition
            start_time13!!.text = String.format(
                "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime3.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(sTime3.toLong()) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(sTime3.toLong())
                )
            )
            seekbar3!!.progress = sTime3
            hdlr3.postDelayed(this, 100)
        }
    }
    private val updateSongTime4: Runnable = object : Runnable {
        @SuppressLint("DefaultLocale")
        override fun run() {
            sTime4 = mediaPlayer41!!.currentPosition
            start_time14!!.text = String.format(
                "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime4.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(sTime4.toLong()) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(sTime4.toLong())
                )
            )
            seekbar4!!.progress = sTime4
            hdlr4.postDelayed(this, 100)
        }
    }
    private val updateSongTime5: Runnable = object : Runnable {
        @SuppressLint("DefaultLocale")
        override fun run() {
            sTime5 = mediaPlayer51!!.currentPosition
            start_time15!!.text = String.format(
                "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime5.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(sTime5.toLong()) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(sTime5.toLong())
                )
            )
            seekbar5!!.progress = sTime5
            hdlr5.postDelayed(this, 100)
        }
    }
    private val updateSongTime6: Runnable = object : Runnable {
        @SuppressLint("DefaultLocale")
        override fun run() {
            sTime6 = mediaPlayer61!!.currentPosition
            start_time16!!.text = String.format(
                "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime6.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(sTime6.toLong()) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(sTime6.toLong())
                )
            )
            seekbar6!!.progress = sTime6
            hdlr6.postDelayed(this, 100)
        }
    }
    private val updateSongTime7: Runnable = object : Runnable {
        @SuppressLint("DefaultLocale")
        override fun run() {
            sTime7 = mediaPlayer71!!.currentPosition
            start_time17!!.text = String.format(
                "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime7.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(sTime7.toLong()) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(sTime7.toLong())
                )
            )
            seekbar7!!.progress = sTime7
            hdlr7.postDelayed(this, 100)
        }
    }
    private val updateSongTime8: Runnable = object : Runnable {
        @SuppressLint("DefaultLocale")
        override fun run() {
            sTime8 = mediaPlayer81!!.currentPosition
            start_time18!!.text = String.format(
                "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime8.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(sTime8.toLong()) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(sTime8.toLong())
                )
            )
            seekbar8!!.progress = sTime8
            hdlr8.postDelayed(this, 100)
        }
    }
    private val updateSongTime9: Runnable = object : Runnable {
        @SuppressLint("DefaultLocale")
        override fun run() {
            sTime9 = mediaPlayer91!!.currentPosition
            start_time19!!.text = String.format(
                "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime9.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(sTime9.toLong()) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(sTime9.toLong())
                )
            )
            seekbar9!!.progress = sTime9
            hdlr9.postDelayed(this, 100)
        }
    }
    private val updateSongTime10: Runnable = object : Runnable {
        @SuppressLint("DefaultLocale")
        override fun run() {
            sTime10 = mediaPlayer101!!.currentPosition
            start_time110!!.text = String.format(
                "%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime10.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(sTime10.toLong()) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(sTime10.toLong())
                )
            )
            seekbar10!!.progress = sTime10
            hdlr10.postDelayed(this, 100)
        }
    }

    override fun onBackPressed() {
        mediaPlayer1!!.stop()
        mediaPlayer2!!.stop()
        mediaPlayer3!!.stop()
        mediaPlayer4!!.stop()
        mediaPlayer5!!.stop()
        mediaPlayer6!!.stop()
        mediaPlayer7!!.stop()
        mediaPlayer8!!.stop()
        mediaPlayer9!!.stop()
        mediaPlayer10!!.stop()

        mediaPlayer11!!.stop()
        mediaPlayer21!!.stop()
        mediaPlayer31!!.stop()
        mediaPlayer41!!.stop()
        mediaPlayer51!!.stop()
        mediaPlayer61!!.stop()
        mediaPlayer71!!.stop()
        mediaPlayer81!!.stop()
        mediaPlayer91!!.stop()
        mediaPlayer101!!.stop()
        val Archivo1 = "Audio"
        val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
        if (prefs1.activi == "UsuA") {
            prefs1.activi = "UsuA"
            finish()
            startActivity(Intent(this, Usuarios::class.java))
            Bungee.zoom(this)
        } else if (prefs1.activi == "MenuP") {
            prefs1.activi = "MenuP"
            finish()
            startActivity(Intent(this, MenuPrin::class.java))
            Bungee.zoom(this)
        }
    }

}