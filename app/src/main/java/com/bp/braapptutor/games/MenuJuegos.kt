package com.bp.braapptutor.games

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import com.bp.braapptutor.R
import com.bp.braapptutor.catalogo.MenuCatalogo
import com.bp.braapptutor.chat.activity.LoginActivity
import com.bp.braapptutor.chat.activity.UsersActivity
import com.bp.braapptutor.chat.firebase.FirebaseService
import com.bp.braapptutor.conexion.ConnectivityLiveData
import com.bp.braapptutor.extra.Extras
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
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.contador1
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.contadorE1
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.contadorV1
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.correo1
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.foto1
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.idUsuario1
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.nombreUs1
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.recodd
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.rmayM1
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.rmaya1
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.rmaynum1
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.rminM1
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.rminsim1
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.rminsimb1
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.rnumM1
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.rnuma1
import com.bp.braapptutor.games.MenuJuegos.PreferenceHelper1.rsimM1
import com.bp.braapptutor.games.adivinanzas.*
import com.bp.braapptutor.games.memos.memomay
import com.bp.braapptutor.games.memos.memomin
import com.bp.braapptutor.games.memos.memonum
import com.bp.braapptutor.games.memos.memosim
import com.bp.braapptutor.games.record.RecordMundial
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
import com.bp.braapptutor.inicio.Splash.PreferenceHelper5.dato122
import com.bp.braapptutor.inicio.Usuarios
import com.bp.braapptutor.mate.materialapoyo
import com.bp.braapptutor.menuprincipal.MenuPrin
import com.bp.braapptutor.redes.Red
import com.bp.braapptutor.traductor.Traductores
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_braes_num.*
import kotlinx.android.synthetic.main.activity_cerrarchat.*
import kotlinx.android.synthetic.main.activity_cerrarchat1.*
import kotlinx.android.synthetic.main.activity_historia.*
import kotlinx.android.synthetic.main.activity_menu_juegos.*
import kotlinx.android.synthetic.main.activity_menu_prin.*
import kotlinx.android.synthetic.main.crear_perfil.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.io.IOException

class MenuJuegos : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private lateinit var connectivityLiveData: ConnectivityLiveData
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_juegos)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        val Archivo = "Usuario"
        val defaultPrefs = Splash.PreferenceHelper.defaultPreference(this)
        defaultPrefs.password = "Admin"
        defaultPrefs.userId = 0
        val prefs = Splash.PreferenceHelper.customPreference(this, Archivo)
        mAuth = FirebaseAuth.getInstance()
        val Archivo1 = "Audio"
        val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this)
        defaultPrefs1.tono = 1
        defaultPrefs1.melodia = 1
        defaultPrefs1.activi = ""
        defaultPrefs1.volum = 0.10f
        defaultPrefs1.volum1 = 1.00f
        val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
        val Archivo5 = "Juegod"
        val defaultPrefs5 = Splash.PreferenceHelper5.defaultPreference5(this)
        defaultPrefs5.dato122 = 0
        val prefs5 = Splash.PreferenceHelper5.customPreference5(this, Archivo5)
        var carga = prefs1.tono
        soundPool = SoundPool(100, AudioManager.STREAM_MUSIC, 0)
        mediaPlayer = MediaPlayer()
        val texto2: LinearLayout = findViewById(R.id.com78i)
        //Asignacioón de las animaciones
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto2.startAnimation(anim1)
        val foto2 = prefs.userId.toString()
        bu1gffgddfds.text = prefs.password
        checkNetworkConnection()
        when {
            foto2.toInt() == 0 -> {
                Creditosscfdvvcf.setBackgroundResource(R.drawable.nina)
            }
            foto2.toInt() == 1 -> {
                Creditosscfdvvcf.setBackgroundResource(R.drawable.nino)
            }
            foto2.toInt() == 2 -> {
                Creditosscfdvvcf.setBackgroundResource(R.drawable.jovena)
            }
            foto2.toInt() == 3 -> {
                Creditosscfdvvcf.setBackgroundResource(R.drawable.joveno)
            }
            foto2.toInt() == 4 -> {
                Creditosscfdvvcf.setBackgroundResource(R.drawable.adulta)
            }
            foto2.toInt() == 5 -> {
                Creditosscfdvvcf.setBackgroundResource(R.drawable.adulto)
            }
            foto2.toInt() == 6 -> {
                Creditosscfdvvcf.setBackgroundResource(R.drawable.abuelo)
            }
            foto2.toInt() == 7 -> {
                Creditosscfdvvcf.setBackgroundResource(R.drawable.abuela)
            }
            foto2.toInt() == 8 -> {
                Creditosscfdvvcf.setBackgroundResource(R.drawable.indefinido)
            }
        }
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
        if (prefs5.dato122 == 0) {
            userImage1.setBackgroundResource(R.drawable.memodama1)
            userImage2.setBackgroundResource(R.drawable.adivina)
            scrols1.visibility = View.VISIBLE
            scrols2.visibility = View.GONE
        }
        else if (prefs5.dato122 == 1) {
            userImage1.setBackgroundResource(R.drawable.memodama)
            userImage2.setBackgroundResource(R.drawable.adivina1)
            scrols1.visibility = View.GONE
            scrols2.visibility = View.VISIBLE
        }
        juegoM4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, memosim::class.java))
            Bungee.zoom(this)
            finish()
        }
        juegoM3.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, memonum::class.java))
            Bungee.zoom(this)
            finish()
        }
        juegoM2.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, memomay::class.java))
            Bungee.zoom(this)
            finish()
        }
        juegoM1.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, memomin::class.java))
            Bungee.zoom(this)
            finish()
        }
        juegoA1.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, adivi1::class.java))
            Bungee.zoom(this)
            finish()
        }
        juegoA2.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, adivi2::class.java))
            Bungee.zoom(this)
            finish()
        }
        juegoA3.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, adivi3::class.java))
            Bungee.zoom(this)
            finish()
        }
        juegoA4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, adivi4::class.java))
            Bungee.zoom(this)
            finish()
        }
        juegoA5.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, adivi5::class.java))
            Bungee.zoom(this)
            finish()
        }
        userImage1.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            prefs5.dato122 = 0
            if (prefs5.dato122 == 0) {
                userImage1.setBackgroundResource(R.drawable.memodama1)
                userImage2.setBackgroundResource(R.drawable.adivina)
                scrols1.visibility = View.VISIBLE
                scrols2.visibility = View.GONE
            } else if (prefs5.dato122 == 1) {
                userImage1.setBackgroundResource(R.drawable.memodama)
                userImage2.setBackgroundResource(R.drawable.adivina1)
                scrols1.visibility = View.GONE
                scrols2.visibility = View.VISIBLE
            }
        }
        userImage2.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            prefs5.dato122 = 1
            if (prefs5.dato122 == 0) {
                userImage1.setBackgroundResource(R.drawable.memodama1)
                userImage2.setBackgroundResource(R.drawable.adivina)
                scrols1.visibility = View.VISIBLE
                scrols2.visibility = View.GONE
            } else if (prefs5.dato122 == 1) {
                userImage1.setBackgroundResource(R.drawable.memodama)
                userImage2.setBackgroundResource(R.drawable.adivina1)
                scrols1.visibility = View.GONE
                scrols2.visibility = View.VISIBLE
            }
        }
        setSupportActionBar(findViewById(R.id.toolbarJ1))
        navigation_viewJ1.addOnLayoutChangeListener { view, i, i2, i3, i4, i5, i6, i7, i8 ->
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
                        startActivity(Intent(this@MenuJuegos, Usuarios::class.java))
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
        navigation_viewJ1.setNavigationItemSelectedListener {
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
                    drawerJ1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuPrin::class.java))

                    Bungee.zoom(this)
                    true
                }
                R.id.dos2 -> {
                    drawerJ1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, materialapoyo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.tres3 -> {
                    drawerJ1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Red::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cuatro4 -> {
                    drawerJ1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuJuegos::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cinco5 -> {
                    drawerJ1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, historia::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.seis6 -> {
                    drawerJ1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Extras::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.siete7 -> {
                    drawerJ1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuCatalogo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.ocho8 -> {
                    drawerJ1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Traductores::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.nueve9 -> {
                    drawerJ1.closeDrawer(GravityCompat.START)
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
        val drawerToggle = ActionBarDrawerToggle(this, drawerJ1, R.string.open, R.string.close)
        drawerJ1.addDrawerListener(drawerToggle)
        drawerToggle.drawerArrowDrawable.color = Color.BLACK
        drawerToggle.drawerArrowDrawable.gapSize = 30.0f
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_viewJ1.setItemIconTintList(null);


    }

    private fun alerta1() {
        val Archivo1 = "Audio"
        val defaultPrefs2 = Splash.PreferenceHelper1.defaultPreference1(this)
        defaultPrefs2.tono = 1
        defaultPrefs2.melodia = 1
        defaultPrefs2.activi = ""
        defaultPrefs2.volum = 0.10f
        defaultPrefs2.volum1 = 1.00f
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
        val CUSTOM_PREF_NAME = "Record"
        val defaultPrefs = PreferenceHelper.defaultPreference(this)
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
        val prefs = PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)
        val CUSTOM_PREF_NAME1 = "Record1"
        val defaultPrefs1 = PreferenceHelper1.defaultPreference1(this)
        defaultPrefs1.contadorE1 = 0
        defaultPrefs1.contadorV1 = 0
        defaultPrefs1.contador1 = 0
        defaultPrefs1.rminM1 = 0
        defaultPrefs1.rmayM1 = 0
        defaultPrefs1.rnumM1 = 0
        defaultPrefs1.rsimM1 = 0
        defaultPrefs1.correo1 = ""
        defaultPrefs1.foto1 = 0
        defaultPrefs1.nombreUs1 = ""
        defaultPrefs1.idUsuario1 = ""
        defaultPrefs1.rminsim1 = 0
        defaultPrefs1.rminsimb1 = 0
        defaultPrefs1.rmaya1 = 0
        defaultPrefs1.rmaynum1 = 0
        defaultPrefs1.rnuma1 = 0
        defaultPrefs1.recodd = 0
        val Prefs1 = PreferenceHelper1.customPreference1(this, CUSTOM_PREF_NAME1)
        val Archivo5 = "Usuario"
        val defaultPrefs5 = Splash.PreferenceHelper.defaultPreference(this)
        defaultPrefs5.password = "Admin"
        defaultPrefs5.userId = 50
        val prefs5 = PreferenceHelper.customPreference(this, Archivo5)
        Prefs1.foto = prefs5.userId
        Prefs1.nombreUs = prefs5.password
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.crear_perfil)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialog.setCancelable(false)
        val yesBtn = customDialog.findViewById<Button>(R.id.yes_opt9) as TextView
        val noBtn = customDialog.findViewById<Button>(R.id.no_opt9) as TextView

        yesBtn.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
           if (customDialog.email.text.isEmpty()){
               toast("Llene sus datos por favor.")
           }
           else if (customDialog.email.text.isNotEmpty()){
               Prefs1.contadorE1 = prefs.contadorE
               Prefs1.contadorV1 = prefs.contadorV
               Prefs1.contador1 = prefs.contador1
               Prefs1.rminM1 = prefs.rminM
               Prefs1.rmayM1 = prefs.rmayM
               Prefs1.rnumM1 = prefs.rnumM
               Prefs1.rsimM1 = prefs.rsimM
               Prefs1.correo1 = prefs.correo
               Prefs1.foto1 = prefs.foto
               Prefs1.nombreUs1 = prefs.nombreUs
               Prefs1.idUsuario1 = prefs.idUsuario
               Prefs1.rminsim1 = prefs.rminsim
               Prefs1.rminsimb1 = prefs.rminsimb
               Prefs1.rmaya1 = prefs.rmaya
               Prefs1.rmaynum1 = prefs.rmaynum
               Prefs1.rnuma1 = prefs.rnuma
               Prefs1.recodd = 2
               customDialog.email?.setOnFocusChangeListener { view, b ->
                   if (b) {
                       soundPool!!.play(
                           carga,
                           prefs1.volum1,
                           prefs1.volum1,
                           0,
                           0,
                           1f
                       )

                   } else {
                       view.clearFocus()
                   }
               }
               val email1 = customDialog.email?.text.toString()

               prefs.correo = email1
               db.collection("Records").whereEqualTo("correo", email1)
                   .get()
                   .addOnSuccessListener { result ->
                       for (document in result) {
                           prefs.contadorE = 1
                           prefs.idUsuario = "${document.id}"
                           prefs.correo = "${document.get("correo")}"
                           prefs.nombreUs = "${document.get("usuario")}"
                           prefs.foto = "${document.get("foto")}".toInt()
                           prefs.rnuma = "${document.get("numerosA")}".toInt() + prefs.rnuma
                           prefs.rminM = "${document.get("minusculas")}".toInt() + prefs.rminM
                           prefs.rmayM = "${document.get("mayusculas")}".toInt() + prefs.rmayM
                           prefs.rnumM = "${document.get("numeros")}".toInt() + prefs.rnumM
                           prefs.rsimM = "${document.get("simbolos")}".toInt() + prefs.rsimM
                           prefs.rminsim = "${document.get("minsim")}".toInt() + prefs.rminsim
                           prefs.rminsimb = "${document.get("minsimB")}".toInt() + prefs.rminsimb
                           prefs.rmaya = "${document.get("mayusculasA")}".toInt() + prefs.rmaya
                           prefs.rmaynum = "${document.get("maynum")}".toInt() + prefs.rmaynum
                       }
                       customDialog.dismiss()
                       startActivity(Intent(this@MenuJuegos, RecordMundial::class.java))
                       finish()
           }
                   .addOnFailureListener { exception ->
                       toast("Error al devolver la información")
                   }
                }

        }
        noBtn.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)

            customDialog.dismiss()
        }
        customDialog.show()

    }

    override fun onResume() {
        super.onResume()
        mediaPlayer!!.start()
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer!!.pause()
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
        if (drawerJ1.isDrawerOpen(GravityCompat.START)) {
            drawerJ1.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
            startActivity(Intent(this, MenuPrin::class.java))
            Bungee.zoom(this)
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            android.R.id.home -> {
                drawerJ1.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    object PreferenceHelper {
        val ID_ContadorE = "ID_ContadorE"
        val ID_ContadorV = "ID_ContadorV"
        val ID_Contador = "ID_Contador"
        val ID_Correo = "ID_Correo"
        val ID_Foto = "ID_Foto"
        val ID_Usuario = "ID_Usuario"
        val ID_Us = "ID_Us"
        val ID_RminM = "ID_RminM"
        val ID_RmayM = "ID_RmayM"
        val ID_RnumM = "ID_RnumM"
        val ID_RsimM = "ID_RsimM"
        val ID_RminSim = "ID_RminSim"
        val ID_RmayNum = "ID_RmayNum"
        val ID_RminSimB = "ID_RnumSimB"
        val ID_RmayA = "ID_RmayA"
        val ID_RnumA = "ID_RnumA"
        fun defaultPreference(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

        fun customPreference(context: Context, name: String): SharedPreferences =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)

        inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
            val editMe = edit()
            operation(editMe)
            editMe.apply()
        }

        inline fun SharedPreferences.Editor.put(pair: Pair<String, Any>) {
            val key = pair.first
            val value = pair.second
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Long -> putLong(key, value)
                is Float -> putFloat(key, value)
                else -> error("Only primitive types can be stored in SharedPreferences")
            }
        }

        var SharedPreferences.contadorE
            get() = getInt(ID_ContadorE, 0)
            set(value) {
                editMe {
                    it.putInt(ID_ContadorE, value)
                }
            }
        var SharedPreferences.contadorV
            get() = getInt(ID_ContadorV, 0)
            set(value) {
                editMe {
                    it.putInt(ID_ContadorV, value)
                }
            }
        var SharedPreferences.contador
            get() = getInt(ID_Contador, 0)
            set(value) {
                editMe {
                    it.putInt(ID_Contador, value)
                }
            }
        var SharedPreferences.correo
            get() = getString(ID_Correo, "")
            set(value) {
                editMe {
                    it.putString(ID_Correo, value)
                }
            }
        var SharedPreferences.nombreUs
            get() = getString(ID_Usuario, "")
            set(value) {
                editMe {
                    it.putString(ID_Usuario, value)
                }
            }
        var SharedPreferences.idUsuario
            get() = getString(ID_Us, "")
            set(value) {
                editMe {
                    it.putString(ID_Us, value)
                }
            }
        var SharedPreferences.foto
            get() = getInt(ID_Foto, 0)
            set(value) {
                editMe {
                    it.putInt(ID_Foto, value)
                }
            }
        var SharedPreferences.rminM
            get() = getInt(ID_RminM, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RminM, value)
                }
            }
        var SharedPreferences.rmayM
            get() = getInt(ID_RmayM, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RmayM, value)
                }
            }
        var SharedPreferences.rnumM
            get() = getInt(ID_RnumM, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RnumM, value)
                }
            }
        var SharedPreferences.rsimM
            get() = getInt(ID_RsimM, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RsimM, value)
                }
            }
        var SharedPreferences.rminsim
            get() = getInt(ID_RminSim, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RminSim, value)
                }
            }
        var SharedPreferences.rmaynum
            get() = getInt(ID_RmayNum, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RmayNum, value)
                }
            }
        var SharedPreferences.rminsimb
            get() = getInt(ID_RminSimB, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RminSimB, value)
                }
            }
        var SharedPreferences.rmaya
            get() = getInt(ID_RmayA, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RmayA, value)
                }
            }
        var SharedPreferences.rnuma
            get() = getInt(ID_RnumA, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RnumA, value)
                }
            }
        var SharedPreferences.clearValues
            get() = { }
            set(value) {
                editMe {
                    it.remove(ID_ContadorE)
                    it.remove(ID_ContadorV)
                    it.remove(ID_Contador)
                    it.remove(ID_Correo)
                    it.remove(ID_Usuario)
                    it.remove(ID_Foto)
                    it.remove(ID_Us)
                    it.remove(ID_RminM)
                    it.remove(ID_RmayM)
                    it.remove(ID_RnumM)
                    it.remove(ID_RsimM)
                    it.remove(ID_RminSim)
                    it.remove(ID_RmayNum)
                    it.remove(ID_RminSimB)
                    it.remove(ID_RmayA)
                    it.remove(ID_RnumA)
                    it.remove(contadorE.toString())
                    it.remove(contadorV.toString())
                    it.remove(contador.toString())
                    it.remove(correo)
                    it.remove(nombreUs)
                    it.remove(idUsuario)
                    it.remove(foto.toString())
                    it.remove(rminM.toString())
                    it.remove(rmayM.toString())
                    it.remove(rnumM.toString())
                    it.remove(rsimM.toString())
                    it.remove(rminsim.toString())
                    it.remove(rmaynum.toString())
                    it.remove(rminsimb.toString())
                    it.remove(rmaya.toString())
                    it.remove(rnuma.toString())
                    it.clear()
                }
            }
    }

    object PreferenceHelper1 {
        val ID_ContadorE1 = "ID_ContadorE1"
        val ID_ContadorV1 = "ID_ContadorV1"
        val ID_Contador1 = "ID_Contador1"
        val ID_Correo1 = "ID_Correo1"
        val ID_Foto1 = "ID_Foto1"
        val ID_Usuario1 = "ID_Usuario1"
        val ID_Us1 = "ID_Us1"
        val ID_RminM1 = "ID_RminM1"
        val ID_RmayM1 = "ID_RmayM1"
        val ID_RnumM1 = "ID_RnumM1"
        val ID_RsimM1 = "ID_RsimM1"
        val ID_RminSim1 = "ID_RminSim1"
        val ID_RmayNum1 = "ID_RmayNum1"
        val ID_RminSimB1 = "ID_RnumSimB1"
        val ID_RmayA1 = "ID_RmayA1"
        val ID_RnumA1 = "ID_RnumA1"
        val recodd1 = "ID_recodd1"
        val recodd12 = "ID_recodd12"
        fun defaultPreference1(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

        fun customPreference1(context: Context, name: String): SharedPreferences =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)

        inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
            val editMe = edit()
            operation(editMe)
            editMe.apply()
        }

        inline fun SharedPreferences.Editor.put(pair: Pair<String, Any>) {
            val key = pair.first
            val value = pair.second
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Long -> putLong(key, value)
                is Float -> putFloat(key, value)
                else -> error("Only primitive types can be stored in SharedPreferences")
            }
        }

        var SharedPreferences.contadorE1
            get() = getInt(ID_ContadorE1, 0)
            set(value) {
                editMe {
                    it.putInt(ID_ContadorE1, value)
                }
            }
        var SharedPreferences.contadorV1
            get() = getInt(ID_ContadorV1, 0)
            set(value) {
                editMe {
                    it.putInt(ID_ContadorV1, value)
                }
            }
        var SharedPreferences.contador1
            get() = getInt(ID_Contador1, 0)
            set(value) {
                editMe {
                    it.putInt(ID_Contador1, value)
                }
            }
        var SharedPreferences.correo1
            get() = getString(ID_Correo1, "")
            set(value) {
                editMe {
                    it.putString(ID_Correo1, value)
                }
            }
        var SharedPreferences.nombreUs1
            get() = getString(ID_Usuario1, "")
            set(value) {
                editMe {
                    it.putString(ID_Usuario1, value)
                }
            }
        var SharedPreferences.idUsuario1
            get() = getString(ID_Us1, "")
            set(value) {
                editMe {
                    it.putString(ID_Us1, value)
                }
            }
        var SharedPreferences.foto1
            get() = getInt(ID_Foto1, 0)
            set(value) {
                editMe {
                    it.putInt(ID_Foto1, value)
                }
            }
        var SharedPreferences.rminM1
            get() = getInt(ID_RminM1, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RminM1, value)
                }
            }
        var SharedPreferences.rmayM1
            get() = getInt(ID_RmayM1, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RmayM1, value)
                }
            }
        var SharedPreferences.rnumM1
            get() = getInt(ID_RnumM1, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RnumM1, value)
                }
            }
        var SharedPreferences.rsimM1
            get() = getInt(ID_RsimM1, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RsimM1, value)
                }
            }
        var SharedPreferences.rminsim1
            get() = getInt(ID_RminSim1, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RminSim1, value)
                }
            }
        var SharedPreferences.rmaynum1
            get() = getInt(ID_RmayNum1, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RmayNum1, value)
                }
            }
        var SharedPreferences.rminsimb1
            get() = getInt(ID_RminSimB1, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RminSimB1, value)
                }
            }
        var SharedPreferences.rmaya1
            get() = getInt(ID_RmayA1, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RmayA1, value)
                }
            }
        var SharedPreferences.recodd
            get() = getInt(recodd1, 0)
            set(value) {
                editMe {
                    it.putInt(recodd1, value)
                }
            }
        var SharedPreferences.rnuma1
            get() = getInt(ID_RnumA1, 0)
            set(value) {
                editMe {
                    it.putInt(ID_RnumA1, value)
                }
            }
        var SharedPreferences.clearValues
            get() = { }
            set(value) {
                editMe {
                    it.remove(ID_ContadorE1)
                    it.remove(ID_ContadorV1)
                    it.remove(ID_Contador1)
                    it.remove(ID_Correo1)
                    it.remove(ID_Usuario1)
                    it.remove(ID_Foto1)
                    it.remove(ID_Us1)
                    it.remove(ID_RminM1)
                    it.remove(ID_RmayM1)
                    it.remove(ID_RnumM1)
                    it.remove(ID_RsimM1)
                    it.remove(ID_RminSim1)
                    it.remove(ID_RmayNum1)
                    it.remove(ID_RminSimB1)
                    it.remove(ID_RmayA1)
                    it.remove(ID_RnumA1)
                    it.remove(contadorE1.toString())
                    it.remove(contadorV1.toString())
                    it.remove(contador1.toString())
                    it.remove(correo1)
                    it.remove(nombreUs1)
                    it.remove(idUsuario1)
                    it.remove(foto1.toString())
                    it.remove(rminM1.toString())
                    it.remove(rmayM1.toString())
                    it.remove(rnumM1.toString())
                    it.remove(rsimM1.toString())
                    it.remove(rminsim1.toString())
                    it.remove(rmaynum1.toString())
                    it.remove(rminsimb1.toString())
                    it.remove(rmaya1.toString())
                    it.remove(rnuma1.toString())
                    it.remove(recodd1)
                    it.remove(recodd.toString())
                    it.remove(recodd12)
                    it.clear()
                }
            }
    }

    private fun checkNetworkConnection() {
        connectivityLiveData = ConnectivityLiveData(application)
        connectivityLiveData.observe(this, Observer { isAvailable ->
            when (isAvailable) {

                true -> {
                    val Archivo = "Usuario"
                    val defaultPrefs = Splash.PreferenceHelper.defaultPreference(this)
                    defaultPrefs.password = "Admin"
                    defaultPrefs.userId = 0
                    val prefs2 = Splash.PreferenceHelper.customPreference(this, Archivo)
                    val Archivo1 = "Audio"
                    val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this)
                    defaultPrefs1.tono = 1
                    defaultPrefs1.melodia = 1
                    defaultPrefs1.activi = ""
                    defaultPrefs1.volum = 0.10f
                    defaultPrefs1.volum1 = 1.00f
                    val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
                    var carga = prefs1.tono
                    torneo1.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        val CUSTOM_PREF_NAME = "Record"
                        val defaultPrefs = PreferenceHelper.defaultPreference(this)
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
                        val prefs = PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)
                        val cont = prefs.contadorV
                        val foto2 = prefs2.userId.toString()
                        prefs.foto = foto2.toInt()
                        if (cont == 0) {
                            alerta1()
                        } else {
                            startActivity(Intent(applicationContext, RecordMundial::class.java))

                            finish()
                        }
                    }
                }
                false -> {
                    torneo1.setOnClickListener {
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
                        toast("Conéctate a internet para acceder")
                    }
                }
            }
        })
    }
}