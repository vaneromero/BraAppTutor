package com.bp.braapptutor.chat.activity

import android.annotation.SuppressLint
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bp.braapptutor.R
import com.bp.braapptutor.chat.RetrofitInstance
import com.bp.braapptutor.chat.adapter.ChatAdapter
import com.bp.braapptutor.chat.model.Chat
import com.bp.braapptutor.chat.model.NotificationData
import com.bp.braapptutor.chat.model.PushNotification
import com.bp.braapptutor.chat.model.User
import com.bp.braapptutor.inicio.Splash
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.activi
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.tono
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.volum
import com.bp.braapptutor.inicio.Splash.PreferenceHelper1.volum1
import com.bp.braapptutor.inicio.Splash.PreferenceHelper2.entrada
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChatActivity : AppCompatActivity() {
    var firebaseUser: FirebaseUser? = null
    var reference: DatabaseReference? = null
    var reference1: DatabaseReference? = null
    var chatList = ArrayList<Chat>()
    var topic = ""
    var idUsuario = ""
    var a = ""
    var b = ""
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        chatRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        (chatRecyclerView.layoutManager as LinearLayoutManager).setStackFromEnd(true)
        val Archivo1 = "Audio"
        val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this@ChatActivity)
        defaultPrefs1.tono = 1
        defaultPrefs1.melodia = 1
        defaultPrefs1.activi = ""
        defaultPrefs1.volum = 0.10f
        defaultPrefs1.volum1 = 1.00f
        val prefs1 = Splash.PreferenceHelper1.customPreference1(this@ChatActivity, Archivo1)
        var carga = prefs1.tono
        val Archivo2 = "Chat"
        val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(this@ChatActivity)
        defaultPrefs2.entrada = 0
        val prefs2 = Splash.PreferenceHelper2.customPreference2(this, Archivo2)
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
        FirebaseMessaging.getInstance().isAutoInitEnabled = true
        val firebase: FirebaseUser = FirebaseAuth.getInstance().currentUser!!
        var intent = getIntent()
        var userId = intent.getStringExtra("userId")
        idUsuario = userId.toString()
        var usuario = firebase.uid
        //enableFCM()
        val texto1: LinearLayout = findViewById(R.id.l1)
        val texto2: RecyclerView = findViewById(R.id.chatRecyclerView)
        val texto3: RelativeLayout = findViewById(R.id.r1)
        val anim1: Animation = AnimationUtils.loadAnimation(this@ChatActivity, R.anim.abajo)
        texto1.startAnimation(anim1)
        texto2.startAnimation(anim1)
        texto3.startAnimation(anim1)
        firebaseUser = FirebaseAuth.getInstance().currentUser
        reference = FirebaseDatabase.getInstance().getReference("Administradores").child(userId!!)

        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                val user = snapshot.getValue(User::class.java)
                bu.text = user!!.userName
                if (user.sexo == "Masculino") {
                    imgProfile.setImageResource(R.drawable.businessman)
                    a = user.sexo
                } else if (user.sexo == "Femenino") {
                    imgProfile.setImageResource(R.drawable.businesswoman)
                    a = user.sexo
                } else if (user.sexo == "no") {
                    imgProfile.setImageResource(R.drawable.interrogation)
                    a = user.sexo
                }
                b = user.userName
            }
        })
        etMessage.setOnFocusChangeListener { view, b ->
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
        btnSendMessage.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            var message: String = etMessage.text.toString()

            if (message.isEmpty()) {
                toast("Mensaje vacio")

                etMessage.setText("")
            } else {
                sendMessage(firebaseUser!!.uid, userId, message)
                etMessage.setText("")
                topic = "/topics/$userId"
                reference1 = FirebaseDatabase.getInstance().getReference("Users").child(usuario)
                reference1!!.addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                    override fun onDataChange(snapshot: DataSnapshot) {
                        val user = snapshot.getValue(User::class.java)
                        PushNotification(
                            NotificationData(user!!.userName, message),
                            topic
                        ).also {
                            sendNotification(it)
                        }
                    }
                })

            }
        }

        readMessage(firebaseUser!!.uid, userId)
    }

    private fun sendMessage(senderId: String, receiverId: String, message: String) {
        var reference: DatabaseReference? = FirebaseDatabase.getInstance().getReference()

        var hashMap: HashMap<String, String> = HashMap()
        hashMap.put("senderId", senderId)
        hashMap.put("receiverId", receiverId)
        hashMap.put("message", message)

        reference!!.child("Chat").push().setValue(hashMap)

    }

    fun enableFCM() {
        // Enable FCM via enable Auto-init service which generate new token and receive in FCMService
        FirebaseMessaging.getInstance().isAutoInitEnabled = true
    }

    fun readMessage(senderId: String, receiverId: String) {
        val databaseReference: DatabaseReference =
            FirebaseDatabase.getInstance().getReference("Chat")

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                chatList.clear()
                for (dataSnapShot: DataSnapshot in snapshot.children) {
                    val chat = dataSnapShot.getValue(Chat::class.java)

                    if (chat!!.senderId.equals(senderId) && chat!!.receiverId.equals(receiverId) ||
                        chat!!.senderId.equals(receiverId) && chat!!.receiverId.equals(senderId)
                    ) {
                        chatList.add(chat)

                    }
                }

                val chatAdapter = ChatAdapter(this@ChatActivity, chatList, idUsuario)

                chatRecyclerView.adapter = chatAdapter
            }
        })
    }

    private fun sendNotification(notification: PushNotification) =
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.api.postNotification(notification)
                if (response.isSuccessful) {
                    Log.d("TAG", "Response: ${Gson().toJson(response)}")
                } else {
                    Log.e("TAG", response.errorBody()!!.string())
                }
            } catch (e: Exception) {
                Log.e("TAG", e.toString())
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

    override fun onPause() {
        super.onPause()
        mediaPlayer!!.pause()

    }

    override fun onResume() {
        super.onResume()
        mediaPlayer!!.start()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}