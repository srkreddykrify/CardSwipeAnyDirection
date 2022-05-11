package com.swipeanimations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardsAdapter  extends ArrayAdapter<Card> {
    private final ArrayList<Card> cards;
    private final LayoutInflater layoutInflater;

    public CardsAdapter(Context context, ArrayList<Card> cards) {
        super(context, -1);
        this.cards = cards;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        Card card = cards.get(position);
        View view = layoutInflater.inflate(R.layout.card_item, parent, false);
//        ((ImageView) view.findViewById(R.id.card_image)).setImageResource(card.imageId);
        ((ImageView) view.findViewById(R.id.card_image)).setImageDrawable(card.imageDraw);
        ((TextView) view.findViewById(R.id.helloText)).setText(card.name);
        return view;
    }

    @Override public Card getItem(int position) {
        return cards.get(position);
    }

    @Override public int getCount() {
        return cards.size();
    }

}
