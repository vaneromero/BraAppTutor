package com.bp.braapptutor.traductor.LectorQr

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
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import com.bp.braapptutor.R
import com.bp.braapptutor.catalogo.MenuCatalogo
import com.bp.braapptutor.chat.activity.LoginActivity
import com.bp.braapptutor.chat.activity.UsersActivity
import com.bp.braapptutor.chat.firebase.FirebaseService
import com.bp.braapptutor.databinding.ActivityLectorqrBinding
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
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_cerrarchat.*
import kotlinx.android.synthetic.main.activity_cerrarchat1.*
import kotlinx.android.synthetic.main.activity_lectorqr.*
import kotlinx.android.synthetic.main.activity_traductor.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.io.IOException

class Lectorqr : AppCompatActivity() {
    private lateinit var binding: ActivityLectorqrBinding
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lectorqr)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        val Archivo1 = "Audio"
        val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this)
        defaultPrefs1.tono = 1
        defaultPrefs1.melodia = 1
        defaultPrefs1.volum = 0.10f
        defaultPrefs1.volum1 = 1.00f
        val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
        soundPool = SoundPool(100, AudioManager.STREAM_MUSIC, 0)
        mediaPlayer = MediaPlayer()
        mAuth = FirebaseAuth.getInstance()
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
        val Archivo = "Usuario"
        val defaultPrefs = Splash.PreferenceHelper.defaultPreference(this)
        defaultPrefs.password = "Admin"
        defaultPrefs.userId = 0
        val prefs = Splash.PreferenceHelper.customPreference(this, Archivo)
        binding = ActivityLectorqrBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.Avaz1.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            scanearqr()
        }
        bufd31.text = prefs.password
        val foto2 = prefs.userId.toString()
        val texto1: ConstraintLayout = findViewById(R.id.comdsp1)
        //Asignacioón de las animaciones
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto1.startAnimation(anim1)
        setSupportActionBar(findViewById(R.id.toolbarT2))
        navigation_viewT2.addOnLayoutChangeListener { view, i, i2, i3, i4, i5, i6, i7, i8 ->
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
                        startActivity(Intent(this@Lectorqr, Usuarios::class.java))
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
        navigation_viewT2.setNavigationItemSelectedListener {
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
                    drawerT2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuPrin::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.dos2 -> {
                    drawerT2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, materialapoyo::class.java))
                    Bungee.zoom(this)
                    true
                }

                R.id.tres3 -> {
                    drawerT2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Red::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cuatro4 -> {
                    drawerT2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuJuegos::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cinco5 -> {
                    drawerT2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, historia::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.seis6 -> {
                    drawerT2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Extras::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.siete7 -> {
                    drawerT2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuCatalogo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.ocho8 -> {
                    drawerT2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Traductores::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.nueve9 -> {
                    drawerT2.closeDrawer(GravityCompat.START)
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
        val drawerToggle = ActionBarDrawerToggle(this, drawerT2, R.string.open, R.string.close)
        drawerT2.addDrawerListener(drawerToggle)
        drawerToggle.drawerArrowDrawable.color = Color.BLACK
        drawerToggle.drawerArrowDrawable.gapSize = 30.0f
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_viewT2.setItemIconTintList(null);
        when {
            foto2.toInt() == 0 -> {
                fotifdto111.setBackgroundResource(R.drawable.nina)
            }
            foto2.toInt() == 1 -> {
                fotifdto111.setBackgroundResource(R.drawable.nino)
            }
            foto2.toInt() == 2 -> {
                fotifdto111.setBackgroundResource(R.drawable.jovena)
            }
            foto2.toInt() == 3 -> {
                fotifdto111.setBackgroundResource(R.drawable.joveno)
            }
            foto2.toInt() == 4 -> {
                fotifdto111.setBackgroundResource(R.drawable.adulta)
            }
            foto2.toInt() == 5 -> {
                fotifdto111.setBackgroundResource(R.drawable.adulto)
            }
            foto2.toInt() == 6 -> {
                fotifdto111.setBackgroundResource(R.drawable.abuelo)
            }
            foto2.toInt() == 7 -> {
                fotifdto111.setBackgroundResource(R.drawable.abuela)
            }
            foto2.toInt() == 8 -> {
                fotifdto111.setBackgroundResource(R.drawable.indefinido)
            }
        }
    }

    fun scanearqr() {
        val integretor = IntentIntegrator(this)
        integretor.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integretor.setBeepEnabled(true)
        integretor.setPrompt("Enfoque al Código Qr")
        integretor.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                toast("Cancelado")
            } else {
                val dato = result.contents
                when (dato) {
                    "a" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "b" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "c" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "d" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "e" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "f" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "g" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "h" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "i" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "j" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "k" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "l" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "m" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "n" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "ñ" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "o" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "p" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "q" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "r" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "s" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "t" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "u" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "v" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "w" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "x" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "y" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "z" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "ÿ" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "á" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "ä" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "í" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "é" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "ö" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "ó" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "ú" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "ü" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "A" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "B" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "C" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "D" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "E" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "F" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "G" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "H" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "I" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "J" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "K" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "L" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "M" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "N" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "Ñ" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "O" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "P" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "Q" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "R" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "S" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "T" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "U" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "V" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "W" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "X" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "Y" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "Z" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "Ÿ" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "Á" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "Ä" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "Í" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "É" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "Ö" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "Ó" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "Ú" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "Ü" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "." -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "," -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    ";" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    ":" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "¡!" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "=" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "¿?" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "(" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    ")" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "*" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "»" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "@" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "_" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "/" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "|" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "^" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "#" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "Ç" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "[" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "]" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "x" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "÷" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "+" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "-" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "1" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "2" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "3" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "4" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "5" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "6" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "7" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "8" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "9" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    "0" -> {
                        binding.tarjetaBase8.setText(dato)
                    }
                    else -> {
                        binding.tarjetaBase8.setText("\uD83D\uDEAB")
                    }
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
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

    private fun toast(s: String) {
        val customLayout = layoutInflater.inflate(R.layout.toast, toast23)
        val toast = Toast(this)
        toast.duration = Toast.LENGTH_SHORT
        toast.setGravity(Gravity.TOP or Gravity.RIGHT, 0, 0)
        toast.view = customLayout
        customLayout.toastT.text = s
        toast.show()
    }

    override fun onBackPressed() {
        if (drawerT2.isDrawerOpen(GravityCompat.START)) {
            drawerT2.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            android.R.id.home -> {
                drawerT2.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}