package com.bp.braapptutor.extra

import android.annotation.SuppressLint
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
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bp.braapptutor.R
import com.bp.braapptutor.adaptadores.ClickListener
import com.bp.braapptutor.catalogo.MenuCatalogo
import com.bp.braapptutor.chat.activity.LoginActivity
import com.bp.braapptutor.chat.activity.UsersActivity
import com.bp.braapptutor.chat.firebase.FirebaseService
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
import com.bp.braapptutor.inicio.Splash.PreferenceHelper3.dato11
import com.bp.braapptutor.inicio.Usuarios
import com.bp.braapptutor.mate.materialapoyo
import com.bp.braapptutor.menuprincipal.MenuPrin
import com.bp.braapptutor.redes.Red
import com.bp.braapptutor.traductor.Traductores
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_cerrarchat.*
import kotlinx.android.synthetic.main.activity_cerrarchat1.*
import kotlinx.android.synthetic.main.activity_extraemer.*
import kotlinx.android.synthetic.main.activity_extraemer.cardView2
import kotlinx.android.synthetic.main.activity_extraemer.cardView3
import kotlinx.android.synthetic.main.activity_extras.*
import kotlinx.android.synthetic.main.activity_menu_prin.*
import kotlinx.android.synthetic.main.activity_red.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.io.IOException

class Extras : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    var listaM: RecyclerView? = null
    var listaM1: RecyclerView? = null
    var listaM2: RecyclerView? = null
    var adaptador: AdaptadorCustom? = null
    var adaptador1: AdaptadorCustom1? = null
    var adaptador2: AdaptadorCustom2? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    private var mAuth: FirebaseAuth? = null

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extras)
        val texto2: LinearLayout = findViewById(R.id.cogfm67ujy)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        //Asignacioón de las animaciones
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto2.startAnimation(anim1)
        mAuth = FirebaseAuth.getInstance()
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
        val Archivo3 = "Extras"
        val defaultPrefs3 = Splash.PreferenceHelper3.defaultPreference3(this)
        defaultPrefs3.dato11 = 0
        val prefs3 = Splash.PreferenceHelper3.customPreference3(this, Archivo3)
        when (prefs3.dato11) {
            0 -> {
                letraa.isChecked = true
            }
            1 -> {
                nudd.isChecked = true
            }
            2 -> {
                acent.isChecked = true
            }
        }
        when (prefs3.dato11) {
            0 -> {
                letraa.isChecked
                contene1.visibility = View.VISIBLE
                contene2.visibility = View.GONE
                contene3.visibility = View.GONE
            }
            1 -> {
                nudd.isChecked
                contene2.visibility = View.VISIBLE
                contene1.visibility = View.GONE
                contene3.visibility = View.GONE
            }
            2 -> {
                acent.isChecked
                contene2.visibility = View.GONE
                contene1.visibility = View.GONE
                contene3.visibility = View.VISIBLE
            }
        }
        val Archivo = "Usuario"
        val defaultPrefs = Splash.PreferenceHelper.defaultPreference(this)
        defaultPrefs.password = "Admin"
        defaultPrefs.userId = 0
        val prefs = Splash.PreferenceHelper.customPreference(this, Archivo)
        val foto2 = prefs.userId.toString()
        bu1df.text = prefs.password
        when {
            foto2.toInt() == 0 -> {
                fotitodf1.setBackgroundResource(R.drawable.nina)
            }
            foto2.toInt() == 1 -> {
                fotitodf1.setBackgroundResource(R.drawable.nino)
            }
            foto2.toInt() == 2 -> {
                fotitodf1.setBackgroundResource(R.drawable.jovena)
            }
            foto2.toInt() == 3 -> {
                fotitodf1.setBackgroundResource(R.drawable.joveno)
            }
            foto2.toInt() == 4 -> {
                fotitodf1.setBackgroundResource(R.drawable.adulta)
            }
            foto2.toInt() == 5 -> {
                fotitodf1.setBackgroundResource(R.drawable.adulto)
            }
            foto2.toInt() == 6 -> {
                fotitodf1.setBackgroundResource(R.drawable.abuelo)
            }
            foto2.toInt() == 7 -> {
                fotitodf1.setBackgroundResource(R.drawable.abuela)
            }
            foto2.toInt() == 8 -> {
                fotitodf1.setBackgroundResource(R.drawable.indefinido)
            }
        }

        letraa.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            prefs3.dato11 = 0
            when (prefs3.dato11) {
                0 -> {
                    letraa.isChecked
                    contene1.visibility = View.VISIBLE
                    contene2.visibility = View.GONE
                    contene3.visibility = View.GONE
                }
                1 -> {
                    nudd.isChecked
                    contene2.visibility = View.VISIBLE
                    contene1.visibility = View.GONE
                    contene3.visibility = View.GONE
                }
                2 -> {
                    acent.isChecked
                    contene2.visibility = View.GONE
                    contene1.visibility = View.GONE
                    contene3.visibility = View.VISIBLE
                }
            }
        }
        nudd.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            prefs3.dato11 = 1
            when (prefs3.dato11) {
                0 -> {
                    letraa.isChecked
                    contene1.visibility = View.VISIBLE
                    contene2.visibility = View.GONE
                    contene3.visibility = View.GONE
                }
                1 -> {
                    nudd.isChecked
                    contene2.visibility = View.VISIBLE
                    contene1.visibility = View.GONE
                    contene3.visibility = View.GONE
                }
                2 -> {
                    acent.isChecked
                    contene2.visibility = View.GONE
                    contene1.visibility = View.GONE
                    contene3.visibility = View.VISIBLE
                }
            }
        }
        acent.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            prefs3.dato11 = 2
            when (prefs3.dato11) {
                0 -> {
                    letraa.isChecked
                    contene1.visibility = View.VISIBLE
                    contene2.visibility = View.GONE
                    contene3.visibility = View.GONE
                }
                1 -> {
                    nudd.isChecked
                    contene2.visibility = View.VISIBLE
                    contene1.visibility = View.GONE
                    contene3.visibility = View.GONE
                }
                2 -> {
                    acent.isChecked
                    contene2.visibility = View.GONE
                    contene1.visibility = View.GONE
                    contene3.visibility = View.VISIBLE
                }
            }
        }
        setSupportActionBar(findViewById(R.id.toolbarE1))
        navigation_viewE1.addOnLayoutChangeListener { view, i, i2, i3, i4, i5, i6, i7, i8 ->
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
                        startActivity(Intent(this@Extras, Usuarios::class.java))
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
        navigation_viewE1.setNavigationItemSelectedListener {
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
                    drawerE1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuPrin::class.java))

                    Bungee.zoom(this)
                    true
                }
                R.id.dos2 -> {
                    drawerE1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, materialapoyo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.tres3 -> {
                    drawerE1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Red::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cuatro4 -> {
                    drawerE1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuJuegos::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cinco5 -> {
                    drawerE1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, historia::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.seis6 -> {
                    drawerE1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Extras::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.siete7 -> {
                    drawerE1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuCatalogo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.ocho8 -> {
                    drawerE1.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Traductores::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.nueve9 -> {
                    drawerE1.closeDrawer(GravityCompat.START)

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
        val drawerToggle = ActionBarDrawerToggle(this, drawerE1, R.string.open, R.string.close)
        drawerE1.addDrawerListener(drawerToggle)
        drawerToggle.drawerArrowDrawable.color = Color.BLACK
        drawerToggle.drawerArrowDrawable.gapSize = 30.0f
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_viewE1.setItemIconTintList(null);
        //Letras
        val datos = ArrayList<extraa>()

        datos.add(
            extraa(
                R.drawable.a1,
                R.drawable.a2
            )
        )
        datos.add(
            extraa(
                R.drawable.b1,
                R.drawable.b2
            )
        )
        datos.add(
            extraa(
                R.drawable.c1,
                R.drawable.c2
            )
        )
        datos.add(
            extraa(
                R.drawable.d1,
                R.drawable.d2
            )
        )
        datos.add(
            extraa(
                R.drawable.e1,
                R.drawable.e2
            )
        )
        datos.add(
            extraa(
                R.drawable.f1,
                R.drawable.f2
            )
        )
        datos.add(
            extraa(
                R.drawable.g1,
                R.drawable.g2
            )
        )
        datos.add(
            extraa(
                R.drawable.h1,
                R.drawable.h2
            )
        )
        datos.add(
            extraa(
                R.drawable.i1,
                R.drawable.i2
            )
        )
        datos.add(
            extraa(
                R.drawable.j1,
                R.drawable.j2
            )
        )
        datos.add(
            extraa(
                R.drawable.k1,
                R.drawable.k2
            )
        )
        datos.add(
            extraa(
                R.drawable.l1,
                R.drawable.l2
            )
        )
        datos.add(
            extraa(
                R.drawable.m1,
                R.drawable.m2
            )
        )
        datos.add(
            extraa(
                R.drawable.n11,
                R.drawable.n21
            )
        )
        datos.add(
            extraa(
                R.drawable.ene1,
                R.drawable.ene1
            )
        )
        datos.add(
            extraa(
                R.drawable.o1,
                R.drawable.o2
            )
        )
        datos.add(
            extraa(
                R.drawable.p1,
                R.drawable.p2
            )
        )
        datos.add(
            extraa(
                R.drawable.q1,
                R.drawable.q2
            )
        )
        datos.add(
            extraa(
                R.drawable.r1,
                R.drawable.r2
            )
        )
        datos.add(
            extraa(
                R.drawable.s1,
                R.drawable.s2
            )
        )
        datos.add(
            extraa(
                R.drawable.t1,
                R.drawable.t2
            )
        )
        datos.add(
            extraa(
                R.drawable.u1,
                R.drawable.u2
            )
        )
        datos.add(
            extraa(
                R.drawable.v1,
                R.drawable.v2
            )
        )
        datos.add(
            extraa(
                R.drawable.w1,
                R.drawable.w2
            )
        )
        datos.add(
            extraa(
                R.drawable.x1,
                R.drawable.x2
            )
        )
        datos.add(
            extraa(
                R.drawable.y1,
                R.drawable.y2
            )
        )
        datos.add(
            extraa(
                R.drawable.z1,
                R.drawable.z2
            )
        )
        listaM = findViewById(R.id.exts)
        listaM?.setHasFixedSize(true)  //adaptador tamaño de la vista

        layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        listaM?.layoutManager = layoutManager  // donde se dibuje el layout
        adaptador = AdaptadorCustom(this, datos, object : ClickListener {
            override fun onClick(vista: View, index: Int) {
                val Archivo1 = "Audio"
                val prefs1 =
                    Splash.PreferenceHelper1.customPreference1(applicationContext, Archivo1)
                var carga = prefs1.tono
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                letras(index)

            }
        })
        listaM?.adapter = adaptador
        //numeros
        val datos1 = ArrayList<extraa1>()
        datos1.add(
            extraa1(
                "Números", R.drawable.uno
            )
        )
        datos1.add(
            extraa1(
                "Números", R.drawable.dos
            )
        )
        datos1.add(
            extraa1(
                "Números", R.drawable.tres
            )
        )
        datos1.add(
            extraa1(
                "Números", R.drawable.cuatro
            )
        )
        datos1.add(
            extraa1(
                "Números", R.drawable.cinco
            )
        )
        datos1.add(
            extraa1(
                "Números", R.drawable.seis
            )
        )
        datos1.add(
            extraa1(
                "Números", R.drawable.siete
            )
        )
        datos1.add(
            extraa1(
                "Números", R.drawable.ocho
            )
        )
        datos1.add(
            extraa1(
                "Números", R.drawable.nueve
            )
        )
        datos1.add(
            extraa1(
                "Números", R.drawable.cero
            )
        )
        listaM1 = findViewById(R.id.exts2)
        listaM1?.setHasFixedSize(true)  //adaptador tamaño de la vista

        layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        listaM1?.layoutManager = layoutManager  // donde se dibuje el layout
        adaptador1 = AdaptadorCustom1(this, datos1, object : ClickListener {
            override fun onClick(vista: View, index: Int) {
                val Archivo1 = "Audio"
                val prefs1 =
                    Splash.PreferenceHelper1.customPreference1(applicationContext, Archivo1)
                var carga = prefs1.tono
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)

                numero6(index)
            }
        })
        listaM1?.adapter = adaptador1
        //numeros
        val datos2 = ArrayList<extraa2>()
        datos2.add(
            extraa2(
                "Ÿ", "Acento & Diéresis"
            )
        )
        datos2.add(
            extraa2(
                "á", "Acento & Diéresis"
            )
        )
        datos2.add(
            extraa2(
                "ä", "Acento & Diéresis"
            )
        )
        datos2.add(
            extraa2(
                "í", "Acento & Diéresis"
            )
        )
        datos2.add(
            extraa2(
                "é", "Acento & Diéresis"
            )
        )
        datos2.add(
            extraa2(
                "ö", "Acento & Diéresis"
            )
        )
        datos2.add(
            extraa2(
                "ó", "Acento & Diéresis"
            )
        )
        datos2.add(
            extraa2(
                "ú", "Acento & Diéresis"
            )
        )
        datos2.add(
            extraa2(
                "ü", "Acento & Diéresis"
            )
        )
        datos2.add(
            extraa2(
                ".", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                ",", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                ";", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                ":", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "¡!", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "=", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "¿?", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "(", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                ")", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "*", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "»", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "@", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "_", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "/", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "|", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "^", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "#", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "Ç", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "[", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "]", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "x", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "÷", "Símbolos"
            )
        )
        datos2.add(
            extraa2(
                "+", " Símbolos "
            )
        )
        datos2.add(
            extraa2(
                "-", "Símbolos"
            )
        )
        listaM2 = findViewById(R.id.exts3)
        listaM2?.setHasFixedSize(true)  //adaptador tamaño de la vista

        layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        listaM2?.layoutManager = layoutManager  // donde se dibuje el layout
        adaptador2 = AdaptadorCustom2(this, datos2, object : ClickListener {
            override fun onClick(vista: View, index: Int) {
                val Archivo1 = "Audio"
                val prefs1 =
                    Splash.PreferenceHelper1.customPreference1(applicationContext, Archivo1)
                var carga = prefs1.tono
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)

                acesin(index)
            }
        })
        listaM2?.adapter = adaptador2
    }


    fun letras(index: Int) {
        val customDialog = Dialog(this)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.setContentView(R.layout.activity_extraemer)
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialog.cardView35.visibility = View.VISIBLE
        customDialog.cardView3.visibility = View.VISIBLE
        customDialog.cardView2.visibility = View.VISIBLE
        customDialog.cardView25.visibility = View.GONE
        customDialog.cardView3567.visibility = View.GONE
        customDialog.cardView25sb.visibility = View.GONE
        customDialog.cardView3df567.visibility = View.GONE
        when (index) {
            0 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.a2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.a1)
                customDialog.mifdf.setBackgroundResource(R.drawable.ma)
                customDialog.gfTextViegfwl.setText("A")
                customDialog.gfTextViewl.setText("Piensa y lo adivinarás… ¿qué tiene Adelita delante que Eva tiene detrás?")
                customDialog.mifdklf.setBackgroundResource(R.drawable.a)
                customDialog.gfTextViegfw.setText("a")
                customDialog.gfTextView.setText("Yo fui tu primer sonido cuando empezaste a hablar y soy la primera letra que en el alfabeto está.")
            }
            1 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.b2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.b1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mb)
                customDialog.gfTextViegfwl.setText("B")
                customDialog.gfTextViewl.setText("Cuando soy pequeña tengo solo una barriguita, pero cuando me quedo mayor mi barriga se divide en dos ¿Quién soy?")
                customDialog.mifdklf.setBackgroundResource(R.drawable.b)
                customDialog.gfTextViegfw.setText("b")
                customDialog.gfTextView.setText("Porque bien gordita estoy, dos barrigas me verás. No me gustan los viajes y en el barco me veras.")
            }
            2 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.c2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.c1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mc)
                customDialog.gfTextViegfwl.setText("C")
                customDialog.gfTextViewl.setText("Una raja de melón de la comida al final y los cuernos de la luna cuando menguante está.")
                customDialog.mifdklf.setBackgroundResource(R.drawable.c)
                customDialog.gfTextViegfw.setText("c")
                customDialog.gfTextView.setText("Me puedes encontrar muy al final del amanecer, nunca al mediodía ni en la tarde, pero sí en el medio de la noche ¿Quién soy?")
            }
            3 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.d2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.d1)
                customDialog.mifdf.setBackgroundResource(R.drawable.md)
                customDialog.gfTextViegfwl.setText("D")
                customDialog.gfTextViewl.setText("Yo soy letra tan escasa, que en dos sólo verás una y entra una en la docena.")
                customDialog.mifdklf.setBackgroundResource(R.drawable.d)
                customDialog.gfTextViegfw.setText("d")
                customDialog.gfTextView.setText("En los dedos tengo dos, en los dientes tengo uno, pero en las pierns, manos y brazos, ninguno. ¿Qué será?")
            }
            4 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.e2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.e1)
                customDialog.mifdf.setBackgroundResource(R.drawable.me)
                customDialog.gfTextViegfwl.setText("E")
                customDialog.gfTextViewl.setText("En medio del cielo estoy, sin ser lucero ni estrella, sin ser sol ni luna bella. ¡A ver si sabes quién soy!")
                customDialog.mifdklf.setBackgroundResource(R.drawable.e)
                customDialog.gfTextViegfw.setText("e")
                customDialog.gfTextView.setText("Como un tenedor, pero sin asa. Así dicen que soy los que me graban.")
            }
            5 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.f2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.f1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mf)
                customDialog.gfTextViegfwl.setText("F")
                customDialog.gfTextViewl.setText("Soy la letra del desfile y el sonido del pinchazo, sólo tres palitos tengo y a los Felipes empiezo.")
                customDialog.mifdklf.setBackgroundResource(R.drawable.f)
                customDialog.gfTextViegfw.setText("f")
                customDialog.gfTextView.setText("Le sirve de puerta al frío y al fuego, es final en nombres rusos y mediadora en oferta ¿Qué letra soy?")
            }
            6 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.g2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.g1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mg)
                customDialog.gfTextViegfwl.setText("G")
                customDialog.gfTextViewl.setText("Gracias siempre la lleva consigo, y guapa, y también garbanzo. ¿Sabes ya de qué letrita te hablo?.")
                customDialog.mifdklf.setBackgroundResource(R.drawable.g)
                customDialog.gfTextViegfw.setText("g")
                customDialog.gfTextView.setText("Generosa gracias a ti existe, y en garganta dos veces insiste. ¿Quién soy?")
            }
            7 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.h2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.h1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mh)
                customDialog.gfTextViegfwl.setText("H")
                customDialog.gfTextViewl.setText("Aunque diciendo mi nombre des tú casi un estornudo, hacha me tiene en su vientre, pero mi sonido es mudo.")
                customDialog.mifdklf.setBackgroundResource(R.drawable.h)
                customDialog.gfTextViegfw.setText("h")
                customDialog.gfTextView.setText("Aunque mi sonido es mudo, cuando me nombran parezco a un estornudo ¿Quién soy?")
            }
            8 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.i2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.i1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mi)
                customDialog.gfTextViegfwl.setText("I")
                customDialog.gfTextViewl.setText("Entre todas mis hermanas, soy la que he crecido menos; jamás en España estoy, pero en Madrid sí me encuentro..")
                customDialog.mifdklf.setBackgroundResource(R.drawable.i)
                customDialog.gfTextViegfw.setText("i")
                customDialog.gfTextView.setText("Soy un palito muy derechito y encima de la frente llevo un mosquito que ni pica ni vuela ni toca la vihuela.")
            }

            9 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.j2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.j1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mj)
                customDialog.gfTextViegfwl.setText("J")
                customDialog.gfTextViewl.setText("Por la cabeza me danza esta gran adivinanza: la letra más bailadora resultó ser servidora. ¿Cuál es?")
                customDialog.mifdklf.setBackgroundResource(R.drawable.j)
                customDialog.gfTextViegfw.setText("j")
                customDialog.gfTextView.setText("Mi nombre es nombre de baile, alegre y muy bravío; cuando suena en Aragón, la gente pierde el sentía.")
            }
            10 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.k2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.k1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mk)
                customDialog.gfTextViegfwl.setText("K")
                customDialog.gfTextViewl.setText("Primera en el kiwi, también en kimono, no está en banana, y tampoco en el mono.")
                customDialog.mifdklf.setBackgroundResource(R.drawable.k)
                customDialog.gfTextViegfw.setText("k")
                customDialog.gfTextView.setText("No me pronunciéis dos veces, que tengo sonido feo; siendo la letra del kilo, en carreteras me veo.")
            }
            11 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.l2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.l1)
                customDialog.mifdf.setBackgroundResource(R.drawable.ml)
                customDialog.gfTextViegfwl.setText("L")
                customDialog.gfTextViewl.setText("En Melilla hay tres, en Madrid ninguna, en Castilla dos y en Galicia una..")
                customDialog.mifdklf.setBackgroundResource(R.drawable.l)
                customDialog.gfTextViegfw.setText("l")
                customDialog.gfTextView.setText("Empieza en luna termina en sol.")
            }
            12 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.m2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.m1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mm)
                customDialog.gfTextViegfwl.setText("M")
                customDialog.gfTextViewl.setText("¿Qué es lo que se repite una vez cada minuto, dos veces cada momento y nunca en cien años?")
                customDialog.mifdklf.setBackgroundResource(R.drawable.m)
                customDialog.gfTextViegfw.setText("m")
                customDialog.gfTextView.setText("Una vez en un minuto, dos veces en un momento, tres veces en mimetismo, y en cuatro, ¡no la encuentro!")
            }
            13 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.n21)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.n11)
                customDialog.mifdf.setBackgroundResource(R.drawable.mn)
                customDialog.gfTextViegfwl.setText("N")
                customDialog.gfTextViewl.setText("¡Nana, nanita, nanita, ea! ¿Cuál es esa letrita que tanto suena?")
                customDialog.mifdklf.setBackgroundResource(R.drawable.n)
                customDialog.gfTextViegfw.setText("n")
                customDialog.gfTextView.setText("Suelen tenerla los puentes, pero no los viaductos. como también las fuentes. ¿Qué será?")
            }
            14 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.ene1)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.ene1)
                customDialog.mifdf.setBackgroundResource(R.drawable.n2)
                customDialog.gfTextViegfwl.setText("Ñ")
                customDialog.gfTextViewl.setText("Estoy en medio del año, y casi al final del castaño y del otoño ¿Quién soy?")
                customDialog.mifdklf.setBackgroundResource(R.drawable.n1)
                customDialog.gfTextViegfw.setText("ñ")
                customDialog.gfTextView.setText("Aunque lleve turbante mora no soy, que solo en castellano de letra estoy.")
            }
            15 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.o2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.o1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mo)
                customDialog.gfTextViegfwl.setText("O")
                customDialog.gfTextViewl.setText("Tengo forma de anillo, y soy la primera y la última en organillo.")
                customDialog.mifdklf.setBackgroundResource(R.drawable.o)
                customDialog.gfTextViegfw.setText("o")
                customDialog.gfTextView.setText("Una cosa quisicosa, de ovalada construcción, todos los nombres la tienen, pero las mujeres, no. El Obispo como todos también tiene dos.")
            }
            16 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.p2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.p1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mp)
                customDialog.gfTextViegfwl.setText("P")
                customDialog.gfTextViewl.setText("José, dicho entre amigos, repite siempre esta letra; también es la de los padres y la de Pedros y Petras.")
                customDialog.mifdklf.setBackgroundResource(R.drawable.p)
                customDialog.gfTextViegfw.setText("p")
                customDialog.gfTextView.setText("Como una B pero sin barriga. Me encontrarás al comienzo de Pancho, Paco y Pandora.")
            }
            17 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.q2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.q1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mq)
                customDialog.gfTextViegfwl.setText("Q")
                customDialog.gfTextViewl.setText("Estoy en el mosquito pero no en la hormiguita. No me tiene en el grillo, pero sí en la mariquita ¿Qué letra soy?")
                customDialog.mifdklf.setBackgroundResource(R.drawable.q)
                customDialog.gfTextViegfw.setText("q")
                customDialog.gfTextView.setText("Estoy en el mosquito, pero no en la hormiguita. No me tiene en el grillo, pero sí en la mariquita ¿Qué letra soy?")
            }
            18 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.r2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.r1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mr)
                customDialog.gfTextViegfwl.setText("R")
                customDialog.gfTextViewl.setText("Formo parte de París, en el fin del mar me encuentro, en el principio de Roma y, del Norte, estoy en el centro..")
                customDialog.mifdklf.setBackgroundResource(R.drawable.r)
                customDialog.gfTextViegfw.setText("r")
                customDialog.gfTextView.setText("La tiene el tigre, pero no el león dos veces el perro y una el ratón.")
            }
            19 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.s2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.s1)
                customDialog.mifdf.setBackgroundResource(R.drawable.ms)
                customDialog.gfTextViegfwl.setText("S")
                customDialog.gfTextViewl.setText("En cualquier día de la semana me verás, excepto en domingo que no me encontrarás.")
                customDialog.mifdklf.setBackgroundResource(R.drawable.s)
                customDialog.gfTextViegfw.setText("s")
                customDialog.gfTextView.setText("Desde el lunes hasta el viernes, soy la última en llegar, el sábado soy la primera y el domingo a descansar.")
            }
            20 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.t2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.t1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mt)
                customDialog.gfTextViegfwl.setText("T")
                customDialog.gfTextViewl.setText("La tienes en Torremocha y hacia el final de Albacete, y, dondequiera que estés, a las tres como a las siete.")
                customDialog.mifdklf.setBackgroundResource(R.drawable.t)
                customDialog.gfTextViegfw.setText("t")
                customDialog.gfTextView.setText("Te la digo y no la sabes, te la vuelvo a repetir, te la digo 3 veces y no la sabes decir.")
            }
            21 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.u2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.u1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mu)
                customDialog.gfTextViegfwl.setText("U")
                customDialog.gfTextViewl.setText("El burro la lleva a cuestas, metidas está en el baúl yo no la tuve jamás y siempre la tienes tú ¿Quién soy?")
                customDialog.mifdklf.setBackgroundResource(R.drawable.u)
                customDialog.gfTextViegfw.setText("u")
                customDialog.gfTextView.setText("¿Sabes de alguna letrita, que si la vuelta le das, enseguida se convierte de consonante en vocal?.")
            }
            22 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.v2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.v1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mv)
                customDialog.gfTextViegfwl.setText("V")
                customDialog.gfTextViewl.setText("Vanessa la lleva al principio, y Violeta, y también Víctor. Veleta y venado se apuntan. ¿sabes qué letra es la que llevan?")
                customDialog.mifdklf.setBackgroundResource(R.drawable.v)
                customDialog.gfTextViegfw.setText("v")
                customDialog.gfTextView.setText("En la vaca estoy, en el viento voy, si en burro me ves en ortografía vas al revés.")
            }
            23 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.w2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.w1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mw)
                customDialog.gfTextViegfwl.setText("W")
                customDialog.gfTextViewl.setText("Cuando estoy de pie puedes confundirme con dos letras. Cuando estoy al revés suelen confundirme con una letra ¿Quién soy?.")
                customDialog.mifdklf.setBackgroundResource(R.drawable.w)
                customDialog.gfTextViegfw.setText("w")
                customDialog.gfTextView.setText("Wamba y Witiza me tienen de pie, Víctor sólo a medias y Muza al revés..")
            }

            24 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.x2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.x1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mx)
                customDialog.gfTextViegfwl.setText("X")
                customDialog.gfTextViewl.setText("Es una cruz muy bonita, molino de aspas son. ¿Qué letra puede ser esta, que se emplea en multiplicación? ¿Cuál será?.")
                customDialog.mifdklf.setBackgroundResource(R.drawable.x)
                customDialog.gfTextViegfw.setText("x")
                customDialog.gfTextView.setText("Es una cruz muy bonita, molino de aspas son. ¿Qué letra puede ser esta, que se emplea en multiplicación? ¿Cuál será?")
            }
            25 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.y2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.y1)
                customDialog.mifdf.setBackgroundResource(R.drawable.my)
                customDialog.gfTextViegfwl.setText("Y")
                customDialog.gfTextViewl.setText("Soy hermana de la V, pero con un palito de más. Me llevas en un pronombre, si de ti quieres hablar.")
                customDialog.mifdklf.setBackgroundResource(R.drawable.y)
                customDialog.gfTextViegfw.setText("y")
                customDialog.gfTextView.setText("Tengo una pierna y no camino ni salto, tengo dos brazos y no puedo aplaudir. ¿Quién soy?.")
            }
            26 -> {
                customDialog.posterImgeViewl.setBackgroundResource(R.drawable.z2)
                customDialog.posterImgeView.setBackgroundResource(R.drawable.z1)
                customDialog.mifdf.setBackgroundResource(R.drawable.mz)
                customDialog.gfTextViegfwl.setText("Z")
                customDialog.gfTextViewl.setText("Una letra pizpireta, de perdiz y cazoleta que se esconde en la maceta.")
                customDialog.mifdklf.setBackgroundResource(R.drawable.z)
                customDialog.gfTextViegfw.setText("z")
                customDialog.gfTextView.setText("La última de todas soy, pero en zurdo y zapato primera voy.")
            }
        }


        customDialog.show()
    }

    fun numero6(index: Int) {
        val customDialog = Dialog(this)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.setContentView(R.layout.activity_extraemer)
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialog.cardView35.visibility = View.GONE
        customDialog.cardView3.visibility = View.GONE
        customDialog.cardView2.visibility = View.GONE
        customDialog.cardView25.visibility = View.VISIBLE
        customDialog.cardView3567.visibility = View.VISIBLE
        customDialog.cardView25sb.visibility = View.GONE
        customDialog.cardView3df567.visibility = View.GONE
        when (index) {
            0 -> {
                customDialog.posterImgeViewlh.setBackgroundResource(R.drawable.uno)
                customDialog.mifdfv.setBackgroundResource(R.drawable.num1)
                customDialog.gfTextViegfwgl.setText("1")
                customDialog.gfTextVinewl.setText("Un agricultor tiene tres montones de paja en el pajar y cuatro en el prado. Si los junta ¿cuántos montones tiene?")
            }
            1 -> {
                customDialog.posterImgeViewlh.setBackgroundResource(R.drawable.dos)
                customDialog.mifdfv.setBackgroundResource(R.drawable.num2)
                customDialog.gfTextViegfwgl.setText("2")
                customDialog.gfTextVinewl.setText("Tengo forma de patito, soy arqueado y redondito. ¿Quién soy?")
            }
            2 -> {
                customDialog.posterImgeViewlh.setBackgroundResource(R.drawable.tres)
                customDialog.mifdfv.setBackgroundResource(R.drawable.num3)
                customDialog.gfTextViegfwgl.setText("3")
                customDialog.gfTextVinewl.setText("En una pecera 2 peces van delante de un pez, 2 peces van detrás de un pez, y un pez entre dos peces, ¿Cuántos peces hay?")
            }
            3 -> {
                customDialog.posterImgeViewlh.setBackgroundResource(R.drawable.cuatro)
                customDialog.mifdfv.setBackgroundResource(R.drawable.num4)
                customDialog.gfTextViegfwgl.setText("4")
                customDialog.gfTextVinewl.setText("Soy como una escalerita o como un hombre sentado, y cuando se habla de patas, soy las que tienen los bancos.")
            }
            4 -> {
                customDialog.posterImgeViewlh.setBackgroundResource(R.drawable.cinco)
                customDialog.mifdfv.setBackgroundResource(R.drawable.num5)
                customDialog.gfTextViegfwgl.setText("5")
                customDialog.gfTextVinewl.setText("¿Qué número tiene tantas letras en su nombre como lo indica el valor de su cifra?")
            }
            5 -> {
                customDialog.posterImgeViewlh.setBackgroundResource(R.drawable.seis)
                customDialog.mifdfv.setBackgroundResource(R.drawable.num6)
                customDialog.gfTextViegfwgl.setText("6")
                customDialog.gfTextVinewl.setText("Este era un número impar, pero un día la vuelta se dio bocabajo se quedó y en un numero par se convirtió.")
            }
            6 -> {
                customDialog.posterImgeViewlh.setBackgroundResource(R.drawable.siete)
                customDialog.mifdfv.setBackgroundResource(R.drawable.num7)
                customDialog.gfTextViegfwgl.setText("7")
                customDialog.gfTextVinewl.setText("Si quieres saber qué número soy, espera a que llueva. Contando los colores del arcoíris tendrás la prueba.")
            }
            7 -> {
                customDialog.posterImgeViewlh.setBackgroundResource(R.drawable.ocho)
                customDialog.mifdfv.setBackgroundResource(R.drawable.num8)
                customDialog.gfTextViegfwgl.setText("8")
                customDialog.gfTextVinewl.setText("Un caracol se cayó en un pozo de 11 metros, cada día sube 3 metros y al dormirse baja 2 ¿En cuántos días saldrá el caracol del pozo?")
            }
            8 -> {
                customDialog.posterImgeViewlh.setBackgroundResource(R.drawable.nueve)
                customDialog.mifdfv.setBackgroundResource(R.drawable.num9)
                customDialog.gfTextViegfwgl.setText("9")
                customDialog.gfTextVinewl.setText("¿Cuál es el número que si lo pones de manos vale menos?")
            }
            9 -> {
                customDialog.posterImgeViewlh.setBackgroundResource(R.drawable.cero)
                customDialog.mifdfv.setBackgroundResource(R.drawable.num0)
                customDialog.gfTextViegfwgl.setText("0")
                customDialog.gfTextVinewl.setText("Redondo soy y es cosa anunciada que a la derecha algo valgo, pero a la izquierda nada.")
            }
        }

        customDialog.show()
    }

    fun acesin(index: Int) {
        val customDialog = Dialog(this)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.setContentView(R.layout.activity_extraemer)
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialog.cardView35.visibility = View.GONE
        customDialog.cardView3.visibility = View.GONE
        customDialog.cardView2.visibility = View.GONE
        customDialog.cardView25.visibility = View.GONE
        customDialog.cardView3567.visibility = View.GONE
        customDialog.cardView25sb.visibility = View.VISIBLE
        customDialog.cardView3df567.visibility = View.VISIBLE
        when (index) {
            0 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("Ÿ")
                customDialog.gfTextViegfwgfgl.setText("Ÿ")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.ypuntos)
            }
            1 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("á")
                customDialog.gfTextViegfwgfgl.setText("á")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.aacento)
            }
            2 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("ä")
                customDialog.gfTextViegfwgfgl.setText("ä")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.apuntos)
            }
            3 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("í")
                customDialog.gfTextViegfwgfgl.setText("í")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.iacento)
            }
            4 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("é")
                customDialog.gfTextViegfwgfgl.setText("é")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.eacento)
            }
            5 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("ö")
                customDialog.gfTextViegfwgfgl.setText("ö")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.opuntos)
            }
            6 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("ó")
                customDialog.gfTextViegfwgfgl.setText("ó")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.oacento)
            }
            7 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("ú")
                customDialog.gfTextViegfwgfgl.setText("ú")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.uacento)
            }
            8 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("ü")
                customDialog.gfTextViegfwgfgl.setText("ü")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.upuntos)
            }
            9 -> {
                customDialog.gfTextfsdVinewl.visibility = View.VISIBLE
                customDialog.posterImgeVifdwlh.setText(".")
                customDialog.gfTextViegfwgfgl.setText(".")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.punto)
                customDialog.gfTextfsdVinewl.setText("Muy chiquito, chiquito, pone fin a lo escrito.")
            }
            10 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText(",")
                customDialog.gfTextViegfwgfgl.setText(",")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.coma)
            }
            11 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText(";")
                customDialog.gfTextViegfwgfgl.setText(";")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.punto_coma)
            }
            12 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText(":")
                customDialog.gfTextViegfwgfgl.setText(":")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.dos_puntos)
            }
            13 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("¡!")
                customDialog.gfTextViegfwgfgl.setText("¡!")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.signos_admiracion)
            }
            14 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("=")
                customDialog.gfTextViegfwgfgl.setText("=")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.igual)
            }

            15 -> {
                customDialog.gfTextfsdVinewl.visibility = View.VISIBLE
                customDialog.posterImgeVifdwlh.setText("¿?")
                customDialog.gfTextViegfwgfgl.setText("¿?")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.signos_interrogacion)
                customDialog.gfTextfsdVinewl.setText("Termino cabeza arriba y empiezo cabeza abajo, y tan sólo a preguntar se limita mi trabajo.")
            }
            16 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("(")
                customDialog.gfTextViegfwgfgl.setText("(")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.parentesis_abrir)
            }
            17 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText(")")
                customDialog.gfTextViegfwgfgl.setText(")")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.parantesis_cerrar)
            }
            18 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("*")
                customDialog.gfTextViegfwgfgl.setText("*")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.asterisco)
            }
            19 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("»")
                customDialog.gfTextViegfwgfgl.setText("»")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.doble_flecha)
            }
            20 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("@")
                customDialog.gfTextViegfwgfgl.setText("@")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.arroba)
            }
            21 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("_")
                customDialog.gfTextViegfwgfgl.setText("_")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.guion_bajo)
            }
            22 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("/")
                customDialog.gfTextViegfwgfgl.setText("/")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.diagonal)
            }
            23 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("|")
                customDialog.gfTextViegfwgfgl.setText("|")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.barra_vertical)
            }
            24 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("^")
                customDialog.gfTextViegfwgfgl.setText("^")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.exponencial)
            }
            25 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("#")
                customDialog.gfTextViegfwgfgl.setText("#")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.numeros1)
            }
            26 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("Ç")
                customDialog.gfTextViegfwgfgl.setText("Ç")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.simbolo_c)
            }
            27 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("[")
                customDialog.gfTextViegfwgfgl.setText("[")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.corchete_abrir)
            }
            28 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("]")
                customDialog.gfTextViegfwgfgl.setText("]")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.corchete_cerrar)
            }
            29 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("x")
                customDialog.gfTextViegfwgfgl.setText("x")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.multiplicar)
            }
            30 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("÷")
                customDialog.gfTextViegfwgfgl.setText("÷")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.dividir)
            }
            31 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("+")
                customDialog.gfTextViegfwgfgl.setText("+")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.suma)
            }
            32 -> {
                customDialog.gfTextfsdVinewl.visibility = View.GONE
                customDialog.posterImgeVifdwlh.setText("-")
                customDialog.gfTextViegfwgfgl.setText("-")
                customDialog.mifdhfv.setBackgroundResource(R.drawable.resta)
            }
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
        if (drawerE1.isDrawerOpen(GravityCompat.START)) {
            drawerE1.closeDrawer(GravityCompat.START)
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
                drawerE1.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}