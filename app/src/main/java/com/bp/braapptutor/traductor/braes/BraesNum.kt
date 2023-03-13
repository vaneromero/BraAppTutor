package com.bp.braapptutor.traductor.braes

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
import kotlinx.android.synthetic.main.activity_braes_min.*
import kotlinx.android.synthetic.main.activity_braes_num.*
import kotlinx.android.synthetic.main.activity_braes_num.limpiar4
import kotlinx.android.synthetic.main.activity_cerrarchat.*
import kotlinx.android.synthetic.main.activity_cerrarchat1.*
import kotlinx.android.synthetic.main.activity_mostrar.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.io.IOException

class BraesNum : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    var noUno = 0
    var noDos = 0
    var noTres = 0
    var noCuatro = 0
    var noCinco = 0
    var noSeis = 0
    var cadena = ""
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_braes_num)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        val texto2: LinearLayout = findViewById(R.id.comdfddssp2)
        //Asignacioón de las animaciones
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
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
        usu2.text = prefs.password
        val foto2 = prefs.userId.toString()
        when {
            foto2.toInt() == 0 -> {
                fotito2.setBackgroundResource(R.drawable.nina)
            }
            foto2.toInt() == 1 -> {
                fotito2.setBackgroundResource(R.drawable.nino)
            }
            foto2.toInt() == 2 -> {
                fotito2.setBackgroundResource(R.drawable.jovena)
            }
            foto2.toInt() == 3 -> {
                fotito2.setBackgroundResource(R.drawable.joveno)
            }
            foto2.toInt() == 4 -> {
                fotito2.setBackgroundResource(R.drawable.adulta)
            }
            foto2.toInt() == 5 -> {
                fotito2.setBackgroundResource(R.drawable.adulto)
            }
            foto2.toInt() == 6 -> {
                fotito2.setBackgroundResource(R.drawable.abuelo)
            }
            foto2.toInt() == 7 -> {
                fotito2.setBackgroundResource(R.drawable.abuela)
            }
            foto2.toInt() == 8 -> {
                fotito2.setBackgroundResource(R.drawable.indefinido)
            }
        }
        btnuno4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noUno += 1
            if (noUno == 1) {
                noUno = 1
                btnuno4.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))

            } else {
                noUno = 0
                btnuno4.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        btndos4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noDos += 1
            if (noDos == 1) {
                noDos = 1
                btndos4.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))
            } else {
                noDos = 0
                btndos4.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        btntres4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noTres += 1
            if (noTres == 1) {
                noTres = 1
                btntres4.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))
            } else {
                noTres = 0
                btntres4.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        btncuatro4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noCuatro += 1
            if (noCuatro == 1) {
                noCuatro = 1
                btncuatro4.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))
            } else {
                noCuatro = 0
                btncuatro4.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        btncinco4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noCinco += 1
            if (noCinco == 1) {
                noCinco = 1
                btncinco4.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))
            } else {
                noCinco = 0
                btncinco4.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        btnseis4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            noSeis += 1
            if (noSeis == 1) {
                noSeis = 1
                btnseis4.setBackgroundDrawable(resources.getDrawable(R.drawable.on1))
            } else {
                noSeis = 0
                btnseis4.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
            }
        }
        convertir4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            letra4.text = ""
            if (noUno == 1) {
                cadena += "1"
            }
            if (noDos == 1) {
                cadena += "2"
            }
            if (noTres == 1) {
                cadena += "3"
            }
            if (noCuatro == 1) {
                cadena += "4"
            }
            if (noCinco == 1) {
                cadena += "5"
            }
            if (noSeis == 1) {
                cadena += "6"
            }
            Log.v("Prueba1", "la cadena es $cadena")

            //Se busca la letra usando los puntos activos en braille
            when (cadena) {
                "1" -> {
                    asignacion(cadena)
                    cadena = ""
                }
                "12" -> {
                    asignacion(cadena)
                    cadena = ""
                }
                "14" -> {
                    asignacion(cadena)
                    cadena = ""
                }
                "145" -> {
                    asignacion(cadena)
                    cadena = ""
                }
                "15" -> {
                    asignacion(cadena)
                    cadena = ""
                }
                "124" -> {
                    asignacion(cadena)
                    cadena = ""
                }
                "1245" -> {
                    asignacion(cadena)
                    cadena = ""
                }
                "125" -> {
                    asignacion(cadena)
                    cadena = ""
                }
                "24" -> {
                    asignacion(cadena)
                    cadena = ""
                }
                "245" -> {
                    asignacion(cadena)
                    cadena = ""
                }
                else -> {
                    letra4.text = "Número en Braille"
                    cadena = ""
                    limpiar()
                    toast("Intente de nuevo")
                }
            }
            letra4.text = "Número en Braille"
        }
        limpiar4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            limpiar()
        }
        setSupportActionBar(findViewById(R.id.toolbarT7))
        navigation_viewT7.addOnLayoutChangeListener { view, i, i2, i3, i4, i5, i6, i7, i8 ->
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
                        startActivity(Intent(this@BraesNum, Usuarios::class.java))
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
        navigation_viewT7.setNavigationItemSelectedListener {
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
                    drawerT7.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuPrin::class.java))

                    Bungee.zoom(this)
                    true
                }
                R.id.dos2 -> {
                    drawerT7.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, materialapoyo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.tres3 -> {
                    drawerT7.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Red::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cuatro4 -> {
                    drawerT7.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuJuegos::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cinco5 -> {
                    drawerT7.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, historia::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.seis6 -> {
                    drawerT7.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Extras::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.siete7 -> {
                    drawerT7.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuCatalogo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.ocho8 -> {
                    drawerT7.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Traductores::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.nueve9 -> {
                    drawerT7.closeDrawer(GravityCompat.START)

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
        val drawerToggle = ActionBarDrawerToggle(this, drawerT7, R.string.open, R.string.close)
        drawerT7.addDrawerListener(drawerToggle)
        drawerToggle.drawerArrowDrawable.color = Color.BLACK
        drawerToggle.drawerArrowDrawable.gapSize = 30.0f
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_viewT7.setItemIconTintList(null);
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

    fun limpiar() {
        btnuno4.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btndos4.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btntres4.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btncuatro4.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btncinco4.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        btnseis4.setBackgroundDrawable(resources.getDrawable(R.drawable.off1))
        noUno = 0
        noDos = 0
        noTres = 0
        noCuatro = 0
        noCinco = 0
        noSeis = 0
        cadena = ""
        letra4.text = "Número en Braille"
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer!!.pause()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer!!.start()
    }

    fun asignacion(cadena1: String) {
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.activity_mostrar)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        when (cadena1) {
            "1" -> {
                customDialog.tarjetaBase8.text = "1"
            }
            "12" -> {
                customDialog.tarjetaBase8.text = "2"
            }
            "14" -> {
                customDialog.tarjetaBase8.text = "3"
            }
            "145" -> {
                customDialog.tarjetaBase8.text = "4"
            }
            "15" -> {
                customDialog.tarjetaBase8.text = "5"
            }
            "124" -> {
                customDialog.tarjetaBase8.text = "6"
            }
            "1245" -> {
                customDialog.tarjetaBase8.text = "7"
            }
            "125" -> {
                customDialog.tarjetaBase8.text = "8"
            }
            "24" -> {
                customDialog.tarjetaBase8.text = "9"
            }
            "245" -> {
                customDialog.tarjetaBase8.text = "0"
            }
            else -> {
                customDialog.tarjetaBase8.text = ""
            }
        }
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
        if (drawerT7.isDrawerOpen(GravityCompat.START)) {
            drawerT7.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            android.R.id.home -> {
                drawerT7.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}