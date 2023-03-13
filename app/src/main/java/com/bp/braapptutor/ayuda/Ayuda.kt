package com.bp.braapptutor.ayuda

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
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bp.braapptutor.R
import com.bp.braapptutor.adaptadores.ClickListener
import com.bp.braapptutor.catalogo.MenuCatalogo
import com.bp.braapptutor.catalogo.similares.Produc
import com.bp.braapptutor.catalogo.similares.Producto
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
import com.bp.braapptutor.inicio.Splash.PreferenceHelpe6.ayu
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
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_ayuda2.*
import kotlinx.android.synthetic.main.activity_cerrarchat.*
import kotlinx.android.synthetic.main.activity_cerrarchat1.*
import kotlinx.android.synthetic.main.activity_creditoss.*
import kotlinx.android.synthetic.main.activity_detalles.*
import kotlinx.android.synthetic.main.activity_menu_prin.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import spencerstudios.com.bungeelib.Bungee
import java.io.IOException

class Ayuda : AppCompatActivity() {

    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private var mAuth: FirebaseAuth? = null
    var listaM: RecyclerView? = null
    var adaptador: AdaptadorCustom111? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda2)
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
        val texto1: ConstraintLayout = findViewById(R.id.comddv)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto1.startAnimation(anim1)
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
        val Archivo6 = "Ayuda"
        val defaultPrefs6 = Splash.PreferenceHelpe6.defaultPreference6(this)
        defaultPrefs6.ayu = 0
        val prefs6 = Splash.PreferenceHelpe6.customPreference6(this, Archivo6)
        if (prefs6.ayu == 0) {
            userImage3.setBackgroundResource(R.drawable.help2)
            userImage4.setBackgroundResource(R.drawable.audio)
            ayudaN.visibility = View.VISIBLE
            Audio.visibility = View.GONE
            titd.text="Ayuda General"
        }
        else if (prefs6.ayu == 1) {
            userImage3.setBackgroundResource(R.drawable.help)
            userImage4.setBackgroundResource(R.drawable.audio2)
            Audio.visibility = View.VISIBLE
            ayudaN.visibility = View.GONE
            titd.text="Ajustes de Audio"
        }
        userImage3.setOnClickListener {
            prefs6.ayu=0
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (prefs6.ayu == 0) {
                userImage3.setBackgroundResource(R.drawable.help2)
                userImage4.setBackgroundResource(R.drawable.audio)
                ayudaN.visibility = View.VISIBLE
                Audio.visibility = View.GONE
                titd.text="Ayuda General"
            } else if (prefs6.ayu == 1) {
                userImage3.setBackgroundResource(R.drawable.help)
                userImage4.setBackgroundResource(R.drawable.audio2)
                Audio.visibility = View.VISIBLE
                ayudaN.visibility = View.GONE
                titd.text="Ajustes de Audio"
            }
        }
        userImage4.setOnClickListener {
            prefs6.ayu=1
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (prefs6.ayu == 0) {
                userImage3.setBackgroundResource(R.drawable.help2)
                userImage4.setBackgroundResource(R.drawable.audio)
                Audio.visibility = View.GONE
                ayudaN.visibility = View.VISIBLE
                titd.text="Ayuda General"
            } else if (prefs6.ayu == 1) {
                userImage3.setBackgroundResource(R.drawable.help)
                userImage4.setBackgroundResource(R.drawable.audio2)
                Audio.visibility = View.VISIBLE
                ayudaN.visibility = View.GONE
                titd.text="Ajustes de Audio"
            }
        }
        cardView8.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(1)
        }
        cardView25.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(2)
        }
        cardView.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(3)
        }
        cardView6.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(5)
        }
        cardView13.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(9)
        }
        cardView35.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(10)
        }
        cardView9.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(12)
        }
        ajuste.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(13)
        }
        setSupportActionBar(findViewById(R.id.toolbarC2))
        val Archivo = "Usuario"
        val defaultPrefs = Splash.PreferenceHelper.defaultPreference(this)
        defaultPrefs.password = "Admin"
        defaultPrefs.userId = 0
        defaultPrefs.sele1 = 1
        val prefs = Splash.PreferenceHelper.customPreference(this, Archivo)
        val foto2 = prefs.userId.toString()
        bud.text = prefs.password
        when {
            foto2.toInt() == 0 -> {
                fotdito.setBackgroundResource(R.drawable.nina)
            }
            foto2.toInt() == 1 -> {
                fotdito.setBackgroundResource(R.drawable.nino)
            }
            foto2.toInt() == 2 -> {
                fotdito.setBackgroundResource(R.drawable.jovena)
            }
            foto2.toInt() == 3 -> {
                fotdito.setBackgroundResource(R.drawable.joveno)
            }
            foto2.toInt() == 4 -> {
                fotdito.setBackgroundResource(R.drawable.adulta)
            }
            foto2.toInt() == 5 -> {
                fotdito.setBackgroundResource(R.drawable.adulto)
            }
            foto2.toInt() == 6 -> {
                fotdito.setBackgroundResource(R.drawable.abuelo)
            }
            foto2.toInt() == 7 -> {
                fotdito.setBackgroundResource(R.drawable.abuela)
            }
            foto2.toInt() == 8 -> {
                fotdito.setBackgroundResource(R.drawable.indefinido)
            }
        }
        navigation_viewC2.addOnLayoutChangeListener { view, i, i2, i3, i4, i5, i6, i7, i8 ->
            val Archivo = "Usuario"
            val defaultPrefs = Splash.PreferenceHelper.defaultPreference(this)
            defaultPrefs.password = "Admin"
            defaultPrefs.userId = 0
            defaultPrefs.sele1 = 1
            val prefs = Splash.PreferenceHelper.customPreference(this, Archivo)

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
                        startActivity(Intent(this@Ayuda, Usuarios::class.java))
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
        navigation_viewC2.setNavigationItemSelectedListener {
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
                    drawerC2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuPrin::class.java))

                    Bungee.zoom(this)
                    true
                }
                R.id.dos2 -> {
                    drawerC2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, materialapoyo::class.java))
                    Bungee.zoom(this)
                    true
                }

                R.id.tres3 -> {
                    drawerC2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Red::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cuatro4 -> {
                    drawerC2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuJuegos::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cinco5 -> {
                    drawerC2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, historia::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.seis6 -> {
                    drawerC2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Extras::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.siete7 -> {
                    drawerC2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuCatalogo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.ocho8 -> {
                    drawerC2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Traductores::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.nueve9 -> {
                    drawerC2.closeDrawer(GravityCompat.START)

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

        val drawerToggle = ActionBarDrawerToggle(this, drawerC2, R.string.open, R.string.close)
        drawerC2.addDrawerListener(drawerToggle)

        drawerToggle.drawerArrowDrawable.color = Color.BLACK
        drawerToggle.drawerArrowDrawable.gapSize = 30.0f
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_viewC2.setItemIconTintList(null);
        if (prefs1.activi == "CreU") {
            toolbarC2.visibility = View.GONE
            drawerC2.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            imagend.visibility = View.GONE
        } else if (prefs1.activi == "CreM") {
            toolbarC2.visibility = View.VISIBLE
            drawerC2.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            imagend.visibility = View.VISIBLE
        }
        val datos = ArrayList<ayudaaa>()

        datos.add(
            ayudaaa(
                "Ayuda",
                R.drawable.ayudaicon
            )
        )
        datos.add(
            ayudaaa(
                "Créditos",
                R.drawable.creditos1
            )
        )
        datos.add(
            ayudaaa(
                "Audio",
                R.drawable.uectangle
            )
        )
        datos.add(
            ayudaaa(
                "Flechas", R.drawable.flechas
            )
        )
        datos.add(
            ayudaaa(
                "Perfil", R.drawable.nina
            )
        )
        datos.add(
            ayudaaa(
                "Wifi", R.drawable.wifis
            )
        )
        datos.add(
            ayudaaa(
                "Pausa y Play", R.drawable.pausa
            )
        )
        datos.add(
            ayudaaa(
                "Tiempo", R.drawable.tiemp
            )
        )
        datos.add(
            ayudaaa(
                "Silencio", R.drawable.sound
            )
        )
        datos.add(
            ayudaaa(
                "Sonido", R.drawable.sound2
            )
        )
        datos.add(
            ayudaaa(
                "Cambiar", R.drawable.regresar
            )
        )
        datos.add(
            ayudaaa(
                "Pista", R.drawable.pregunta
            )
        )
        datos.add(
            ayudaaa(
                "Verificar", R.drawable.verifi
            )
        )
        datos.add(
            ayudaaa(
                "Seleccionador", R.drawable.ches
            )
        )
        datos.add(
            ayudaaa(
                "Enlace", R.drawable.enlace
            )
        )
        datos.add(
            ayudaaa(
                "Recarga", R.drawable.rec
            )
        )
        datos.add(
            ayudaaa(
                "Boton Salir", R.drawable.salida
            )
        )
        datos.add(
            ayudaaa(
                "Global", R.drawable.mund
            )
        )
        datos.add(
            ayudaaa(
                "Adivinanza", R.drawable.adiv
            )
        )
        datos.add(
            ayudaaa(
                "Memorama", R.drawable.memo
            )
        )
        datos.add(
            ayudaaa(
                "Teclado Individual", R.drawable.brait
            )
        )
        datos.add(
            ayudaaa(
                "Teclado Doble", R.drawable.brait2
            )
        )
        datos.add(
            ayudaaa(
                "Escritura", R.drawable.escri
            )
        )
        datos.add(
            ayudaaa(
                "Tarjeta",
                R.drawable.tarjeta
            )
        )
        datos.add(
            ayudaaa(
                "Diamante", R.drawable.diamond
            )
        )

        listaM = findViewById(R.id.ayudaN)
        listaM?.setHasFixedSize(true)  //adaptador tamaño de la vista

        layoutManager = StaggeredGridLayoutManager(2, RecyclerView.HORIZONTAL)
        listaM?.layoutManager = layoutManager  // donde se dibuje el layout


        adaptador = AdaptadorCustom111(this, datos, object : ClickListener {
            override fun onClick(vista: View, index: Int) {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)

                alert2(index)

            }
        })
        listaM?.adapter = adaptador
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer!!.pause()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer!!.start()
    }

    fun alert(dato: Int) {
        Bungee.zoom(this)
        val customDialog = Dialog(this)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.setContentView(R.layout.activity_detalles)
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        when (dato) {
            1 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.dereflecha)
                customDialog.textView9.text = "Flechas"
                customDialog.aparece1.text = "En los controles de Tonos y Melodías"
                customDialog.funcion1.text =
                    "Permite los movimientos de izquierda a derecha entre los tonos y melodías, así como la asignación del mismo."
            }
            2 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.vol)
                customDialog.textView9.text = "Identificador de Volumen"
                customDialog.aparece1.text = "Aparece donde se controlan el volumen."
                customDialog.funcion1.text =
                    "Guiar la categoría para modificar el volumen del audio."
            }
            3 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.cancion)
                customDialog.textView9.text = "Nota Musical 2"
                customDialog.aparece1.text =
                    "Aparece en el encabezado de la canción ya seleccionada o predeterminada."
                customDialog.funcion1.text = "Mostrar el apartado de la canción."
            }

            5 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.cond)
                customDialog.textView9.text = "Identificador de Tono o Canción y control de cambios."
                customDialog.aparece1.text = "Aparece a lado de cada tono o melodía."
                customDialog.funcion1.text = "Mostrar el tono o Melodía ya establecida, así como el detener y continuar melodía."
            }

            7 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.creditos1)
                customDialog.textView9.text = "Botón de créditos"
                customDialog.aparece1.text = "Aparece en la parte superior."
                customDialog.funcion1.text = "Permite ver la información de los Administradores."
            }

            9 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.restablecer1)
                customDialog.textView9.text = "Botón Restablecer"
                customDialog.aparece1.text = "Aparece en la parte superior."
                customDialog.funcion1.text =
                    "Sirve para restablecer el volumen, tono y melodía predeterminada."
            }
            10 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.nota)
                customDialog.textView9.text = "Nota Musical 1"
                customDialog.aparece1.text =
                    "Aparece en el encabezado de la tono ya seleccionada o predeterminada."
                customDialog.funcion1.text = "Mostrar el apartado del tono."
            }
            12 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.volu1)
                customDialog.textView9.text = "Control de volumen"
                customDialog.aparece1.text = "Aparece al final de cada apartado."
                customDialog.funcion1.text = "Controla la cantidad de volumen del 1-10 como máximo."
            }
            13 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.ajus1)
                customDialog.textView9.text = "Tema Principal"
                customDialog.aparece1.text = "Aparece de encabezado."
                customDialog.funcion1.text = "Sin función."
            }
            14 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.ajus2)
                customDialog.textView9.text = "Botón de ajustes de audio"
                customDialog.aparece1.text = "Aparece de encabezado en el lado derecho."
                customDialog.funcion1.text = "Sirve para entrar a la modificación de audio."
            }


        }
        customDialog.show()
    }

    fun alert2(dato: Int) {
        Bungee.zoom(this)
        val customDialog = Dialog(this)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.setContentView(R.layout.activity_detalles)
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        when (dato) {
            0 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.ayudaicon)
                customDialog.textView9.text = "Ayuda"
                customDialog.aparece1.text = "Aparece de Usuarios y en Menú Principal"
                customDialog.funcion1.text =
                    "Sirve para ver algunas cosas que pueden resultar confusas."
            }
            1 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.creditos1)
                customDialog.textView9.text = "Botón de créditos"
                customDialog.aparece1.text = "Aparece en la parte superior."
                customDialog.funcion1.text = "Permite ver la información de los Administradores."
            }
            2 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.uectangle)
                customDialog.textView9.text = "Audio"
                customDialog.aparece1.text =
                    "Aparece en la parte superior de Usuarios y Menú Principal."
                customDialog.funcion1.text = "Permite acceder a las configuraciones de audio."
            }
            3 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.dereflecha)
                customDialog.textView9.text = "Flechas"
                customDialog.aparece1.text = "En los controles de Tonos y Melodías"
                customDialog.funcion1.text =
                    "Permite los movimientos de izquierda a derecha entre los tonos y melodías, así como la asignación del mismo."
            }
            4 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.nina)
                customDialog.textView9.text = "Perfil"
                customDialog.aparece1.text = "Aparece en todas las vistas."
                customDialog.funcion1.text =
                    "Al mantener presionada la foto en el menú de opciones te permite cambiar tu nombre y foto de usuario o bien sirve para visualizar el nombre escrito inicialmente."
            }
            5 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.wific)
                customDialog.textView9.text = "Wifi"
                customDialog.aparece1.text = "Aparece en las ventanas que requiere internet."
                customDialog.funcion1.text =
                    "Sirven para visualizar si tiene o no acceso a internet."
            }
            6 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.pausa)
                customDialog.textView9.text = "Pausa y Play"
                customDialog.aparece1.text =
                    "Aparece en la historia."
                customDialog.funcion1.text = "Sirve para activar o desactivar el audio de historia."
            }
            7 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.tiemp)
                customDialog.textView9.text = "Tiempo"
                customDialog.aparece1.text = "Aparece en historia."
                customDialog.funcion1.text =
                    "Muestra el tiempo a trascurrir del audio de historia o el volumen."
            }
            8 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.sound)
                customDialog.textView9.text = "Silencio"
                customDialog.aparece1.text = "Aparece en historia."
                customDialog.funcion1.text = "Baja totalmente el volumen."

            }
            9 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.sound2)
                customDialog.textView9.text = "Sonido"
                customDialog.aparece1.text = "Aparece en historia."
                customDialog.funcion1.text = "Sube totalmente el volumen."

            }
            10 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.regresar)
                customDialog.textView9.text = "Cambiar"
                customDialog.aparece1.text =
                    "Aparece en los juegos."
                customDialog.funcion1.text = "Actualiza el juego."
            }
            11 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.pregunta)
                customDialog.textView9.text = "Pista"
                customDialog.aparece1.text = "Aparece en los juegos."
                customDialog.funcion1.text = "Brinda la respuesta de los juegos."
            }
            12 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.verifi)
                customDialog.textView9.text = "Verificar"
                customDialog.aparece1.text = "Aparece en los juegos de Adivinanzas"
                customDialog.funcion1.text = "Sirve para corroborar la respuesta"
            }
            13 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.ches)
                customDialog.textView9.text = "Seleccionador"
                customDialog.aparece1.text = "Aparece en la parte superior de extras."
                customDialog.funcion1.text = "Sirve para seleccionar el contenido a mostrar."
            }
            14 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.enlace)
                customDialog.textView9.text = "Enlace"
                customDialog.aparece1.text = "Aparece en Productos del Mercado."
                customDialog.funcion1.text = "Sirve para acceder en linea a mas contenido."
            }
            15 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.rec)
                customDialog.textView9.text = "Recargar"
                customDialog.aparece1.text =
                    "Aparece al deslizar hacia abajo, en records, productos y avisos."
                customDialog.funcion1.text = "Recarga contenido desde la base de datos."
            }
            16 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.salida)
                customDialog.textView9.text = "Cerrar Sesión"
                customDialog.aparece1.text =
                    "Aparece en la barra lateral y en chat."
                customDialog.funcion1.text =
                    "El de chat cierra sesión y corta las notificaciones, en cambio en de barra cierra tanto el chat como el de la aplicación."
            }
            17 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.mund)
                customDialog.textView9.text = "Global"
                customDialog.aparece1.text =
                    "Aparece en Records."
                customDialog.funcion1.text = "Cambia a estadísticas totales."
            }
            18 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.adiv)
                customDialog.textView9.text = "Adivinanzas"
                customDialog.aparece1.text =
                    "Aparece en Records."
                customDialog.funcion1.text = "Cambia a estadísticas de adivinanzas."
            }
            19 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.memo)
                customDialog.textView9.text = "Memorama"
                customDialog.aparece1.text =
                    "Aparece en Récords."
                customDialog.funcion1.text = "Cambia a estadísticas de memorama."
            }
            20 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.brait)
                customDialog.textView9.text = "Teclado Individual"
                customDialog.aparece1.text =
                    "Aparece en traductores o adivinanzas."
                customDialog.funcion1.text = "Sirve para poner la secuencia correspondiente."
            }
            21 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.brait2)
                customDialog.textView9.text = "Teclado Doble"
                customDialog.aparece1.text =
                    "Aparece en traductores o adivinanzas."
                customDialog.funcion1.text = "Sirve para poner la secuencia correspondiente."
            }
            22 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.escri)
                customDialog.textView9.text = "Escritura"
                customDialog.aparece1.text =
                    "Aparece en chat, traductores y mas..."
                customDialog.funcion1.text = "Sirve para poner información correspondiente."
            }
            23 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.tarjeta)
                customDialog.textView9.text = "Tarjeta"
                customDialog.aparece1.text =
                    "Aparecen en juegos y traductores."
                customDialog.funcion1.text = "Sirve de forma demostrativa."
            }
            24 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.diamond)
                customDialog.textView9.text = "Diamante"
                customDialog.aparece1.text =
                    "Aparecen en Records."
                customDialog.funcion1.text = "Sirve para ver todas tus estadísticas..."
            }
        }
        customDialog.show()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            android.R.id.home -> {
                drawerC2.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        val Archivo1 = "Audio"
        val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this)
        defaultPrefs1.tono = 1
        defaultPrefs1.melodia = 1
        defaultPrefs1.volum = 0.10f
        defaultPrefs1.volum1 = 1.00f
        val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
        if (drawerC2.isDrawerOpen(GravityCompat.START)) {
            drawerC2.closeDrawer(GravityCompat.START)
            prefs1.activi = ""
        } else {
            mediaPlayer?.stop()
            if (prefs1.activi == "CreU") {
                prefs1.activi = ""
                startActivity(Intent(this, Usuarios::class.java))
                Bungee.zoom(this)
                finish()
            } else if (prefs1.activi == "CreM") {
                prefs1.activi = ""
                startActivity(Intent(this, MenuPrin::class.java))
                Bungee.zoom(this)
                finish()
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

}