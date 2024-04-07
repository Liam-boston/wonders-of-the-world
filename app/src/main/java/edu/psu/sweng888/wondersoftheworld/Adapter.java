package edu.psu.sweng888.wondersoftheworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<WonderOfTheWorld> listOfWonders;

    public Adapter(List<WonderOfTheWorld> listOfWonders) {
        this.listOfWonders = listOfWonders;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WonderOfTheWorld toDisplay = listOfWonders.get(position);

        // determine image to display
        holder.cardImage.setBackgroundResource(imageConfig(toDisplay));

        // display Name and Description
        holder.cardTitle.setText(toDisplay.getName());
        holder.cardDescription.setText(toDisplay.getDescription());
    }

    /**
     * determines which image to display
     *
     * @param toDisplay
     * @return resource id of the desired image
     */
    private int imageConfig(WonderOfTheWorld toDisplay) {
        if (toDisplay.getName().equals("Chichen Itza")) {
            return R.drawable.chichen_itza;
        } else if (toDisplay.getName().equals("Christ The Redeemer")) {
            return R.drawable.christ_the_redeemer;
        } else if (toDisplay.getName().equals("The Colosseum")) {
            return R.drawable.colosseum;
        } else if (toDisplay.getName().equals("The Great Wall Of China")) {
            return R.drawable.great_wall_of_china;
        } else if (toDisplay.getName().equals("Machu Picchu")) {
            return R.drawable.machu_picchu;
        } else if (toDisplay.getName().equals("Petra")) {
            return R.drawable.petra;
        } else if (toDisplay.getName().equals("Taj Mahal")) {
            return R.drawable.taj_mahal;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return listOfWonders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        private CardView itemCard;
        private ImageView cardImage;
        private TextView cardTitle, cardDescription;

        public ViewHolder(View view) {
            super(view);
            context = view.getContext();

            // initialize class variables
            itemCard = view.findViewById(R.id.itemCard);
            cardImage = view.findViewById(R.id.cardImage);
            cardTitle = view.findViewById(R.id.cardTitle);
            cardDescription = view.findViewById(R.id.cardDescription);
        }
    }
}
