package com.bp.braapptutor.games.adivinanzas

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.bp.braapptutor.R
import com.bp.braapptutor.catalogo.MenuCatalogo
import com.bp.braapptutor.chat.activity.LoginActivity
import com.bp.braapptutor.chat.activity.UsersActivity
import com.bp.braapptutor.chat.firebase.FirebaseService
import com.bp.braapptutor.extra.Extras
import com.bp.braapptutor.games.MenuJuegos
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.contador
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.contadorE
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.contadorV
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.correo
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.foto
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.idUsuario
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.nombreUs
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.rmayM
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.rmaya
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.rmaynum
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.rminM
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.rminsim
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.rminsimb
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.rnumM
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.rnuma
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper.rsimM
import com.bp.braapptutor.history.historia
import com.bp.braapptutor.inicio.Splash
import com.bp.braapptutor.inicio.Splash.PreferenceHelper.password
import com.bp.braapptutor.inicio.Splash.PreferenceHelper.sele1
import com.bp.braapptutor.inicio.Splash.PreferenceHelper.userId
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.activi
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.tono
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.volum
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.volum1
import com.bp.braapptutor.inicio.Splash.PreferenceHelper2.entrada
import com.bp.braapptutor.inicio.Usuarios
import com.bp.braapptutor.mate.materialapoyo
import com.bp.braapptutor.menuprincipal.MenuPrin
import com.bp.braapptutor.redes.Red
import com.bp.braapptutor.traductor.Traductores
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_adivi3.*
import kotlinx.android.synthetic.main.activity_adivi3.mue1
import kotlinx.android.synthetic.main.activity_adivi3.mue2
import kotlinx.android.synthetic.main.activity_adivi3.mue3
import kotlinx.android.synthetic.main.activity_cerrarchat.*
import kotlinx.android.synthetic.main.activity_cerrarchat1.*
import kotlinx.android.synthetic.main.activity_pista.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.io.IOException

class adivi3 : AppCompatActivity() {
    var noUno2 = 0
    var noDos2 = 0
    var noTres2 = 0
    var noCuatro2 = 0
    var noCinco2 = 0
    var noSeis2 = 0
    var cadena4 = ""
    var marcador = 0
    var equi = 1
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private var mAuth: FirebaseAuth? = null
    var adivinanzaResp = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivi3)
        val Archivo = "Usuario"
        val defaultPrefs1 = Splash.PreferenceHelper.defaultPreference(this)
        defaultPrefs1.password = "Admin"
        defaultPrefs1.userId = 50
        val prefs1 = Splash.PreferenceHelper.customPreference(this, Archivo)
        val texto2: LinearLayout = findViewById(R.id.adivi3)
        //Asignacioón de las animaciones
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto2.startAnimation(anim1)
        val namem1 = prefs1.password
        val fotom = prefs1.userId.toString()
        userj5.text = namem1
        when {
            fotom.toInt() == 0 -> {
                fotoj5.setBackgroundResource(R.drawable.nina)
            }
            fotom.toInt() == 1 -> {
                fotoj5.setBackgroundResource(R.drawable.nino)
            }
            fotom.toInt() == 2 -> {
                fotoj5.setBackgroundResource(R.drawable.jovena)
            }
            fotom.toInt() == 3 -> {
                fotoj5.setBackgroundResource(R.drawable.joveno)
            }
            fotom.toInt() == 4 -> {
                fotoj5.setBackgroundResource(R.drawable.adulta)
            }
            fotom.toInt() == 5 -> {
                fotoj5.setBackgroundResource(R.drawable.adulto)
            }
            fotom.toInt() == 6 -> {
                fotoj5.setBackgroundResource(R.drawable.abuelo)
            }
            fotom.toInt() == 7 -> {
                fotoj5.setBackgroundResource(R.drawable.abuela)
            }
            fotom.toInt() == 8 -> {
                fotoj5.setBackgroundResource(R.drawable.indefinido)
            }
        }
        val Archivo1 = "Audio"
        val defaultPrefs2 = Splash.PreferenceHelper1.defaultPreference1(this)
        defaultPrefs2.tono = 1
        defaultPrefs2.melodia = 1
        defaultPrefs2.activi = ""
        defaultPrefs2.volum = 0.10f
        defaultPrefs2.volum1 = 1.00f
        val prefs2 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
        var carga = prefs2.tono
        soundPool = SoundPool(100, AudioManager.STREAM_MUSIC, 0)
        mediaPlayer = MediaPlayer()
        when (equi) {
            1 -> {
                mue1.visibility=View.INVISIBLE
                mue2.visibility=View.INVISIBLE
                mue3.visibility=View.INVISIBLE
            }
            2 -> {
                mue1.visibility=View.VISIBLE
                mue2.visibility=View.INVISIBLE
                mue3.visibility=View.INVISIBLE
            }
            3 -> {
                mue1.visibility=View.VISIBLE
                mue2.visibility=View.VISIBLE
                mue3.visibility=View.INVISIBLE
            }
            4 -> {
                equi=1
                mue1.visibility=View.VISIBLE
                mue2.visibility=View.VISIBLE
                mue3.visibility=View.VISIBLE
                prefs1.rminsimb = prefs1.rminsimb - marcador
                marcador=0
                asignacion()
            }
        }
        when (prefs2.tono) {
            1 -> {
                carga = soundPool!!.load(this, R.raw.ton1, 1)
            }
            2 -> {
                carga = soundPool!!.load(this, R.raw.ton2, 1)
            }
            3 -> {
                carga = soundPool!!.load(this, R.raw.ton3, 1)
            }
            4 -> {
                carga = soundPool!!.load(this, R.raw.ton4, 1)
            }
            5 -> {
                carga = soundPool!!.load(this, R.raw.ton5, 1)
            }
            6 -> {
                carga = soundPool!!.load(this, R.raw.ton6, 1)
            }
            7 -> {
                carga = soundPool!!.load(this, R.raw.ton7, 1)
            }
            8 -> {
                carga = soundPool!!.load(this, R.raw.ton8, 1)
            }
            9 -> {
                carga = soundPool!!.load(this, R.raw.ton9, 1)
            }
            10 -> {
                carga = soundPool!!.load(this, R.raw.ton10, 1)
            }
        }
        when (prefs2.melodia) {

            1 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo1)
                mediaPlayer!!.setVolume(prefs2.volum, prefs2.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            2 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo2)
                mediaPlayer!!.setVolume(prefs2.volum, prefs2.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            3 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo3)
                mediaPlayer!!.setVolume(prefs2.volum, prefs2.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            4 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo4)
                mediaPlayer!!.setVolume(prefs2.volum, prefs2.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            5 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo5)
                mediaPlayer!!.setVolume(prefs2.volum, prefs2.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            6 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo6)
                mediaPlayer!!.setVolume(prefs2.volum, prefs2.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            7 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo7)
                mediaPlayer!!.setVolume(prefs2.volum, prefs2.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            8 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo8)
                mediaPlayer!!.setVolume(prefs2.volum, prefs2.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            9 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo9)
                mediaPlayer!!.setVolume(prefs2.volum, prefs2.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            10 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo10)
                mediaPlayer!!.setVolume(prefs2.volum, prefs2.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }

        }
        val CUSTOM_PREF_NAME = "Record"
        val defaultPrefs11 = MenuJuegos.PreferenceHelper.defaultPreference(this)
        defaultPrefs11.contadorE = 0
        defaultPrefs11.contadorV = 0
        defaultPrefs11.contador = 0
        defaultPrefs11.rminM = 0
        defaultPrefs11.rmayM = 0
        defaultPrefs11.rnumM = 0
        defaultPrefs11.rsimM = 0
        defaultPrefs11.correo = ""
        defaultPrefs11.foto = 0
        defaultPrefs11.nombreUs = ""
        defaultPrefs11.idUsuario = ""
        defaultPrefs11.rminsim = 0
        defaultPrefs11.rminsimb = 0
        defaultPrefs11.rmaya = 0
        defaultPrefs11.rmaynum = 0
        defaultPrefs11.rnuma = 0
        val prefs3 = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)
        if (prefs3.contador == 0) {
            alerta()
        }
        setSupportActionBar(findViewById(R.id.toolbarJ23))
        navigation_viewJ23.addOnLayoutChangeListener { view, i, i2, i3, i4, i5, i6, i7, i8 ->
            val foto6 = prefs1.userId.toString()
            view.NavBu.text = prefs1.password
            when {
                foto6.toInt() == 0 -> {
                    view.NaveFoto.setBackgroundResource(R.drawable.nina)
                }
                foto6.toInt() == 1 -> {
                    view.NaveFoto.setBackgroundResource(R.drawable.nino)
                }
                foto6.toInt() == 2 -> {
                    view.NaveFoto.setBackgroundResource(R.drawable.jovena)
                }
                foto6.toInt() == 3 -> {
                    view.NaveFoto.setBackgroundResource(R.drawable.joveno)
                }
                foto6.toInt() == 4 -> {
                    view.NaveFoto.setBackgroundResource(R.drawable.adulta)
                }
                foto6.toInt() == 5 -> {
                    view.NaveFoto.setBackgroundResource(R.drawable.adulto)
                }
                foto6.toInt() == 6 -> {
                    view.NaveFoto.setBackgroundResource(R.drawable.abuelo)
                }
                foto6.toInt() == 7 -> {
                    view.NaveFoto.setBackgroundResource(R.drawable.abuela)
                }
                foto6.toInt() == 8 -> {
                    view.NaveFoto.setBackgroundResource(R.drawable.indefinido)
                }
            }
            view.NaveCloo.setOnClickListener {
                soundPool!!.play(carga, prefs2.volum1, prefs2.volum1, 0, 0, 1f)
                val Archivo = "Usuario"
                val defaultPrefs = Splash.PreferenceHelper.defaultPreference(this)
                defaultPrefs.password = "Admin"
                defaultPrefs.userId = 0
                defaultPrefs.sele1 = 1
                val prefs = Splash.PreferenceHelper.customPreference(this, Archivo)

                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(this)
                defaultPrefs2.entrada = 0
                val prefs2 = Splash.PreferenceHelper2.customPreference2(this, Archivo2)
                if (prefs2.entrada == 0) {
                    val customDialog = Dialog(this)
                    customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    customDialog.setContentView(R.layout.activity_cerrarchat)
                    customDialog.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    customDialog.setCancelable(false)
                    customDialog.acgfvepd.setOnClickListener {
                        soundPool!!.play(carga, prefs2.volum1, prefs2.volum1, 0, 0, 1f)
                        val CUSTOM_PREF_NAME = "Record"
                        val defaultPrefs = MenuJuegos.PreferenceHelper.defaultPreference(this)
                        defaultPrefs.contadorE = 0
                        defaultPrefs.contadorV = 0
                        defaultPrefs.contador = 0
                        defaultPrefs.rminM = 0
                        defaultPrefs.rmayM = 0
                        defaultPrefs.rnumM = 0
                        defaultPrefs.rsimM = 0
                        defaultPrefs.correo = ""
                        defaultPrefs.foto = 0
                        defaultPrefs.nombreUs = ""
                        defaultPrefs.idUsuario = ""
                        defaultPrefs.rminsim = 0
                        defaultPrefs.rminsimb = 0
                        defaultPrefs.rmaya = 0
                        defaultPrefs.rmaynum = 0
                        defaultPrefs.rnuma = 0
                        val prefs23 = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)
                        prefs23.contadorE = 0
                        prefs23.contadorV = 0
                        prefs23.contador = 0
                        prefs23.rminM = 0
                        prefs23.rmayM = 0
                        prefs23.rnumM = 0
                        prefs23.rsimM = 0
                        prefs23.correo = ""
                        prefs23.foto = 0
                        prefs23.nombreUs = ""
                        prefs23.idUsuario = ""
                        prefs23.rminsim = 0
                        prefs23.rminsimb = 0
                        prefs23.rmaya = 0
                        prefs23.rmaynum = 0
                        prefs.rnuma = 0
                        prefs.password = "Admin"
                        prefs.userId = 0
                        prefs.sele1 = 1
                        prefs2.entrada = 0
                        startActivity(Intent(this, Usuarios::class.java))
                        Bungee.zoom(this)
                        finish()
                    }
                    customDialog.canfgfgcd.setOnClickListener {
                        soundPool!!.play(carga, prefs2.volum1, prefs2.volum1, 0, 0, 1f)
                        customDialog.dismiss()
                    }
                    customDialog.show()
                } else if (prefs2.entrada == 1) {

                    val Archivo = "Usuario"
                    val defaultPrefs = Splash.PreferenceHelper.defaultPreference(this)
                    defaultPrefs.password = "Admin"
                    defaultPrefs.userId = 0
                    val prefs = Splash.PreferenceHelper.customPreference(this, Archivo)


                    val customDialog = Dialog(this)
                    customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    customDialog.setContentView(R.layout.activity_cerrarchat1)
                    customDialog.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    customDialog.setCancelable(false)
                    customDialog.dlv.setOnClickListener {
                        soundPool!!.play(carga, prefs2.volum1, prefs2.volum1, 0, 0, 1f)
                        mAuth = FirebaseAuth.getInstance()
                        FirebaseService.sharedPref =
                            getSharedPreferences("sharedPref", Context.MODE_PRIVATE)

                        FirebaseMessaging.getInstance().token
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    if (task.result != null && !TextUtils.isEmpty(task.result)) {
                                        val token: String = task.result!!
                                    }
                                }
                            }
                        mAuth!!.signOut()
                        disableFCM()
                        prefs.password = "Admin"
                        prefs.userId = 0
                        prefs.sele1 = 1
                        val CUSTOM_PREF_NAME = "Record"
                        val defaultPrefs = MenuJuegos.PreferenceHelper.defaultPreference(this)
                        defaultPrefs.contadorE = 0
                        defaultPrefs.contadorV = 0
                        defaultPrefs.contador = 0
                        defaultPrefs.rminM = 0
                        defaultPrefs.rmayM = 0
                        defaultPrefs.rnumM = 0
                        defaultPrefs.rsimM = 0
                        defaultPrefs.correo = ""
                        defaultPrefs.foto = 0
                        defaultPrefs.nombreUs = ""
                        defaultPrefs.idUsuario = ""
                        defaultPrefs.rminsim = 0
                        defaultPrefs.rminsimb = 0
                        defaultPrefs.rmaya = 0
                        defaultPrefs.rmaynum = 0
                        defaultPrefs.rnuma = 0
                        val prefs23 = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)
                        prefs23.contadorE = 0
                        prefs23.contadorV = 0
                        prefs23.contador = 0
                        prefs23.rminM = 0
                        prefs23.rmayM = 0
                        prefs23.rnumM = 0
                        prefs23.rsimM = 0
                        prefs23.correo = ""
                        prefs23.foto = 0
                        prefs23.nombreUs = ""
                        prefs23.idUsuario = ""
                        prefs23.rminsim = 0
                        prefs23.rminsimb = 0
                        prefs23.rmaya = 0
                        prefs23.rmaynum = 0
                        prefs.rnuma = 0
                        prefs.password = "Admin"
                        prefs.userId = 0
                        prefs.sele1 = 1
                        prefs2.entrada = 0
                        finish()
                        startActivity(Intent(this@adivi3, Usuarios::class.java))
                        Bungee.zoom(this)

                    }
                    customDialog.fvfb.setOnClickListener {
                        soundPool!!.play(carga, prefs2.volum1, prefs2.volum1, 0, 0, 1f)
                        customDialog.dismiss()
                    }
                    customDialog.show()
                }
            }
        }
        navigation_viewJ23.setNavigationItemSelectedListener {
            val Archivo1 = "Audio"
            val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this)
            defaultPrefs1.tono = 1
            defaultPrefs1.melodia = 1
            defaultPrefs1.activi = ""
            defaultPrefs1.volum = 0.10f
            defaultPrefs1.volum1 = 1.00f
            val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
            val CUSTOM_PREF_NAME = "Record"
            val defaultPrefs = MenuJuegos.PreferenceHelper.defaultPreference(this)
            defaultPrefs.contadorE = 0
            defaultPrefs.contadorV = 0
            defaultPrefs.contador = 0
            defaultPrefs.rminM = 0
            defaultPrefs.rmayM = 0
            defaultPrefs.rnumM = 0
            defaultPrefs.rsimM = 0
            defaultPrefs.correo = ""
            defaultPrefs.foto = 0
            defaultPrefs.nombreUs = ""
            defaultPrefs.idUsuario = ""
            defaultPrefs.rminsim = 0
            defaultPrefs.rminsimb = 0
            defaultPrefs.rmaya = 0
            defaultPrefs.rmaynum = 0
            defaultPrefs.rnuma = 0
            val prefs = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)
            var carga = prefs1.tono
            when (it.itemId) {
                R.id.uno1 -> {
                    drawerJ23.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuPrin::class.java))

                    Bungee.zoom(this)
                    true
                }
                R.id.dos2 -> {
                    drawerJ23.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, materialapoyo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.tres3 -> {
                    drawerJ23.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Red::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cuatro4 -> {
                    drawerJ23.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuJuegos::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cinco5 -> {
                    drawerJ23.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, historia::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.seis6 -> {
                    drawerJ23.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Extras::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.siete7 -> {
                    drawerJ23.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuCatalogo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.ocho8 -> {
                    drawerJ23.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Traductores::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.nueve9 -> {
                    drawerJ23.closeDrawer(GravityCompat.START)

                    val Archivo1 = "Audio"
                    val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this)
                    defaultPrefs1.tono = 1
                    defaultPrefs1.melodia = 1
                    defaultPrefs1.activi = ""
                    defaultPrefs1.volum = 0.10f
                    defaultPrefs1.volum1 = 1.00f
                    val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
                    var carga = prefs1.tono
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    val Archivo2 = "Chat"
                    val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(this)
                    defaultPrefs2.entrada = 0
                    val prefs2 = Splash.PreferenceHelper2.customPreference2(this, Archivo2)
                    if (prefs2.entrada == 0) {
                        startActivity(Intent(this, LoginActivity::class.java))
                        Bungee.zoom(this)
                    } else if (prefs2.entrada == 1) {
                        startActivity(Intent(this, UsersActivity::class.java))
                        Bungee.zoom(this)
                    }
                    true
                }

            }
            true
        }
        val drawerToggle = ActionBarDrawerToggle(this, drawerJ23, R.string.open, R.string.close)
        drawerJ23.addDrawerListener(drawerToggle)
        drawerToggle.drawerArrowDrawable.color = Color.BLACK
        drawerToggle.drawerArrowDrawable.gapSize = 30.0f
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_viewJ23.setItemIconTintList(null);
        asignacion()
        reiniciar6.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            equi=1
            when (equi) {
                1 -> {
                    mue1.visibility=View.INVISIBLE
                    mue2.visibility=View.INVISIBLE
                    mue3.visibility=View.INVISIBLE
                }
                2 -> {
                    mue1.visibility=View.VISIBLE
                    mue2.visibility=View.INVISIBLE
                    mue3.visibility=View.INVISIBLE
                }
                3 -> {
                    mue1.visibility=View.VISIBLE
                    mue2.visibility=View.VISIBLE
                    mue3.visibility=View.INVISIBLE
                }
                4 -> {
                    equi=1
                    mue1.visibility=View.VISIBLE
                    mue2.visibility=View.VISIBLE
                    mue3.visibility=View.VISIBLE
                    prefs1.rminsimb = prefs1.rminsimb - marcador
                    marcador=0
                    asignacion()
                }
            }
            if (marcador > 0) {
                marcador = marcador - 2
                prefs1.rminsimb = prefs1.rminsimb - 2
                if (marcador < 0) {
                    marcador = 0
                }
                if (prefs1.rminsimb < 0) {
                    prefs1.rminsimb = 0
                }
            }
            marcadorA4.text = marcador.toString()
            asignacion()
            limpiar()

        }
        btnuno2.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noUno2 += 1
            if (noUno2 == 1) {
                noUno2 = 1
                btnuno2.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))

            } else {
                noUno2 = 0
                btnuno2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        btndos2.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noDos2 += 1
            if (noDos2 == 1) {
                noDos2 = 1
                btndos2.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))

            } else {
                noDos2 = 0
                btndos2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        btntres2.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noTres2 += 1
            if (noTres2 == 1) {
                noTres2 = 1
                btntres2.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))

            } else {
                noTres2 = 0
                btntres2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        btncuatro2.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noCuatro2 += 1
            if (noCuatro2 == 1) {
                noCuatro2 = 1
                btncuatro2.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))

            } else {
                noCuatro2 = 0
                btncuatro2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        btncinco2.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noCinco2 += 1
            if (noCinco2 == 1) {
                noCinco2 = 1
                btncinco2.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))

            } else {
                noCinco2 = 0
                btncinco2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        btnseis2.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noSeis2 += 1
            if (noSeis2 == 1) {
                noSeis2 = 1
                btnseis2.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))

            } else {
                noSeis2 = 0
                btnseis2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        verificar5.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (noUno2 == 1) {
                cadena4 += "1"
            }
            if (noDos2 == 1) {
                cadena4 += "2"
            }
            if (noTres2 == 1) {
                cadena4 += "3"
            }
            if (noCuatro2 == 1) {
                cadena4 += "4"
            }
            if (noCinco2 == 1) {
                cadena4 += "5"
            }
            if (noSeis2 == 1) {
                cadena4 += "6"
            }
            val l = imagen2.getTag().toString()
            if (cadena4 == "1") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "12") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "14") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "145") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "15") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "124") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "1245") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "125") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "24") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "245") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "13") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "123") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "134") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "1345") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "12456") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "135") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "1234") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "12345") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "1235") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "234") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "2345") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "136") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "1236") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "2456") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "1346") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "13456") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "1356") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "3") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "26") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else if (cadena4 == "") {
                comparacion(cadena4, l)
                cadena4 = ""
            } else {
                comparacion(cadena4, l)
                cadena4 = ""
            }

        }
        pista3.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (marcador <= 5) {
                toast("Necesita 5 puntos para Activar la Pista.")
            } else if (marcador >= 5) {
                val CUSTOM_PREF_NAME = "Record"
                val defaultPrefs1 = MenuJuegos.PreferenceHelper.defaultPreference(this)
                defaultPrefs1.contadorE = 0
                defaultPrefs1.contadorV = 0
                defaultPrefs1.contador = 0
                defaultPrefs1.rminM = 0
                defaultPrefs1.rmayM = 0
                defaultPrefs1.rnumM = 0
                defaultPrefs1.rsimM = 0
                defaultPrefs1.correo = ""
                defaultPrefs1.foto = 0
                defaultPrefs1.nombreUs = ""
                defaultPrefs1.idUsuario = ""
                defaultPrefs1.rminsim = 0
                defaultPrefs1.rminsimb = 0
                defaultPrefs1.rmaya = 0
                defaultPrefs1.rmaynum = 0
                defaultPrefs1.rnuma = 0
                val prefs1 = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)
                if (marcador > 0) {
                    marcador = marcador - 5
                    prefs1.rminsimb = prefs1.rminsimb - 5
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rminsimb < 0) {
                        prefs1.rminsimb = 0
                    }
                }
                marcadorA4.text = marcador.toString()
                alerta2(adivinanzaResp)
            }
        }
    }

    fun asignacion() {
        val numero = (1..29).random()
        numero + 1
        if (numero == 1) {
            imagen2.setBackgroundResource(R.drawable.a)
            adivinanza.text =
                "Yo fui tu primer sonido cuando empezaste a hablar y soy la primera letra que en el alfabeto está. ¿Qué seré?"
            imagen2.setTag("1")
            adivinanzaResp = "a"
        } else if (numero == 2) {
            imagen2.setBackgroundResource(R.drawable.b)
            adivinanza.text =
                "Porque bien gordita estoy, dos barrigas me verás. No me gustan los viajes y en el barco me veras. ¿Qué seré?"
            imagen2.setTag("12")
            adivinanzaResp = "b"
        } else if (numero == 3) {
            imagen2.setBackgroundResource(R.drawable.c)
            adivinanza.text =
                "Me puedes encontrar muy al final del amanecer, nunca al mediodía ni en la tarde, pero sí en el medio de la noche ¿Quién soy?"
            imagen2.setTag("14")
            adivinanzaResp = "c"
        } else if (numero == 4) {
            imagen2.setBackgroundResource(R.drawable.d)
            adivinanza.text =
                "En los dedos tengo dos, en los dientes tengo uno, pero en las piernas, manos y brazos, ninguno. ¿Qué será?"
            imagen2.setTag("145")
            adivinanzaResp = "d"
        } else if (numero == 5) {
            imagen2.setBackgroundResource(R.drawable.e)
            adivinanza.text =
                "Como un tenedor, pero sin asa. Así dicen que soy los que me graban. ¿Qué seré?"
            imagen2.setTag("15")
            adivinanzaResp = "e"
        } else if (numero == 6) {
            imagen2.setBackgroundResource(R.drawable.f)
            adivinanza.text =
                "Le sirve de puerta al frío y al fuego, es final en nombres rusos y mediadora en oferta ¿Qué letra soy?"
            imagen2.setTag("124")
            adivinanzaResp = "f"
        } else if (numero == 7) {
            imagen2.setBackgroundResource(R.drawable.g)
            adivinanza.text =
                "Generosa gracias a ti existe, y en garganta dos veces insiste. ¿Quién soy?"
            imagen2.setTag("1245")
            adivinanzaResp = "g"
        } else if (numero == 8) {
            imagen2.setBackgroundResource(R.drawable.h)
            adivinanza.text =
                "Aunque mi sonido es mudo, cuando me nombran parezco a un estornudo ¿Quién soy?"
            imagen2.setTag("125")
            adivinanzaResp = "h"
        } else if (numero == 9) {
            imagen2.setBackgroundResource(R.drawable.i)
            adivinanza.text =
                "Soy un palito muy derechito y encima de la frente llevo un mosquito que ni pica ni vuela ni toca la vihuela. ¿Qué seré?"
            imagen2.setTag("24")
            adivinanzaResp = "i"
        } else if (numero == 10) {
            imagen2.setBackgroundResource(R.drawable.j)
            adivinanza.text =
                "Mi nombre es nombre de baile, alegre y muy bravío; cuando suena en Aragón, la gente pierde el sentío. ¿Qué seré?"
            imagen2.setTag("245")
            adivinanzaResp = "j"
        } else if (numero == 11) {
            imagen2.setBackgroundResource(R.drawable.k)
            adivinanza.text =
                "No me pronunciéis dos veces, que tengo sonido feo; siendo la letra del kilo, en carreteras me veo. ¿Qué seré?"
            imagen2.setTag("13")
            adivinanzaResp = "k"
        } else if (numero == 12) {
            imagen2.setBackgroundResource(R.drawable.l)
            adivinanza.text = "Empieza en luna termina en sol. ¿Qué seré?"
            imagen2.setTag("123")
            adivinanzaResp = "l"
        } else if (numero == 13) {
            imagen2.setBackgroundResource(R.drawable.m)
            adivinanza.text =
                "Una vez en un minuto, dos veces en un momento, tres veces en mimetismo, y en cuatro, ¡no la encuentro! ¿Qué seré?"
            imagen2.setTag("134")
            adivinanzaResp = "m"
        } else if (numero == 14) {
            imagen2.setBackgroundResource(R.drawable.n)
            adivinanza.text =
                "Suelen tenerla los puentes, pero no los viaductos. Como también las fuentes. ¿Qué será?"
            imagen2.setTag("1345")
            adivinanzaResp = "n"
        } else if (numero == 15) {
            imagen2.setBackgroundResource(R.drawable.ene)
            adivinanza.text =
                "Aunque lleve turbante moro no soy, que solo en castellano de letra estoy. ¿Qué seré?"
            imagen2.setTag("12456")
            adivinanzaResp = "ene"
        } else if (numero == 16) {
            imagen2.setBackgroundResource(R.drawable.o)
            adivinanza.text =
                "Una cosa quisicosa, de ovalada construcción, todos los nombres la tienen, pero las mujeres, no. El Obispo como todos también tiene dos. ¿Qué seré?"
            imagen2.setTag("135")
            adivinanzaResp = "o"
        } else if (numero == 17) {
            imagen2.setBackgroundResource(R.drawable.p)
            adivinanza.text =
                "Como una B pero sin barriga. Me encontrarás al comienzo de Pancho, Paco y Pandora. ¿Qué seré?"
            imagen2.setTag("1234")
            adivinanzaResp = "p"
        } else if (numero == 18) {
            imagen2.setBackgroundResource(R.drawable.q)
            adivinanza.text =
                "Estoy en el mosquito, pero no en la hormiguita. No me tiene en el grillo, pero sí en la mariquita ¿Qué letra soy?"
            imagen2.setTag("12345")
            adivinanzaResp = "q"
        } else if (numero == 19) {
            imagen2.setBackgroundResource(R.drawable.r)
            adivinanza.text =
                "La tiene el tigre, pero no el león dos veces el perro y una el ratón. ¿Qué seré?"
            imagen2.setTag("1235")
            adivinanzaResp = "r"
        } else if (numero == 20) {
            imagen2.setBackgroundResource(R.drawable.s)
            adivinanza.text =
                "Desde el lunes hasta el viernes, soy la última en llegar, el sábado soy la primera y el domingo a descansar. ¿Qué seré?"
            imagen2.setTag("234")
            adivinanzaResp = "s"
        } else if (numero == 21) {
            imagen2.setBackgroundResource(R.drawable.t)
            adivinanza.text =
                "Te la digo y no la sabes, te la vuelvo a repetir, te la digo 3 veces y no la sabes decir. ¿Qué seré?"
            imagen2.setTag("2345")
            adivinanzaResp = "t"
        } else if (numero == 22) {
            imagen2.setBackgroundResource(R.drawable.u)
            adivinanza.text =
                "¿Sabes de alguna letrita, que si la vuelta le das, enseguida se convierte de consonante en vocal?"
            imagen2.setTag("136")
            adivinanzaResp = "u"
        } else if (numero == 23) {
            imagen2.setBackgroundResource(R.drawable.v)
            adivinanza.text =
                "En la vaca estoy, en el viento voy, si en burro me ves en ortografía vas al revés. ¿Qué seré?"
            imagen2.setTag("1236")
            adivinanzaResp = imagen2.tag.toString()
            adivinanzaResp = "v"
        } else if (numero == 24) {
            imagen2.setBackgroundResource(R.drawable.w)
            adivinanza.text =
                "Wamba y Witiza me tienen de pie, Víctor sólo a medias y Muza al revés. ¿Qué seré?"
            imagen2.setTag("2456")
            adivinanzaResp = "w"
        } else if (numero == 25) {
            imagen2.setBackgroundResource(R.drawable.x)
            adivinanza.text =
                "Es una cruz muy bonita, molino de aspas son. ¿Qué letra puede ser esta, que se emplea en multiplicación? ¿Cuál será?"
            imagen2.setTag("1346")
            adivinanzaResp = "x"
        } else if (numero == 26) {
            imagen2.setBackgroundResource(R.drawable.y)
            adivinanza.text =
                "Tengo una pierna y no camino ni salto, tengo dos brazos y no puedo aplaudir. ¿Quién soy?"
            imagen2.setTag("13456")
            adivinanzaResp = "y"
        } else if (numero == 27) {
            imagen2.setBackgroundResource(R.drawable.z)
            adivinanza.text =
                "La última de todas soy, pero en zurdo y zapato primera voy. ¿Qué seré?"
            imagen2.setTag("1356")
            adivinanzaResp = "z"
        } else if (numero == 28) {
            imagen2.setBackgroundResource(R.drawable.punto)
            adivinanza.text = "Muy chiquito, chiquito, pone fin a lo escrito. ¿Qué seré?"
            imagen2.setTag("3")
            adivinanzaResp = "punto"
        } else if (numero == 29) {
            imagen2.setBackgroundResource(R.drawable.signos_interrogacion)
            adivinanza.text =
                "Termino cabeza arriba y empiezo cabeza abajo, y tan sólo a preguntar se limita mi trabajo. ¿Qué seré?"
            imagen2.setTag("26")
            adivinanzaResp = "signos_interrogacion"
        }
    }

    private fun toast(s: String) {
        val customLayout = layoutInflater.inflate(R.layout.toast, toast23)
        val toast = Toast(this)
        toast.duration = Toast.LENGTH_SHORT
        toast.setGravity(Gravity.TOP or Gravity.RIGHT, 0, 0)
        toast.view = customLayout
        customLayout.toastT.text = s
        toast.show()
    }

    fun disableFCM() {
        // Disable auto init
        FirebaseMessaging.getInstance().isAutoInitEnabled = false
        Thread {
            try {
                // Remove InstanceID initiate to unsubscribe all topic
                // TODO: May be a better way to use FirebaseMessaging.getInstance().unsubscribeFromTopic()
                FirebaseMessaging.getInstance().deleteToken()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }.start()
    }

    override fun onBackPressed() {
        if (drawerJ23.isDrawerOpen(GravityCompat.START)) {
            drawerJ23.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
            startActivity(Intent(this, MenuJuegos::class.java))
            Bungee.zoom(this)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer!!.start()
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer!!.pause()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            android.R.id.home -> {
                drawerJ23.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun limpiar() {
        btnuno2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btndos2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btntres2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btncuatro2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btncinco2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btnseis2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        noUno2 = 0
        noDos2 = 0
        noTres2 = 0
        noCuatro2 = 0
        noCinco2 = 0
        noSeis2 = 0
        cadena4 = ""
    }

    fun comparacion(dato1: String, l: String) {
        val CUSTOM_PREF_NAME = "Record"
        val defaultPrefs1 = MenuJuegos.PreferenceHelper.defaultPreference(this)
        defaultPrefs1.contadorE = 0
        defaultPrefs1.contadorV = 0
        defaultPrefs1.contador = 0
        defaultPrefs1.rminM = 0
        defaultPrefs1.rmayM = 0
        defaultPrefs1.rnumM = 0
        defaultPrefs1.rsimM = 0
        defaultPrefs1.correo = ""
        defaultPrefs1.foto = 0
        defaultPrefs1.nombreUs = ""
        defaultPrefs1.idUsuario = ""
        defaultPrefs1.rminsim = 0
        defaultPrefs1.rminsimb = 0
        defaultPrefs1.rmaya = 0
        defaultPrefs1.rmaynum = 0
        defaultPrefs1.rnuma = 0
        val prefs1 = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)
        if (dato1 == l) {
            marcador = marcador + 10
            prefs1.rminsimb = prefs1.rminsimb + 10
            limpiar()
            asignacion()
            marcadorA4.text = marcador.toString()
            toast("Es correcto")
        } else if (dato1 != l) {
            if (dato1.isEmpty() || l.isEmpty()) {
                if (marcador > 0) {
                    marcador = marcador - 1
                    prefs1.rminsimb = prefs1.rminsimb - 1
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rminsimb < 0) {
                        prefs1.rminsimb = 0
                    }
                    equi = equi + 1
                    when (equi) {
                        1 -> {
                            mue1.visibility=View.INVISIBLE
                            mue2.visibility=View.INVISIBLE
                            mue3.visibility=View.INVISIBLE
                        }
                        2 -> {
                            mue1.visibility=View.VISIBLE
                            mue2.visibility=View.INVISIBLE
                            mue3.visibility=View.INVISIBLE
                        }
                        3 -> {
                            mue1.visibility=View.VISIBLE
                            mue2.visibility=View.VISIBLE
                            mue3.visibility=View.INVISIBLE
                        }
                        4 -> {
                            equi=1
                            mue1.visibility=View.VISIBLE
                            mue2.visibility=View.VISIBLE
                            mue3.visibility=View.VISIBLE
                            prefs1.rminsimb = prefs1.rminsimb - marcador
                            marcador=0
                            asignacion()
                        }
                    }
                }
                marcadorA4.text = marcador.toString()
                toast("Datos Incompletos")
                limpiar()
            } else if (dato1.isEmpty() && l.isEmpty()) {
                if (marcador > 0) {
                    marcador = marcador - 1
                    prefs1.rminsimb = prefs1.rminsimb - 1
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rminsimb < 0) {
                        prefs1.rminsimb = 0
                    }
                    equi = equi + 1
                    when (equi) {
                        1 -> {
                            mue1.visibility=View.INVISIBLE
                            mue2.visibility=View.INVISIBLE
                            mue3.visibility=View.INVISIBLE
                        }
                        2 -> {
                            mue1.visibility=View.VISIBLE
                            mue2.visibility=View.INVISIBLE
                            mue3.visibility=View.INVISIBLE
                        }
                        3 -> {
                            mue1.visibility=View.VISIBLE
                            mue2.visibility=View.VISIBLE
                            mue3.visibility=View.INVISIBLE
                        }
                        4 -> {
                            equi=1
                            mue1.visibility=View.VISIBLE
                            mue2.visibility=View.VISIBLE
                            mue3.visibility=View.VISIBLE
                            prefs1.rminsimb = prefs1.rminsimb - marcador
                            marcador=0
                            asignacion()
                        }
                    }
                }
                marcadorA4.text = marcador.toString()
                toast("Datos vacios")
                limpiar()
            } else {
                if (marcador > 0) {
                    marcador = marcador - 2
                    prefs1.rminsimb = prefs1.rminsimb - 2
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rminsimb < 0) {
                        prefs1.rminsimb = 0
                    }
                    equi = equi + 1
                    when (equi) {
                        1 -> {
                            mue1.visibility=View.INVISIBLE
                            mue2.visibility=View.INVISIBLE
                            mue3.visibility=View.INVISIBLE
                        }
                        2 -> {
                            mue1.visibility=View.VISIBLE
                            mue2.visibility=View.INVISIBLE
                            mue3.visibility=View.INVISIBLE
                        }
                        3 -> {
                            mue1.visibility=View.VISIBLE
                            mue2.visibility=View.VISIBLE
                            mue3.visibility=View.INVISIBLE
                        }
                        4 -> {
                            equi=1
                            mue1.visibility=View.VISIBLE
                            mue2.visibility=View.VISIBLE
                            mue3.visibility=View.VISIBLE
                            prefs1.rminsimb = prefs1.rminsimb - marcador
                            marcador=0
                            asignacion()
                        }
                    }
                }
                marcadorA4.text = marcador.toString()
                toast("Es incorrecto")
                limpiar()
            }

        }
    }

    private fun alerta() {
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.instrucciones_adivinanzas)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialog.show()
    }

    private fun alerta2(dato1: String) {
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.activity_pista)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialog.tarjetaBase8.visibility = View.GONE
        customDialog.dob.visibility = View.GONE
        customDialog.tarjetaBase81.setImageResource(
            getResources().getIdentifier(
                dato1,
                "drawable",
                getPackageName()
            )
        )
        customDialog.show()
    }
}