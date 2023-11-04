package android.restapidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class ArtistActivity extends AppCompatActivity {
        TextView tvArtist;
        ListView lvArtist;
        CustomAdapterArtist adapterArtist;
        ArrayList<Artist> lsArtist = new ArrayList<>();
        String url="https://soundiiz.com/data/fileExamples/artistsExport.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        tvArtist=(TextView) findViewById(R.id.tvArtist);
        lvArtist = (ListView) findViewById(R.id.lvArtist);
        //-----------------------------------
        getAllDataArtist(url);
    }

    public void getAllDataArtist( String url)
    {
        RequestQueue requestQueue= Volley.newRequestQueue(ArtistActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                     parseJsonData(response);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);

    }
    public void  parseJsonData(String response) throws JSONException {

        JSONArray artistArray  = new JSONArray(response);
        for(int i=0;i<artistArray.length();i++)
        {
            JSONObject artist= artistArray.getJSONObject(i);
            Artist a  =new Artist();
            a.name = artist.getString("name");
            a.numberFans = artist.getString("fans");
            a.piclink = artist.getString("picture"); //link của hình
            lsArtist.add(a);
        }
        adapterArtist=new CustomAdapterArtist(getApplicationContext(),R.layout.layout_item_artist,
                lsArtist);
        lvArtist.setAdapter(adapterArtist);
    }



}






