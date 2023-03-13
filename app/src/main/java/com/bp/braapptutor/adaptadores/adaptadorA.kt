package com.bp.braapptutor.adaptadores

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bp.braapptutor.R
import kotlinx.android.synthetic.main.list_item4.view.*
import java.util.*
import kotlin.collections.ArrayList

class adaptadorA(var context: Context, items: ArrayList<avisol>, var listener: ClickListener) :
    RecyclerView.Adapter<adaptadorA.ViewHolder>() {
    private var lastPosition = -1
    var items: ArrayList<avisol>? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.list_item4, parent, false)
        val viewHolder = ViewHolder(vista, listener)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.fecha?.text = item?.fecha
        holder.respuesta?.text = item?.Descrip
        holder.name1?.text = item?.titulo
        holder.fecha2?.text = item?.fechaAc
        if (holder.fecha2?.text == "Online") {
            holder.online1.setBackgroundResource(R.drawable.on)
        } else if (holder.fecha2?.text == "Offline") {
            holder.online1.setBackgroundResource(R.drawable.off)
        }
        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    class ViewHolder(vista: View, listener: ClickListener) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {

        var vista = vista
        var listener: ClickListener? = null
        var fecha: TextView? = null
        var fecha2: TextView? = null
        var respuesta: TextView? = null
        var name1: TextView? = null

        var online1: TextView

        init {
            fecha = vista.findViewById(R.id.fechaa)
            respuesta = vista.findViewById(R.id.Descrip)
            name1 = vista.findViewById(R.id.titulo)
            online1 = vista.findViewById(R.id.online)
            fecha2 = vista.findViewById(R.id.fehca2)


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