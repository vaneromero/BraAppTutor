package com.bp.braapptutor.games.memos

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
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
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
import kotlinx.android.synthetic.main.activity_cerrarchat.*
import kotlinx.android.synthetic.main.activity_cerrarchat1.*
import kotlinx.android.synthetic.main.activity_memomay.*
import kotlinx.android.synthetic.main.activity_memomin.*
import kotlinx.android.synthetic.main.activity_memomin.puntaje
import kotlinx.android.synthetic.main.activity_memomin.reintentar
import kotlinx.android.synthetic.main.activity_memomin.vida
import kotlinx.android.synthetic.main.activity_respu.*
import kotlinx.android.synthetic.main.cartas_imagen.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import kotlinx.android.synthetic.main.ventana.*
import spencerstudios.com.bungeelib.Bungee
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class memomay : AppCompatActivity() {
    var marcador: Int = 0
    var primeraCarta: Int = 0
    var segundaCarta: Int = 0
    var primerClick: Int = 0
    var segundoClick: Int = 0
    var numeroCarta: Int = 1
    var vidas: Int = 6
    var p1: String = ""
    var p2: String = ""
    var p3: String = ""
    var p4: String = ""
    var p5: String = ""
    var p6: String = ""
    var bandera = false
    var cartas = ArrayList<Int>(listOf(12, 13, 14, 15, 16, 17, 22, 23, 24, 25, 26, 27))
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memomay)
        val texto2: LinearLayout = findViewById(R.id.memomay1)
        //Asignacioón de las animaciones
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto2.startAnimation(anim1)
        val Archivo = "Usuario"
        val defaultPrefs1 = Splash.PreferenceHelper.defaultPreference(this)
        defaultPrefs1.password = "Admin"
        defaultPrefs1.userId = 50

        val prefs1 = Splash.PreferenceHelper.customPreference(this, Archivo)
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
        val prefs = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)
        val namem1 = prefs1.password
        val fotom = prefs1.userId.toString()
        userm2.text = namem1
        when {
            fotom.toInt() == 0 -> {
                fotom2.setBackgroundResource(R.drawable.nina)
            }
            fotom.toInt() == 1 -> {
                fotom2.setBackgroundResource(R.drawable.nino)
            }
            fotom.toInt() == 2 -> {
                fotom2.setBackgroundResource(R.drawable.jovena)
            }
            fotom.toInt() == 3 -> {
                fotom2.setBackgroundResource(R.drawable.joveno)
            }
            fotom.toInt() == 4 -> {
                fotom2.setBackgroundResource(R.drawable.adulta)
            }
            fotom.toInt() == 5 -> {
                fotom2.setBackgroundResource(R.drawable.adulto)
            }
            fotom.toInt() == 6 -> {
                fotom2.setBackgroundResource(R.drawable.abuelo)
            }
            fotom.toInt() == 7 -> {
                fotom2.setBackgroundResource(R.drawable.abuela)
            }
            fotom.toInt() == 8 -> {
                fotom2.setBackgroundResource(R.drawable.indefinido)
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
        reintentar.setOnClickListener {
            soundPool!!.play(carga, prefs2.volum1, prefs2.volum1, 0, 0, 1f)
            recargar()
        }
        var cnt = prefs.contador
        if (cnt == 0) {
            alerta()
        }

        // 2.- Cargar Cartas
        seleccionLetras()

        // 3.- Barajar las Cartas
        Collections.shuffle(cartas)

        // 4.- setUp OnClickListener
        setUpOnClickListner()
        setSupportActionBar(findViewById(R.id.toolbarJ12))
        navigation_viewJ12.addOnLayoutChangeListener { view, i, i2, i3, i4, i5, i6, i7, i8 ->
            val foto6 = prefs.userId.toString()
            view.NavBu.text = prefs.password
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
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
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
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
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
                        startActivity(Intent(this@memomay, Usuarios::class.java))
                        Bungee.zoom(this)

                    }
                    customDialog.fvfb.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        customDialog.dismiss()
                    }
                    customDialog.show()
                }
            }
        }
        navigation_viewJ12.setNavigationItemSelectedListener {
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
                    drawerJ12.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuPrin::class.java))

                    Bungee.zoom(this)
                    true
                }
                R.id.dos2 -> {
                    drawerJ12.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, materialapoyo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.tres3 -> {
                    drawerJ12.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Red::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cuatro4 -> {
                    drawerJ12.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuJuegos::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cinco5 -> {
                    drawerJ12.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, historia::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.seis6 -> {
                    drawerJ12.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Extras::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.siete7 -> {
                    drawerJ12.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuCatalogo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.ocho8 -> {
                    drawerJ12.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Traductores::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.nueve9 -> {
                    drawerJ12.closeDrawer(GravityCompat.START)
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
        val drawerToggle = ActionBarDrawerToggle(this, drawerJ12, R.string.open, R.string.close)
        drawerJ12.addDrawerListener(drawerToggle)
        drawerToggle.drawerArrowDrawable.color = Color.BLACK
        drawerToggle.drawerArrowDrawable.gapSize = 30.0f
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_viewJ12.setItemIconTintList(null);

    }

    private fun seleccionLetras() {
        p1 = ""
        val abc = mutableListOf(
            "ma",
            "mb",
            "mc",
            "md",
            "me",
            "mf",
            "mg",
            "mh",
            "mi",
            "mj",
            "mk",
            "ml",
            "mm",
            "mn",
            "n2",
            "mo",
            "mp",
            "mq",
            "mr",
            "ms",
            "mt",
            "mu",
            "mv",
            "mw",
            "mx",
            "my",
            "mz",
            "mda",
            "mda1",
            "mde",
            "mdi",
            "mdo",
            "mdo1",
            "mdu",
            "mdu1",
            "mdy"
        )
        p1 = abc.random().toString()
        p2 = abc.random().toString()
        p3 = abc.random().toString()
        p4 = abc.random().toString()
        p5 = abc.random().toString()
        p6 = abc.random().toString()
        while (!bandera) {
            if ((p2.equals(p1)) || (p2.equals(p3)) || (p2.equals(p4)) || (p2.equals(p5)) || (p2.equals(
                    p6
                ))
            ) {
                p2 = abc.random().toString()
            } else if ((p3.equals(p1)) || (p3.equals(p2)) || (p3.equals(p4)) || (p3.equals(p5)) || (p3.equals(
                    p6
                ))
            ) {
                p3 = abc.random().toString()
            } else if ((p4.equals(p1)) || (p4.equals(p2)) || (p4.equals(p3)) || (p4.equals(p5)) || (p4.equals(
                    p6
                ))
            ) {
                p4 = abc.random().toString()
            } else if ((p5.equals(p1)) || (p5.equals(p2)) || (p5.equals(p3)) || (p5.equals(p4)) || (p5.equals(
                    p6
                ))
            ) {
                p5 = abc.random().toString()
            } else if ((p6.equals(p1)) || (p6.equals(p2)) || (p6.equals(p3)) || (p6.equals(p4)) || (p6.equals(
                    p5
                ))
            ) {
                p6 = abc.random().toString()
            } else {
                bandera = true;
            }
        }
    }

    private fun setUpOnClickListner() {
        val Archivo1 = "Audio"
        val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this)
        defaultPrefs1.tono = 1
        defaultPrefs1.melodia = 1
        defaultPrefs1.activi = ""
        defaultPrefs1.volum = 0.10f
        defaultPrefs1.volum1 = 1.00f
        val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
        var carga = prefs1.tono
        soundPool = SoundPool(100, AudioManager.STREAM_MUSIC, 0)
        when (prefs1.tono) {
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
        im11.setOnClickListener() {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            var carta: Int = 0
            asignarImagenalaCarta(im11, carta)
        }

        im12.setOnClickListener() {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            var carta: Int = 1
            asignarImagenalaCarta(im12, carta)
        }

        im13.setOnClickListener() {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            var carta: Int = 2
            asignarImagenalaCarta(im13, carta)
        }

        im21.setOnClickListener() {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            var carta: Int = 3
            asignarImagenalaCarta(im21, carta)
        }

        im22.setOnClickListener() {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            var carta: Int = 4
            asignarImagenalaCarta(im22, carta)
        }

        im23.setOnClickListener() {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            var carta: Int = 5
            asignarImagenalaCarta(im23, carta)
        }

        im31.setOnClickListener() {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            var carta: Int = 6
            asignarImagenalaCarta(im31, carta)
        }

        im32.setOnClickListener() {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            var carta: Int = 7
            asignarImagenalaCarta(im32, carta)
        }

        im33.setOnClickListener() {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            var carta: Int = 8
            asignarImagenalaCarta(im33, carta)
        }

        im41.setOnClickListener() {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            var carta: Int = 9
            asignarImagenalaCarta(im41, carta)
        }
        im42.setOnClickListener() {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            var carta: Int = 10
            asignarImagenalaCarta(im42, carta)
        }
        im43.setOnClickListener() {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            var carta: Int = 11
            asignarImagenalaCarta(im43, carta)
        }
    }

    private fun asignarImagenalaCarta(image: ImageView, carta: Int) {
        if (vidas >= 1) {
            when (cartas[carta]) {
                12 -> image.setImageResource(
                    getResources().getIdentifier(
                        p1,
                        "drawable",
                        getPackageName()
                    )
                );
                13 -> image.setImageResource(
                    getResources().getIdentifier(
                        p2,
                        "drawable",
                        getPackageName()
                    )
                );
                14 -> image.setImageResource(
                    getResources().getIdentifier(
                        p3,
                        "drawable",
                        getPackageName()
                    )
                );
                15 -> image.setImageResource(
                    getResources().getIdentifier(
                        p4,
                        "drawable",
                        getPackageName()
                    )
                );
                16 -> image.setImageResource(
                    getResources().getIdentifier(
                        p5,
                        "drawable",
                        getPackageName()
                    )
                );
                17 -> image.setImageResource(
                    getResources().getIdentifier(
                        p6,
                        "drawable",
                        getPackageName()
                    )
                );

                22 -> image.setImageResource(
                    getResources().getIdentifier(
                        p1,
                        "drawable",
                        getPackageName()
                    )
                );
                23 -> image.setImageResource(
                    getResources().getIdentifier(
                        p2,
                        "drawable",
                        getPackageName()
                    )
                );
                24 -> image.setImageResource(
                    getResources().getIdentifier(
                        p3,
                        "drawable",
                        getPackageName()
                    )
                );
                25 -> image.setImageResource(
                    getResources().getIdentifier(
                        p4,
                        "drawable",
                        getPackageName()
                    )
                );
                26 -> image.setImageResource(
                    getResources().getIdentifier(
                        p5,
                        "drawable",
                        getPackageName()
                    )
                );
                27 -> image.setImageResource(
                    getResources().getIdentifier(
                        p6,
                        "drawable",
                        getPackageName()
                    )
                );
            }
            if (numeroCarta == 1) {
                primeraCarta = cartas[carta]
                if (primeraCarta > 20) {
                    primeraCarta = primeraCarta - 10
                }
                numeroCarta = 2
                primerClick = carta
                image.isEnabled = false
            } else if (numeroCarta == 2) {
                segundaCarta = cartas[carta]
                if (segundaCarta > 20) {
                    segundaCarta = segundaCarta - 10
                }
                numeroCarta = 1
                segundoClick = carta

                im11.isEnabled = false
                im12.isEnabled = false
                im13.isEnabled = false
                im21.isEnabled = false
                im22.isEnabled = false
                im23.isEnabled = false
                im31.isEnabled = false
                im32.isEnabled = false
                im33.isEnabled = false
                im41.isEnabled = false
                im42.isEnabled = false
                im43.isEnabled = false

                var handler = Handler()
                handler.postDelayed(Runnable {
                    comprobarCorrecto()
                }, 1000)
            }
        } else {
            var imagen = "lose"
            var titulo = "HAS PERDIDO!!"
            var dato2 = "Te has quedado sin intentos"
            var dato1 = "Tu puntuación es de: " + marcador
            alerta3(imagen, titulo, dato1, dato2, marcador)
        }

    }

    private fun comprobarCorrecto() {
        if (primeraCarta == segundaCarta) {
            when (primerClick) {
                0 -> im11.visibility = View.INVISIBLE
                1 -> im12.visibility = View.INVISIBLE
                2 -> im13.visibility = View.INVISIBLE
                3 -> im21.visibility = View.INVISIBLE
                4 -> im22.visibility = View.INVISIBLE
                5 -> im23.visibility = View.INVISIBLE
                6 -> im31.visibility = View.INVISIBLE
                7 -> im32.visibility = View.INVISIBLE
                8 -> im33.visibility = View.INVISIBLE
                9 -> im41.visibility = View.INVISIBLE
                10 -> im42.visibility = View.INVISIBLE
                11 -> im43.visibility = View.INVISIBLE
            }

            when (segundoClick) {
                0 -> im11.visibility = View.INVISIBLE
                1 -> im12.visibility = View.INVISIBLE
                2 -> im13.visibility = View.INVISIBLE
                3 -> im21.visibility = View.INVISIBLE
                4 -> im22.visibility = View.INVISIBLE
                5 -> im23.visibility = View.INVISIBLE
                6 -> im31.visibility = View.INVISIBLE
                7 -> im32.visibility = View.INVISIBLE
                8 -> im33.visibility = View.INVISIBLE
                9 -> im41.visibility = View.INVISIBLE
                10 -> im42.visibility = View.INVISIBLE
                11 -> im43.visibility = View.INVISIBLE
            }
            vidas += 1;
            vida.setText("" + vidas)
            marcador = marcador + 10
            puntaje.setText("" + marcador)
            if ((primeraCarta == 12) || (primeraCarta == 22)) {
                mensaje(p1)
            } else if ((primeraCarta == 13) || (primeraCarta == 23)) {
                mensaje(p2)
            } else if ((primeraCarta == 14) || (primeraCarta == 24)) {
                mensaje(p3)
            } else if ((primeraCarta == 15) || (primeraCarta == 25)) {
                mensaje(p4)
            } else if ((primeraCarta == 16) || (primeraCarta == 26)) {
                mensaje(p5)
            } else if ((primeraCarta == 17) || (primeraCarta == 27)) {
                mensaje(p6)
            }
        } else {
            im11.setImageResource(R.drawable.tarjeta)
            im12.setImageResource(R.drawable.tarjeta)
            im13.setImageResource(R.drawable.tarjeta)

            im21.setImageResource(R.drawable.tarjeta)
            im22.setImageResource(R.drawable.tarjeta)
            im23.setImageResource(R.drawable.tarjeta)

            im31.setImageResource(R.drawable.tarjeta)
            im32.setImageResource(R.drawable.tarjeta)
            im33.setImageResource(R.drawable.tarjeta)

            im41.setImageResource(R.drawable.tarjeta)
            im42.setImageResource(R.drawable.tarjeta)
            im43.setImageResource(R.drawable.tarjeta)
            vidas -= 1
            vida.setText("" + vidas)
            if (marcador > 0) {
                marcador = marcador - 2
                if (marcador < 0) {
                    marcador = 0
                }
                puntaje.setText("" + marcador)
            }
        }
        im11.isEnabled = true
        im12.isEnabled = true
        im13.isEnabled = true

        im21.isEnabled = true
        im22.isEnabled = true
        im23.isEnabled = true

        im31.isEnabled = true
        im32.isEnabled = true
        im33.isEnabled = true

        im41.isEnabled = true
        im42.isEnabled = true
        im43.isEnabled = true

        finPartida()
    }

    private fun finPartida() {
        if (im11.visibility == View.INVISIBLE &&
            im12.visibility == View.INVISIBLE &&
            im13.visibility == View.INVISIBLE &&
            im21.visibility == View.INVISIBLE &&
            im22.visibility == View.INVISIBLE &&
            im23.visibility == View.INVISIBLE &&
            im31.visibility == View.INVISIBLE &&
            im32.visibility == View.INVISIBLE &&
            im33.visibility == View.INVISIBLE &&
            im41.visibility == View.INVISIBLE &&
            im42.visibility == View.INVISIBLE &&
            im43.visibility == View.INVISIBLE
        ) {
            var imagen = "win"
            var titulo = "HAS GANADO!!"
            var dato1 = "Tu puntuación es de: " + marcador
            var dato2 = "Intentos restantes: " + vidas
            alerta3(imagen, titulo, dato1, dato2, marcador)
        }
    }

    private fun alerta3(imagen: String, titulo: String, dato1: String, dato2: String, dato3: Int) {

        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.ventana)
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.setCancelable(false)
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
        val prefs = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)
        val Archivo1 = "Audio"
        val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this)
        defaultPrefs1.tono = 1
        defaultPrefs1.melodia = 1
        defaultPrefs1.activi = ""
        defaultPrefs1.volum = 0.10f
        defaultPrefs1.volum1 = 1.00f
        val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
        var carga = prefs1.tono
        prefs.rmayM = prefs.rmayM + dato3
        Log.v("prueba", "${prefs.rmayM}")
        prefs.contador = 1
        customDialog.imagen.setImageResource(
            getResources().getIdentifier(
                imagen,
                "drawable",
                getPackageName()
            )
        )
        customDialog.titulo.setText(titulo)
        customDialog.punt.setText(dato1)
        customDialog.vid.setText(dato2)
        val yesBtn = customDialog.findViewById<Button>(R.id.yes_opt9) as TextView
        val noBtn = customDialog.findViewById<Button>(R.id.no_opt9) as TextView

        yesBtn.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            recargar()
        }
        noBtn.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            prefs.contador = 0
            var intent = Intent(applicationContext, MenuJuegos::class.java)
            startActivity(intent)
            finish()
            customDialog.dismiss()
            onBackPressed()
        }
        customDialog.show()
    }

    fun recargar() {
        overridePendingTransition(0, 0);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    private fun alerta() {
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.instrucciones)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialog.show()
    }

    fun mensaje(dato: String) {
        var dato1 = ""
        if (dato.equals("ma")) {
            dato1 = "A"
        } else if (dato.equals("mb")) {
            dato1 = "B"
        } else if (dato.equals("mc")) {
            dato1 = "C"
        } else if (dato.equals("md")) {
            dato1 = "D"
        } else if (dato.equals("me")) {
            dato1 = "E"
        } else if (dato.equals("mf")) {
            dato1 = "F"
        } else if (dato.equals("mg")) {
            dato1 = "G"
        } else if (dato.equals("mh")) {
            dato1 = "H"
        } else if (dato.equals("mi")) {
            dato1 = "I"
        } else if (dato.equals("mj")) {
            dato1 = "J"
        } else if (dato.equals("mk")) {
            dato1 = "K"
        } else if (dato.equals("ml")) {
            dato1 = "L"
        } else if (dato.equals("mm")) {
            dato1 = "M"
        } else if (dato.equals("mn")) {
            dato1 = "N"
        } else if (dato.equals("n2")) {
            dato1 = "Ñ"
        } else if (dato.equals("mo")) {
            dato1 = "O"
        } else if (dato.equals("mp")) {
            dato1 = "P"
        } else if (dato.equals("mq")) {
            dato1 = "Q"
        } else if (dato.equals("mr")) {
            dato1 = "R"
        } else if (dato.equals("ms")) {
            dato1 = "S"
        } else if (dato.equals("mt")) {
            dato1 = "T"
        } else if (dato.equals("mu")) {
            dato1 = "U"
        } else if (dato.equals("mv")) {
            dato1 = "V"
        } else if (dato.equals("mw")) {
            dato1 = "W"
        } else if (dato.equals("mx")) {
            dato1 = "X"
        } else if (dato.equals("my")) {
            dato1 = "Y"
        } else if (dato.equals("mz")) {
            dato1 = "Z"
        } else if (dato.equals("mda")) {
            dato1 = "á"
        } else if (dato.equals("mda1")) {
            dato1 = "ä"
        } else if (dato.equals("mde")) {
            dato1 = "é"
        } else if (dato.equals("mdi")) {
            dato1 = "í"
        } else if (dato.equals("mdo")) {
            dato1 = "ó"
        } else if (dato.equals("mdo1")) {
            dato1 = "ö"
        } else if (dato.equals("mdu")) {
            dato1 = "ú"
        } else if (dato.equals("mdu1")) {
            dato1 = "ü"
        } else if (dato.equals("mdy")) {
            dato1 = "Ÿ"
        }
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.activity_respu)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialog.imageee1.visibility = View.GONE
        customDialog.imageee.visibility = View.VISIBLE
        customDialog.letraa.text = "$dato1"
        customDialog.imageee.setBackgroundResource(
            getResources().getIdentifier(
                dato,
                "drawable",
                getPackageName()
            )
        )
        customDialog.show()

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
        if (drawerJ12.isDrawerOpen(GravityCompat.START)) {
            drawerJ12.closeDrawer(GravityCompat.START)
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
                drawerJ12.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}