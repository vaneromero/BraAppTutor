package com.bp.braapptutor.games.record

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
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bp.braapptutor.R
import com.bp.braapptutor.adaptadores.ClickListener
import com.bp.braapptutor.adaptadores.adaptadorA
import com.bp.braapptutor.catalogo.MenuCatalogo
import com.bp.braapptutor.catalogo.similares.Propio
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
import com.google.firebase.auth.FirebaseAuthProvider
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_avisp.*
import kotlinx.android.synthetic.main.activity_avisp.tituloAviso
import kotlinx.android.synthetic.main.activity_cerrarchat.*
import kotlinx.android.synthetic.main.activity_cerrarchat1.*
import kotlinx.android.synthetic.main.activity_menu_juegos.*
import kotlinx.android.synthetic.main.activity_produc.*
import kotlinx.android.synthetic.main.activity_record_mundial.*
import kotlinx.android.synthetic.main.datos_jugador.*
import kotlinx.android.synthetic.main.general.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.io.IOException

class RecordMundial : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private var mAuth: FirebaseAuth? = null
    var listGlobal = ArrayList<DatosUsuario1>()
    var listAddi1 = ArrayList<DatosUsuario6>()
    var listAddi2 = ArrayList<DatosUsuario7>()
    var listAddi3 = ArrayList<DatosUsuario8>()
    var listAddi4 = ArrayList<DatosUsuario9>()
    var listAddi5 = ArrayList<DatosUsuario10>()
    var listMemo1 = ArrayList<DatosUsuario2>()
    var listMemo2 = ArrayList<DatosUsuario3>()
    var listMemo3 = ArrayList<DatosUsuario4>()
    var listMemo4 = ArrayList<DatosUsuario5>()

    var ReciclRE: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var adaptador1: AdaptadorRecord0? = null
    var adaptador2: AdaptadorRecord1? = null
    var adaptador3: AdaptadorRecord2? = null
    var adaptador4: AdaptadorRecord3? = null
    var adaptador5: AdaptadorRecord4? = null
    var adaptador6: AdaptadorRecord5? = null
    var adaptador7: AdaptadorRecord6? = null
    var adaptador8: AdaptadorRecord7? = null
    var adaptador9: AdaptadorRecord8? = null
    var adaptador0: AdaptadorRecord9? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_mundial)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        val Archivo = "Usuario"
        val defaultPrefs2 = Splash.PreferenceHelper.defaultPreference(this)
        defaultPrefs2.password = "Admin"
        defaultPrefs2.userId = 0
        val prefs2 = Splash.PreferenceHelper.customPreference(this, Archivo)
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
        val texto2: LinearLayout = findViewById(R.id.records)
        //Asignacioón de las animaciones
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto2.startAnimation(anim1)
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
        val dat = prefs.contadorE
        if (prefs.contadorV == 0) {
            if (dat == 1) {
                Log.v("emergente", "entro")
                val customDialog1 = Dialog(this)
                customDialog1.setContentView(R.layout.datos_jugador)
                customDialog1.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                customDialog1.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                customDialog1.setCancelable(false)
                when {
                    prefs.foto == 0 -> {
                        customDialog1.imagen.setBackgroundResource(R.drawable.nina)
                    }
                    prefs.foto == 1 -> {
                        customDialog1.imagen.setBackgroundResource(R.drawable.nino)
                    }
                    prefs.foto == 2 -> {
                        customDialog1.imagen.setBackgroundResource(R.drawable.jovena)
                    }
                    prefs.foto == 3 -> {
                        customDialog1.imagen.setBackgroundResource(R.drawable.joveno)
                    }
                    prefs.foto == 4 -> {
                        customDialog1.imagen.setBackgroundResource(R.drawable.adulta)
                    }
                    prefs.foto == 5 -> {
                        customDialog1.imagen.setBackgroundResource(R.drawable.adulto)
                    }
                    prefs.foto == 6 -> {
                        customDialog1.imagen.setBackgroundResource(R.drawable.abuelo)
                    }
                    prefs.foto == 7 -> {
                        customDialog1.imagen.setBackgroundResource(R.drawable.abuela)
                    }
                    prefs.foto == 8 -> {
                        customDialog1.imagen.setBackgroundResource(R.drawable.indefinido)
                    }
                }
                customDialog1.tituloUs.setText(prefs.nombreUs)
                customDialog1.dCorreo.setText("Correo: " + prefs.correo)
                val yesBtn = customDialog1.findViewById<Button>(R.id.yes_opt9) as TextView
                val noBtn = customDialog1.findViewById<Button>(R.id.no_opt9) as TextView

                yesBtn.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    prefs.contadorE = 0
                    Log.v("revisando", " " + prefs.contadorE)

                    db.collection("Records").whereEqualTo("correo", prefs.correo)
                        .get()
                        .addOnSuccessListener { result ->
                            for (document in result) {
                                db.collection("Records").document("${document.id}")
                                    .update("usuario", prefs2.password)
                                db.collection("Records").document("${document.id}")
                                    .update("foto", prefs2.userId)
                            }
                        }
                    prefs.contadorV = 1
                    customDialog1.dismiss()
                }
                noBtn.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    val CUSTOM_PREF_NAME1 = "Record1"
                    val defaultPrefs1 = MenuJuegos.PreferenceHelper1.defaultPreference1(this)
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
                    val Prefs1 =
                        MenuJuegos.PreferenceHelper1.customPreference1(this, CUSTOM_PREF_NAME1)
                    prefs.contadorE = Prefs1.contadorE1
                    prefs.correo = Prefs1.correo1
                    prefs.nombreUs = Prefs1.nombreUs1
                    prefs.idUsuario = Prefs1.idUsuario1
                    prefs.foto = Prefs1.foto1
                    prefs.rnuma = Prefs1.rnuma1
                    prefs.rminM = Prefs1.rminM1
                    prefs.rmayM = Prefs1.rmayM1
                    prefs.rnumM = Prefs1.rnumM1
                    prefs.rsimM = Prefs1.rsimM1
                    prefs.rminsim = Prefs1.rminsim1
                    prefs.rminsimb = Prefs1.rminsimb1
                    prefs.rmaya = Prefs1.rmaya1
                    prefs.rmaynum = Prefs1.rmaynum1

                    startActivity(Intent(this@RecordMundial, MenuJuegos::class.java))
                    Bungee.zoom(this@RecordMundial)
                    customDialog1.dismiss()
                    onBackPressed()
                }
                customDialog1.show()
            }
            else {
                val correo = prefs.correo
                val nombreUs = prefs2.password
                val foto = prefs2.userId
                val memoMin = prefs.rminM
                val memoMay = prefs.rmayM
                val memoNum = prefs.rnumM
                val memoSim = prefs.rsimM
                val adivMinSim = prefs.rminsim
                val adivMayA = prefs.rmaya
                val adivMayNum = prefs.rmaynum
                val adivNumA = prefs.rnuma
                val usus=""
                val adivMinSimB = prefs.rminsimb
                val SumaL =
                    (adivMayNum + memoMay + adivMayA + adivMinSim + adivMinSimB + memoMin + memoNum + adivNumA + memoSim)
                val user = hashMapOf(
                    "correo" to correo,
                    "foto" to foto,
                    "maynum" to adivMayNum,
                    "mayusculas" to memoMay,
                    "mayusculasA" to adivMayA,
                    "minsim" to adivMinSim,
                    "minsimB" to adivMinSimB,
                    "minusculas" to memoMin,
                    "numeros" to memoNum,
                    "numerosA" to adivNumA,
                    "simbolos" to memoSim,
                    "usuario" to nombreUs,
                    "puntaje" to SumaL,
                    "uid" to usus,
                )
                db.collection("Records")
                    .add(user)
                    .addOnSuccessListener { documentReference ->
                        prefs.contadorE = 0
                        prefs.contadorV = 1
                        toast("Perfil creado")
                        db.collection("Records").whereEqualTo("correo", prefs.correo)
                            .get()
                            .addOnSuccessListener { result ->
                                for (document in result) {
                                    Log.v("Prueba","${document.id}")

                                    db.collection("Records")
                                        .document("${document.id}").update("uid","${document.id}")

                                }
                            }
                    }
                    .addOnFailureListener { e ->
                        toast("Error al guardar")

                    }

            }

        }


        if (prefs.contadorV == 1) {
            db.collection("Records").whereEqualTo("correo", prefs.correo)
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.v(
                            "Actualizado",
                            " " + prefs.rminM.toString() + ">" + document.get("minusculas")
                                .toString()
                        )
                        if (prefs.rminM > "${document.get("minusculas")}".toInt()) {
                            db.collection("Records").document("${document.id}")
                                .update("minusculas", prefs.rminM)
                        }
                        if (prefs.rmaynum > "${document.get("maynum")}".toInt()) {
                            db.collection("Records").document("${document.id}")
                                .update("maynum", prefs.rmaynum)
                        }
                        if (prefs.rmayM > "${document.get("mayusculas")}".toInt()) {
                            db.collection("Records").document("${document.id}")
                                .update("mayusculas", prefs.rmayM)
                        }
                        if (prefs.rmaya > "${document.get("mayusculasA")}".toInt()) {
                            db.collection("Records").document("${document.id}")
                                .update("mayusculasA", prefs.rmaya)
                        }
                        if (prefs.rminsim > "${document.get("minsim")}".toInt()) {
                            db.collection("Records").document("${document.id}")
                                .update("minsim", prefs.rminsim)
                            Log.v("Actualizado", "minsim " + prefs.rminsim)
                        }
                        if (prefs.rminsimb > "${document.get("minsimB")}".toInt()) {
                            db.collection("Records").document("${document.id}")
                                .update("minsimB", prefs.rminsimb)
                        }

                        if (prefs.rnumM > "${document.get("numeros")}".toInt()) {
                            db.collection("Records").document("${document.id}")
                                .update("numeros", prefs.rnumM)
                        }
                        if (prefs.rnuma > "${document.get("numerosA")}".toInt()) {
                            db.collection("Records").document("${document.id}")
                                .update("numerosA", prefs.rnuma)
                        }
                        if (prefs.rsimM > "${document.get("simbolos")}".toInt()) {
                            db.collection("Records").document("${document.id}")
                                .update("simbolos", prefs.rsimM)
                        }
                        db.collection("Records").document("${document.id}")
                            .update("usuario", prefs2.password)
                        db.collection("Records").document("${document.id}")
                            .update("foto", prefs2.userId)
                        val sum =
                            prefs.rminM + prefs.rmaynum + prefs.rmayM + prefs.rmaya + prefs.rminsim + prefs.rminsimb + prefs.rnumM + prefs.rnuma + prefs.rsimM
                        db.collection("Records").document("${document.id}")
                            .update(
                                "foto", prefs2.userId,
                                "usuario", prefs2.password,
                                "puntaje", sum
                            )

                        toast("Datos Actualizados")
                    }
                }
        }
        val foto2 = prefs2.userId.toString()
        userj4.text = prefs2.password
        when {
            foto2.toInt() == 0 -> {
                fotoj4.setBackgroundResource(R.drawable.nina)
            }
            foto2.toInt() == 1 -> {
                fotoj4.setBackgroundResource(R.drawable.nino)
            }
            foto2.toInt() == 2 -> {
                fotoj4.setBackgroundResource(R.drawable.jovena)
            }
            foto2.toInt() == 3 -> {
                fotoj4.setBackgroundResource(R.drawable.joveno)
            }
            foto2.toInt() == 4 -> {
                fotoj4.setBackgroundResource(R.drawable.adulta)
            }
            foto2.toInt() == 5 -> {
                fotoj4.setBackgroundResource(R.drawable.adulto)
            }
            foto2.toInt() == 6 -> {
                fotoj4.setBackgroundResource(R.drawable.abuelo)
            }
            foto2.toInt() == 7 -> {
                fotoj4.setBackgroundResource(R.drawable.abuela)
            }
            foto2.toInt() == 8 -> {
                fotoj4.setBackgroundResource(R.drawable.indefinido)
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
        setSupportActionBar(findViewById(R.id.toolbarRe))
        navigation_viewRe.addOnLayoutChangeListener { view, i, i2, i3, i4, i5, i6, i7, i8 ->
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
                        startActivity(Intent(this@RecordMundial, Usuarios::class.java))
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
        navigation_viewRe.setNavigationItemSelectedListener {
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
                    drawerRe.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuPrin::class.java))

                    Bungee.zoom(this)
                    true
                }
                R.id.dos2 -> {
                    drawerRe.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, materialapoyo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.tres3 -> {
                    drawerRe.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Red::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cuatro4 -> {
                    drawerRe.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuJuegos::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.cinco5 -> {
                    drawerRe.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, historia::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.seis6 -> {
                    drawerRe.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Extras::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.siete7 -> {
                    drawerRe.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, MenuCatalogo::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.ocho8 -> {
                    drawerRe.closeDrawer(GravityCompat.START)
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    startActivity(Intent(this, Traductores::class.java))
                    Bungee.zoom(this)
                    true
                }
                R.id.nueve9 -> {
                    drawerRe.closeDrawer(GravityCompat.START)

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
        val drawerToggle = ActionBarDrawerToggle(this, drawerRe, R.string.open, R.string.close)
        drawerRe.addDrawerListener(drawerToggle)
        drawerToggle.drawerArrowDrawable.color = Color.BLACK
        drawerToggle.drawerArrowDrawable.gapSize = 30.0f
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation_viewRe.setItemIconTintList(null);
        val CUSTOM_PREF_NAME1 = "Record1"
        val defaultPrefs4 = MenuJuegos.PreferenceHelper1.defaultPreference1(this)
        defaultPrefs4.recodd = 0
        val Prefs1 = MenuJuegos.PreferenceHelper1.customPreference1(this, CUSTOM_PREF_NAME1)
        Prefs1.recodd = 2
        inicializar()
        puntajpo.visibility = View.VISIBLE
        ima1.setBackgroundResource(R.drawable.mund)
        text1.setText("Global")
        listGlobal.clear()
        setupRecyclerView9("puntaje")
        refrescaRe.setOnRefreshListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            listGlobal.clear()
            setupRecyclerView9("puntaje")
            refrescaRe.isRefreshing = false
        }

        memo.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            Prefs1.recodd = 0
            inicializar()
            puntajpo.visibility = View.GONE
        }
        adiv.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            Prefs1.recodd = 1
            inicializar()
            puntajpo.visibility = View.GONE
        }
        mund.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            Prefs1.recodd = 2
            inicializar()
            puntajpo.visibility = View.VISIBLE
            ima1.setBackgroundResource(R.drawable.mund)
            text1.setText("Global")
            listGlobal.clear()
            setupRecyclerView9("puntaje")
            refrescaRe.setOnRefreshListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                listGlobal.clear()
                setupRecyclerView9("puntaje")
                refrescaRe.isRefreshing = false
            }
        }
       linearLayout17.setOnClickListener {
            val Archivo1 = "Audio"
            val prefs1 = Splash.PreferenceHelper1.customPreference1(
                applicationContext,
                Archivo1
            )
            val CUSTOM_PREF_NAME = "Record"

            val prefs = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)
            var carga = prefs1.tono
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val customDialog = Dialog(this@RecordMundial)
            customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            customDialog.setContentView(R.layout.general)
            customDialog.window?.setLayout(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            db.collection("Records")
                .whereEqualTo("correo", prefs.correo)
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        val foto2 = "${document.get("foto")}"
                        when {
                            foto2.toInt() == 0 -> {
                                customDialog.fotoP.setBackgroundResource(R.drawable.nina)
                            }
                            foto2.toInt() == 1 -> {
                                customDialog.fotoP.setBackgroundResource(R.drawable.nino)
                            }
                            foto2.toInt() == 2 -> {
                                customDialog.fotoP.setBackgroundResource(R.drawable.jovena)
                            }
                            foto2.toInt() == 3 -> {
                                customDialog.fotoP.setBackgroundResource(R.drawable.joveno)
                            }
                            foto2.toInt() == 4 -> {
                                customDialog.fotoP.setBackgroundResource(R.drawable.adulta)
                            }
                            foto2.toInt() == 5 -> {
                                customDialog.fotoP.setBackgroundResource(R.drawable.adulto)
                            }
                            foto2.toInt() == 6 -> {
                                customDialog.fotoP.setBackgroundResource(R.drawable.abuelo)
                            }
                            foto2.toInt() == 7 -> {
                                customDialog.fotoP.setBackgroundResource(R.drawable.abuela)
                            }
                            foto2.toInt() == 8 -> {
                                customDialog.fotoP.setBackgroundResource(R.drawable.indefinido)
                            }
                        }
                        customDialog.Usuario.text = "${document.get("usuario")}"
                        val datos = "${document.get("puntaje")}"
                        val datos1 = "${document.get("minusculas")}"
                        val datos2 = "${document.get("mayusculas")}"
                        val datos3 = "${document.get("numeros")}"
                        val datos4 = "${document.get("simbolos")}"
                        val datos5 = "${document.get("minsim")}"
                        val datos6 = "${document.get("maynum")}"
                        val datos7 = "${document.get("minsimB")}"
                        val datos8 = "${document.get("mayusculasA")}"
                        val datos9 = "${document.get("numerosA")}"

                        when {
                            datos.length >= 5 -> {
                                val uno = datos.substring(0, 2)
                                val dos = datos.substring(2, 3)
                                customDialog.juego10.text = "$uno.${dos}k pts"
                            }
                            datos.length < 5 -> {
                                customDialog.juego10.text = "${datos} pts"
                            }
                        }
                        when {
                            datos1.length >= 5 -> {
                                val uno = datos1.substring(0, 2)
                                val dos = datos1.substring(2, 3)
                                customDialog.juego1.text = "$uno.${dos}k pts"
                            }
                            datos1.length < 5 -> {
                                customDialog.juego1.text = "${datos1} pts"
                            }
                        }
                        when {
                            datos2.length >= 5 -> {
                                val uno = datos2.substring(0, 2)
                                val dos = datos2.substring(2, 3)
                                customDialog.juego2.text = "$uno.${dos}k pts"
                            }
                            datos2.length < 5 -> {
                                customDialog.juego2.text = "${datos2} pts"
                            }
                        }
                        when {
                            datos3.length >= 5 -> {
                                val uno = datos3.substring(0, 2)
                                val dos = datos3.substring(2, 3)
                                customDialog.juego3.text = "$uno.${dos}k pts"
                            }
                            datos3.length < 5 -> {
                                customDialog.juego3.text = "${datos3} pts"
                            }
                        }
                        when {
                            datos4.length >= 5 -> {
                                val uno = datos4.substring(0, 2)
                                val dos = datos4.substring(2, 3)
                                customDialog.juego4.text = "$uno.${dos}k pts"
                            }
                            datos4.length < 5 -> {
                                customDialog.juego4.text = "${datos4} pts"
                            }
                        }
                        when {
                            datos5.length >= 5 -> {
                                val uno = datos5.substring(0, 2)
                                val dos = datos5.substring(2, 3)
                                customDialog.juego5.text = "$uno.${dos}k pts"
                            }
                            datos5.length < 5 -> {
                                customDialog.juego5.text = "${datos5} pts"
                            }
                        }
                        when {
                            datos6.length >= 5 -> {
                                val uno = datos6.substring(0, 2)
                                val dos = datos6.substring(2, 3)
                                customDialog.juego6.text = "$uno.${dos}k pts"
                            }
                            datos6.length < 5 -> {
                                customDialog.juego6.text = "${datos6} pts"
                            }
                        }
                        when {
                            datos7.length >= 5 -> {
                                val uno = datos7.substring(0, 2)
                                val dos = datos7.substring(2, 3)
                                customDialog.juego7.text = "$uno.${dos}k pts"
                            }
                            datos7.length < 5 -> {
                                customDialog.juego7.text = "${datos7} pts"
                            }
                        }
                        when {
                            datos8.length >= 5 -> {
                                val uno = datos8.substring(0, 2)
                                val dos = datos8.substring(2, 3)
                                customDialog.juego8.text = "$uno.${dos}k pts"
                            }
                            datos8.length < 5 -> {
                                customDialog.juego8.text = "${datos8} pts"
                            }
                        }
                        when {
                            datos9.length >= 5 -> {
                                val uno = datos9.substring(0, 2)
                                val dos = datos9.substring(2, 3)
                                customDialog.juego9.text = "$uno.${dos}k pts"
                            }
                            datos9.length < 5 -> {
                                customDialog.juego9.text = "${datos9} pts"
                            }
                        }


                    }

                }
            customDialog.show()

        }
        jue1.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            puntajpo.visibility = View.VISIBLE
            ima1.setBackgroundResource(R.drawable.memo)
            text1.setText("Memorama 1")

            listMemo1.clear()
            setupRecyclerView0("minusculas")
            refrescaRe.visibility = View.VISIBLE
            refrescaRe.setOnRefreshListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                listMemo1.clear()
                setupRecyclerView0("minusculas")
                refrescaRe.isRefreshing = false
            }
        }
        jue2.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            puntajpo.visibility = View.VISIBLE
            ima1.setBackgroundResource(R.drawable.memo)
            text1.setText("Memorama 2")
            listMemo2.clear()
            setupRecyclerView1("mayusculas")
            refrescaRe.visibility = View.VISIBLE
            refrescaRe.setOnRefreshListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                listMemo2.clear()
                setupRecyclerView1("mayusculas")
                refrescaRe.isRefreshing = false
            }
        }
        jue3.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            puntajpo.visibility = View.VISIBLE
            ima1.setBackgroundResource(R.drawable.memo)
            text1.setText("Memorama 3")
            listMemo3.clear()
            setupRecyclerView2("numeros")
            refrescaRe.visibility = View.VISIBLE
            refrescaRe.setOnRefreshListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                listMemo3.clear()
                setupRecyclerView2("numeros")
                refrescaRe.isRefreshing = false
            }
        }
        jue4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            puntajpo.visibility = View.VISIBLE
            ima1.setBackgroundResource(R.drawable.memo)
            text1.setText("Memorama 4")
            listMemo4.clear()
            setupRecyclerView3("simbolos")
            refrescaRe.visibility = View.VISIBLE
            refrescaRe.setOnRefreshListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                listMemo4.clear()
                setupRecyclerView3("simbolos")
                refrescaRe.isRefreshing = false
            }
        }
        jue5.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            puntajpo.visibility = View.VISIBLE
            ima1.setBackgroundResource(R.drawable.adiv)
            text1.setText("Adivinanza 1")
            listAddi1.clear()
            setupRecyclerView4("minsim")
            refrescaRe.visibility = View.VISIBLE
            refrescaRe.setOnRefreshListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                listAddi1.clear()
                setupRecyclerView4("minsim")
                refrescaRe.isRefreshing = false
            }
        }
        jue6.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            puntajpo.visibility = View.VISIBLE
            ima1.setBackgroundResource(R.drawable.adiv)
            text1.setText("Adivinanza 2")
            listAddi2.clear()
            setupRecyclerView5("maynum")
            refrescaRe.visibility = View.VISIBLE
            refrescaRe.setOnRefreshListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                listAddi2.clear()
                setupRecyclerView5("maynum")
                refrescaRe.isRefreshing = false
            }
        }
        jue7.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            puntajpo.visibility = View.VISIBLE
            ima1.setBackgroundResource(R.drawable.adiv)
            text1.setText("Adivinanza 3")
            listAddi3.clear()
            setupRecyclerView6("minsimB")
            refrescaRe.visibility = View.VISIBLE
            refrescaRe.setOnRefreshListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                listAddi3.clear()
                setupRecyclerView6("minsimB")
                refrescaRe.isRefreshing = false
            }
        }
        jue8.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            puntajpo.visibility = View.VISIBLE
            ima1.setBackgroundResource(R.drawable.adiv)
            text1.setText("Adivinanza 4")
            listAddi4.clear()
            setupRecyclerView7("mayusculasA")
            refrescaRe.visibility = View.VISIBLE
            refrescaRe.setOnRefreshListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                listAddi4.clear()
                setupRecyclerView7("mayusculasA")
                refrescaRe.isRefreshing = false
            }
        }
        jue9.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            puntajpo.visibility = View.VISIBLE
            ima1.setBackgroundResource(R.drawable.adiv)
            text1.setText("Adivinanza 5")
            listAddi5.clear()
            setupRecyclerView8("numerosA")
            refrescaRe.visibility = View.VISIBLE
            refrescaRe.setOnRefreshListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                listAddi5.clear()
                setupRecyclerView8("numerosA")
                refrescaRe.isRefreshing = false
            }
        }
        jue10.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            puntajpo.visibility = View.VISIBLE
            ima1.setBackgroundResource(R.drawable.mund)
            text1.setText("Global")
            listGlobal.clear()
            setupRecyclerView9("puntaje")
            refrescaRe.setOnRefreshListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                listGlobal.clear()
                setupRecyclerView9("puntaje")
                refrescaRe.isRefreshing = false
            }
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
        if (drawerRe.isDrawerOpen(GravityCompat.START)) {
            drawerRe.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
            startActivity(Intent(this, MenuJuegos::class.java))
            finish()
        }
    }

    fun inicializar() {
        val CUSTOM_PREF_NAME1 = "Record1"
        val defaultPrefs4 = MenuJuegos.PreferenceHelper1.defaultPreference1(this)
        defaultPrefs4.recodd = 0
        val Prefs1 = MenuJuegos.PreferenceHelper1.customPreference1(this, CUSTOM_PREF_NAME1)
        when (Prefs1.recodd) {
            0 -> {
                titulai.setBackgroundResource(R.drawable.memo)
                titulat.setText("Memorama")
                adi1.visibility = View.GONE
                jue10.visibility = View.GONE
                puntajpo.visibility = View.GONE
                refrescaRe.visibility = View.GONE
                memo1.visibility = View.VISIBLE
                limpiar()
            }
            1 -> {
                titulai.setBackgroundResource(R.drawable.adiv)
                titulat.setText("Adivinanzas")
                memo1.visibility = View.GONE
                adi1.visibility = View.VISIBLE
                jue10.visibility = View.GONE
                puntajpo.visibility = View.GONE
                refrescaRe.visibility = View.GONE
                limpiar()
            }
            2 -> {
                titulai.setBackgroundResource(R.drawable.mund)
                titulat.setText("Global")
                memo1.visibility = View.GONE
                adi1.visibility = View.GONE
                jue10.visibility = View.VISIBLE
                puntajpo.visibility = View.VISIBLE
                refrescaRe.visibility = View.VISIBLE
            }
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            android.R.id.home -> {
                drawerRe.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    @SuppressLint("WrongConstant")
    fun setupRecyclerView9(consulta: String) {
        val CUSTOM_PREF_NAME = "Record"
        val defaultPrefs = MenuJuegos.PreferenceHelper.defaultPreference(this)
        defaultPrefs.correo = ""
        val prefs = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)

        listGlobal.clear()
        db.collection("Records").whereEqualTo("correo", prefs.correo).get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val datos = (document.get("$consulta")).toString()
                    when {
                        datos.length >= 5 -> {
                            val uno = datos.substring(0, 2)
                            val dos = datos.substring(2, 3)
                            puntaaa.text = "$uno.${dos}k pts"
                        }
                        datos.length < 5 -> {
                            puntaaa.text = "${datos} pts"
                        }
                    }


                }
            }
        //carga
        db.collection("Records").orderBy(consulta, Query.Direction.DESCENDING).limit(10)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {

                    listGlobal.add(
                        DatosUsuario1(
                            "${document.get("usuario")}",
                            "${document.get("foto")}",
                            "${document.get("puntaje")}"
                        )
                    )

                }
                ReciclRE?.setHasFixedSize(true)  //adaptador tamaño de la vista
                ReciclRE = findViewById(R.id.ReciclRE)
                layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                ReciclRE?.layoutManager = layoutManager  // donde se dibuje el layout
                adaptador0 = AdaptadorRecord9(this, listGlobal)
                ReciclRE?.adapter = adaptador0

            }

    }

    @SuppressLint("WrongConstant")
    fun setupRecyclerView0(consulta: String) {
        val CUSTOM_PREF_NAME = "Record"
        val defaultPrefs = MenuJuegos.PreferenceHelper.defaultPreference(this)
        defaultPrefs.correo = ""
        val prefs = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)

        listMemo1.clear()
        db.collection("Records").whereEqualTo("correo", prefs.correo).get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val datos = (document.get("$consulta")).toString()
                    when {
                        datos.length >= 5 -> {
                            val uno = datos.substring(0, 2)
                            val dos = datos.substring(2, 3)
                            puntaaa.text = "$uno.${dos}k pts"
                        }
                        datos.length < 5 -> {
                            puntaaa.text = "${datos} pts"
                        }
                    }


                }
            }
        //carga
        db.collection("Records").orderBy(consulta, Query.Direction.DESCENDING).limit(10)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {

                    listMemo1.add(
                        DatosUsuario2(
                            "${document.get("usuario")}",
                            "${document.get("foto")}",
                            "${document.get("minusculas")}"
                        )
                    )

                }
                ReciclRE?.setHasFixedSize(true)  //adaptador tamaño de la vista
                ReciclRE = findViewById(R.id.ReciclRE)
                layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                ReciclRE?.layoutManager = layoutManager  // donde se dibuje el layout
                adaptador1 = AdaptadorRecord0(this, listMemo1)
                ReciclRE?.adapter = adaptador1

            }

    }

    @SuppressLint("WrongConstant")
    fun setupRecyclerView1(consulta: String) {
        val CUSTOM_PREF_NAME = "Record"
        val defaultPrefs = MenuJuegos.PreferenceHelper.defaultPreference(this)
        defaultPrefs.correo = ""
        val prefs = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)

        listMemo2.clear()
        db.collection("Records").whereEqualTo("correo", prefs.correo).get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val datos = (document.get("$consulta")).toString()
                    when {
                        datos.length >= 5 -> {
                            val uno = datos.substring(0, 2)
                            val dos = datos.substring(2, 3)
                            puntaaa.text = "$uno.${dos}k pts"
                        }
                        datos.length < 5 -> {
                            puntaaa.text = "${datos} pts"
                        }
                    }


                }
            }
        //carga
        db.collection("Records").orderBy(consulta, Query.Direction.DESCENDING).limit(10)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    listMemo2.add(
                        DatosUsuario3(
                            "${document.get("usuario")}",
                            "${document.get("foto")}",
                            "${document.get("mayusculas")}",
                        )
                    )

                }
                ReciclRE?.setHasFixedSize(true)  //adaptador tamaño de la vista
                ReciclRE = findViewById(R.id.ReciclRE)
                layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                ReciclRE?.layoutManager = layoutManager  // donde se dibuje el layout
                adaptador2 = AdaptadorRecord1(this, listMemo2)
                ReciclRE?.adapter = adaptador2

            }

    }

    @SuppressLint("WrongConstant")
    fun setupRecyclerView2(consulta: String) {
        val CUSTOM_PREF_NAME = "Record"
        val defaultPrefs = MenuJuegos.PreferenceHelper.defaultPreference(this)
        defaultPrefs.correo = ""
        val prefs = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)

        listMemo3.clear()
        db.collection("Records").whereEqualTo("correo", prefs.correo).get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val datos = (document.get("$consulta")).toString()
                    when {
                        datos.length >= 5 -> {
                            val uno = datos.substring(0, 2)
                            val dos = datos.substring(2, 3)
                            puntaaa.text = "$uno.${dos}k pts"
                        }
                        datos.length < 5 -> {
                            puntaaa.text = "${datos} pts"
                        }
                    }


                }
            }
        //carga
        db.collection("Records").orderBy(consulta, Query.Direction.DESCENDING).limit(10)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    listMemo3.add(
                        DatosUsuario4(
                            "${document.get("usuario")}",
                            "${document.get("foto")}",
                            "${document.get("numeros")}"
                        )
                    )
                }
                ReciclRE?.setHasFixedSize(true)  //adaptador tamaño de la vista
                ReciclRE = findViewById(R.id.ReciclRE)
                layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                ReciclRE?.layoutManager = layoutManager  // donde se dibuje el layout
                adaptador3 = AdaptadorRecord2(this, listMemo3)
                ReciclRE?.adapter = adaptador3

            }

    }

    @SuppressLint("WrongConstant")
    fun setupRecyclerView3(consulta: String) {
        val CUSTOM_PREF_NAME = "Record"
        val defaultPrefs = MenuJuegos.PreferenceHelper.defaultPreference(this)
        defaultPrefs.correo = ""
        val prefs = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)

        listMemo4.clear()
        db.collection("Records").whereEqualTo("correo", prefs.correo).get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val datos = (document.get("$consulta")).toString()
                    when {
                        datos.length >= 5 -> {
                            val uno = datos.substring(0, 2)
                            val dos = datos.substring(2, 3)
                            puntaaa.text = "$uno.${dos}k pts"
                        }
                        datos.length < 5 -> {
                            puntaaa.text = "${datos} pts"
                        }
                    }


                }
            }
        //carga
        db.collection("Records").orderBy(consulta, Query.Direction.DESCENDING).limit(10)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    listMemo4.add(
                        DatosUsuario5(
                            "${document.get("usuario")}",
                            "${document.get("foto")}",
                            "${document.get("simbolos")}"
                        )
                    )
                }
                ReciclRE?.setHasFixedSize(true)  //adaptador tamaño de la vista
                ReciclRE = findViewById(R.id.ReciclRE)
                layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                ReciclRE?.layoutManager = layoutManager  // donde se dibuje el layout
                adaptador4 = AdaptadorRecord3(this, listMemo4)
                ReciclRE?.adapter = adaptador4

            }

    }

    @SuppressLint("WrongConstant")
    fun setupRecyclerView4(consulta: String) {
        val CUSTOM_PREF_NAME = "Record"
        val defaultPrefs = MenuJuegos.PreferenceHelper.defaultPreference(this)
        defaultPrefs.correo = ""
        val prefs = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)

        listAddi1.clear()
        db.collection("Records").whereEqualTo("correo", prefs.correo).get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val datos = (document.get("$consulta")).toString()
                    when {
                        datos.length >= 5 -> {
                            val uno = datos.substring(0, 2)
                            val dos = datos.substring(2, 3)
                            puntaaa.text = "$uno.${dos}k pts"
                        }
                        datos.length < 5 -> {
                            puntaaa.text = "${datos} pts"
                        }
                    }


                }
            }
        //carga
        db.collection("Records").orderBy(consulta, Query.Direction.DESCENDING).limit(10)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    listAddi1.add(
                        DatosUsuario6(
                            "${document.get("usuario")}",
                            "${document.get("foto")}",
                            "${document.get("minsim")}"
                        )
                    )
                }
                ReciclRE?.setHasFixedSize(true)  //adaptador tamaño de la vista
                ReciclRE = findViewById(R.id.ReciclRE)
                layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                ReciclRE?.layoutManager = layoutManager  // donde se dibuje el layout
                adaptador5 = AdaptadorRecord4(this, listAddi1)
                ReciclRE?.adapter = adaptador5

            }

    }

    @SuppressLint("WrongConstant")
    fun setupRecyclerView5(consulta: String) {
        val CUSTOM_PREF_NAME = "Record"
        val defaultPrefs = MenuJuegos.PreferenceHelper.defaultPreference(this)
        defaultPrefs.correo = ""
        val prefs = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)

        listAddi2.clear()
        db.collection("Records").whereEqualTo("correo", prefs.correo).get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val datos = (document.get("$consulta")).toString()
                    when {
                        datos.length >= 5 -> {
                            val uno = datos.substring(0, 2)
                            val dos = datos.substring(2, 3)
                            puntaaa.text = "$uno.${dos}k pts"
                        }
                        datos.length < 5 -> {
                            puntaaa.text = "${datos} pts"
                        }
                    }


                }
            }
        //carga
        db.collection("Records").orderBy(consulta, Query.Direction.DESCENDING).limit(10)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    listAddi2.add(
                        DatosUsuario7(
                            "${document.get("usuario")}",
                            "${document.get("foto")}",
                            "${document.get("mayusculasA")}"
                        )
                    )
                }
                ReciclRE?.setHasFixedSize(true)  //adaptador tamaño de la vista
                ReciclRE = findViewById(R.id.ReciclRE)
                layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                ReciclRE?.layoutManager = layoutManager  // donde se dibuje el layout
                adaptador6 = AdaptadorRecord5(this, listAddi2)
                ReciclRE?.adapter = adaptador6

            }

    }

    @SuppressLint("WrongConstant")
    fun setupRecyclerView6(consulta: String) {
        val CUSTOM_PREF_NAME = "Record"
        val defaultPrefs = MenuJuegos.PreferenceHelper.defaultPreference(this)
        defaultPrefs.correo = ""
        val prefs = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)

        listAddi3.clear()
        db.collection("Records").whereEqualTo("correo", prefs.correo).get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val datos = (document.get("$consulta")).toString()
                    when {
                        datos.length >= 5 -> {
                            val uno = datos.substring(0, 2)
                            val dos = datos.substring(2, 3)
                            puntaaa.text = "$uno.${dos}k pts"
                        }
                        datos.length < 5 -> {
                            puntaaa.text = "${datos} pts"
                        }
                    }


                }
            }
        //carga
        db.collection("Records").orderBy(consulta, Query.Direction.DESCENDING).limit(10)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    listAddi3.add(
                        DatosUsuario8(
                            "${document.get("usuario")}",
                            "${document.get("foto")}",
                            "${document.get("maynum")}"
                        )
                    )
                }
                ReciclRE?.setHasFixedSize(true)  //adaptador tamaño de la vista
                ReciclRE = findViewById(R.id.ReciclRE)
                layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                ReciclRE?.layoutManager = layoutManager  // donde se dibuje el layout
                adaptador7 = AdaptadorRecord6(this, listAddi3)
                ReciclRE?.adapter = adaptador7

            }

    }

    @SuppressLint("WrongConstant")
    fun setupRecyclerView7(consulta: String) {
        val CUSTOM_PREF_NAME = "Record"
        val defaultPrefs = MenuJuegos.PreferenceHelper.defaultPreference(this)
        defaultPrefs.correo = ""
        val prefs = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)

        listAddi4.clear()
        db.collection("Records").whereEqualTo("correo", prefs.correo).get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val datos = (document.get("$consulta")).toString()
                    when {
                        datos.length >= 5 -> {
                            val uno = datos.substring(0, 2)
                            val dos = datos.substring(2, 3)
                            puntaaa.text = "$uno.${dos}k pts"
                        }
                        datos.length < 5 -> {
                            puntaaa.text = "${datos} pts"
                        }
                    }


                }
            }
        //carga
        db.collection("Records").orderBy(consulta, Query.Direction.DESCENDING).limit(10)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    listAddi4.add(
                        DatosUsuario9(
                            "${document.get("usuario")}",
                            "${document.get("foto")}",
                            "${document.get("numerosA")}"
                        )
                    )
                }
                ReciclRE?.setHasFixedSize(true)  //adaptador tamaño de la vista
                ReciclRE = findViewById(R.id.ReciclRE)
                layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                ReciclRE?.layoutManager = layoutManager  // donde se dibuje el layout
                adaptador8 = AdaptadorRecord7(this, listAddi4)
                ReciclRE?.adapter = adaptador8

            }

    }

    @SuppressLint("WrongConstant")
    fun setupRecyclerView8(consulta: String) {
        val CUSTOM_PREF_NAME = "Record"
        val defaultPrefs = MenuJuegos.PreferenceHelper.defaultPreference(this)
        defaultPrefs.correo = ""
        val prefs = MenuJuegos.PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)

        listAddi5.clear()
        db.collection("Records").whereEqualTo("correo", prefs.correo).get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val datos = (document.get("$consulta")).toString()
                    when {
                        datos.length >= 5 -> {
                            val uno = datos.substring(0, 2)
                            val dos = datos.substring(2, 3)
                            puntaaa.text = "$uno.${dos}k pts"
                        }
                        datos.length < 5 -> {
                            puntaaa.text = "${datos} pts"
                        }
                    }


                }
            }
        //carga
        db.collection("Records").orderBy(consulta, Query.Direction.DESCENDING).limit(10)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    listAddi5.add(
                        DatosUsuario10(
                            "${document.get("usuario")}",
                            "${document.get("foto")}",
                            "${document.get("minsimB")}"
                        )
                    )
                }
                ReciclRE?.setHasFixedSize(true)  //adaptador tamaño de la vista
                ReciclRE = findViewById(R.id.ReciclRE)
                layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                ReciclRE?.layoutManager = layoutManager  // donde se dibuje el layout
                adaptador9 = AdaptadorRecord8(this, listAddi5)
                ReciclRE?.adapter = adaptador9

            }

    }

    fun limpiar() {
        puntajpo.visibility = View.GONE
        refrescaRe.visibility = View.GONE
        puntaaa.text = ""
        text1.text = ""
    }
}