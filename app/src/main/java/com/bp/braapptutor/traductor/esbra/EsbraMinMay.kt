package com.bp.braapptutor.traductor.esbra

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
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.constraintlayout.widget.ConstraintLayout
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
import kotlinx.android.synthetic.main.activity_esbra_min_may.*
import kotlinx.android.synthetic.main.activity_lectorqr.*
import kotlinx.android.synthetic.main.activity_usuarios.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.io.IOException

class EsbraMinMay : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esbra_min_may)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        limpieza()
        val texto1: ConstraintLayout = findViewById(R.id.comp1q)
        val texto2: LinearLayout = findViewById(R.id.contenedora1)
        //Asignacioón de las animaciones
        mAuth = FirebaseAuth.getInstance()
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto1.startAnimation(anim1)
        texto2.startAnimation(anim1)
        val defaultPrefs = Splash.PreferenceHelper.defaultPreference(this)
        defaultPrefs.password = "Admin"
        defaultPrefs.userId = 0
        defaultPrefs.sele1 = 1
        val prefs = Splash.PreferenceHelper.customPreference(this, "Usuario")
        val Archivo1 = "Audio"
        val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this)
        defaultPrefs1.tono = 1
        defaultPrefs1.melodia = 1
        defaultPrefs1.volum = 0.10f
        defaultPrefs1.volum1 = 1.00f
        val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
        soundPool = SoundPool(100, AudioManager.STREAM_MUSIC, 0)
        mediaPlayer = MediaPlayer()
        var carga = prefs1.tono
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
        bu311.text = prefs.password
        val foto2 = prefs.userId.toString()
        when {
            foto2.toInt() == 0 -> {
                fotito1111.setBackgroundResource(R.drawable.nina)
            }
            foto2.toInt() == 1 -> {
                fotito1111.setBackgroundResource(R.drawable.nino)
            }
            foto2.toInt() == 2 -> {
                fotito1111.setBackgroundResource(R.drawable.jovena)
            }
            foto2.toInt() == 3 -> {
                fotito1111.setBackgroundResource(R.drawable.joveno)
            }
            foto2.toInt() == 4 -> {
                fotito1111.setBackgroundResource(R.drawable.adulta)
            }
            foto2.toInt() == 5 -> {
                fotito1111.setBackgroundResource(R.drawable.adulto)
            }
            foto2.toInt() == 6 -> {
                fotito1111.setBackgroundResource(R.drawable.abuelo)
            }
            foto2.toInt() == 7 -> {
                fotito1111.setBackgroundResource(R.drawable.abuela)
            }
            foto2.toInt() == 8 -> {
                fotito1111.setBackgroundResource(R.drawable.indefinido)
            }
        }
        setSupportActionBar(findViewById(R.id.toolbarT3))
        navigation_viewT3.addOnLayoutChangeListener { view, i, i2, i3, i4, i5, i6, i7, i8 ->
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
                        startActivity(Intent(this@EsbraMinMay, Usuarios::class.java))
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
        navigation_viewT3.setNavigationItemSelectedListener {
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
                    drawerT3.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuPrin::class.java))

                    Bungee.zoom(this)
                    true
                }
                R.id.dos2 -> {
                    drawerT3.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, materialapoyo::class.java))
                    Bungee.zoom(this)
                    true
                }

                R.id.tres3 -> {
                    drawerT3.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Red::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cuatro4 -> {
                    drawerT3.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuJuegos::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cinco5 -> {
                    drawerT3.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, historia::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.seis6 -> {
                    drawerT3.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Extras::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.siete7 -> {
                    drawerT3.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuCatalogo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.ocho8 -> {
                    drawerT3.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Traductores::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.nueve9 -> {
                    drawerT3.closeDrawer(GravityCompat.START)

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
        val drawerToggle = ActionBarDrawerToggle(this, drawerT3, R.string.open, R.string.close)
        drawerT3.addDrawerListener(drawerToggle)
        drawerToggle.drawerArrowDrawable.color = Color.BLACK
        drawerToggle.drawerArrowDrawable.gapSize = 30.0f
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_viewT3.setItemIconTintList(null);
        val campoMensaje = findViewById<View>(R.id.letraEspa) as EditText
        campoMensaje.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) { }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (count==1){
                    campoMensaje.clearFocus()
                }
            }
            override fun afterTextChanged(s: Editable) {
                campoMensaje.clearFocus()
            }
        })
        letraEspa.setOnFocusChangeListener { view, b ->
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
        Convertir.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val dato = letraEspa.text.toString().lowercase()
            val dato2 = ""
            if (dato == "a") {
                tarjetaBase.setBackgroundResource(R.drawable.a)
                tarjetaBase1.setBackgroundResource(R.drawable.ma)
                tarjetaBase3.setBackgroundResource(R.drawable.num1)
                hit(dato, "1")
            } else if (dato == "b") {
                tarjetaBase.setBackgroundResource(R.drawable.b)
                tarjetaBase1.setBackgroundResource(R.drawable.mb)
                tarjetaBase3.setBackgroundResource(R.drawable.num2)
                hit(dato, "2")
            } else if (dato == "c") {
                tarjetaBase.setBackgroundResource(R.drawable.c)
                tarjetaBase1.setBackgroundResource(R.drawable.mc)
                tarjetaBase3.setBackgroundResource(R.drawable.num3)
                hit(dato, "3")
            } else if (dato == "d") {
                tarjetaBase.setBackgroundResource(R.drawable.d)
                tarjetaBase1.setBackgroundResource(R.drawable.md)
                tarjetaBase3.setBackgroundResource(R.drawable.num4)
                hit(dato, "4")
            } else if (dato == "e") {
                tarjetaBase.setBackgroundResource(R.drawable.e)
                tarjetaBase1.setBackgroundResource(R.drawable.me)
                tarjetaBase3.setBackgroundResource(R.drawable.num5)
                hit(dato, "5")
            } else if (dato == "f") {
                tarjetaBase.setBackgroundResource(R.drawable.f)
                tarjetaBase1.setBackgroundResource(R.drawable.mf)
                tarjetaBase3.setBackgroundResource(R.drawable.num6)
                hit(dato, "6")
            } else if (dato == "g") {
                tarjetaBase.setBackgroundResource(R.drawable.g)
                tarjetaBase1.setBackgroundResource(R.drawable.mc)
                tarjetaBase3.setBackgroundResource(R.drawable.num7)
                hit(dato, "7")
            } else if (dato == "h") {
                tarjetaBase.setBackgroundResource(R.drawable.h)
                tarjetaBase1.setBackgroundResource(R.drawable.mh)
                tarjetaBase3.setBackgroundResource(R.drawable.num8)
                hit(dato, "8")
            } else if (dato == "i") {
                tarjetaBase.setBackgroundResource(R.drawable.i)
                tarjetaBase1.setBackgroundResource(R.drawable.mi)
                tarjetaBase3.setBackgroundResource(R.drawable.num9)
                hit(dato, "9")
            } else if (dato == "j") {
                tarjetaBase.setBackgroundResource(R.drawable.j)
                tarjetaBase1.setBackgroundResource(R.drawable.mj)
                tarjetaBase3.setBackgroundResource(R.drawable.num0)
                hit(dato, "0")
            } else if (dato == "k") {
                tarjetaBase.setBackgroundResource(R.drawable.k)
                tarjetaBase1.setBackgroundResource(R.drawable.mk)
            } else if (dato == "l") {
                tarjetaBase.setBackgroundResource(R.drawable.l)
                tarjetaBase1.setBackgroundResource(R.drawable.ml)
                hit(dato, "")
            } else if (dato == "m") {
                tarjetaBase.setBackgroundResource(R.drawable.m)
                tarjetaBase1.setBackgroundResource(R.drawable.mm)
                hit(dato, "")
            } else if (dato == "n") {
                tarjetaBase.setBackgroundResource(R.drawable.n)
                tarjetaBase1.setBackgroundResource(R.drawable.mn)
                hit(dato, "")
            } else if (dato == "ñ") {
                tarjetaBase.setBackgroundResource(R.drawable.ene)
                tarjetaBase1.setBackgroundResource(R.drawable.n2)
                hit(dato, "")
            } else if (dato == "o") {
                tarjetaBase.setBackgroundResource(R.drawable.o)
                tarjetaBase1.setBackgroundResource(R.drawable.mo)
                hit(dato, "")
            } else if (dato == "p") {
                tarjetaBase.setBackgroundResource(R.drawable.p)
                tarjetaBase1.setBackgroundResource(R.drawable.mp)
                hit(dato, "")
            } else if (dato == "q") {
                tarjetaBase.setBackgroundResource(R.drawable.q)
                tarjetaBase1.setBackgroundResource(R.drawable.mq)
                hit(dato, "")
            } else if (dato == "r") {
                tarjetaBase.setBackgroundResource(R.drawable.r)
                tarjetaBase1.setBackgroundResource(R.drawable.mr)
                hit(dato, "")
            } else if (dato == "s") {
                tarjetaBase.setBackgroundResource(R.drawable.s)
                tarjetaBase1.setBackgroundResource(R.drawable.ms)
                hit(dato, "")
            } else if (dato == "t") {
                tarjetaBase.setBackgroundResource(R.drawable.t)
                tarjetaBase1.setBackgroundResource(R.drawable.mt)
                hit(dato, "")
            } else if (dato == "u") {
                tarjetaBase.setBackgroundResource(R.drawable.u)
                tarjetaBase1.setBackgroundResource(R.drawable.mu)
                hit(dato, "")
            } else if (dato == "v") {
                tarjetaBase.setBackgroundResource(R.drawable.v)
                tarjetaBase1.setBackgroundResource(R.drawable.mv)
                hit(dato, "")
            } else if (dato == "w") {
                tarjetaBase.setBackgroundResource(R.drawable.w)
                tarjetaBase1.setBackgroundResource(R.drawable.mw)
                hit(dato, "")
            } else if (dato == "x") {
                tarjetaBase.setBackgroundResource(R.drawable.x)
                tarjetaBase1.setBackgroundResource(R.drawable.mx)
                hit(dato, "")
            } else if (dato == "y") {
                tarjetaBase.setBackgroundResource(R.drawable.y)
                tarjetaBase1.setBackgroundResource(R.drawable.my)
                hit(dato, "")
            } else if (dato == "z") {
                tarjetaBase.setBackgroundResource(R.drawable.z)
                tarjetaBase1.setBackgroundResource(R.drawable.mz)
                hit(dato, "")
            } else if (dato == "ÿ") {
                tarjetaBase.setBackgroundResource(R.drawable.ypuntos)
                tarjetaBase1.setBackgroundResource(R.drawable.mdy)
                hit(dato, "")
            } else if (dato == "á") {
                tarjetaBase.setBackgroundResource(R.drawable.aacento)
                tarjetaBase1.setBackgroundResource(R.drawable.mda)
                hit(dato, "")
            } else if (dato == "ä") {
                tarjetaBase.setBackgroundResource(R.drawable.apuntos)
                tarjetaBase1.setBackgroundResource(R.drawable.mda1)
                hit(dato, "")
            } else if (dato == "í") {
                tarjetaBase.setBackgroundResource(R.drawable.iacento)
                tarjetaBase1.setBackgroundResource(R.drawable.mdi)
                hit(dato, "")
            } else if (dato == "é") {
                tarjetaBase.setBackgroundResource(R.drawable.eacento)
                tarjetaBase1.setBackgroundResource(R.drawable.mde)
                hit(dato, "")
            } else if (dato == "ö") {
                tarjetaBase.setBackgroundResource(R.drawable.opuntos)
                tarjetaBase1.setBackgroundResource(R.drawable.mdo)
                hit(dato, "")
            } else if (dato == "ó") {
                tarjetaBase.setBackgroundResource(R.drawable.oacento)
                tarjetaBase1.setBackgroundResource(R.drawable.mdo1)
                hit(dato, "")
            } else if (dato == "ú") {
                tarjetaBase.setBackgroundResource(R.drawable.uacento)
                tarjetaBase1.setBackgroundResource(R.drawable.mdu)
                hit(dato, "")
            } else if (dato == "ü") {
                tarjetaBase.setBackgroundResource(R.drawable.upuntos)
                tarjetaBase1.setBackgroundResource(R.drawable.mdu1)
                hit(dato, "")
            } else if (dato == "" || !TextUtils.isEmpty(dato) || dato == " " || dato2 == "" || dato2 == " ") {
                limpieza()
            } else {
                limpieza()
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    fun limpieza() {
        tarjetaBase.setBackgroundResource(R.drawable.tarjetitas)
        tarjetaBase1.setBackgroundResource(R.drawable.conjunto)
        tarjetaBase3.setBackgroundResource(R.drawable.conjunto)
        letraEspa.setText("")
        letraelegida.text = ""
        letraelegida1.text = ""
        cas.visibility = View.GONE
    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    fun hit(dato: String, dato2: String) {
        letraEspa.setText("")
        letraelegida.text = "Letra Obtenida: $dato"
        letraelegida1.text = "Numero Obtenido: $dato2"
        if (dato2 == "") {
            cas.visibility = View.GONE
            tarjetaBase3.setBackgroundResource(R.drawable.conjunto)
            letraelegida1.text = ""
        } else {
            cas.visibility = View.VISIBLE
        }
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer!!.pause()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer!!.start()
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
        if (drawerT3.isDrawerOpen(GravityCompat.START)) {
            drawerT3.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            android.R.id.home -> {
                drawerT3.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}