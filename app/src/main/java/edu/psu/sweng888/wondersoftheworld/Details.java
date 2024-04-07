package edu.psu.sweng888.wondersoftheworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class Details extends FragmentActivity {
    // declare class variables
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private Adapter adapter;
    private BottomNavigationView navBar;

    public Details() {
        // required empty constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        // initialize class variables
        recyclerView = findViewById(R.id.recycler_view);
        navBar = findViewById(R.id.nav_bar);

        // set Details selected
        navBar.setSelectedItemId(R.id.list_nav_button);

        // populate list with Wonders
        ArrayList<WonderOfTheWorld> listOfWonders = populateList();

        // populate RecyclerView
        adapter = new Adapter(listOfWonders);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // navBar logic
        navBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.map_nav_button) {
                    startActivity(new Intent(getApplicationContext(), Map.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (item.getItemId() == R.id.list_nav_button) {
                    startActivity(new Intent(getApplicationContext(), Details.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });
    }
        private ArrayList<WonderOfTheWorld> populateList() {
        ArrayList<WonderOfTheWorld> list = new ArrayList<>();

        // Create Wonders
        WonderOfTheWorld one = new WonderOfTheWorld("Chichen Itza", "Located on the Yucatan Peninsula, Chichen Itza is an ancient Mayan archaeological site renowned for its well-preserved ruins and historical significance. This UNESCO World Heritage site was once a major pre-Columbian city and served as a center of political, economic, and religious activity for the Maya civilization. Its iconic centerpiece is the towering El Castillo pyramid, also known as the Temple of Kukulcan, which aligns with the sun to create a stunning visual effect during the spring and autumn equinoxes. Chichen Itza provides a fascinating glimpse into the rich cultural heritage and architectural prowess of the ancient Maya, attracting visitors from around the world to marvel at its grandeur and mysteries.");
        WonderOfTheWorld two = new WonderOfTheWorld("Christ The Redeemer", "Perched atop the 700-meter-tall Corcovado mountain overlooking Rio de Janeiro, Christ the Redeemer is one of the most recognizable landmarks in the world. Completed in 1931, this colossal statue of Jesus Christ stands 30 meters tall, with outstretched arms symbolizing peace and welcome. Designed by Brazilian engineer Heitor da Silva Costa and French sculptor Paul Landowski, Christ the Redeemer has become a symbol of Rio's vibrant culture and religious devotion, attracting millions of visitors each year to admire its panoramic views and serene presence.");
        WonderOfTheWorld three = new WonderOfTheWorld("The Colosseum", "Situated in the heart of Rome, the Colosseum is a monumental amphitheater that once hosted gladiatorial contests, animal hunts, and dramatic performances during the height of the Roman Empire. Completed in 80 CE under Emperor Titus, this iconic structure could accommodate over 50,000 spectators and remains one of the largest ancient amphitheaters in the world. Despite centuries of earthquakes, looting, and neglect, the Colosseum stands as a symbol of Roman engineering genius and architectural grandeur, attracting millions of visitors each year to explore its history and cultural significance.");
        WonderOfTheWorld four = new WonderOfTheWorld("The Great Wall Of China", "Spanning over 21,000 kilometers, the Great Wall of China is an awe-inspiring feat of ancient engineering and one of the most iconic symbols of Chinese civilization. Originally built to protect against invasions from northern tribes, construction began as early as the 7th century BCE and continued for centuries. The wall comprises a series of fortifications, including walls, watchtowers, and defensive structures, built across rugged terrain, forests, and mountains. Today, it stands as a testament to human perseverance and ingenuity, attracting millions of visitors annually to marvel at its grandeur and historical significance.");
        WonderOfTheWorld five = new WonderOfTheWorld("Machu Picchu", "Nestled high in the Andes Mountains of Peru, Machu Picchu is an ancient Incan citadel shrouded in mist and mystery. Built in the 15th century and abandoned a century later during the Spanish conquest, this UNESCO World Heritage site remained hidden from the outside world until its rediscovery by American explorer Hiram Bingham in 1911. Machu Picchu's remarkable architecture, including terraced fields, temples, and residential areas, reflects the ingenuity of the Inca civilization and their harmonious integration with the natural landscape. Today, it stands as a symbol of Peru's rich cultural heritage and continues to captivate visitors with its breathtaking beauty and enigmatic history.");
        WonderOfTheWorld six = new WonderOfTheWorld("Petra", "Hidden amidst the rugged desert canyons of southern Jordan, Petra is an ancient city carved into vibrant rose-red sandstone cliffs. Established as the capital of the Nabatean Kingdom around the 4th century BCE, Petra flourished as a vital trading hub along ancient caravan routes. Its most iconic structure is the Treasury (Al-Khazneh), a monumental temple carved into the rock face, adorned with intricate facades and towering columns. Other highlights include the Roman Theater, the Monastery (Ad Deir), and the Royal Tombs, all showcasing the architectural prowess and cultural richness of this UNESCO World Heritage site.");
        WonderOfTheWorld seven = new WonderOfTheWorld("Taj Mahal", "Regarded as one of the most exquisite examples of Mughal architecture, the Taj Mahal is a breathtaking mausoleum located in Agra, India. Commissioned by Emperor Shah Jahan in memory of his beloved wife Mumtaz Mahal, who died in childbirth in 1631, the Taj Mahal took over 20,000 artisans and craftsmen nearly 20 years to complete. Constructed from white marble adorned with intricate inlays of precious stones and calligraphy, the Taj Mahal is renowned for its symmetrical beauty and ethereal aura, particularly when bathed in the soft light of dawn or dusk. Today, it stands as a UNESCO World Heritage site and a symbol of enduring love, drawing millions of visitors from around the world to witness its timeless elegance and romance.");

        // Add Wonders to list
        list.add(one); // Chichen Itza
        list.add(two); // Christ The Redeemer
        list.add(three); // The Colosseum
        list.add(four); // The Great Wall Of China
        list.add(five); // Machu Picchu
        list.add(six); // Petra
        list.add(seven); // Taj Mahal

        return list;
    }
}
