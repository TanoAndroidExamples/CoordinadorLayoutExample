package coordlyexample.com.coordinatorlayoutexample;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rvToDoList) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Coordinator Layout");

        ArrayList<CardObject> cardList = new ArrayList<>();
        // Dummy data creation
        for (int i = 0; i <= 100; i++) {
            cardList.add(new CardObject("I am the text number: "+ (i+1), "I am the subtext number: " + (i+1)));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter(cardList));

    }

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private ArrayList<CardObject> cardObjects;

        public RecyclerAdapter(ArrayList<CardObject> cardObjects) {
            this.cardObjects = cardObjects;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_layout, parent, false);
            RecyclerView.ViewHolder viewHolder = new ItemHolders.ItemView(convertView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            CardObject cardObject = cardObjects.get(position);
            ItemHolders.ItemView itemView = (ItemHolders.ItemView) holder;
            itemView.text1.setText(cardObject.getText1());
            itemView.text2.setText(cardObject.getText2());
        }

        @Override
        public int getItemCount() {
            return cardObjects!=null?cardObjects.size():0;
        }
    }


}
