package com.bp.braapptutor.games.record

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bp.braapptutor.R
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_record_mundial.*
import java.util.*
import kotlin.collections.ArrayList

class AdaptadorRecord9(var context: Context, items1: ArrayList<DatosUsuario1>) :
    RecyclerView.Adapter<AdaptadorRecord9.ViewHolder>() {
    var a = 1
    private var lastPosition = -1
    var items1: ArrayList<DatosUsuario1>? = null

    init {
        this.items1 = items1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var vista = LayoutInflater.from(context).inflate(R.layout.datos, parent, false)
        var viewHolder = ViewHolder(vista)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item1 = items1?.get(position)//Gobal 9.
        when (a) {
            1 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.prime)
                holder.posicion!!.visibility = View.GONE
            }
            2 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.segu)
                holder.posicion!!.visibility = View.GONE
            }
            3 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.terc)
                holder.posicion!!.visibility = View.GONE
            }
            else -> {
                holder.lugar?.visibility = View.INVISIBLE
                holder.posicion!!.visibility = View.VISIBLE
            }
        }

        //holder.posicion?.text = "0"
        holder.nombre?.text = item1?.nombreUs
        val datos = item1?.puntaje.toString()
        when {
            datos.length >= 5 -> {
                val uno = datos.substring(0, 2)
                val dos = datos.substring(2, 3)
                holder.puntos?.text = "$uno.${dos}k pts"
            }
            datos.length < 5 -> {
                holder.puntos?.text = "${datos} pts"
            }
        }

        when (item1?.foto) {
            "0" -> {
                holder.foto1!!.setImageResource(R.drawable.nina)
            }
            "1" -> {
                holder.foto1!!.setImageResource(R.drawable.nino)
            }
            "2" -> {
                holder.foto1!!.setImageResource(R.drawable.jovena)
            }
            "3" -> {
                holder.foto1!!.setImageResource(R.drawable.joveno)
            }
            "4" -> {
                holder.foto1!!.setImageResource(R.drawable.adulta)
            }
            "5" -> {
                holder.foto1!!.setImageResource(R.drawable.adulto)
            }
            "6" -> {
                holder.foto1!!.setImageResource(R.drawable.abuelo)
            }
            "7" -> {
                holder.foto1!!.setImageResource(R.drawable.abuela)
            }
            "8" -> {
                holder.foto1!!.setImageResource(R.drawable.indefinido)
            }
        }
        holder.posicion?.text = a.toString()
        a += 1
        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {
        return items1?.count()!!

    }

    class ViewHolder(vista: View) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {

        var vista = vista
        var posicion: TextView? = null
        var nombre: TextView? = null
        var puntos: TextView? = null
        var foto1: CircleImageView? = null
        var lugar: CircleImageView? = null

        init {
            lugar = vista.findViewById(R.id.lugar)
            posicion = vista.findViewById(R.id.posicion)
            nombre = vista.findViewById(R.id.nombre)
            puntos = vista.findViewById(R.id.pts)
            foto1 = vista.findViewById(R.id.foto)

        }

        override fun onClick(v: View?) {


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

class AdaptadorRecord0(var context: Context, items2: ArrayList<DatosUsuario2>) :
    RecyclerView.Adapter<AdaptadorRecord0.ViewHolder>() {

    var a1 = 1
    private var lastPosition = -1
    var items2: ArrayList<DatosUsuario2>? = null

    init {
        this.items2 = items2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var vista = LayoutInflater.from(context).inflate(R.layout.datos, parent, false)
        var viewHolder = ViewHolder(vista)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var item2 = items2?.get(position)//memoMin 0.


        when (a1) {
            1 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.prime)
                holder.posicion!!.visibility = View.GONE
            }
            2 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.segu)
                holder.posicion!!.visibility = View.GONE
            }
            3 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.terc)
                holder.posicion!!.visibility = View.GONE
            }
            else -> {
                holder.lugar?.visibility = View.INVISIBLE
                holder.posicion!!.visibility = View.VISIBLE
            }
        }
        //holder.posicion?.text = "0"
        holder.nombre?.text = item2?.nombreUs
        val datos = item2?.memoMin.toString()
        when {
            datos.length >= 5 -> {
                val uno = datos.substring(0, 2)
                val dos = datos.substring(2, 3)
                holder.puntos?.text = "$uno.${dos}k pts"
            }
            datos.length < 5 -> {
                holder.puntos?.text = "${datos} pts"
            }
        }

        when (item2?.foto) {
            "0" -> {
                holder.foto1!!.setImageResource(R.drawable.nina)
            }
            "1" -> {
                holder.foto1!!.setImageResource(R.drawable.nino)
            }
            "2" -> {
                holder.foto1!!.setImageResource(R.drawable.jovena)
            }
            "3" -> {
                holder.foto1!!.setImageResource(R.drawable.joveno)
            }
            "4" -> {
                holder.foto1!!.setImageResource(R.drawable.adulta)
            }
            "5" -> {
                holder.foto1!!.setImageResource(R.drawable.adulto)
            }
            "6" -> {
                holder.foto1!!.setImageResource(R.drawable.abuelo)
            }
            "7" -> {
                holder.foto1!!.setImageResource(R.drawable.abuela)
            }
            "8" -> {
                holder.foto1!!.setImageResource(R.drawable.indefinido)
            }
        }
        holder.posicion?.text = a1.toString()
        a1 += 1
        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {

        return items2?.count()!!

    }

    class ViewHolder(vista: View) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {

        var vista = vista
        var posicion: TextView? = null
        var nombre: TextView? = null
        var puntos: TextView? = null
        var foto1: CircleImageView? = null
        var lugar: CircleImageView? = null

        init {
            lugar = vista.findViewById(R.id.lugar)
            posicion = vista.findViewById(R.id.posicion)
            nombre = vista.findViewById(R.id.nombre)
            puntos = vista.findViewById(R.id.pts)
            foto1 = vista.findViewById(R.id.foto)

        }

        override fun onClick(v: View?) {


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

class AdaptadorRecord1(var context: Context, items3: ArrayList<DatosUsuario3>) :
    RecyclerView.Adapter<AdaptadorRecord1.ViewHolder>() {
    var a2 = 1
    private var lastPosition = -1
    var items3: ArrayList<DatosUsuario3>? = null

    init {

        this.items3 = items3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var vista = LayoutInflater.from(context).inflate(R.layout.datos, parent, false)
        var viewHolder = ViewHolder(vista)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var item3 = items3?.get(position)//memoMay 1.
        when (a2) {
            1 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.prime)
                holder.posicion!!.visibility = View.GONE
            }
            2 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.segu)
                holder.posicion!!.visibility = View.GONE
            }
            3 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.terc)
                holder.posicion!!.visibility = View.GONE
            }
            else -> {
                holder.lugar?.visibility = View.INVISIBLE
                holder.posicion!!.visibility = View.VISIBLE
            }
        }
        //holder.posicion?.text = "0"
        holder.nombre?.text = item3?.nombreUs
        val datos = item3?.memoMay.toString()
        when {
            datos.length >= 5 -> {
                val uno = datos.substring(0, 2)
                val dos = datos.substring(2, 3)
                holder.puntos?.text = "$uno.${dos}k pts"
            }
            datos.length < 5 -> {
                holder.puntos?.text = "${datos} pts"
            }
        }

        when (item3?.foto) {
            "0" -> {
                holder.foto1!!.setImageResource(R.drawable.nina)
            }
            "1" -> {
                holder.foto1!!.setImageResource(R.drawable.nino)
            }
            "2" -> {
                holder.foto1!!.setImageResource(R.drawable.jovena)
            }
            "3" -> {
                holder.foto1!!.setImageResource(R.drawable.joveno)
            }
            "4" -> {
                holder.foto1!!.setImageResource(R.drawable.adulta)
            }
            "5" -> {
                holder.foto1!!.setImageResource(R.drawable.adulto)
            }
            "6" -> {
                holder.foto1!!.setImageResource(R.drawable.abuelo)
            }
            "7" -> {
                holder.foto1!!.setImageResource(R.drawable.abuela)
            }
            "8" -> {
                holder.foto1!!.setImageResource(R.drawable.indefinido)
            }
        }
        holder.posicion?.text = a2.toString()
        a2 += 1
        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {

        return items3?.count()!!

    }

    class ViewHolder(vista: View) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {

        var vista = vista
        var posicion: TextView? = null
        var nombre: TextView? = null
        var puntos: TextView? = null
        var foto1: CircleImageView? = null
        var lugar: CircleImageView? = null

        init {
            lugar = vista.findViewById(R.id.lugar)
            posicion = vista.findViewById(R.id.posicion)
            nombre = vista.findViewById(R.id.nombre)
            puntos = vista.findViewById(R.id.pts)
            foto1 = vista.findViewById(R.id.foto)

        }

        override fun onClick(v: View?) {


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

class AdaptadorRecord2(var context: Context, items4: ArrayList<DatosUsuario4>) :
    RecyclerView.Adapter<AdaptadorRecord2.ViewHolder>() {
    var a3 = 1
    private var lastPosition = -1
    var items4: ArrayList<DatosUsuario4>? = null

    init {

        this.items4 = items4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var vista = LayoutInflater.from(context).inflate(R.layout.datos, parent, false)
        var viewHolder = ViewHolder(vista)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var item4 = items4?.get(position)//memoNum 2 .

        when (a3) {
            1 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.prime)
                holder.posicion!!.visibility = View.GONE
            }
            2 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.segu)
                holder.posicion!!.visibility = View.GONE
            }
            3 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.terc)
                holder.posicion!!.visibility = View.GONE
            }
            else -> {
                holder.lugar?.visibility = View.INVISIBLE
                holder.posicion!!.visibility = View.VISIBLE
            }
        }
        //holder.posicion?.text = "0"
        holder.nombre?.text = item4?.nombreUs
        val datos = item4?.memoNum.toString()
        when {
            datos.length >= 5 -> {
                val uno = datos.substring(0, 2)
                val dos = datos.substring(2, 3)
                holder.puntos?.text = "$uno.${dos}k pts"
            }
            datos.length < 5 -> {
                holder.puntos?.text = "${datos} pts"
            }
        }

        when (item4?.foto) {
            "0" -> {
                holder.foto1!!.setImageResource(R.drawable.nina)
            }
            "1" -> {
                holder.foto1!!.setImageResource(R.drawable.nino)
            }
            "2" -> {
                holder.foto1!!.setImageResource(R.drawable.jovena)
            }
            "3" -> {
                holder.foto1!!.setImageResource(R.drawable.joveno)
            }
            "4" -> {
                holder.foto1!!.setImageResource(R.drawable.adulta)
            }
            "5" -> {
                holder.foto1!!.setImageResource(R.drawable.adulto)
            }
            "6" -> {
                holder.foto1!!.setImageResource(R.drawable.abuelo)
            }
            "7" -> {
                holder.foto1!!.setImageResource(R.drawable.abuela)
            }
            "8" -> {
                holder.foto1!!.setImageResource(R.drawable.indefinido)
            }
        }
        holder.posicion?.text = a3.toString()
        a3 += 1
        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {
        return items4?.count()!!

    }

    class ViewHolder(vista: View) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {

        var vista = vista
        var posicion: TextView? = null
        var nombre: TextView? = null
        var puntos: TextView? = null
        var foto1: CircleImageView? = null
        var lugar: CircleImageView? = null

        init {
            lugar = vista.findViewById(R.id.lugar)
            posicion = vista.findViewById(R.id.posicion)
            nombre = vista.findViewById(R.id.nombre)
            puntos = vista.findViewById(R.id.pts)
            foto1 = vista.findViewById(R.id.foto)

        }

        override fun onClick(v: View?) {


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

class AdaptadorRecord3(var context: Context, items5: ArrayList<DatosUsuario5>) :
    RecyclerView.Adapter<AdaptadorRecord3.ViewHolder>() {

    var a4 = 1
    private var lastPosition = -1
    var items5: ArrayList<DatosUsuario5>? = null

    init {
        this.items5 = items5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var vista = LayoutInflater.from(context).inflate(R.layout.datos, parent, false)
        var viewHolder = ViewHolder(vista)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var item5 = items5?.get(position)//memoSim 3.
        //holder.posicion?.text = "0"
        when (a4) {
            1 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.prime)
                holder.posicion!!.visibility = View.GONE
            }
            2 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.segu)
                holder.posicion!!.visibility = View.GONE
            }
            3 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.terc)
                holder.posicion!!.visibility = View.GONE
            }
            else -> {
                holder.lugar?.visibility = View.INVISIBLE
                holder.posicion!!.visibility = View.VISIBLE
            }
        }
        holder.nombre?.text = item5?.nombreUs
        val datos = item5?.memoSim.toString()
        when {
            datos.length >= 5 -> {
                val uno = datos.substring(0, 2)
                val dos = datos.substring(2, 3)
                holder.puntos?.text = "$uno.${dos}k pts"
            }
            datos.length < 5 -> {
                holder.puntos?.text = "${datos} pts"
            }
        }

        when (item5?.foto) {
            "0" -> {
                holder.foto1!!.setImageResource(R.drawable.nina)
            }
            "1" -> {
                holder.foto1!!.setImageResource(R.drawable.nino)
            }
            "2" -> {
                holder.foto1!!.setImageResource(R.drawable.jovena)
            }
            "3" -> {
                holder.foto1!!.setImageResource(R.drawable.joveno)
            }
            "4" -> {
                holder.foto1!!.setImageResource(R.drawable.adulta)
            }
            "5" -> {
                holder.foto1!!.setImageResource(R.drawable.adulto)
            }
            "6" -> {
                holder.foto1!!.setImageResource(R.drawable.abuelo)
            }
            "7" -> {
                holder.foto1!!.setImageResource(R.drawable.abuela)
            }
            "8" -> {
                holder.foto1!!.setImageResource(R.drawable.indefinido)
            }
        }
        holder.posicion?.text = a4.toString()
        a4 += 1


        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {
        return items5?.count()!!

    }

    class ViewHolder(vista: View) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {

        var vista = vista
        var posicion: TextView? = null
        var nombre: TextView? = null
        var puntos: TextView? = null
        var foto1: CircleImageView? = null
        var lugar: CircleImageView? = null

        init {
            lugar = vista.findViewById(R.id.lugar)
            posicion = vista.findViewById(R.id.posicion)
            nombre = vista.findViewById(R.id.nombre)
            puntos = vista.findViewById(R.id.pts)
            foto1 = vista.findViewById(R.id.foto)

        }

        override fun onClick(v: View?) {


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

class AdaptadorRecord4(var context: Context, items6: ArrayList<DatosUsuario6>) :
    RecyclerView.Adapter<AdaptadorRecord4.ViewHolder>() {

    var a5 = 1
    private var lastPosition = -1
    var items6: ArrayList<DatosUsuario6>? = null

    init {
        this.items6 = items6
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var vista = LayoutInflater.from(context).inflate(R.layout.datos, parent, false)
        var viewHolder = ViewHolder(vista)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item6 = items6?.get(position)//adivMinSim 4 .

        when (a5) {
            1 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.prime)
                holder.posicion!!.visibility = View.GONE
            }
            2 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.segu)
                holder.posicion!!.visibility = View.GONE
            }
            3 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.terc)
                holder.posicion!!.visibility = View.GONE
            }
            else -> {
                holder.lugar?.visibility = View.INVISIBLE
                holder.posicion!!.visibility = View.VISIBLE
            }
        }
        //holder.posicion?.text = "0"
        holder.nombre?.text = item6?.nombreUs
        val datos = item6?.adivMinSim.toString()
        when {
            datos.length >= 5 -> {
                val uno = datos.substring(0, 2)
                val dos = datos.substring(2, 3)
                holder.puntos?.text = "$uno.${dos}k pts"
            }
            datos.length < 5 -> {
                holder.puntos?.text = "${datos} pts"
            }
        }

        when (item6?.foto) {
            "0" -> {
                holder.foto1!!.setImageResource(R.drawable.nina)
            }
            "1" -> {
                holder.foto1!!.setImageResource(R.drawable.nino)
            }
            "2" -> {
                holder.foto1!!.setImageResource(R.drawable.jovena)
            }
            "3" -> {
                holder.foto1!!.setImageResource(R.drawable.joveno)
            }
            "4" -> {
                holder.foto1!!.setImageResource(R.drawable.adulta)
            }
            "5" -> {
                holder.foto1!!.setImageResource(R.drawable.adulto)
            }
            "6" -> {
                holder.foto1!!.setImageResource(R.drawable.abuelo)
            }
            "7" -> {
                holder.foto1!!.setImageResource(R.drawable.abuela)
            }
            "8" -> {
                holder.foto1!!.setImageResource(R.drawable.indefinido)
            }
        }
        holder.posicion?.text = a5.toString()
        a5 += 1



        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {
        return items6?.count()!!
    }

    class ViewHolder(vista: View) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {

        var vista = vista
        var posicion: TextView? = null
        var nombre: TextView? = null
        var puntos: TextView? = null
        var foto1: CircleImageView? = null
        var lugar: CircleImageView? = null

        init {
            lugar = vista.findViewById(R.id.lugar)
            posicion = vista.findViewById(R.id.posicion)
            nombre = vista.findViewById(R.id.nombre)
            puntos = vista.findViewById(R.id.pts)
            foto1 = vista.findViewById(R.id.foto)

        }

        override fun onClick(v: View?) {


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

class AdaptadorRecord5(var context: Context, items7: ArrayList<DatosUsuario7>) :
    RecyclerView.Adapter<AdaptadorRecord5.ViewHolder>() {

    var a6 = 1
    private var lastPosition = -1
    var items7: ArrayList<DatosUsuario7>? = null

    init {

        this.items7 = items7
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var vista = LayoutInflater.from(context).inflate(R.layout.datos, parent, false)
        var viewHolder = ViewHolder(vista)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var item7 = items7?.get(position)//adivMayA 5.

        when (a6) {
            1 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.prime)
                holder.posicion!!.visibility = View.GONE
            }
            2 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.segu)
                holder.posicion!!.visibility = View.GONE
            }
            3 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.terc)
                holder.posicion!!.visibility = View.GONE
            }
            else -> {
                holder.lugar?.visibility = View.INVISIBLE
                holder.posicion!!.visibility = View.VISIBLE
            }
        }
        //holder.posicion?.text = "0"
        holder.nombre?.text = item7?.nombreUs
        val datos = item7?.adivMayA.toString()
        when {
            datos.length >= 5 -> {
                val uno = datos.substring(0, 2)
                val dos = datos.substring(2, 3)
                holder.puntos?.text = "$uno.${dos}k pts"
            }
            datos.length < 5 -> {
                holder.puntos?.text = "${datos} pts"
            }
        }

        when (item7?.foto) {
            "0" -> {
                holder.foto1!!.setImageResource(R.drawable.nina)
            }
            "1" -> {
                holder.foto1!!.setImageResource(R.drawable.nino)
            }
            "2" -> {
                holder.foto1!!.setImageResource(R.drawable.jovena)
            }
            "3" -> {
                holder.foto1!!.setImageResource(R.drawable.joveno)
            }
            "4" -> {
                holder.foto1!!.setImageResource(R.drawable.adulta)
            }
            "5" -> {
                holder.foto1!!.setImageResource(R.drawable.adulto)
            }
            "6" -> {
                holder.foto1!!.setImageResource(R.drawable.abuelo)
            }
            "7" -> {
                holder.foto1!!.setImageResource(R.drawable.abuela)
            }
            "8" -> {
                holder.foto1!!.setImageResource(R.drawable.indefinido)
            }
        }
        holder.posicion?.text = a6.toString()
        a6 += 1


        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {
        return items7?.count()!!

    }

    class ViewHolder(vista: View) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {

        var vista = vista
        var posicion: TextView? = null
        var nombre: TextView? = null
        var puntos: TextView? = null
        var foto1: CircleImageView? = null
        var lugar: CircleImageView? = null

        init {
            lugar = vista.findViewById(R.id.lugar)
            posicion = vista.findViewById(R.id.posicion)
            nombre = vista.findViewById(R.id.nombre)
            puntos = vista.findViewById(R.id.pts)
            foto1 = vista.findViewById(R.id.foto)

        }

        override fun onClick(v: View?) {


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

class AdaptadorRecord6(var context: Context, items8: ArrayList<DatosUsuario8>) :
    RecyclerView.Adapter<AdaptadorRecord6.ViewHolder>() {

    var a7 = 1
    private var lastPosition = -1

    var items8: ArrayList<DatosUsuario8>? = null

    init {
        this.items8 = items8
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var vista = LayoutInflater.from(context).inflate(R.layout.datos, parent, false)
        var viewHolder = ViewHolder(vista)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var item8 = items8?.get(position)//adivMayNum 6.

        when (a7) {
            1 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.prime)
                holder.posicion!!.visibility = View.GONE
            }
            2 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.segu)
                holder.posicion!!.visibility = View.GONE
            }
            3 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.terc)
                holder.posicion!!.visibility = View.GONE
            }
            else -> {
                holder.lugar?.visibility = View.INVISIBLE
                holder.posicion!!.visibility = View.VISIBLE
            }
        }
        //holder.posicion?.text = "0"
        holder.nombre?.text = item8?.nombreUs
        val datos = item8?.adivMayNum.toString()
        when {
            datos.length >= 5 -> {
                val uno = datos.substring(0, 2)
                val dos = datos.substring(2, 3)
                holder.puntos?.text = "$uno.${dos}k pts"
            }
            datos.length < 5 -> {
                holder.puntos?.text = "${datos} pts"
            }
        }

        when (item8?.foto) {
            "0" -> {
                holder.foto1!!.setImageResource(R.drawable.nina)
            }
            "1" -> {
                holder.foto1!!.setImageResource(R.drawable.nino)
            }
            "2" -> {
                holder.foto1!!.setImageResource(R.drawable.jovena)
            }
            "3" -> {
                holder.foto1!!.setImageResource(R.drawable.joveno)
            }
            "4" -> {
                holder.foto1!!.setImageResource(R.drawable.adulta)
            }
            "5" -> {
                holder.foto1!!.setImageResource(R.drawable.adulto)
            }
            "6" -> {
                holder.foto1!!.setImageResource(R.drawable.abuelo)
            }
            "7" -> {
                holder.foto1!!.setImageResource(R.drawable.abuela)
            }
            "8" -> {
                holder.foto1!!.setImageResource(R.drawable.indefinido)
            }
        }
        holder.posicion?.text = a7.toString()
        a7 += 1
        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {
        return items8?.count()!!

    }

    class ViewHolder(vista: View) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {

        var vista = vista
        var posicion: TextView? = null
        var nombre: TextView? = null
        var puntos: TextView? = null
        var foto1: CircleImageView? = null
        var lugar: CircleImageView? = null

        init {
            lugar = vista.findViewById(R.id.lugar)
            posicion = vista.findViewById(R.id.posicion)
            nombre = vista.findViewById(R.id.nombre)
            puntos = vista.findViewById(R.id.pts)
            foto1 = vista.findViewById(R.id.foto)

        }

        override fun onClick(v: View?) {


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

class AdaptadorRecord7(var context: Context, items9: ArrayList<DatosUsuario9>) :
    RecyclerView.Adapter<AdaptadorRecord7.ViewHolder>() {

    var a8 = 1
    private var lastPosition = -1
    var items9: ArrayList<DatosUsuario9>? = null

    init {
        this.items9 = items9
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var vista = LayoutInflater.from(context).inflate(R.layout.datos, parent, false)
        var viewHolder = ViewHolder(vista)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item9 = items9?.get(position)//adivNumA 7.
        when (a8) {
            1 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.prime)
                holder.posicion!!.visibility = View.GONE
            }
            2 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.segu)
                holder.posicion!!.visibility = View.GONE
            }
            3 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.terc)
                holder.posicion!!.visibility = View.GONE
            }
            else -> {
                holder.lugar?.visibility = View.INVISIBLE
                holder.posicion!!.visibility = View.VISIBLE
            }
        }
        //holder.posicion?.text = "0"
        holder.nombre?.text = item9?.nombreUs
        val datos = item9?.adivNumA.toString()
        when {
            datos.length >= 5 -> {
                val uno = datos.substring(0, 2)
                val dos = datos.substring(2, 3)
                holder.puntos?.text = "$uno.${dos}k pts"
            }
            datos.length < 5 -> {
                holder.puntos?.text = "${datos} pts"
            }
        }

        when (item9?.foto) {
            "0" -> {
                holder.foto1!!.setImageResource(R.drawable.nina)
            }
            "1" -> {
                holder.foto1!!.setImageResource(R.drawable.nino)
            }
            "2" -> {
                holder.foto1!!.setImageResource(R.drawable.jovena)
            }
            "3" -> {
                holder.foto1!!.setImageResource(R.drawable.joveno)
            }
            "4" -> {
                holder.foto1!!.setImageResource(R.drawable.adulta)
            }
            "5" -> {
                holder.foto1!!.setImageResource(R.drawable.adulto)
            }
            "6" -> {
                holder.foto1!!.setImageResource(R.drawable.abuelo)
            }
            "7" -> {
                holder.foto1!!.setImageResource(R.drawable.abuela)
            }
            "8" -> {
                holder.foto1!!.setImageResource(R.drawable.indefinido)
            }
        }
        holder.posicion?.text = a8.toString()
        a8 += 1

        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {

        return items9?.count()!!

    }

    class ViewHolder(vista: View) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {

        var vista = vista
        var posicion: TextView? = null
        var nombre: TextView? = null
        var puntos: TextView? = null
        var foto1: CircleImageView? = null
        var lugar: CircleImageView? = null

        init {
            lugar = vista.findViewById(R.id.lugar)
            posicion = vista.findViewById(R.id.posicion)
            nombre = vista.findViewById(R.id.nombre)
            puntos = vista.findViewById(R.id.pts)
            foto1 = vista.findViewById(R.id.foto)

        }

        override fun onClick(v: View?) {


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

class AdaptadorRecord8(var context: Context, items10: ArrayList<DatosUsuario10>) :
    RecyclerView.Adapter<AdaptadorRecord8.ViewHolder>() {
    var a9 = 1
    private var lastPosition = -1
    var items10: ArrayList<DatosUsuario10>? = null

    init {
        this.items10 = items10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var vista = LayoutInflater.from(context).inflate(R.layout.datos, parent, false)
        var viewHolder = ViewHolder(vista)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item10 = items10?.get(position)//adivMinSimB 8
        when (a9) {
            1 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.prime)
                holder.posicion!!.visibility = View.GONE
            }
            2 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.segu)
                holder.posicion!!.visibility = View.GONE
            }
            3 -> {
                holder.lugar?.visibility = View.VISIBLE
                holder.lugar?.setImageResource(R.drawable.terc)
                holder.posicion!!.visibility = View.GONE
            }
            else -> {
                holder.lugar?.visibility = View.INVISIBLE
                holder.posicion!!.visibility = View.VISIBLE
            }
        }
        //holder.posicion?.text = "0"
        holder.nombre?.text = item10?.nombreUs
        val datos = item10?.adivMinSimB.toString()
        when {
            datos.length >= 5 -> {
                val uno = datos.substring(0, 2)
                val dos = datos.substring(2, 3)
                holder.puntos?.text = "$uno.${dos}k pts"
            }
            datos.length < 5 -> {
                holder.puntos?.text = "${datos} pts"
            }
        }

        when (item10?.foto) {
            "0" -> {
                holder.foto1!!.setImageResource(R.drawable.nina)
            }
            "1" -> {
                holder.foto1!!.setImageResource(R.drawable.nino)
            }
            "2" -> {
                holder.foto1!!.setImageResource(R.drawable.jovena)
            }
            "3" -> {
                holder.foto1!!.setImageResource(R.drawable.joveno)
            }
            "4" -> {
                holder.foto1!!.setImageResource(R.drawable.adulta)
            }
            "5" -> {
                holder.foto1!!.setImageResource(R.drawable.adulto)
            }
            "6" -> {
                holder.foto1!!.setImageResource(R.drawable.abuelo)
            }
            "7" -> {
                holder.foto1!!.setImageResource(R.drawable.abuela)
            }
            "8" -> {
                holder.foto1!!.setImageResource(R.drawable.indefinido)
            }
        }
        holder.posicion?.text = a9.toString()
        a9 += 1
        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {

        return items10?.count()!!

    }

    class ViewHolder(vista: View) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {

        var vista = vista
        var posicion: TextView? = null
        var nombre: TextView? = null
        var puntos: TextView? = null
        var foto1: CircleImageView? = null
        var lugar: CircleImageView? = null

        init {
            lugar = vista.findViewById(R.id.lugar)
            posicion = vista.findViewById(R.id.posicion)
            nombre = vista.findViewById(R.id.nombre)
            puntos = vista.findViewById(R.id.pts)
            foto1 = vista.findViewById(R.id.foto)

        }

        override fun onClick(v: View?) {


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