package com.bp.braapptutor.chat.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bp.braapptutor.R
import com.bp.braapptutor.chat.activity.ChatActivity
import com.bp.braapptutor.chat.activity.UsersActivity
import com.bp.braapptutor.chat.model.User
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*
import kotlin.collections.ArrayList

class UserAdapter(private val context: UsersActivity, private val userList: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private var lastPosition = -1
    lateinit var a: String
    lateinit var b: String
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.txtUserName.text = user.userName
        setAnimation(holder.itemView, position);
        when (user!!.sexo) {
            "Masculino" -> {
                holder.imgUser.setImageResource(R.drawable.businessman)

            }
            "Femenino" -> {
                holder.imgUser.setImageResource(R.drawable.businesswoman)

            }
            "no" -> {
                holder.imgUser.setImageResource(R.drawable.interrogation)

            }
        }
        holder.layoutUser.setOnClickListener {
            val intent = Intent(context, ChatActivity::class.java)
            intent.putExtra("userId", user.userId)
            intent.putExtra("userName", user.userName)
            context.startActivity(intent)
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtUserName: TextView = view.findViewById(R.id.userName)
        val imgUser: CircleImageView = view.findViewById(R.id.userImage)
        val layoutUser: LinearLayout = view.findViewById(R.id.layoutUser)
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