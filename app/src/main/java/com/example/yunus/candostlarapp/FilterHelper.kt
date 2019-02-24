package com.example.yunus.candostlarapp

import android.widget.Filter

class FilterHelper(var tumDostlar : ArrayList<Dost>, var myAdapter: DostRecyclerViewAdapter) : Filter() {

    //filtremeleme yapılan kısım
    override fun performFiltering(p0: CharSequence?): FilterResults {
        var sonuc=FilterResults()

        if (p0 != null && p0.length >0)
        {
            var aranilan = p0.toString().toLowerCase()
            var eslesenler = ArrayList<Dost>()

            for (dost in tumDostlar){
                var adi = dost.dostAdi.toLowerCase()
                if (adi.contains(aranilan)){
                    eslesenler.add(dost)
                }
            }
            sonuc.values = eslesenler
            sonuc.count = eslesenler.size
        }
        else{
            sonuc.values = tumDostlar
            sonuc.count = tumDostlar.size
        }
        return sonuc
    }
    //sonuçların gösterildiği kısım
    override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
        myAdapter.setFilter2(p1?.values as ArrayList<Dost>)
        myAdapter.notifyDataSetChanged()
    }
}