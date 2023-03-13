package com.bp.braapptutor.games.adivinanzas

import  android.app.Dialog
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
import kotlinx.android.synthetic.main.activity_adivi1.*
import kotlinx.android.synthetic.main.activity_adivi1.imagen
import kotlinx.android.synthetic.main.activity_adivi1.mue1
import kotlinx.android.synthetic.main.activity_adivi1.mue2
import kotlinx.android.synthetic.main.activity_adivi1.mue3
import kotlinx.android.synthetic.main.activity_cerrarchat.*
import kotlinx.android.synthetic.main.activity_cerrarchat1.*
import kotlinx.android.synthetic.main.activity_memosim.*
import kotlinx.android.synthetic.main.activity_pista.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import kotlinx.android.synthetic.main.ventana.*
import spencerstudios.com.bungeelib.Bungee
import java.io.IOException

class adivi1 : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private var mAuth: FirebaseAuth? = null
    var adivinanza = ""
    var marcador = 0
    var equi = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivi1)
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
        when (equi) {
            1 -> {
                mue1.visibility = View.INVISIBLE
                mue2.visibility = View.INVISIBLE
                mue3.visibility = View.INVISIBLE
            }
            2 -> {
                equi = equi + 1
                mue1.visibility = View.VISIBLE
                mue2.visibility = View.INVISIBLE
                mue3.visibility = View.INVISIBLE
            }
            3 -> {
                equi = equi + 1
                mue1.visibility = View.VISIBLE
                mue2.visibility = View.VISIBLE
                mue3.visibility = View.INVISIBLE
            }
            4 -> {
                equi = 1
                mue1.visibility = View.VISIBLE
                mue2.visibility = View.VISIBLE
                mue3.visibility = View.VISIBLE
                repetir2()
            }
        }
        val texto2: LinearLayout = findViewById(R.id.adivi1)
        //Asignacioón de las animaciones
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto2.startAnimation(anim1)
        val namem1 = prefs1.password
        val fotom = prefs1.userId.toString()
        usera21.text = namem1
        when {
            fotom.toInt() == 0 -> {
                fotoa21.setBackgroundResource(R.drawable.nina)
            }
            fotom.toInt() == 1 -> {
                fotoa21.setBackgroundResource(R.drawable.nino)
            }
            fotom.toInt() == 2 -> {
                fotoa21.setBackgroundResource(R.drawable.jovena)
            }
            fotom.toInt() == 3 -> {
                fotoa21.setBackgroundResource(R.drawable.joveno)
            }
            fotom.toInt() == 4 -> {
                fotoa21.setBackgroundResource(R.drawable.adulta)
            }
            fotom.toInt() == 5 -> {
                fotoa21.setBackgroundResource(R.drawable.adulto)
            }
            fotom.toInt() == 6 -> {
                fotoa21.setBackgroundResource(R.drawable.abuelo)
            }
            fotom.toInt() == 7 -> {
                fotoa21.setBackgroundResource(R.drawable.abuela)
            }
            fotom.toInt() == 8 -> {
                fotoa21.setBackgroundResource(R.drawable.indefinido)
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
        setSupportActionBar(findViewById(R.id.toolbarJ21))
        navigation_viewJ21.addOnLayoutChangeListener { view, i, i2, i3, i4, i5, i6, i7, i8 ->
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
                        soundPool!!.play(carga, prefs.volum1, prefs.volum1, 0, 0, 1f)
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
                        startActivity(Intent(this@adivi1, Usuarios::class.java))
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
        navigation_viewJ21.setNavigationItemSelectedListener {
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
                    drawerJ21.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuPrin::class.java))

                    Bungee.zoom(this)
                    true
                }
                R.id.dos2 -> {
                    drawerJ21.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, materialapoyo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.tres3 -> {
                    drawerJ21.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Red::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cuatro4 -> {
                    drawerJ21.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuJuegos::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cinco5 -> {
                    drawerJ21.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, historia::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.seis6 -> {
                    drawerJ21.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Extras::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.siete7 -> {
                    drawerJ21.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuCatalogo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.ocho8 -> {
                    drawerJ21.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Traductores::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.nueve9 -> {
                    drawerJ21.closeDrawer(GravityCompat.START)

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
        val drawerToggle = ActionBarDrawerToggle(this, drawerJ21, R.string.open, R.string.close)
        drawerJ21.addDrawerListener(drawerToggle)
        drawerToggle.drawerArrowDrawable.color = Color.BLACK
        drawerToggle.drawerArrowDrawable.gapSize = 30.0f
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_viewJ21.setItemIconTintList(null);
        asignacion()
        reintentar1.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            equi = 1
            repetir()
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
                    prefs1.rminsim = prefs1.rminsim - marcador
                    marcador=0
                    asignacion()
                }
            }
        }
        uno.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (uno.text == imagen.getTag()) {
                marcador = marcador + 10
                prefs1.rminsim = prefs1.rminsim + 10
                puntaje1.text = marcador.toString()
                toast("Es correcto")
                asignacion()
            } else {
                if (marcador > 0) {
                    marcador = marcador - 2
                    prefs1.rminsim = prefs1.rminsim - 2

                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rminsim < 0) {
                        prefs1.rminsim = 0
                    }
                }
                Log.v("Prueba","Equi $equi")
                equi += 1
                Log.v("Prueba","Equi $equi")
                when (equi) {
                    1 -> {
                        mue1.visibility = View.INVISIBLE
                        mue2.visibility = View.INVISIBLE
                        mue3.visibility = View.INVISIBLE
                    }
                    2 -> {

                        mue1.visibility = View.VISIBLE
                        mue2.visibility = View.INVISIBLE
                        mue3.visibility = View.INVISIBLE
                        if (marcador > 0) {
                            marcador = marcador - 2
                            prefs1.rminsim = prefs1.rminsim - 2
                            if (marcador < 0) {
                                marcador = 0
                            }
                            if (prefs1.rminsim < 0) {
                                prefs1.rminsim = 0
                            }
                        }
                        puntaje1.text = marcador.toString()
                    }
                    3 -> {

                        mue1.visibility = View.VISIBLE
                        mue2.visibility = View.VISIBLE
                        mue3.visibility = View.INVISIBLE
                        if (marcador > 0) {
                            marcador = marcador - 2
                            prefs1.rminsim = prefs1.rminsim - 2
                            if (marcador < 0) {
                                marcador = 0
                            }
                            if (prefs1.rminsim < 0) {
                                prefs1.rminsim = 0
                            }
                        }
                        puntaje1.text = marcador.toString()
                    }
                    4 -> {
                        equi = 1
                        mue1.visibility = View.VISIBLE
                        mue2.visibility = View.VISIBLE
                        mue3.visibility = View.VISIBLE
                        prefs1.rminsim = prefs1.rminsim - marcador
                        marcador=0
                        asignacion()

                    }
                }
                puntaje1.text = marcador.toString()
                toast("Es incorrecto")
            }
        }
        dos.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (dos.text == imagen.getTag()) {
                marcador = marcador + 10
                prefs1.rminsim = prefs1.rminsim + 10
                puntaje1.text = marcador.toString()
                toast("Es correcto")
                asignacion()
            } else {
                if (marcador > 0) {
                    marcador = marcador - 2
                    prefs1.rminsim = prefs1.rminsim - 2
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rminsim < 0) {
                        prefs1.rminsim = 0
                    }

                }
                Log.v("Prueba","Equi $equi")
                equi = equi + 1
                Log.v("Prueba","Equi $equi")
                when (equi) {
                    1 -> {
                        mue1.visibility = View.INVISIBLE
                        mue2.visibility = View.INVISIBLE
                        mue3.visibility = View.INVISIBLE
                    }
                    2 -> {

                        mue1.visibility = View.VISIBLE
                        mue2.visibility = View.INVISIBLE
                        mue3.visibility = View.INVISIBLE
                        if (marcador > 0) {
                            marcador = marcador - 2
                            prefs1.rminsim = prefs1.rminsim - 2
                            if (marcador < 0) {
                                marcador = 0
                            }
                            if (prefs1.rminsim < 0) {
                                prefs1.rminsim = 0
                            }
                        }
                        puntaje1.text = marcador.toString()
                    }
                    3 -> {

                        mue1.visibility = View.VISIBLE
                        mue2.visibility = View.VISIBLE
                        mue3.visibility = View.INVISIBLE
                        if (marcador > 0) {
                            marcador = marcador - 2
                            prefs1.rminsim = prefs1.rminsim - 2
                            if (marcador < 0) {
                                marcador = 0
                            }
                            if (prefs1.rminsim < 0) {
                                prefs1.rminsim = 0
                            }
                        }
                        puntaje1.text = marcador.toString()
                    }
                    4 -> {
                        equi = 1
                        mue1.visibility = View.VISIBLE
                        mue2.visibility = View.VISIBLE
                        mue3.visibility = View.VISIBLE
                        prefs1.rminsim = prefs1.rminsim - marcador
                        marcador=0
                        asignacion()

                    }
                }
                puntaje1.text = marcador.toString()
                toast("Es incorrecto")
            }
        }
        tres.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (tres.text == imagen.getTag()) {
                marcador = marcador + 10
                prefs1.rminsim = prefs1.rminsim + 10
                puntaje1.text = marcador.toString()
                toast("Es correcto")
                asignacion()
            } else {
                if (marcador > 0) {
                    marcador = marcador - 2
                    prefs1.rminsim = prefs1.rminsim - 2
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rminsim < 0) {
                        prefs1.rminsim = 0
                    }

                }
                Log.v("Prueba","Equi $equi")
                equi = equi + 1
                Log.v("Prueba","Equi $equi")
                when (equi) {
                    1 -> {
                        mue1.visibility = View.INVISIBLE
                        mue2.visibility = View.INVISIBLE
                        mue3.visibility = View.INVISIBLE
                    }
                    2 -> {

                        mue1.visibility = View.VISIBLE
                        mue2.visibility = View.INVISIBLE
                        mue3.visibility = View.INVISIBLE
                        if (marcador > 0) {
                            marcador = marcador - 2
                            prefs1.rminsim = prefs1.rminsim - 2
                            if (marcador < 0) {
                                marcador = 0
                            }
                            if (prefs1.rminsim < 0) {
                                prefs1.rminsim = 0
                            }
                        }
                        puntaje1.text = marcador.toString()
                    }
                    3 -> {
                            mue1.visibility = View.VISIBLE
                        mue2.visibility = View.VISIBLE
                        mue3.visibility = View.INVISIBLE
                        if (marcador > 0) {
                            marcador = marcador - 2
                            prefs1.rminsim = prefs1.rminsim - 2
                            if (marcador < 0) {
                                marcador = 0
                            }
                            if (prefs1.rminsim < 0) {
                                prefs1.rminsim = 0
                            }
                        }
                        puntaje1.text = marcador.toString()
                    }
                    4 -> {
                        equi = 1
                        mue1.visibility = View.VISIBLE
                        mue2.visibility = View.VISIBLE
                        mue3.visibility = View.VISIBLE
                        prefs1.rminsim = prefs1.rminsim - marcador
                        marcador=0
                        asignacion()

                    }
                }
                puntaje1.text = marcador.toString()
                toast("Es incorrecto")
            }
        }
        cuatro.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)

            if (cuatro.text == imagen.getTag()) {
                marcador = marcador + 10
                prefs1.rminsim = prefs1.rminsim + 10
                puntaje1.text = marcador.toString()
                toast("Es correcto")
                asignacion()
            } else {
                if (marcador > 0) {
                    marcador = marcador - 2
                    prefs1.rminsim = prefs1.rminsim - 2
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rminsim < 0) {
                        prefs1.rminsim = 0
                    }

                }
                Log.v("Prueba","Equi $equi")
                equi = equi + 1
                Log.v("Prueba","Equi $equi")
                when (equi) {
                    1 -> {
                        mue1.visibility = View.INVISIBLE
                        mue2.visibility = View.INVISIBLE
                        mue3.visibility = View.INVISIBLE
                    }
                    2 -> {

                        mue1.visibility = View.VISIBLE
                        mue2.visibility = View.INVISIBLE
                        mue3.visibility = View.INVISIBLE
                        if (marcador > 0) {
                            marcador = marcador - 2
                            prefs1.rminsim = prefs1.rminsim - 2
                            if (marcador < 0) {
                                marcador = 0
                            }
                            if (prefs1.rminsim < 0) {
                                prefs1.rminsim = 0
                            }
                        }
                        puntaje1.text = marcador.toString()
                    }
                    3 -> {

                        mue1.visibility = View.VISIBLE
                        mue2.visibility = View.VISIBLE
                        mue3.visibility = View.INVISIBLE
                        if (marcador > 0) {
                            marcador = marcador - 2
                            prefs1.rminsim = prefs1.rminsim - 2
                            if (marcador < 0) {
                                marcador = 0
                            }
                            if (prefs1.rminsim < 0) {
                                prefs1.rminsim = 0
                            }
                        }
                        puntaje1.text = marcador.toString()
                    }
                    4 -> {
                        equi = 1
                        mue1.visibility = View.VISIBLE
                        mue2.visibility = View.VISIBLE
                        mue3.visibility = View.VISIBLE
                        prefs1.rminsim = prefs1.rminsim - marcador
                       marcador=0
                        asignacion()

                    }
                }
                puntaje1.text = marcador.toString()
                toast("Es incorrecto")
            }
        }
        pista.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (marcador <= 5) {
                toast("Necesita 5 puntos para activar la pista.")
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
                    prefs1.rminsim = prefs1.rminsim - 5
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rminsim < 0) {
                        prefs1.rminsim = 0
                    }
                }
                puntaje1.text = marcador.toString()
                alerta2(adivinanza)
            }
        }
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
        if (drawerJ21.isDrawerOpen(GravityCompat.START)) {
            drawerJ21.closeDrawer(GravityCompat.START)
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
                drawerJ21.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
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
        val numero = (1..29).random()
        numero + 1
        when (numero) {
            1 -> {
                imagen.setBackgroundResource(R.drawable.a)
                adivinanza =
                    "Yo fui tu primer sonido cuando empezaste a hablar y soy la primera letra que en el alfabeto está. ¿Qué seré?"
                imagen.setTag("a")
                asignacionBo(imagen.tag.toString())

            }
            2 -> {
                imagen.setBackgroundResource(R.drawable.b)
                adivinanza =
                    "Porque bien gordita estoy, dos barrigas me verás. No me gustan los viajes y en el barco me veras. ¿Qué seré?"
                imagen.setTag("b")
                asignacionBo(imagen.tag.toString())
            }
            3 -> {
                imagen.setBackgroundResource(R.drawable.c)
                adivinanza =
                    "Me puedes encontrar muy al final del amanecer, nunca al mediodía ni en la tarde, pero sí en el medio de la noche ¿Quién soy?"
                imagen.setTag("c")
                asignacionBo(imagen.tag.toString())
            }
            4 -> {
                imagen.setBackgroundResource(R.drawable.d)
                adivinanza =
                    "En los dedos tengo dos, en los dientes tengo uno, pero en las piernas, manos y brazos, ninguno. ¿Qué será?"
                imagen.setTag("d")
                asignacionBo(imagen.tag.toString())
            }
            5 -> {
                imagen.setBackgroundResource(R.drawable.e)
                adivinanza =
                    "Como un tenedor, pero sin asa. Así dicen que soy los que me graban. ¿Qué seré?"
                imagen.setTag("e")
                asignacionBo(imagen.tag.toString())
            }
            6 -> {
                imagen.setBackgroundResource(R.drawable.f)
                adivinanza =
                    "Le sirve de puerta al frío y al fuego, es final en nombres rusos y mediadora en oferta ¿Qué letra soy?"
                imagen.setTag("f")
                asignacionBo(imagen.tag.toString())
            }
            7 -> {
                imagen.setBackgroundResource(R.drawable.g)
                adivinanza =
                    "Generosa gracias a ti existe, y en garganta dos veces insiste. ¿Quién soy?"
                imagen.setTag("g")
                asignacionBo(imagen.tag.toString())
            }
            8 -> {
                imagen.setBackgroundResource(R.drawable.h)
                adivinanza =
                    "Aunque mi sonido es mudo, cuando me nombran parezco a un estornudo ¿Quién soy?"
                imagen.setTag("h")
                asignacionBo(imagen.tag.toString())
            }
            9 -> {
                imagen.setBackgroundResource(R.drawable.i)
                adivinanza =
                    "Soy un palito muy derechito y encima de la frente llevo un mosquito que ni pica ni vuela ni toca la vihuela. ¿Qué seré?"
                imagen.setTag("i")
                asignacionBo(imagen.tag.toString())
            }
            10 -> {
                imagen.setBackgroundResource(R.drawable.j)
                adivinanza =
                    "Mi nombre es nombre de baile, alegre y muy bravío; cuando suena en Aragón, la gente pierde el sentío. ¿Qué seré?"
                imagen.setTag("j")
                asignacionBo(imagen.tag.toString())
            }
            11 -> {
                imagen.setBackgroundResource(R.drawable.k)
                adivinanza =
                    "No me pronunciéis dos veces, que tengo sonido feo; siendo la letra del kilo, en carreteras me veo. ¿Qué seré?"
                imagen.setTag("k")
                asignacionBo(imagen.tag.toString())
            }
            12 -> {
                imagen.setBackgroundResource(R.drawable.l)
                adivinanza = "Empieza en luna termina en sol. ¿Qué seré?"
                imagen.setTag("l")
                asignacionBo(imagen.tag.toString())
            }
            13 -> {
                imagen.setBackgroundResource(R.drawable.m)
                adivinanza =
                    "Una vez en un minuto, dos veces en un momento, tres veces en mimetismo, y en cuatro, ¡no la encuentro! ¿Qué seré?"
                imagen.setTag("m")
                asignacionBo(imagen.tag.toString())
            }
            14 -> {
                imagen.setBackgroundResource(R.drawable.n)
                adivinanza =
                    "Suelen tenerla los puentes, pero no los viaductos. Como también las fuentes. ¿Qué será?"
                imagen.setTag("n")
                asignacionBo(imagen.tag.toString())
            }
            15 -> {
                imagen.setBackgroundResource(R.drawable.ene)
                adivinanza =
                    "Aunque lleve turbante mor no soy, que solo en castellano de letra estoy. ¿Qué seré?"
                imagen.setTag("ñ")
                asignacionBo(imagen.tag.toString())
            }
            16 -> {
                imagen.setBackgroundResource(R.drawable.o)
                adivinanza =
                    "Una cosa quisicosa, de ovalada construcción, todos los nombres la tienen, pero las mujeres, no. El Obispo como todos también tiene dos. ¿Qué seré?"
                imagen.setTag("o")
                asignacionBo(imagen.tag.toString())
            }
            17 -> {
                imagen.setBackgroundResource(R.drawable.p)
                adivinanza =
                    "Como una B pero sin barriga. Me encontrarás al comienzo de Pancho, Paco y Pandora. ¿Qué seré?"
                imagen.setTag("p")
                asignacionBo(imagen.tag.toString())
            }
            18 -> {
                imagen.setBackgroundResource(R.drawable.q)
                adivinanza =
                    "Estoy en el mosquito, pero no en la hormiguita. No me tiene en el grillo, pero sí en la mariquita ¿Qué letra soy? ¿Qué seré?"
                imagen.setTag("q")
                asignacionBo(imagen.tag.toString())
            }
            19 -> {
                imagen.setBackgroundResource(R.drawable.r)
                adivinanza =
                    "La tiene el tigre, pero no el león dos veces el perro y una el ratón. ¿Qué seré?"
                imagen.setTag("r")
                asignacionBo(imagen.tag.toString())
            }
            20 -> {
                imagen.setBackgroundResource(R.drawable.s)
                adivinanza =
                    "Desde el lunes hasta el viernes, soy la última en llegar, el sábado soy la primera y el domingo a descansar. ¿Qué seré?"
                imagen.setTag("s")
                asignacionBo(imagen.tag.toString())
            }
            21 -> {
                imagen.setBackgroundResource(R.drawable.t)
                adivinanza =
                    "Te la digo y no la sabes, te la vuelvo a repetir, te la digo 3 veces y no la sabes decir. ¿Qué seré?"
                imagen.setTag("t")
                asignacionBo(imagen.tag.toString())
            }
            22 -> {
                imagen.setBackgroundResource(R.drawable.u)
                adivinanza =
                    "¿Sabes de alguna letrita, que, si la vuelta le das, enseguida se convierte de consonante en vocal? ¿Qué seré?"
                imagen.setTag("u")
                asignacionBo(imagen.tag.toString())
            }
            23 -> {
                imagen.setBackgroundResource(R.drawable.v)
                adivinanza =
                    "En la vaca estoy, en el viento voy, si en burro me ves en ortografía vas al revés. ¿Qué seré?"
                imagen.setTag("v")
                asignacionBo(imagen.tag.toString())
            }
            24 -> {
                imagen.setBackgroundResource(R.drawable.w)
                adivinanza =
                    "Wamba y Witiza me tienen de pie, Víctor sólo a medias y Muza al revés. ¿Qué seré?"
                imagen.setTag("w")
                asignacionBo(imagen.tag.toString())
            }
            25 -> {
                imagen.setBackgroundResource(R.drawable.x)
                adivinanza =
                    "Es una cruz muy bonita, molino de aspas son. ¿Qué letra puede ser esta, que se emplea en multiplicación? ¿Cuál será? ¿Qué seré?"
                imagen.setTag("x")
                asignacionBo(imagen.tag.toString())
            }
            26 -> {
                imagen.setBackgroundResource(R.drawable.y)
                adivinanza =
                    "Tengo una pierna y no camino ni salto, tengo dos brazos y no puedo aplaudir. ¿Quién soy?"
                imagen.setTag("y")
                asignacionBo(imagen.tag.toString())
            }
            27 -> {
                imagen.setBackgroundResource(R.drawable.z)
                adivinanza =
                    "La última de todas soy, pero en zurdo y zapato primera voy. ¿Qué seré?"
                imagen.setTag("z")
                asignacionBo(imagen.tag.toString())
            }
            28 -> {
                imagen.setBackgroundResource(R.drawable.punto)
                adivinanza = "Muy chiquito, chiquito, pone fin a lo escrito. ¿Qué seré?"
                imagen.setTag(".")
                asignacionBo(imagen.tag.toString())
            }
            29 -> {
                imagen.setBackgroundResource(R.drawable.signos_interrogacion)
                adivinanza =
                    "Termino cabeza arriba y empiezo cabeza abajo, y tan sólo a preguntar se limita mi trabajo. ¿Qué seré?"
                imagen.setTag("¿?")
                asignacionBo(imagen.tag.toString())
            }
        }
    }

    fun asignacionBo(dato1: String) {
        var bandera = false

        val abc = mutableListOf(
            "a",
            "b",
            "c",
            "d",
            "e",
            "f",
            "g",
            "h",
            "i",
            "j",
            "k",
            "l",
            "m",
            "n",
            "ñ",
            "o",
            "p",
            "q",
            "r",
            "s",
            "t",
            "u",
            "v",
            "w",
            "x",
            "y",
            "z",
            ".",
            "¿?"
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
        uno.text = arreglo[0]
        dos.text = arreglo[1]
        tres.text = arreglo[2]
        cuatro.text = arreglo[3]
    }

    fun repetir() {
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
            marcador = marcador - 2
            prefs1.rminsim = prefs1.rminsim - 2
            if (marcador < 0) {
                marcador = 0
            }
            if (prefs1.rminsim < 0) {
                prefs1.rminsim = 0
            }
        }
        puntaje1.text = marcador.toString()
        asignacion()
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
            marcador = marcador - 1
            prefs1.rminsim = prefs1.rminsim - 1
            if (marcador < 0) {
                marcador = 0
            }
            if (prefs1.rminsim < 0) {
                prefs1.rminsim = 0
            }
        }
        puntaje1.text = marcador.toString()
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
        customDialog.tarjetaBase81.visibility = View.GONE
        customDialog.dob.visibility = View.GONE
        customDialog.tarjetaBase8.text = dato1
        customDialog.show()
    }

}