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
import kotlinx.android.synthetic.main.activity_adivi5.*
import kotlinx.android.synthetic.main.activity_adivi5.adivinanza
import kotlinx.android.synthetic.main.activity_adivi5.btncinco2
import kotlinx.android.synthetic.main.activity_adivi5.btncinco3
import kotlinx.android.synthetic.main.activity_adivi5.btncuatro2
import kotlinx.android.synthetic.main.activity_adivi5.btncuatro3
import kotlinx.android.synthetic.main.activity_adivi5.btndos2
import kotlinx.android.synthetic.main.activity_adivi5.btndos3
import kotlinx.android.synthetic.main.activity_adivi5.btnseis2
import kotlinx.android.synthetic.main.activity_adivi5.btnseis3
import kotlinx.android.synthetic.main.activity_adivi5.btntres2
import kotlinx.android.synthetic.main.activity_adivi5.btntres3
import kotlinx.android.synthetic.main.activity_adivi5.btnuno2
import kotlinx.android.synthetic.main.activity_adivi5.btnuno3
import kotlinx.android.synthetic.main.activity_adivi5.cadena2
import kotlinx.android.synthetic.main.activity_adivi5.imagen
import kotlinx.android.synthetic.main.activity_adivi5.imagen2
import kotlinx.android.synthetic.main.activity_adivi5.mue1
import kotlinx.android.synthetic.main.activity_adivi5.mue2
import kotlinx.android.synthetic.main.activity_adivi5.mue3
import kotlinx.android.synthetic.main.activity_cerrarchat.*
import kotlinx.android.synthetic.main.activity_cerrarchat1.*
import kotlinx.android.synthetic.main.activity_pista.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.io.IOException

class adivi5 : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private var mAuth: FirebaseAuth? = null
    var equi = 0
    var adivinanzaResp = ""
    var noUno1 = 0
    var noDos1 = 0
    var noTres1 = 0
    var noCuatro1 = 0
    var noCinco1 = 0
    var noSeis1 = 0
    var cadena3 = ""
    var noUno2 = 0
    var noDos2 = 0
    var noTres2 = 0
    var noCuatro2 = 0
    var noCinco2 = 0
    var noSeis2 = 0
    var cadena4 = ""
    var marcador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivi5)
        val Archivo = "Usuario"
        val defaultPrefs1 = Splash.PreferenceHelper.defaultPreference(this)
        defaultPrefs1.password = "Admin"
        defaultPrefs1.userId = 50
        val prefs1 = Splash.PreferenceHelper.customPreference(this, Archivo)
        val texto2: LinearLayout = findViewById(R.id.adivi5)
        //Asignacioón de las animaciones
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto2.startAnimation(anim1)
        val namem1 = prefs1.password
        val fotom = prefs1.userId.toString()
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
                repetir2()
            }
        }
        userj4.text = namem1
        if (fotom.toInt() == 0) {
            fotoj4.setBackgroundResource(R.drawable.nina)
        } else if (fotom.toInt() == 1) {
            fotoj4.setBackgroundResource(R.drawable.nino)
        } else if (fotom.toInt() == 2) {
            fotoj4.setBackgroundResource(R.drawable.jovena)
        } else if (fotom.toInt() == 3) {
            fotoj4.setBackgroundResource(R.drawable.joveno)
        } else if (fotom.toInt() == 4) {
            fotoj4.setBackgroundResource(R.drawable.adulta)
        } else if (fotom.toInt() == 5) {
            fotoj4.setBackgroundResource(R.drawable.adulto)
        } else if (fotom.toInt() == 6) {
            fotoj4.setBackgroundResource(R.drawable.abuelo)
        } else if (fotom.toInt() == 7) {
            fotoj4.setBackgroundResource(R.drawable.abuela)
        } else if (fotom.toInt() == 8) {
            fotoj4.setBackgroundResource(R.drawable.indefinido)
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
        setSupportActionBar(findViewById(R.id.toolbarJ25))
        navigation_viewJ25.addOnLayoutChangeListener { view, i, i2, i3, i4, i5, i6, i7, i8 ->
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
                        startActivity(Intent(this@adivi5, Usuarios::class.java))
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
        navigation_viewJ25.setNavigationItemSelectedListener {
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
                    drawerJ25.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuPrin::class.java))

                    Bungee.zoom(this)
                    true
                }
                R.id.dos2 -> {
                    drawerJ25.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, materialapoyo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.tres3 -> {
                    drawerJ25.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Red::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cuatro4 -> {
                    drawerJ25.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuJuegos::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cinco5 -> {
                    drawerJ25.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, historia::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.seis6 -> {
                    drawerJ25.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Extras::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.siete7 -> {
                    drawerJ25.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuCatalogo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.ocho8 -> {
                    drawerJ25.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Traductores::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.nueve9 -> {
                    drawerJ25.closeDrawer(GravityCompat.START)

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
        val drawerToggle = ActionBarDrawerToggle(this, drawerJ25, R.string.open, R.string.close)
        drawerJ25.addDrawerListener(drawerToggle)
        drawerToggle.drawerArrowDrawable.color = Color.BLACK
        drawerToggle.drawerArrowDrawable.gapSize = 30.0f
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_viewJ25.setItemIconTintList(null);
        asignacion()
        btnuno3.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noUno1 += 1
            if (noUno1 == 1) {
                noUno1 = 1
                btnuno3.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))

            } else {
                noUno1 = 0
                btnuno3.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        btndos3.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noDos1 += 1
            if (noDos1 == 1) {
                noDos1 = 1
                btndos3.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))

            } else {
                noDos1 = 0
                btndos3.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        btntres3.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noTres1 += 1
            if (noTres1 == 1) {
                noTres1 = 1
                btntres3.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))

            } else {
                noTres1 = 0
                btntres3.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        btncuatro3.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noCuatro1 += 1
            if (noCuatro1 == 1) {
                noCuatro1 = 1
                btncuatro3.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))

            } else {
                noCuatro1 = 0
                btncuatro3.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        btncinco3.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noCinco1 += 1
            if (noCinco1 == 1) {
                noCinco1 = 1
                btncinco3.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))

            } else {
                noCinco1 = 0
                btncinco3.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        btnseis3.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noSeis1 += 1
            if (noSeis1 == 1) {
                noSeis1 = 1
                btnseis3.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))

            } else {
                noSeis1 = 0
                btnseis3.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
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
        reiniciar4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            equi = 1
            if (marcador > 0) {
                marcador = marcador - 2
                prefs1.rnuma = prefs1.rnuma - 2
                if (marcador < 0) {
                    marcador = 0
                }
                if (prefs1.rnuma < 0) {
                    prefs1.rnuma = 0
                }
            }
            limpiar()
            marcadorA3.text = marcador.toString()
            asignacion()
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
                    prefs1.rnuma = prefs1.rnuma - marcador
                    marcador=0
                    repetir2()
                }
            }
        }
        verificar4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (noUno1 == 1) {
                cadena3 += "1"
            }
            if (noDos1 == 1) {
                cadena3 += "2"
            }
            if (noTres1 == 1) {
                cadena3 += "3"
            }
            if (noCuatro1 == 1) {
                cadena3 += "4"
            }
            if (noCinco1 == 1) {
                cadena3 += "5"
            }
            if (noSeis1 == 1) {
                cadena3 += "6"
            }
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
            val p = imagen.getTag().toString()
            val l = imagen2.getTag().toString()
            if (cadena3 == "3456" && cadena4 == "1") {
                comparacion(cadena3, cadena4, p, l)
                cadena3 = ""
                cadena4 = ""
            } else if (cadena3 == "3456" && cadena4 == "12") {
                comparacion(cadena3, cadena4, p, l)
                cadena3 = ""
                cadena4 = ""
            } else if (cadena3 == "3456" && cadena4 == "14") {
                comparacion(cadena3, cadena4, p, l)
                cadena3 = ""
                cadena4 = ""
            } else if (cadena3 == "3456" && cadena4 == "145") {
                comparacion(cadena3, cadena4, p, l)
                cadena3 = ""
                cadena4 = ""
            } else if (cadena3 == "3456" && cadena4 == "15") {
                comparacion(cadena3, cadena4, p, l)
                cadena3 = ""
                cadena4 = ""
            } else if (cadena3 == "3456" && cadena4 == "124") {
                comparacion(cadena3, cadena4, p, l)
                cadena3 = ""
                cadena4 = ""
            } else if (cadena3 == "3456" && cadena4 == "1245") {
                comparacion(cadena3, cadena4, p, l)
                cadena3 = ""
                cadena4 = ""
            } else if (cadena3 == "3456" && cadena4 == "125") {
                comparacion(cadena3, cadena4, p, l)
                cadena3 = ""
                cadena4 = ""
            } else if (cadena3 == "3456" && cadena4 == "24") {
                comparacion(cadena3, cadena4, p, l)
                cadena3 = ""
                cadena4 = ""
            } else if (cadena3 == "3456" && cadena4 == "245") {
                comparacion(cadena3, cadena4, p, l)
                cadena3 = ""
                cadena4 = ""
            } else if (cadena3 == "" || cadena4 == "") {
                comparacion(cadena3, cadena4, p, l)
                cadena3 = ""
                cadena4 = ""
            } else {
                comparacion(cadena3, cadena4, p, l)
                cadena3 = ""
                cadena4 = ""
            }
        }
        pista5.setOnClickListener {
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
                    prefs1.rnuma = prefs1.rnuma - 5
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rnuma < 0) {
                        prefs1.rnuma = 0
                    }
                }
                marcadorA3.text = marcador.toString()
                alerta2(adivinanzaResp)
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
        if (drawerJ25.isDrawerOpen(GravityCompat.START)) {
            drawerJ25.closeDrawer(GravityCompat.START)
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
                drawerJ25.openDrawer(GravityCompat.START)
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
        val numero = (1..10).random()
        numero + 1
        if (numero == 1) {
            imagen.setBackgroundResource(R.drawable.numeros1)
            imagen2.setBackgroundResource(R.drawable.a)
            adivinanza.text =
                "Un agricultor tiene tres montones de paja en el pajar y cuatro en el prado. Si los junta ¿cuántos montones tiene?"
            imagen2.setTag("1")
            imagen.setTag("3456")
            cadena2.setText("${imagen.tag}")
            adivinanzaResp = "a"
        } else if (numero == 2) {
            imagen2.setBackgroundResource(R.drawable.b)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza.text = "Tengo forma de patito, soy arqueado y redondito. ¿Quién soy?"
            imagen2.setTag("12")
            imagen.setTag("3456")
            cadena2.setText("${imagen.tag}")
            adivinanzaResp = "b"
        } else if (numero == 3) {
            imagen2.setBackgroundResource(R.drawable.c)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza.text =
                "En una pecera 2 peces van delante de un pez, 2 peces van detrás de un pez, y un pez entre dos peces, ¿Cuántos peces hay?"
            imagen2.setTag("14")
            imagen.setTag("3456")
            cadena2.setText("${imagen.tag}")
            adivinanzaResp = "c"
        } else if (numero == 4) {
            imagen2.setBackgroundResource(R.drawable.d)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza.text =
                "Soy como una escalerita o como un hombre sentado, y cuando se habla de patas, soy las que tienen los bancos. ¿Qué seré?"
            imagen2.setTag("145")
            imagen.setTag("3456")
            cadena2.setText("${imagen.tag}")
            adivinanzaResp = "d"
        } else if (numero == 5) {
            imagen2.setBackgroundResource(R.drawable.e)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza.text =
                "¿Qué número tiene tantas letras en su nombre como lo indica el valor de su cifra?"
            imagen2.setTag("15")
            imagen.setTag("3456")
            cadena2.setText("${imagen.tag}")
            adivinanzaResp = "e"
        } else if (numero == 6) {
            imagen2.setBackgroundResource(R.drawable.f)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza.text =
                "Este era un número impar, pero un día la vuelta se dio bocabajo se quedó y en un numero par se convirtió. ¿Qué seré?"
            imagen2.setTag("124")
            imagen.setTag("3456")
            cadena2.setText("${imagen.tag}")
            adivinanzaResp = "f"

        } else if (numero == 7) {
            imagen2.setBackgroundResource(R.drawable.g)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza.text =
                "Si quieres saber qué número soy, espera a que llueva. Contando los colores del arcoíris tendrás la prueba. ¿Qué seré?"
            imagen2.setTag("1245")
            imagen.setTag("3456")
            cadena2.setText("${imagen.tag}")
            adivinanzaResp = "g"
        } else if (numero == 8) {
            imagen2.setBackgroundResource(R.drawable.h)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza.text =
                "Un caracol se cayó en un pozo de 11 metros, cada día sube 3 metros y al dormirse baja 2 ¿En cuántos días saldrá el caracol del pozo?"
            imagen2.setTag("125")
            imagen.setTag("3456")
            cadena2.setText("${imagen.tag}")
            adivinanzaResp = "h"
        } else if (numero == 9) {
            imagen2.setBackgroundResource(R.drawable.i)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza.text = "¿Cuál es el número que si lo pones de manos vale menos? ¿Qué seré?"
            imagen2.setTag("24")
            imagen.setTag("3456")
            cadena2.setText("${imagen.tag}")
            adivinanzaResp = "i"
        } else if (numero == 10) {
            imagen2.setBackgroundResource(R.drawable.j)
            imagen.setBackgroundResource(R.drawable.numeros1)
            adivinanza.text =
                "Redondo soy y es cosa anunciada que a la derecha algo valgo, pero a la izquierda nada. ¿Qué seré?"
            imagen2.setTag("245")
            imagen.setTag("3456")
            cadena2.setText("${imagen.tag}")
            adivinanzaResp = "j"
        }
    }

    fun limpiar() {
        btnuno2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btndos2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btntres2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btncuatro2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btncinco2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btnseis2.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btnuno3.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btndos3.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btntres3.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btncuatro3.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btncinco3.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btnseis3.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        noUno1 = 0
        noDos1 = 0
        noTres1 = 0
        noCuatro1 = 0
        noCinco1 = 0
        noSeis1 = 0
        cadena3 = ""
        noUno2 = 0
        noDos2 = 0
        noTres2 = 0
        noCuatro2 = 0
        noCinco2 = 0
        noSeis2 = 0
        cadena4 = ""
    }

    fun comparacion(dato1: String, dato2: String, p: String, l: String) {
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
        if (dato1 == p && dato2 == l) {
            marcador = marcador + 10
            prefs1.rnuma = prefs1.rnuma + 10
            limpiar()
            asignacion()
            marcadorA3.text = marcador.toString()
            toast("Es correcto")
        }
        else if ((dato1 != p && dato2 != l) || (dato1 == p && dato2 != l) || (dato1 != p && dato2 == l)) {
            if ((dato1.isEmpty() || dato2.isEmpty()) || (dato1.isEmpty() && dato2.isEmpty())) {
                if (marcador > 0) {
                    marcador = marcador - 1
                    prefs1.rnuma = prefs1.rnuma - 1
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rnuma < 0) {
                        prefs1.rnuma = 0
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
                        repetir2()
                    }
                }
                marcadorA3.text = marcador.toString()
                toast("Es incorrecto")
                limpiar()
            } else {
                if (marcador > 0) {
                    marcador = marcador - 2
                    prefs1.rnuma = prefs1.rnuma - 2
                    if (marcador < 0) {
                        marcador = 0
                    }
                    if (prefs1.rnuma < 0) {
                        prefs1.rnuma = 0
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
                        repetir2()
                    }
                }
                marcadorA3.text = marcador.toString()
                toast("Es incorrecto")
                limpiar()
            }


        }
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
            prefs1.rnuma = prefs1.rnuma - 1
            if (marcador < 0) {
                marcador = 0
            }
            if (prefs1.rnuma < 0) {
                prefs1.rnuma = 0
            }
        }
        asignacion()
        limpiar()
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
        customDialog.tarjetaBase81.visibility = View.GONE
        customDialog.tarjetaBase82.setImageResource(R.drawable.numeros1)
        customDialog.tarjetaBase83.setImageResource(
            getResources().getIdentifier(
                dato1,
                "drawable",
                getPackageName()
            )
        )
        customDialog.show()
    }
}