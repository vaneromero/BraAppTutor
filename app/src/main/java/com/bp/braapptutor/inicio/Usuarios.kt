package com.bp.braapptutor.inicio

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.bp.braapptutor.R
import com.bp.braapptutor.audio.Audio
import com.bp.braapptutor.ayuda.Ayuda
import com.bp.braapptutor.bienvenida.ViewInstructions
import com.bp.braapptutor.creditos.Creditoss
import com.bp.braapptutor.inicio.Splash.PreferenceHelper.password
import com.bp.braapptutor.inicio.Splash.PreferenceHelper.userId
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.activi
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.tono
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.volum
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.volum1
import kotlinx.android.synthetic.main.activity_usuarios.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee


class Usuarios : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuarios)
        val Archivo = "Usuario"
        val defaultPrefs = Splash.PreferenceHelper.defaultPreference(this)
        defaultPrefs.password = "Admin"
        defaultPrefs.userId = 0
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
        val texto1: LottieAnimationView = findViewById(R.id.Ayuda0)
        val texto2: LottieAnimationView = findViewById(R.id.Optiones)
        val texto3: ImageView = findViewById(R.id.image1)
        val texto4: LinearLayout = findViewById(R.id.cont1)
        val texto5: LottieAnimationView = findViewById(R.id.Creditossa)

        //Asignacioón de las animaciones
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto1.startAnimation(anim1)
        texto3.startAnimation(anim1)
        texto4.startAnimation(anim1)
        texto2.startAnimation(anim1)
        texto5.startAnimation(anim1)
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
        when (prefs.userId) {
            0 -> {
                textView101.setBackgroundResource(R.drawable.nina)
            }
            1 -> {
                textView101.setBackgroundResource(R.drawable.nino)
            }
            2 -> {
                textView101.setBackgroundResource(R.drawable.jovena)
            }
            3 -> {
                textView101.setBackgroundResource(R.drawable.joveno)
            }
            4 -> {

                textView101.setBackgroundResource(R.drawable.adulta)
            }
            5 -> {

                textView101.setBackgroundResource(R.drawable.adulto)
            }
            6 -> {

                textView101.setBackgroundResource(R.drawable.abuelo)
            }
            7 -> {
                textView101.setBackgroundResource(R.drawable.abuela)
            }
            8 -> {
                textView101.setBackgroundResource(R.drawable.indefinido)
            }
        }
        Creditossa.setOnClickListener {
            prefs1.activi = "CreU"
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, Creditoss::class.java))
            Bungee.zoom(this)
        }
        izqq1.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (prefs.userId == 0) {
                prefs.userId = 8
            } else {
                prefs.userId = prefs.userId - 1
            }
            when (prefs.userId) {
                0 -> {
                    textView101.setBackgroundResource(R.drawable.nina)
                }
                1 -> {
                    textView101.setBackgroundResource(R.drawable.nino)
                }
                2 -> {
                    textView101.setBackgroundResource(R.drawable.jovena)
                }
                3 -> {
                    textView101.setBackgroundResource(R.drawable.joveno)
                }
                4 -> {

                    textView101.setBackgroundResource(R.drawable.adulta)
                }
                5 -> {

                    textView101.setBackgroundResource(R.drawable.adulto)
                }
                6 -> {

                    textView101.setBackgroundResource(R.drawable.abuelo)
                }
                7 -> {
                    textView101.setBackgroundResource(R.drawable.abuela)
                }
                8 -> {
                    textView101.setBackgroundResource(R.drawable.indefinido)
                }
            }
        }
        deree1.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (prefs.userId == 8) {
                prefs.userId = 0
            } else {
                prefs.userId = prefs.userId + 1
            }
            when (prefs.userId) {
                0 -> {
                    textView101.setBackgroundResource(R.drawable.nina)
                }
                1 -> {
                    textView101.setBackgroundResource(R.drawable.nino)
                }
                2 -> {
                    textView101.setBackgroundResource(R.drawable.jovena)
                }
                3 -> {
                    textView101.setBackgroundResource(R.drawable.joveno)
                }
                4 -> {
                    textView101.setBackgroundResource(R.drawable.adulta)
                }
                5 -> {
                    textView101.setBackgroundResource(R.drawable.adulto)
                }
                6 -> {
                    textView101.setBackgroundResource(R.drawable.abuelo)
                }
                7 -> {
                    textView101.setBackgroundResource(R.drawable.abuela)
                }
                8 -> {
                    textView101.setBackgroundResource(R.drawable.indefinido)
                }

            }
        }

        val campoMensaje = findViewById<View>(R.id.edit_text) as EditText
        campoMensaje.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) { }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (count==10){
                    campoMensaje.clearFocus()
                }
            }
            override fun afterTextChanged(s: Editable) {
                campoMensaje.clearFocus()
            }
        })
        edit_text.setOnFocusChangeListener { view, b ->
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

        Aceptar1.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val user = edit_text.text.toString()
            if (!TextUtils.isEmpty(user)) {
                if (user.isEmpty()) {
                    toast("Verifique su Usuario.")
                } else {
                    prefs.password = edit_text.text.toString()
                    alerta7()
                }
            } else {
                toast("Campos Vacios.")
            }
        }
        Optiones.setOnClickListener {
            Log.v("Datosss","inicio ${prefs1.volum}")
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            prefs1.activi = "UsuA"
            startActivity(Intent(this, Audio::class.java))
            Bungee.zoom(this)
        }
        Ayuda0.setOnClickListener {
            prefs1.activi = "CreU"

            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, Ayuda::class.java))
            Bungee.zoom(this)
        }
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
        Bungee.zoom(this)
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer!!.pause()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer!!.start()
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

    fun alerta7() {
        val customDialog = Dialog(this)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.setContentView(R.layout.avisoimpor)
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        val yesBtn = customDialog.findViewById<Button>(R.id.yes_opt) as TextView
        customDialog.setCanceledOnTouchOutside(false)
        customDialog.setCancelable(false)
        yesBtn.setOnClickListener {
            val Archivo1 = "Audio"
            val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this)
            defaultPrefs1.tono = 1
            defaultPrefs1.melodia = 1
            defaultPrefs1.volum = 0.10f
            defaultPrefs1.volum1 = 1.00f
            val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
            val carga = prefs1.tono
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            prefs1.activi = ""
            startActivity(Intent(this, ViewInstructions::class.java))
            Bungee.zoom(this)
            finish()
        }
        customDialog.show()
    }
}