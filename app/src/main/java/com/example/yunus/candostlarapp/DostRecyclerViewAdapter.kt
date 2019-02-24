package com.example.yunus.candostlarapp

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import kotlinx.android.synthetic.main.layout_dost.view.*
import java.text.FieldPosition

class DostRecyclerViewAdapter(var tumDostlar : ArrayList<Dost>) : RecyclerView.Adapter<DostRecyclerViewAdapter.DostViewHolder>() ,Filterable{

    var myFilter = FilterHelper(tumDostlar,this)
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DostViewHolder {
        var inflater = LayoutInflater.from(p0?.context)
        var tek_uye= inflater.inflate(R.layout.layout_dost,p0,false)
        return DostViewHolder(tek_uye)
    }

    override fun getItemCount(): Int {
        return tumDostlar.size
    }

    override fun onBindViewHolder(p0: DostViewHolder, p1: Int) {
        var oAnOlusanDost =tumDostlar.get(p1)
        p0.setData(oAnOlusanDost,p1)
    }

    fun setFilter2(arrayList: ArrayList<Dost>) {
        tumDostlar = arrayList
    }

    override fun getFilter(): Filter {
        return myFilter
    }

    class DostViewHolder(tek_uye : View) : RecyclerView.ViewHolder(tek_uye){
        var tekDostBilgisi = tek_uye as CardView
        var dostAdi = tekDostBilgisi.tvDost
        var dostResim = tekDostBilgisi.imgDost

        fun setData(oAnOlusanDost:Dost,position: Int){
            dostAdi.text = oAnOlusanDost.dostAdi
            dostResim.setImageResource(oAnOlusanDost.resim)

            tekDostBilgisi.setOnClickListener{
                Toast.makeText(tekDostBilgisi.context,"Tıkalan Öğe : " + position + " Adı : " + oAnOlusanDost.dostAdi , Toast.LENGTH_LONG).show()
            }
        }
    }
/*
    fun setFilter(arananlar : ArrayList<Dost>){
        tumDostlar = ArrayList<Dost>()

        tumDostlar.addAll(arananlar)
        notifyDataSetChanged()

    }
    */
}