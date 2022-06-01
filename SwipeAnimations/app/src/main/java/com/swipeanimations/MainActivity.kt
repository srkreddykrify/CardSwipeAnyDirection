package com.swipeanimations

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.swipealldirections.SwipeCardView

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    lateinit var swipeCardView :SwipeCardView ;
    val cardlist :ArrayList<Card> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
    }

    fun initData(){
        getDummyData(cardlist);

        val cardsAdapter = CardsAdapter(this,cardlist)
        swipeCardView = findViewById<View>(R.id.swipe_card_view) as SwipeCardView
        swipeCardView.adapter = cardsAdapter
        swipeCardView.setFlingListener(object : SwipeCardView.OnCardFlingListener {
            override fun onCardExitLeft(dataObject: Any) {
                Log.e(TAG, "Left Exit")
            }

            override fun onCardExitRight(dataObject: Any) {
                Log.e(TAG, "Right Exit")
            }

            override fun onAdapterAboutToEmpty(itemsInAdapter: Int) {
                Log.e(TAG, "Adater to be empty")
                //add more items to adapter and call notifydatasetchanged

//                swipeCardView.restart()
            }

            override fun onScroll(scrollProgressPercent: Float) {
                Log.e(TAG, "Scroll")
            }

            override fun onCardExitTop(dataObject: Any) {
                Log.e(TAG, "Top Exit")


            }

            override fun onCardExitBottom(dataObject: Any) {
                Log.e(TAG, "Bottom Exit")

                swipeCardView.restart(4)
            }
        })
    }

    fun reloadCards(view: View){
        swipeCardView.restart()
    }


    private fun getDummyData(al: ArrayList<Card>) {
        for (i in 1..12) {
            val card = Card()
            card.name = "Card$i"

            var j :Int = i%4
            if(j==0){
                j = 4
            }
            Log.e(TAG, "getDummyData : "+j )
            val name = "card$j"
            val id: Int = getResources().getIdentifier(
                name, "drawable",
                getPackageName()
            )
            val drawable: Drawable = getResources().getDrawable(id, null)
            card.imageDraw = drawable
            card.imageId = R.drawable.card1
            al.add(card)
        }

    }


}