package com.bp.braapptutor.extra

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bp.braapptutor.R
import com.bp.braapptutor.adaptadores.ClickListener
import java.util.*
import kotlin.collections.ArrayList


class AdaptadorCustom(var context: Context, items: ArrayList<extraa>, var listener: ClickListener) :
    RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {
    private var lastPosition = -1
    var items: ArrayList<extraa>? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.producto_content2, parent, false)
        val viewHolder = ViewHolder(vista, listener)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.foto1?.setBackgroundResource(item?.foto1!!)
        holder.foto2?.setBackgroundResource(item?.foto2!!)
        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    class ViewHolder(vista: View, listener: ClickListener) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {
        var vista = vista
        var foto1: TextView? = null
        var foto2: TextView? = null
        var listener: ClickListener? = null

        init {
            foto1 = vista.findViewById(R.id.textView106)
            foto2 = vista.findViewById(R.id.textView1087)
            this.listener = listener
            vista.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!, adapterPosition)
        }

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

class AdaptadorCustom1(
    var context: Context,
    items: ArrayList<extraa1>,
    var listener: ClickListener
) :
    RecyclerView.Adapter<AdaptadorCustom1.ViewHolder>() {
    private var lastPosition = -1
    var items: ArrayList<extraa1>? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.producto_content3, parent, false)
        val viewHolder = ViewHolder(vista, listener)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.titulo1?.text = item?.titulo1
        holder.foto2?.setBackgroundResource(item?.foto2!!)
        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    class ViewHolder(vista: View, listener: ClickListener) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {
        var vista = vista
        var titulo1: TextView? = null
        var foto2: TextView? = null
        var listener: ClickListener? = null

        init {
            titulo1 = vista.findViewById(R.id.texdf)
            foto2 = vista.findViewById(R.id.textView10gf6)
            this.listener = listener
            vista.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!, adapterPosition)
        }

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

class AdaptadorCustom2(
    var context: Context,
    items: ArrayList<extraa2>,
    var listener: ClickListener
) :
    RecyclerView.Adapter<AdaptadorCustom2.ViewHolder>() {
    private var lastPosition = -1
    var items: ArrayList<extraa2>? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.producto_content4, parent, false)
        val viewHolder = ViewHolder(vista, listener)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.titulo1?.text = item?.titulo1
        holder.titulo2?.text = item?.titulo2
        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    class ViewHolder(vista: View, listener: ClickListener) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {
        var vista = vista
        var titulo1: TextView? = null
        var titulo2: TextView? = null
        var listener: ClickListener? = null

        init {
            titulo1 = vista.findViewById(R.id.textView10gf6)
            titulo2 = vista.findViewById(R.id.texdf)
            this.listener = listener
            vista.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!, adapterPosition)
        }

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