package coordlyexample.com.coordinatorlayoutexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ismael.vayra on 13/11/2015.
 */
public class ItemHolders {
    public static class ItemView extends RecyclerView.ViewHolder {

        @Bind(R.id.text1) TextView text1;
        @Bind(R.id.text2) TextView text2;

        public ItemView(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
