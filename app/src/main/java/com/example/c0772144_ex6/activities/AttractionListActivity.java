package com.example.c0772144_ex6.activities;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0772144_ex6.AdapterActivity;
import com.example.c0772144_ex6.model.CanadaAttraction;
import com.example.c0772144_ex6.R;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AttractionListActivity extends AppCompatActivity {
    private RecyclerView rvAttractions;
    private ArrayList<CanadaAttraction> attractions;
    private AdapterActivity attractionsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        rvAttractions = findViewById(R.id.rvAttractions);

        loadAttractions();
        attractionsAdapter = new AdapterActivity(attractions);
        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvAttractions.setLayoutManager(mLinearLayoutManager);
        rvAttractions.setAdapter(attractionsAdapter);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    private void loadAttractions()
    {

        String niagra = "Niagara Falls is Canada's most famous natural attraction, bringing in millions of visitors each year. " +
                " Located just over an hour's drive from Toronto, along the American border, these massive falls drop approximately 57 meters. " +
                "You can see the falls at an astoundingly close distance from several key points." +
                "Niagara Falls and the Niagara Gorge have been attracting tourists and daredevils for well over a century. " +
                "Between the mid-19th and mid-20th centuries there were numerous attempts to plunge over the falls in various types of homemade boats and barrels. " +
                "This, along with tightrope walkers and other spectacles, led to the adjacent town of Niagara Falls developing a carnival type atmosphere that still persists today.";

        String banff = "Banff National Park lies in the heart of the majestic Rocky Mountains in the province of Alberta, and showcases some of Canada's most beautiful scenery." +
                "Turquoise-colored lakes, snow-capped peaks, and glaciers are all easily accessible in this stunning park." +
                "The jewel of the park is Lake Louise, where green waters reflect the surrounding mountains and glaciers, and visitors can stroll easily around the shores." +
                "The Icefields Parkway, which runs from Lake Louise to Jasper, is an unforgettable drive and another major attraction in Banff." +
                "At the south end of the park is the lovely little town of Banff, providing all kinds of options for accommodation, shopping, dining, and nightlife.";
        String cntower="On the shores of Lake Ontario in Canada's biggest city is the iconic CN Tower, one of Canada's most famous landmarks. " +
                "The tower stands an impressive 553 meters high and dominates the skyline. " +
                "At the top, you can find fine dining in the revolving 360 restaurant, and enjoy a meal while looking out over the city and lake. " +
                "The LookOut and the Glass Floor offer beautiful views out over the entire area.";
        String olQuebec = "Old Quebec is a UNESCO World Heritage Site and one of Canada's historic gems. Spread across the Upper and Lower Town of Quebec, this area contains the city's most historic buildings.  " +
                " The Lower Town, along the St. Lawrence River, is the site of the original settlement and home to the outstanding Fairmont Le Château Frontenac, as well as numerous other treasures. " +
                "The Upper Town rests on 100-meter-high cliffs and is home to the Citadel, the Plains of Abraham, Place d'Armes, and the Parque Historique de l'Artillerie.";
        String whister = "Just a two-hour drive from Vancouver is the famous ski resort and village of Whistler."+ "While Whistler has always been an important winter sports area, it has also developed into a popular summer destination, with golf, mountain biking, and a lively town atmosphere throughout the year." +
                "Québec City – the capital of the Canadian province, Québec – dwelled in the shadow of its neighbor, Montréal, for a long time, but the 2008 celebration of its 400th birthday catapulted Québec City back into the spotlight. ";
        String ottawa = "Ottawa's Parliament Hill stands high above the Ottawa River and is graced by the Neo-Gothic-style Parliament buildings built in the last half of the 19th century. The most prominent feature is the Peace Tower, which divides the House of Commons and the Senate on either side. In front of the Parliament buildings is the Centennial Flame, lit in 1966 to commemorate the centenary of the Canadian Confederation, and behind the buildings is a sculpture garden." +
                " In the summer, the Changing of the Guard takes place on the front lawn of the Houses of Parliament, weather permitting. Below Parliament Hill, a lovely walk runs alongside the Ottawa River.";
        String grosmorne = "This UNESCO World Heritage Site encompasses nearly 448,000 acres on Newfoundland's west coast. Its top activity is undoubtedly hiking the Tablelands. Here, you'll traverse exposed earth mantle, a rust-colored landscape that was created millions of years ago by a collision of tectonic plates. Equally impressive: a boat ride through Western Brook Pond, which is a glacier-carved, landlocked fjord that features cascading waterfalls measuring 2,000 feet.";
        String kluane = "Calling all adventure travelers: Kluane National Park and Reserve is home to Canada's highest peak (Mount Logan), the country's largest ice field and the continent's most genetically diverse grizzly population. Situated in the southwest corner of the Yukon, the park lures intrepid explorers with rafting trips on the Alsek River, multiday backcountry hikes and mountaineering on the Icefield Ranges of the St. Elias Mountains.";
        String mont = "Nestled in the Laurentian Mountains northwest of Montréal, Mont-Tremblant is best known for its skiing, specifically Tremblant Resort, which occupies the highest peak in the mountain range. But warm-weather visitors are equally enchanted thanks to the Parc national du Mont-Tremblant, which boasts six rivers and 400 lakes and streams, not to mention countless hiking trails and beaches. Horseback riding, fishing and mountain biking are all popular here thanks to the area's diverse landscape.";
String bear = "One of Canada's most unique attractions is the polar bear migration that sees these beautiful creatures make their way from land out onto the ice in Hudson Bay, near the town of Churchill in Northern Manitoba.";
        attractions = new ArrayList<>();

        attractions.add(new CanadaAttraction("1","Niagara Falls","6650 Niagara Parkway. (River Rd) ","Niagara Falls","Ontario", niagra,R.drawable.niagra));
        attractions.add(new CanadaAttraction("2","Banff National Park & the Rocky Mountains","1029 Banff Ave, Banff, AB T1L 1H8","Banff","Alberta",banff,R.drawable.banff));
        attractions.add(new CanadaAttraction("3","Toronto's CN Tower"," 290 Bremner Blvd Toronto","Toronto","Ontario",cntower, R.drawable.cntower));
        attractions.add(new CanadaAttraction("4","Old Quebec (Vieux-Quebec)","205, boulevard des Cèdres","Quebiec","Quebec", olQuebec,R.drawable.oldquebc));
        attractions.add(new CanadaAttraction("5","Whistler","Village Gate Blvd","Whistler","British Columbia", whister, R.drawable.whislte));
        attractions.add(new CanadaAttraction("6","Ottawa's Parliament Hill","Wellington St","Ottawa","Ottawa", ottawa ,R.drawable.ottawa));
        attractions.add(new CanadaAttraction("7","Grosmorne Park","Rocky Harbour","Newfoundland","Newfoundland", grosmorne ,R.drawable.gross));
        attractions.add(new CanadaAttraction("8","Kluane Reserve","Unorganized Yukon, YT Y0B 1H0","Dawson","Yukon", kluane ,R.drawable.klune));
        attractions.add(new CanadaAttraction("9","Mont Tremblant","Rue Leonard","Montreal","Quebec", mont,R.drawable.monttremblnet));
        attractions.add(new CanadaAttraction("10","Polar Bears of Churchill","manitoba","Manitoba","Ottawa", bear,R.drawable.bear));

    }
}


