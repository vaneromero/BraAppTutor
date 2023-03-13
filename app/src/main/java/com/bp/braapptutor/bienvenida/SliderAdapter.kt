package com.bp.braapptutor.bienvenida

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.bp.braapptutor.R
import com.google.android.material.tabs.TabLayout

class SliderAdapter : PagerAdapter {
    var context: Context
    lateinit var layoutInflater: LayoutInflater
    var tabLayout: TabLayout? = null

    constructor(context: Context) {
        this.context = context
    }

    //Arreglos
    val fondos: ArrayList<Int> = arrayListOf(
        R.drawable.traduccion1,
        R.drawable.juego1,
        R.drawable.historia1,
        R.drawable.redess,
        R.drawable.mat,
        R.drawable.ext1,
        R.drawable.prodd,
        R.drawable.avis,
        R.drawable.caht1
    )
    val slide_images: ArrayList<Int> =
        arrayListOf(
            R.drawable.traduccion,
            R.drawable.juegoss,
            R.drawable.history,
            R.drawable.redess1,
            R.drawable.mat1,
            R.drawable.estrellas,
            R.drawable.producc,
            R.drawable.notificaciones,
            R.drawable.chat
        )
    val slides_headings: java.util.ArrayList<String> =
        arrayListOf(
            "Traductor",
            "Juegos",
            "Historia",
            "Redes Sociales",
            "Material de Apoyo",
            "Extra",
            "Productos",
            "Avisos",
            "Chat"
        )
    val slides_descs: java.util.ArrayList<String> = arrayListOf(
        "Acceda a nuestros tipos de traductores para conocer más ingrese a Traductores desde nuestro menú principal.",
        "Aprende y Juega con Nosotros, y compite contigo mismo.",
        "Conoce acerca de la fundación del sistema Braille y Más.",
        "Puede encontrarnos en distintas redes sociales, videos y consultas.",
        "Accede a la ayuda desde cualquier parte en caso de que requiera de este servicio.",
        "Podrás Visualizar todas las letras, números y símbolos que fueron empleados. Así como las respuestas de las Adivinanzas.",
        "Ofrecemos una lista de distribuciones de artículos, y donde adquirirlos, recomendaciones y nuestros propios productos.",
        "Podrá recibir avisos e información de las novedades.",
        "Puedes escribirnos mediante las aplicaciones, tan pronto podamos contestaremos todas tus preguntas."

    )


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as RelativeLayout
    }

    override fun getCount(): Int {
        return slides_headings.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = layoutInflater.inflate(R.layout.activity_slider_adapter, container, false)
        var fondosP: RelativeLayout = view.findViewById(R.id.fondo) as RelativeLayout
        var slideImageView: ImageView = view.findViewById(R.id.imaagen) as ImageView
        var slideHeading: TextView = view.findViewById(R.id.titulo1) as TextView
        var slideDesc: TextView = view.findViewById(R.id.titulo2) as TextView

        fondosP.setBackgroundResource(fondos[position])
        slideImageView.setImageResource(slide_images[position])
        slideHeading.text = slides_headings[position]
        slideDesc.text = slides_descs[position]
        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}