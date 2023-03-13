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
import kotlinx.android.synthetic.main.activity_adivi2.*
import kotlinx.android.synthetic.main.activity_adivi2.imagen
import kotlinx.android.synthetic.main.activity_adivi2.mue1
import kotlinx.android.synthetic.main.activity_adivi2.mue2
import kotlinx.android.synthetic.main.activity_adivi2.mue3
import kotlinx.android.synthetic.main.activity_cerrarchat.*
import kotlinx.android.synthetic.main.activity_cerrarchat1.*
import kotlinx.android.synthetic.main.activity_pista.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.io.IOException

class adivi2 : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private var mAuth: FirebaseAuth? = null
    var adivinanza = ""
    var marcador = 0
    var equi = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivi2)
        val Archivo = "Usuario"
        val defaultPrefs1 = Splash.PreferenceHelper.defaultPreference(this)
        defaultPrefs1.password = "Admin"
        defaultPrefs1.userId = 50
        val prefs1 = Splash.PreferenceHelper.customPreference(this, Archivo)
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
        val texto2: LinearLayout = findViewById(R.id.adivi2)
        //Asignacioón de las animaciones
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto2.startAnimation(anim1)
        val namem1 = prefs1.password
        val fotom = prefs1.userId.toString()
        userj2.text = namem1
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
                prefs1.rmaynum = prefs1.rmaynum -  marcador
                marcador=0
                asignacion()
            }
        }
        when {
            fotom.toInt() == 0 -> {
                fotoj2.setBackgroundResource(R.drawable.nina)
            }
            fotom.toInt() == 1 -> {
                fotoj2.setBackgroundResource(R.drawable.nino)
            }
            fotom.toInt() == 2 -> {
                fotoj2.setBackgroundResource(R.drawable.jovena)
            }
            fotom.toInt() == 3 -> {
                fotoj2.setBackgroundResource(R.drawable.joveno)
            }
            fotom.toInt() == 4 -> {
                fotoj2.setBackgroundResource(R.drawable.adulta)
            }
            fotom.toInt() == 5 -> {
                fotoj2.setBackgroundResource(R.drawable.adulto)
            }
            fotom.toInt() == 6 -> {
                fotoj2.setBackgroundResource(R.drawable.abuelo)
            }
            fotom.toInt() == 7 -> {
                fotoj2.setBackgroundResource(R.drawable.abuela)
            }
            fotom.toInt() == 8 -> {
                fotoj2.setBackgroundResource(R.drawable.indefinido)
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
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
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
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
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
        setSupportActionBar(findViewById(R.id.toolbarJ22))
        navigation_viewJ22.addOnLayoutChangeListener { view, i, i2, i3, i4, i5, i6, i7, i8 ->
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
                        startActivity(Intent(this@adivi2, Usuarios::class.java))
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
        navigation_viewJ22.setNavigationItemSelectedListener {
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
                    drawerJ22.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuPrin::class.java))

                    Bungee.zoom(this)
                    true
                }
                R.id.dos2 -> {
                    drawerJ22.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, materialapoyo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.tres3 -> {
                    drawerJ22.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Red::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cuatro4 -> {
                    drawerJ22.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuJuegos::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cinco5 -> {
                    drawerJ22.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, historia::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.seis6 -> {
                    drawerJ22.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Extras::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.siete7 -> {
                    drawerJ22.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuCatalogo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.ocho8 -> {
                    drawerJ22.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Traductores::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.nueve9 -> {
                    drawerJ22.closeDrawer(GravityCompat.START)

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
        val drawerToggle = ActionBarDrawerToggle(this, drawerJ22, R.string.open, R.string.close)
        drawerJ22.addDrawerListener(drawerToggle)
        drawerToggle.drawerArrowDrawable.color = Color.BLACK
        drawerToggle.drawerArrowDrawable.gapSize = 30.0f
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_viewJ22.setItemIconTintList(null);
        asignacion()
        reiniciar.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            equi = 1
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
                    equi = equi + 1
                    mue1.visibility=View.VISIBLE
                    mue2.visibility=View.VISIBLE
                    mue3.visibility=View.INVISIBLE
                }
                4 -> {
                    equi=1
                    mue1.visibility=View.VISIBLE
                    mue2.visibility=View.VISIBLE
                    mue3.visibility=View.VISIBLE
                    prefs1.rmaynum = prefs1.rmaynum -  marcador
                    marcador=0
                    asignacion()
                }
            }
            if (marcador > 0) {
                marcador = marcador - 2
                prefs1.rmaynum = prefs1.rmaynum - 2
                if (marcador < 0) {
                    marcador = 0
                }
                if (prefs1.rmaynum < 0) {
                    prefs1.rmaynum = 0
                }

            }
            marcadorA1.text = marcador.toString()
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
                    equi = equi + 1
                    mue1.visibility=View.VISIBLE
                    mue2.visibility=View.VISIBLE
                    mue3.visibility=View.INVISIBLE
                }
                4 -> {
                    equi=1
                    mue1.visibility=View.VISIBLE
                    mue2.visibility=View.VISIBLE
                    mue3.visibility=View.VISIBLE
                    prefs1.rmaynum = prefs1.rmaynum -  marcador
                    marcador=0
                    asignacion()
                }
            }
            repetir2()
        }
        cinco.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (cinco.text == imagen2.getTag()) {
                marcador = marcador + 10
                prefs1.rmaynum = prefs1.rmaynum + 10
                marcadorA1.text = marcador.toString()
                toast("Es correcto")
                asignacion()
            } else {
                if (marcador > 0) {
                    marcador = marcador - 2
                    prefs1.rmaynum = prefs1.rmaynum - 2
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rmaynum < 0) {
                        prefs1.rmaynum = 0
                    }

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
                        prefs1.rmaynum = prefs1.rmaynum -  marcador
                        marcador=0
                        asignacion()
                    }
                }
                marcadorA1.text = marcador.toString()
                toast("Es incorrecto")
            }
        }
        seis.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (seis.text == imagen2.getTag()) {
                marcador = marcador + 10
                prefs1.rmaynum = prefs1.rmaynum + 10
                marcadorA1.text = marcador.toString()
                toast("Es correcto")
                asignacion()
            } else {
                if (marcador > 0) {
                    marcador = marcador - 2
                    prefs1.rmaynum = prefs1.rmaynum - 2
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rmaynum < 0) {
                        prefs1.rmaynum = 0
                    }

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
                        prefs1.rmaynum = prefs1.rmaynum -  marcador
                        marcador=0
                        asignacion()
                    }
                }
                marcadorA1.text = marcador.toString()
                toast("Es incorrecto")
            }
        }
        siete.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (siete.text == imagen2.getTag()) {
                marcador = marcador + 10
                prefs1.rmaynum = prefs1.rmaynum + 10
                marcadorA1.text = marcador.toString()
                toast("Es correcto")
                asignacion()
            } else {
                if (marcador > 0) {
                    marcador = marcador - 2
                    prefs1.rmaynum = prefs1.rmaynum - 2
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rmaynum < 0) {
                        prefs1.rmaynum = 0
                    }

                }
                equi = equi+ 1
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
                        prefs1.rmaynum = prefs1.rmaynum -  marcador
                        marcador=0
                        asignacion()
                    }
                }
                marcadorA1.text = marcador.toString()
                toast("Es incorrecto")
            }
        }
        ocho.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (ocho.text == imagen2.getTag()) {
                marcador = marcador + 10
                prefs1.rmaynum = prefs1.rmaynum + 10
                marcadorA1.text = marcador.toString()
                toast("Es correcto")
                asignacion()
            } else {
                if (marcador > 0) {
                    marcador = marcador - 2
                    prefs1.rmaynum = prefs1.rmaynum - 2
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rmaynum < 0) {
                        prefs1.rmaynum = 0
                    }

                }
                equi = equi + 1
                when (equi) {
                    1 -> {
                        mue1.visibility=View.INVISIBLE
                        mue2.visibility=View.INVISIBLE
                        mue3.visibility=View.INVISIBLE
                    }
                    2 -> {
                        equi = equi + 1
                        mue1.visibility=View.VISIBLE
                        mue2.visibility=View.INVISIBLE
                        mue3.visibility=View.INVISIBLE
                    }
                    3 -> {
                        equi = equi + 1
                        mue1.visibility=View.VISIBLE
                        mue2.visibility=View.VISIBLE
                        mue3.visibility=View.INVISIBLE
                    }
                    4 -> {
                        equi=1
                        mue1.visibility=View.VISIBLE
                        mue2.visibility=View.VISIBLE
                        mue3.visibility=View.VISIBLE
                        prefs1.rmaynum = prefs1.rmaynum -  marcador
                        marcador=0
                        asignacion()
                    }
                }
                marcadorA1.text = marcador.toString()
                toast("Es incorrecto")
            }
        }
        pista2.setOnClickListener {

            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (marcador <= 5) {
                toast("Necesita 5 puntos para Activar la Pista.")
            } else if (marcador >= 5) {
                Log.v("VERErro", "quito 5 puntos")
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
                    prefs1.rmaynum = prefs1.rmaynum - 5
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rmaynum < 0) {
                        prefs1.rmaynum = 0
                    }
                }
                marcadorA1.text = marcador.toString()
                alerta2(adivinanza)
            }
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
        if (drawerJ22.isDrawerOpen(GravityCompat.START)) {
            drawerJ22.closeDrawer(GravityCompat.START)
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
                drawerJ22.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
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

    fun asignacion() {
        val numero = (1..37).random()
        numero + 1
        if (numero == 1) {
            imagen.setBackgroundResource(R.drawable.mayuscula)
            imagen2.setBackgroundResource(R.drawable.a)
            adivinanza =
                "Piensa y lo adivinarás… ¿qué tiene Adelita delante que Eva tiene detrás?"
            imagen2.setTag("A")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 2) {
            imagen2.setBackgroundResource(R.drawable.b)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Cuando soy pequeña tengo solo una barriguita, pero cuando me quedo mayor mi barriga se divide en dos ¿Quién soy?"
            imagen2.setTag("B")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 3) {
            imagen2.setBackgroundResource(R.drawable.c)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Una raja de melón de la comida al final y los cuernos de la luna cuando menguante está. ¿Qué seré?"
            imagen2.setTag("C")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 4) {
            imagen2.setBackgroundResource(R.drawable.d)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Yo soy letra tan escasa, que en dos sólo verás una y entra una en la docena. ¿Qué seré?"
            imagen2.setTag("D")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 5) {
            imagen2.setBackgroundResource(R.drawable.e)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "En medio del cielo estoy, sin ser lucero ni estrella, sin ser sol ni luna bella. ¡A ver si sabes quién soy! ¿Qué seré?"
            imagen2.setTag("E")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 6) {
            imagen2.setBackgroundResource(R.drawable.f)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Soy la letra del desfile y el sonido del pinchazo, sólo tres palitos tengo y a los Felipes empiezo. ¿Qué seré?"
            imagen2.setTag("F")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())

        } else if (numero == 7) {
            imagen2.setBackgroundResource(R.drawable.g)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Gracias siempre la lleva consigo, y guapa, y también garbanzo. ¿Sabes ya de qué letrita te hablo?"
            imagen2.setTag("G")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())

        } else if (numero == 8) {
            imagen2.setBackgroundResource(R.drawable.h)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Aunque diciendo mi nombre des tú casi un estornudo, hacha me tiene en su vientre, pero mi sonido es mudo. ¿Qué seré?"
            imagen2.setTag("H")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())

        } else if (numero == 9) {
            imagen2.setBackgroundResource(R.drawable.i)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Entre todas mis hermanas, soy la que he crecido menos; jamás en España estoy, pero en Madrid sí me encuentro. ¿Qué seré?"
            imagen2.setTag("I")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 10) {
            imagen2.setBackgroundResource(R.drawable.j)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Por la cabeza me danza esta gran adivinanza: la letra más bailadora resultó ser servidora. ¿Cuál es?"
            imagen2.setTag("J")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())

        } else if (numero == 11) {
            imagen2.setBackgroundResource(R.drawable.k)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Primera en el kiwi, tambien en kimono, no está en banana, y tampoco en el mono. ¿Qué seré?"
            imagen2.setTag("K")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 12) {
            imagen2.setBackgroundResource(R.drawable.l)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "En Melilla hay tres, en Madrid ninguna, en Castilla dos y en Galicia una. ¿Qué seré?"
            imagen2.setTag("L")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 13) {
            imagen2.setBackgroundResource(R.drawable.m)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "¿Qué es lo que se repite una vez cada minuto, dos veces cada momento y nunca en cien años? ¿Qué seré?"
            imagen2.setTag("M")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 14) {
            imagen2.setBackgroundResource(R.drawable.n)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "¡Nana, nanita, nanita, ea! ¿Cuál es esa letrita que tanto suena? ¿Qué seré?"
            imagen2.setTag("N")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 15) {
            imagen2.setBackgroundResource(R.drawable.ene)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Estoy en medio del año, y casi al final del castaño y del otoño ¿Quién soy?"
            imagen2.setTag("Ñ")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
        } else if (numero == 16) {
            imagen2.setBackgroundResource(R.drawable.o)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Tengo forma de anillo, y soy la primera y la última en organillo. ¿Qué seré?"
            imagen2.setTag("O")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 17) {
            imagen2.setBackgroundResource(R.drawable.p)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "José, dicho entre amigos, repite siempre esta letra; también es la de los padres y la de Pedros y Petras. ¿Qué seré?"
            imagen2.setTag("P")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 18) {
            imagen2.setBackgroundResource(R.drawable.q)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Estoy en el mosquito, pero no en la hormiguita. No me tiene en el grillo, pero sí en la mariquita ¿Qué letra soy?"
            imagen2.setTag("Q")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 19) {
            imagen2.setBackgroundResource(R.drawable.r)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Formo parte de París, en el fin del mar me encuentro, en el principio de Roma y, del Norte, estoy en el centro. ¿Qué seré?"
            imagen2.setTag("R")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 20) {
            imagen2.setBackgroundResource(R.drawable.s)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "En cualquier día de la semana me verás, excepto en domingo que no me encontrarás..¿Qué seré?"
            imagen2.setTag("S")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 21) {
            imagen2.setBackgroundResource(R.drawable.t)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "La tienes en Torremocha y hacia el final de Albacete, y, dondequiera que estés, a las tres como a las siete. ¿Qué seré?"
            imagen2.setTag("T")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 22) {
            imagen2.setBackgroundResource(R.drawable.u)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "El burro la lleva a cuestas, metidas está en el baúl yo no la tuve jamás y siempre la tienes tú ¿Quién soy?"
            imagen2.setTag("U")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 23) {
            imagen2.setBackgroundResource(R.drawable.v)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Vanessa la lleva al principio, y Violeta, y también Víctor. Veleta y venado se apuntan. ¿sabes qué letra es la que llevan?"
            imagen2.setTag("V")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 24) {
            imagen2.setBackgroundResource(R.drawable.w)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Cuando estoy de pie puedes confundirme con dos letras. Cuando estoy al revés suelen confundirme con una letra ¿Quién soy?"
            imagen2.setTag("W")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 25) {
            imagen2.setBackgroundResource(R.drawable.x)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Es una cruz muy bonita, molino de aspas son. ¿Qué letra puede ser esta, que se emplea en multiplicación? ¿Cuál será?"
            imagen2.setTag("X")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 26) {
            imagen2.setBackgroundResource(R.drawable.y)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Soy hermana de la V, pero con un palito de más. Me llevas en un pronombre, si de ti quieres hablar. ¿Qué seré?"
            imagen2.setTag("Y")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 27) {
            imagen2.setBackgroundResource(R.drawable.z)
            imagen.setBackgroundResource(R.drawable.mayuscula)
            adivinanza =
                "Una letra pizpireta, de perdiz y cazoleta que se esconde en la maceta. ¿Qué seré?"
            imagen2.setTag("Z")
            imagen.setTag("Mayuscula")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 28) {
            imagen2.setBackgroundResource(R.drawable.a)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza =
                "Un agricultor tiene tres montones de paja en el pajar y cuatro en el prado. Si los junta ¿cuántos montones tiene?"
            imagen2.setTag("1")
            imagen.setTag("Numero")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 29) {
            imagen2.setBackgroundResource(R.drawable.b)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza = "Tengo forma de patito, soy arqueado y redondito. ¿Quién soy?."
            imagen2.setTag("2")
            imagen.setTag("Numero")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 30) {
            imagen2.setBackgroundResource(R.drawable.c)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza =
                "En una pecera 2 peces van delante de un pez, 2 peces van detrás de un pez, y un pez entre dos peces, ¿Cuántos peces hay?"
            imagen2.setTag("3")
            imagen.setTag("Numero")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 31) {
            imagen2.setBackgroundResource(R.drawable.d)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza =
                "Soy como una escalerita o como un hombre sentado, y cuando se habla de patas, soy las que tienen los bancos. ¿Qué seré?"
            imagen2.setTag("4")
            imagen.setTag("Numero")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 32) {
            imagen2.setBackgroundResource(R.drawable.e)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza =
                "¿Qué número tiene tantas letras en su nombre como lo indica el valor de su cifra? ¿Qué seré?"
            imagen2.setTag("5")
            imagen.setTag("Numero")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 33) {
            imagen2.setBackgroundResource(R.drawable.f)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza =
                "Este era un número impar, pero un día la vuelta se dio bocabajo se quedó y en un numero par se convirtió.¿Qué seré?"
            imagen2.setTag("6")
            imagen.setTag("Numero")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 34) {
            imagen2.setBackgroundResource(R.drawable.g)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza =
                "Si quieres saber qué número soy, espera a que llueva. Contando los colores del arcoíris tendrás la prueba. ¿Qué seré?"
            imagen2.setTag("7")
            imagen.setTag("Numero")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 35) {
            imagen2.setBackgroundResource(R.drawable.h)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza =
                "Un caracol se cayó en un pozo de 11 metros, cada día sube 3 metros y al dormirse baja 2 ¿En cuántos días saldrá el caracol del pozo?"
            imagen2.setTag("8")
            imagen.setTag("Numero")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 36) {
            imagen2.setBackgroundResource(R.drawable.i)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza = "¿Cuál es el número que si lo pones de manos vale menos?"
            imagen2.setTag("9")
            imagen.setTag("Numero")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        } else if (numero == 37) {
            imagen2.setBackgroundResource(R.drawable.j)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza =
                "Redondo soy y es cosa anunciada que a la derecha algo valgo, pero a la izquierda nada. ¿Qué seré?"
            imagen2.setTag("0")
            imagen.setTag("Numero")
            cadena2.setText("${imagen.tag}")
            asignacionBo(imagen2.tag.toString())
        }
    }

    fun asignacionBo(dato1: String) {
        var bandera = false

        val abc = mutableListOf(
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
            "N",
            "Ñ",
            "O",
            "P",
            "Q",
            "R",
            "S",
            "T",
            "U",
            "V",
            "W",
            "X",
            "Y",
            "Z",
            "1",
            "2", "3", "4", "5", "6", "7", "8",
            "9", "0"
        )
        var dato2 = abc.random()
        var dato3 = abc.random()
        var dato4 = abc.random()

        while (!bandera) {
            if (dato2.equals(dato1) || dato2.equals(dato3) || dato2.equals(dato4)) {
                dato2 = abc.random()
            } else if (dato3.equals(dato1) || dato3.equals(dato2) || dato3.equals(dato4)) {
                dato3 = abc.random()
            } else if (dato4.equals(dato1) || dato4.equals(dato2) || dato4.equals(dato3)) {
                dato4 = abc.random()
            } else {
                bandera = true
            }
        }
        val arreglo = arrayListOf<String>(dato1, dato2, dato3, dato4)
        arreglo.shuffle()
        cinco.text = arreglo[0]
        seis.text = arreglo[1]
        siete.text = arreglo[2]
        ocho.text = arreglo[3]
    }

    fun repetir2() {
        equi = 1
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
            marcador -= 1
            prefs1.rmaynum = prefs1.rmaynum - 1
            if (marcador < 0) {
                marcador = 0
            }
            if (prefs1.rmaynum < 0) {
                prefs1.rmaynum = 0
            }
        }
        marcadorA1.text = marcador.toString()
        asignacion()
    }

    private fun alerta2(dato1: String) {
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.activity_pista)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialog.tarjetaBase8.text = dato1
        customDialog.dob.visibility = View.GONE
        customDialog.tarjetaBase81.visibility = View.GONE
        customDialog.show()
    }
}