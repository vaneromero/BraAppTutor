package com.bp.braapptutor.catalogo.producto

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
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bp.braapptutor.catalogo.MenuCatalogo
import com.bp.braapptutor.catalogo.similares.Propio
import com.bumptech.glide.Glide
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_prod_rec.*
import kotlinx.android.synthetic.main.activity_prodc_detalle.*
import kotlinx.android.synthetic.main.activity_prodrec_detalle1.*
import kotlinx.android.synthetic.main.activity_prodrec_detalle1.posterImgeView8
import kotlinx.android.synthetic.main.activity_prodrec_detalle2.*
import kotlinx.android.synthetic.main.producto_content1.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import com.bp.braapptutor.R
import com.bp.braapptutor.chat.activity.LoginActivity
import com.bp.braapptutor.chat.activity.UsersActivity
import com.bp.braapptutor.chat.firebase.FirebaseService
import com.bp.braapptutor.conexion.ConnectivityLiveData
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
import com.bp.braapptutor.inicio.Splash.PreferenceHelper4.dato1
import com.bp.braapptutor.inicio.Splash.PreferenceHelper4.dato2
import com.bp.braapptutor.inicio.Splash.PreferenceHelper4.dato3
import com.bp.braapptutor.inicio.Usuarios
import com.bp.braapptutor.mate.materialapoyo
import com.bp.braapptutor.menuprincipal.MenuPrin
import com.bp.braapptutor.redes.Red
import com.bp.braapptutor.traductor.Traductores
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_cerrarchat.*
import kotlinx.android.synthetic.main.activity_cerrarchat1.*
import kotlinx.android.synthetic.main.activity_menu_catalogo.*
import kotlinx.android.synthetic.main.activity_produc.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class ProdRec : AppCompatActivity() {
    private val database = Firebase.database
    private lateinit var messagesListener: ValueEventListener
    private val listPropio: MutableList<Propio> = ArrayList()
    val myRefPropio = database.getReference("Propio")
    private val listRecomendacion: MutableList<Recomendacion> = ArrayList()
    val myRefRecomendaciones = database.getReference("Recomendaciones")
    var soundPool: SoundPool? = null
    var mediaPlayer: MediaPlayer? = null
    private var mAuth: FirebaseAuth? = null
    private lateinit var connectivityLiveData: ConnectivityLiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prod_rec)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        mAuth = FirebaseAuth.getInstance()
        checkNetworkConnection()
        val texto1: LinearLayout = findViewById(R.id.com67udfsjy)
        //Asignacioón de las animaciones
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto1.startAnimation(anim1)
        val defaultPrefs = Splash.PreferenceHelper.defaultPreference(this)
        defaultPrefs.password = "Admin"
        defaultPrefs.userId = 0
        defaultPrefs.sele1 = 1
        val prefs = Splash.PreferenceHelper.customPreference(this, "Usuario")
        val Archivo4 = "Catalogo"
        val defaultPrefs4 = Splash.PreferenceHelper4.defaultPreference4(this)
        defaultPrefs4.dato1 = 0
        defaultPrefs4.dato2 = 0
        defaultPrefs4.dato3 = 0
        val prefs4 = Splash.PreferenceHelper4.customPreference4(this, Archivo4)
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
        bu232tfd.text = prefs.password
        val foto2 = prefs.userId.toString()
        when {
            foto2.toInt() == 0 -> {
                imgProfilesdstg.setBackgroundResource(R.drawable.nina)
            }
            foto2.toInt() == 1 -> {
                imgProfilesdstg.setBackgroundResource(R.drawable.nino)
            }
            foto2.toInt() == 2 -> {
                imgProfilesdstg.setBackgroundResource(R.drawable.jovena)
            }
            foto2.toInt() == 3 -> {
                imgProfilesdstg.setBackgroundResource(R.drawable.joveno)
            }
            foto2.toInt() == 4 -> {
                imgProfilesdstg.setBackgroundResource(R.drawable.adulta)
            }
            foto2.toInt() == 5 -> {
                imgProfilesdstg.setBackgroundResource(R.drawable.adulto)
            }
            foto2.toInt() == 6 -> {
                imgProfilesdstg.setBackgroundResource(R.drawable.abuelo)
            }
            foto2.toInt() == 7 -> {
                imgProfilesdstg.setBackgroundResource(R.drawable.abuela)
            }
            foto2.toInt() == 8 -> {
                imgProfilesdstg.setBackgroundResource(R.drawable.indefinido)
            }
        }
        wiffaa.setBackgroundResource(R.drawable.wifis)

        if (prefs4.dato2 == 0) {
            productod.visibility = View.VISIBLE
            Recomendad.visibility = View.GONE
            cond.visibility = View.VISIBLE
            productosP.visibility = View.GONE
            productosR.visibility = View.GONE
        } else if (prefs4.dato2 == 1) {
            productod.visibility = View.GONE
            Recomendad.visibility = View.VISIBLE
            cond.visibility = View.VISIBLE
            productosP.visibility = View.GONE
            productosR.visibility = View.GONE
        }

        setSupportActionBar(findViewById(R.id.toolbarPS2))
        navigation_viewPS2.addOnLayoutChangeListener { view, i, i2, i3, i4, i5, i6, i7, i8 ->
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
                        startActivity(Intent(this@ProdRec, Usuarios::class.java))
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
        navigation_viewPS2.setNavigationItemSelectedListener {
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
                    drawerPS2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuPrin::class.java))

                    Bungee.zoom(this)
                    true
                }
                R.id.dos2 -> {
                    drawerPS2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, materialapoyo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.tres3 -> {
                    drawerPS2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Red::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cuatro4 -> {
                    drawerPS2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuJuegos::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cinco5 -> {
                    drawerPS2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, historia::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.seis6 -> {
                    drawerPS2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Extras::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.siete7 -> {
                    drawerPS2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuCatalogo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.ocho8 -> {
                    drawerPS2.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Traductores::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.nueve9 -> {
                    drawerPS2.closeDrawer(GravityCompat.START)

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
        val drawerToggle = ActionBarDrawerToggle(this, drawerPS2, R.string.open, R.string.close)
        drawerPS2.addDrawerListener(drawerToggle)
        drawerToggle.drawerArrowDrawable.color = Color.BLACK
        drawerToggle.drawerArrowDrawable.gapSize = 30.0f
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_viewPS2.setItemIconTintList(null);
    }

    private fun setupRecyclerViewPropio(recyclerView: RecyclerView) {

        messagesListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listPropio.clear()
                dataSnapshot.children.forEach { child ->
                    val producto: Propio? =
                        Propio(
                            child.child("nombre").getValue<String>(),
                            child.child("descripción").getValue<String>(),
                            child.child("url").getValue<String>(),
                            child.child("nombresito").getValue<String>(),
                            child.key
                        )
                    producto?.let { listPropio.add(it) }
                }
                recyclerView.adapter = Producto1ViewAdapterPropio(listPropio)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("TAG", "messages:onCancelled: ${error.message}")
            }
        }
        myRefPropio.addValueEventListener(messagesListener)

    }

    class Producto1ViewAdapterPropio(private val values: List<Propio>) :
        RecyclerView.Adapter<Producto1ViewAdapterPropio.ViewHolder>() {
        private var lastPosition = -1
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.producto_content1, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val producto1 = values[position]
            holder.uno.text = producto1.nombre
            holder.mPoster?.let {
                Glide.with(holder.itemView.context)
                    .load(producto1.url)
                    .into(it)
            }
            setAnimation(holder.itemView, position);
            holder.itemView.setOnClickListener { v ->
                var soundPool: SoundPool? = null
                val Archivo1 = "Audio"
                val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(v.context)
                defaultPrefs1.tono = 1
                defaultPrefs1.melodia = 1
                defaultPrefs1.volum = 0.10f
                defaultPrefs1.volum1 = 1.00f
                val prefs1 = Splash.PreferenceHelper1.customPreference1(v.context, Archivo1)
                soundPool = SoundPool(100, AudioManager.STREAM_MUSIC, 0)
                var carga = prefs1.tono
                           when (prefs1.tono) {
                        1 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton1, 1)
                        }
                        2 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton2, 1)
                        }
                        3 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton3, 1)
                        }
                        4 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton4, 1)
                        }
                        5 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton5, 1)
                        }
                        6 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton6, 1)
                        }
                        7 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton7, 1)
                        }
                        8 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton8, 1)
                        }
                        9 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton9, 1)
                        }
                        10 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton10, 1)
                        }
                    }
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                val customDialog = Dialog(v.context)
                customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                customDialog.setContentView(R.layout.activity_prodrec_detalle2)
                customDialog.window?.setLayout(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                var url = ""
                val database = Firebase.database

                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                val myRef9 = database.getReference("Propio").child(
                    producto1.key.toString()
                )
                myRef9.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {

                        val producto: Propio? = dataSnapshot.getValue(Propio::class.java)
                        if (producto != null) {
                            customDialog.nameTextVie9w.text = producto.nombre.toString()
                            customDialog.descriptio78nTextView.text =
                                producto.descripción.toString()
                            Glide.with(v.context)
                                .load(producto.url.toString())
                                .into(customDialog.posterImgeViejgdw)

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.w("TAG", "Failed to read value.", error.toException())
                    }
                })

                customDialog.show()
            }

        }

        override fun getItemCount() = values.size
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val uno: TextView = view.name1TextViewRecomendacion
            val mPoster: ImageView? = view.logito
        }

        fun setAnimation(viewToAnimate: View, position: Int) {
            // If the bound view wasn't previously displayed on screen, it's animated
            if (position > lastPosition) {
                val anim = ScaleAnimation(
                    0.0f,
                    1.0f,
                    0.0f,
                    1.0f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f
                )
                anim.duration =
                    Random().nextInt(501).toLong() //to make duration random number between [0,501)

                viewToAnimate.startAnimation(anim)
                lastPosition = position
            }
        }

    }

    private fun setupRecyclerViewRecomendacion(recyclerView: RecyclerView) {
        messagesListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listRecomendacion.clear()
                dataSnapshot.children.forEach { child ->
                    val producto: Recomendacion? =

                        Recomendacion(
                            child.child("nombre").getValue<String>(),
                            child.child("descripcion").getValue<String>(),
                            child.child("imagen").getValue<String>(),
                            child.child("nombresito").getValue<String>(),
                            child.key

                        )
                    producto?.let { listRecomendacion.add(it) }
                }
                recyclerView.adapter = Producto1ViewAdapterRecomendacion(listRecomendacion)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("TAG", "messages:onCancelled: ${error.message}")
            }
        }
        myRefRecomendaciones.addValueEventListener(messagesListener)
    }

    class Producto1ViewAdapterRecomendacion(private val values: List<Recomendacion>) :
        RecyclerView.Adapter<Producto1ViewAdapterRecomendacion.ViewHolder>() {
        private var lastPosition = -1
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.producto_content1, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val producto2 = values[position]
            holder.uno.text = producto2.nombre
            holder.mPoster?.let {
                Glide.with(holder.itemView.context)
                    .load(producto2.descripcion)
                    .into(it)
            }

            setAnimation(holder.itemView, position);
            holder.itemView.setOnClickListener { v ->
                var soundPool: SoundPool? = null
                val Archivo1 = "Audio"
                val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(v.context)
                defaultPrefs1.tono = 1
                defaultPrefs1.melodia = 1
                defaultPrefs1.volum = 0.10f
                defaultPrefs1.volum1 = 1.00f
                val prefs1 = Splash.PreferenceHelper1.customPreference1(v.context, Archivo1)
                soundPool = SoundPool(100, AudioManager.STREAM_MUSIC, 0)
                var carga = prefs1.tono
                         when (prefs1.tono) {
                        1 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton1, 1)
                        }
                        2 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton2, 1)
                        }
                        3 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton3, 1)
                        }
                        4 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton4, 1)
                        }
                        5 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton5, 1)
                        }
                        6 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton6, 1)
                        }
                        7 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton7, 1)
                        }
                        8 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton8, 1)
                        }
                        9 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton9, 1)
                        }
                        10 -> {
                            carga = soundPool!!.load(v.context, R.raw.ton10, 1)
                        }
                    }
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                val customDialog = Dialog(v.context)
                customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                customDialog.setContentView(R.layout.activity_prodrec_detalle1)
                customDialog.window?.setLayout(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                var url = ""
                val database = Firebase.database

                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                val myRef6 = database.getReference("Recomendaciones").child(
                    producto2.key.toString()
                )
                myRef6.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {

                        val producto: Recomendacion? =
                            dataSnapshot.getValue(Recomendacion::class.java)
                        if (producto != null) {
                            customDialog.nameTextView8.text = producto.nombre.toString()
                            customDialog.descriptionTextView8.text = producto.descripcion.toString()
                            Glide.with(v.context)
                                .load(producto.imagen.toString())
                                .into(customDialog.posterImgeView8)

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.w("TAG", "Failed to read value.", error.toException())
                    }
                })

                customDialog.show()

            }

        }

        override fun getItemCount() = values.size
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val uno: TextView = view.name1TextViewRecomendacion
            val mPoster: ImageView? = view.logito
        }

        fun setAnimation(viewToAnimate: View, position: Int) {
            // If the bound view wasn't previously displayed on screen, it's animated
            if (position > lastPosition) {
                val anim = ScaleAnimation(
                    0.0f,
                    1.0f,
                    0.0f,
                    1.0f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f
                )
                anim.duration =
                    Random().nextInt(501).toLong() //to make duration random number between [0,501)

                viewToAnimate.startAnimation(anim)
                lastPosition = position
            }
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

    private fun checkNetworkConnection() {

        connectivityLiveData = ConnectivityLiveData(application)
        connectivityLiveData.observe(this, Observer { isAvailable ->
            when (isAvailable) {

                true -> {
                    val Archivo4 = "Catalogo"
                    val defaultPrefs4 = Splash.PreferenceHelper4.defaultPreference4(this)
                    defaultPrefs4.dato1 = 0
                    defaultPrefs4.dato2 = 0
                    defaultPrefs4.dato3 = 0
                    val prefs4 = Splash.PreferenceHelper4.customPreference4(this, Archivo4)
                    val Archivo1 = "Audio"
                    val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this)
                    defaultPrefs1.tono = 1
                    defaultPrefs1.melodia = 1
                    defaultPrefs1.volum = 0.10f
                    defaultPrefs1.volum1 = 1.00f
                    val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
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
                    wiffaa.setBackgroundResource(R.drawable.wific)
                    if (prefs4.dato2 == 0) {
                        cond.visibility = View.GONE
                        //Propio
                        productosP.visibility = View.VISIBLE
                        productosR.visibility = View.GONE
                        swipeRefreshPropio1.setOnRefreshListener {
                            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                            setupRecyclerViewPropio(PropioRecyclerView)
                            swipeRefreshPropio1.isRefreshing = false
                        }
                        listPropio.clear()
                        setupRecyclerViewPropio(PropioRecyclerView)
                    } else if (prefs4.dato2 == 1) {
                        cond.visibility = View.GONE
                        //recomendación
                        productosP.visibility = View.GONE
                        productosR.visibility = View.VISIBLE
                        swipeRefreshRecomendacion1.setOnRefreshListener {
                            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                            setupRecyclerViewRecomendacion(RecomendacionRecyclerView)
                            swipeRefreshRecomendacion1.isRefreshing = false
                        }
                        listRecomendacion.clear()
                        setupRecyclerViewRecomendacion(RecomendacionRecyclerView)
                    }
                }
                false -> {
                    val Archivo4 = "Catalogo"
                    val defaultPrefs4 = Splash.PreferenceHelper4.defaultPreference4(this)
                    defaultPrefs4.dato1 = 0
                    defaultPrefs4.dato2 = 0
                    defaultPrefs4.dato3 = 0
                    val prefs4 = Splash.PreferenceHelper4.customPreference4(this, Archivo4)
                    wiffaa.setBackgroundResource(R.drawable.wifis)
                    if (prefs4.dato2 == 0) {
                        productod.visibility = View.VISIBLE
                        Recomendad.visibility = View.GONE
                        cond.visibility = View.VISIBLE
                        productosP.visibility = View.GONE
                        productosR.visibility = View.GONE
                    } else if (prefs4.dato2 == 1) {
                        productod.visibility = View.GONE
                        Recomendad.visibility = View.VISIBLE
                        cond.visibility = View.VISIBLE
                        productosP.visibility = View.GONE
                        productosR.visibility = View.GONE
                    }
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

    override fun onBackPressed() {
        if (drawerPS2.isDrawerOpen(GravityCompat.START)) {
            drawerPS2.closeDrawer(GravityCompat.START)
        } else {
                   val Archivo4 = "Catalogo"
            val defaultPrefs4 = Splash.PreferenceHelper4.defaultPreference4(this)
            defaultPrefs4.dato1 = 0
            defaultPrefs4.dato2 = 0
            defaultPrefs4.dato3 = 0
            val prefs4 = Splash.PreferenceHelper4.customPreference4(this, Archivo4)
            prefs4.dato2 = 0
            mediaPlayer!!.stop()
            startActivity(Intent(this@ProdRec, MenuCatalogo::class.java))
            Bungee.zoom(this@ProdRec)
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            android.R.id.home -> {
                drawerPS2.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}