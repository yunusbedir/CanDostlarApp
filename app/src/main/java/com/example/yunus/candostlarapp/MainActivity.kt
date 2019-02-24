package com.example.yunus.candostlarapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.Menu
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){//,SearchView.OnQueryTextListener {

    var tumDostlar= ArrayList<Dost>()
    lateinit var myAdapter:DostRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynagiDoldur()

        myAdapter = DostRecyclerViewAdapter(tumDostlar)

        recyclerviewDostlar.adapter=myAdapter

        var myLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recyclerviewDostlar.layoutManager=myLayoutManager

        searchViewDost.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                myAdapter.filter.filter(p0)
                return false
            }

        })
    }
/*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //menuyu inflate edip uygulamaya ekliyoruz
        menuInflater.inflate(R.menu.filtre_menu,menu)
        var arama = menu?.findItem(R.id.app_bar_search)
        var searchView = arama?.actionView as SearchView

        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        var girilen = p0?.toLowerCase()
        var arananlar = ArrayList<Dost>()

        for (dost in tumDostlar){
            var adi = dost.dostAdi.toLowerCase()

            if(adi.contains(girilen.toString())){
                arananlar.add(dost)
            }
        }
        myAdapter.setFilter(arananlar)
        return true
    }
*/


    private fun veriKaynagiDoldur() {
        var dostAdlari= arrayOf("HAMSTER 1" , "KEDİ 1", "KEDİ 2","KEDİ 3","KEDİ 4","KÖPEK 1","KÖPEK 2","KÖPEK 3","KÖPEK 4")
        var dostResim = arrayOf(R.drawable.hamster_1 , R.drawable.kedi_1, R.drawable.kedi_2, R.drawable.kedi_3, R.drawable.kedi_4
            , R.drawable.kopek_1, R.drawable.kopek_2, R.drawable.kopek_3, R.drawable.kopek_4)

        for (i in 0..(dostAdlari.size-1)){
            var geciciDost = Dost(dostAdlari[i],dostResim[i])
            tumDostlar.add(geciciDost)
        }
    }
}
