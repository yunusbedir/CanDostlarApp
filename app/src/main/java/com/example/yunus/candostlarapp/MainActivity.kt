package com.example.yunus.candostlarapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tumDostlar= ArrayList<Dost>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynagiDoldur()

        var myAdapter = DostRecyclerViewAdapter(tumDostlar)

        recyclerviewDostlar.adapter=myAdapter

        var myLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recyclerviewDostlar.layoutManager=myLayoutManager
    }

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
