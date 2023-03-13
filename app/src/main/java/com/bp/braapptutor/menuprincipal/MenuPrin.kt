package com.bp.braapptutor.menuprincipal

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bp.braapptutor.R
import com.bp.braapptutor.adaptadores.ClickListener
import com.bp.braapptutor.adaptadores.adaptadorA
import com.bp.braapptutor.adaptadores.avisol
import com.bp.braapptutor.audio.Audio
import com.bp.braapptutor.conexion.ConnectivityLiveData
import com.bp.braapptutor.inicio.Splash
import com.bp.braapptutor.inicio.Splash.PreferenceHelper.password
import com.bp.braapptutor.inicio.Splash.PreferenceHelper.userId
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.activi
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.tono
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.volum
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.volum1
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_avisp.*
import kotlinx.android.synthetic.main.activity_menu_prin.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import androidx.lifecycle.Observer
import com.airbnb.lottie.LottieAnimationView
import com.bp.braapptutor.ayuda.Ayuda
import com.bp.braapptutor.catalogo.MenuCatalogo
import com.bp.braapptutor.chat.activity.LoginActivity
import com.bp.braapptutor.chat.activity.UsersActivity
import com.bp.braapptutor.chat.firebase.FirebaseService
import com.bp.braapptutor.creditos.Creditoss
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
import com.bp.braapptutor.inicio.Splash.PreferenceHelper.sele1
import com.bp.braapptutor.inicio.Splash.PreferenceHelper2.entrada
import com.bp.braapptutor.inicio.Usuarios
import com.bp.braapptutor.mate.materialapoyo
import com.bp.braapptutor.redes.Red
import com.bp.braapptutor.traductor.Traductores
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_cerrarchat.*
import kotlinx.android.synthetic.main.activity_cerrarchat1.*
import kotlinx.android.synthetic.main.activity_traductor.*
import kotlinx.android.synthetic.main.activity_usuario.*
import kotlinx.android.synthetic.main.activity_usuarios.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import java.io.IOException


class MenuPrin : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    var adaptador: adaptadorA? = null
    var lita1: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    val datos = ArrayList<avisol>()
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private lateinit var connectivityLiveData: ConnectivityLiveData
    private var mAuth: FirebaseAuth? = null

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_prin)
        setSupportActionBar(findViewById(R.id.toolbar))
        mAuth = FirebaseAuth.getInstance()
        val Archivo = "Usuario"
        val defaultPrefs = Splash.PreferenceHelper.defaultPreference(this)
        defaultPrefs.password = "Admin"
        defaultPrefs.userId = 0
        defaultPrefs.sele1 = 1
        val prefs = Splash.PreferenceHelper.customPreference(this, Archivo)
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
        mediaPlayer = MediaPlayer()
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
        when (prefs1.melodia) {

            1 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo1)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            2 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo2)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            3 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo3)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
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
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            6 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo6)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            7 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo7)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
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
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            10 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo10)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }

        }
        checkNetworkConnection()
        navigation_view.addOnLayoutChangeListener { view, i, i2, i3, i4, i5, i6, i7, i8 ->
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
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
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
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
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
                        startActivity(Intent(this@MenuPrin, Usuarios::class.java))
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
        navigation_view.setNavigationItemSelectedListener {
            val Archivo1 = "Audio"
            val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this)
            defaultPrefs1.tono = 1
            defaultPrefs1.melodia = 1
            defaultPrefs1.activi = ""
            defaultPrefs1.volum = 0.10f
            defaultPrefs1.volum1 = 1.00f
            val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
            var carga = prefs1.tono
            when (it.itemId) {
                R.id.uno1 -> {
                    drawer.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuPrin::class.java))

                    Bungee.zoom(this)
                    true
                }
                R.id.dos2 -> {
                    drawer.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, materialapoyo::class.java))
                    Bungee.zoom(this)
                    true
                }

                R.id.tres3 -> {
                    drawer.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Red::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cuatro4 -> {
                    drawer.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuJuegos::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cinco5 -> {
                    drawer.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, historia::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.seis6 -> {
                    drawer.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Extras::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.siete7 -> {
                    drawer.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuCatalogo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.ocho8 -> {
                    drawer.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Traductores::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.nueve9 -> {
                    drawer.closeDrawer(GravityCompat.START)

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
        val drawerToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(drawerToggle)
        drawerToggle.drawerArrowDrawable.color = Color.BLACK
        drawerToggle.drawerArrowDrawable.gapSize = 30.0f
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_view.setItemIconTintList(null);
        setupRecyclerView1()
        datos.clear()
        val texto1: LottieAnimationView = findViewById(R.id.Optiones1)
        val texto2: LinearLayout = findViewById(R.id.cardViews)
        val texto3: TextView = findViewById(R.id.wiff)
        //Asignacioón de las animaciones
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto1.startAnimation(anim1)
        texto2.startAnimation(anim1)
        texto3.startAnimation(anim1)
        val foto2 = prefs.userId.toString()
        bu.text = prefs.password
        when {
            foto2.toInt() == 0 -> {
                fotito.setBackgroundResource(R.drawable.nina)
            }
            foto2.toInt() == 1 -> {
                fotito.setBackgroundResource(R.drawable.nino)
            }
            foto2.toInt() == 2 -> {
                fotito.setBackgroundResource(R.drawable.jovena)
            }
            foto2.toInt() == 3 -> {
                fotito.setBackgroundResource(R.drawable.joveno)
            }
            foto2.toInt() == 4 -> {
                fotito.setBackgroundResource(R.drawable.adulta)
            }
            foto2.toInt() == 5 -> {
                fotito.setBackgroundResource(R.drawable.adulto)
            }
            foto2.toInt() == 6 -> {
                fotito.setBackgroundResource(R.drawable.abuelo)
            }
            foto2.toInt() == 7 -> {
                fotito.setBackgroundResource(R.drawable.abuela)
            }
            foto2.toInt() == 8 -> {
                fotito.setBackgroundResource(R.drawable.indefinido)
            }
        }
        swipeRefreshAvisos.setOnRefreshListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            setupRecyclerView1()
            swipeRefreshAvisos.isRefreshing = false
        }
        Optiones1.setOnClickListener {
            mediaPlayer!!.stop()
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            prefs1.activi = "MenuP"
            startActivity(Intent(this, Audio::class.java))
            Bungee.zoom(this)
        }
        adshn.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            prefs1.activi = "CreM"
            startActivity(Intent(this, Ayuda::class.java))
            Bungee.zoom(this)
        }
        fotito.setOnLongClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val customDialog = Dialog(this)
            customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            customDialog.setContentView(R.layout.activity_usuario)
            customDialog.window?.setLayout(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            val Archivo = "Usuario"
            val defaultPrefs = Splash.PreferenceHelper.defaultPreference(this)
            defaultPrefs.password = "Admin"
            defaultPrefs.userId = 50
            val prefs = Splash.PreferenceHelper.customPreference(this, Archivo)
            val foto2 = prefs.userId
            customDialog.numerito.text = foto2.toString()

            when {
                foto2.toInt() == 0 -> {
                    customDialog.textView10.setBackgroundResource(R.drawable.nina)
                }
                foto2.toInt() == 1 -> {
                    customDialog.textView10.setBackgroundResource(R.drawable.nino)
                }
                foto2.toInt() == 2 -> {
                    customDialog.textView10.setBackgroundResource(R.drawable.jovena)
                }
                foto2.toInt() == 3 -> {
                    customDialog.textView10.setBackgroundResource(R.drawable.joveno)
                }
                foto2.toInt() == 4 -> {
                    customDialog.textView10.setBackgroundResource(R.drawable.adulta)
                }
                foto2.toInt() == 5 -> {
                    customDialog.textView10.setBackgroundResource(R.drawable.adulto)
                }
                foto2.toInt() == 6 -> {
                    customDialog.textView10.setBackgroundResource(R.drawable.abuelo)
                }
                foto2.toInt() == 7 -> {
                    customDialog.textView10.setBackgroundResource(R.drawable.abuela)
                }
                foto2.toInt() == 8 -> {
                    customDialog.textView10.setBackgroundResource(R.drawable.indefinido)
                }
            }
            customDialog.izqq.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                if (prefs.userId == 0) {
                    prefs.userId = 8
                } else {
                    prefs.userId = prefs.userId - 1
                }
                var foto2 = prefs.userId
                when (foto2) {
                    0 -> {
                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.nina)
                    }
                    1 -> {

                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.nino)
                    }
                    2 -> {

                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.jovena)
                    }
                    3 -> {
                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.joveno)
                    }
                    4 -> {
                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.adulta)
                    }
                    5 -> {
                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.adulto)
                    }
                    6 -> {
                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.abuelo)
                    }
                    7 -> {
                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.abuela)
                    }
                    8 -> {
                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.indefinido)
                    }
                }
            }
            customDialog.deree.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                if (prefs.userId == 8) {
                    prefs.userId = 0
                } else {
                    prefs.userId = prefs.userId + 1
                }
                var foto2 = prefs.userId
                when (foto2) {
                    0 -> {
                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.nina)
                    }
                    1 -> {

                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.nino)
                    }
                    2 -> {

                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.jovena)
                    }
                    3 -> {
                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.joveno)
                    }
                    4 -> {
                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.adulta)
                    }
                    5 -> {
                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.adulto)
                    }
                    6 -> {
                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.abuelo)
                    }
                    7 -> {
                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.abuela)
                    }
                    8 -> {
                        customDialog.numerito.text = foto2.toString()
                        customDialog.textView10.setBackgroundResource(R.drawable.indefinido)
                    }

                }
            }
            customDialog.setCanceledOnTouchOutside(false)
            customDialog.setCancelable(false)
            customDialog.userMod.setOnFocusChangeListener { view, b ->
                if (b){
                    soundPool!!.play(
                        carga,
                        prefs1.volum1,
                        prefs1.volum1,
                        0,
                        0,
                        1f
                    )

                }
                else {
                    view.clearFocus()
                }
            }
            customDialog.Aceptar.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                if (!TextUtils.isEmpty(customDialog.userMod.text)) {
                    prefs.password = customDialog.userMod.text.toString()
                    finish(); startActivity(intent)
                    Bungee.zoom(this)
                } else {
                    finish(); startActivity(intent)
                    Bungee.zoom(this)
                }

            }
            customDialog.show()
            true
        }
        Creditosfgs.setOnClickListener {
            prefs1.activi = "CreM"
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, Creditoss::class.java))
            Bungee.zoom(this)
        }
        uno1.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, Traductores::class.java))
            Bungee.zoom(this)
        }
        dos2.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, MenuJuegos::class.java))
            Bungee.zoom(this)
        }
        tres3.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            mediaPlayer!!.stop()
            startActivity(Intent(this, historia::class.java))
            Bungee.zoom(this)
        }
        cuatro4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, Red::class.java))
            Bungee.zoom(this)
        }
        cinco5.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, materialapoyo::class.java))
            Bungee.zoom(this)
        }
        seis6.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, Extras::class.java))
            Bungee.zoom(this)
        }
        siete7.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, MenuCatalogo::class.java))
            Bungee.zoom(this)
        }
        ocho8.setOnClickListener {
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

        }
    }
    //todo
    @SuppressLint("WrongConstant", "SimpleDateFormat")
    fun setupRecyclerView1() {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val fecha1 = sdf.format(Date())
        val fechaOb: String = fecha1.toString()
        val sSubfechaOb = fechaOb.substring(0, 9)
        var fechanueva = sSubfechaOb
        datos.clear()
        db.collection("Avisos").orderBy("fecha", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val sSubfechasacada = (document.get("fecha")).toString().substring(0, 9)
                    if (sSubfechasacada == sSubfechaOb) {
                        fechanueva = "Online"
                    } else {
                        fechanueva = "Offline"
                    }
                    datos.add(
                        avisol(
                            "${document.get("fecha")}",
                            "${document.get("titulo")}",
                            "${document.get("Descrip")}",
                            fechanueva
                        )

                    )
                    lita1?.setHasFixedSize(true)  //adaptador tamaño de la vista
                    lita1 = findViewById(R.id.menuAvisos)
                    layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
                    lita1?.layoutManager = layoutManager  // donde se dibuje el layout
                    adaptador = adaptadorA(this, datos, object : ClickListener {
                        override fun onClick(vista: View, index: Int) {
                            val Archivo1 = "Audio"
                            val prefs1 = Splash.PreferenceHelper1.customPreference1(
                                vista.context,
                                Archivo1
                            )
                            var carga = prefs1.tono

                            val customDialog = Dialog(this@MenuPrin)
                            customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                            customDialog.setContentView(R.layout.activity_avisp)
                            customDialog.window?.setLayout(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            )
                            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                            db.collection("Avisos").whereEqualTo("fecha", datos[index].fecha)
                                .get()
                                .addOnSuccessListener { result ->
                                    for (document in result) {
                                        customDialog.titulo2Aviso.text = "${document.get("fecha")}"
                                        customDialog.tituloAviso.setText("${document.get("titulo")}")
                                        customDialog.titulo1Aviso.setText("${document.get("Descrip")}")
                                    }

                                }
                                .addOnFailureListener { exception ->
                                    toast("Error al devolver la información")
                                }
                            customDialog.show()
                        }
                    })

                    lita1?.adapter = adaptador
                }
            }
            .addOnFailureListener { exception ->
                toast("Error al devolver la información")
            }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
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

    private fun checkNetworkConnection() {

        connectivityLiveData = ConnectivityLiveData(application)
        connectivityLiveData.observe(this, Observer { isAvailable ->
            when (isAvailable) {
                true -> {
                    wiff.setBackgroundResource(R.drawable.wific)
                    linearLayout7.visibility = View.VISIBLE
                    swipeRefreshAvisos.visibility = View.VISIBLE
                    linearLayout9.visibility = View.GONE

                }
                false -> {
                    wiff.setBackgroundResource(R.drawable.wifis)
                    linearLayout7.visibility = View.GONE
                    swipeRefreshAvisos.visibility = View.GONE
                    linearLayout9.visibility = View.VISIBLE

                }
            }
        })

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

    override fun onPause() {
        super.onPause()
        mediaPlayer!!.pause()

    }

    override fun onResume() {
        super.onResume()
        mediaPlayer!!.start()
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            moveTaskToBack(true)
        }
    }
}