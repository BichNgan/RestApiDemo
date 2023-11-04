package android.restapidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button btn_Artist, btn_Album, btn_playlist;
    EditText edtIp;
    TextView textView;
    ListView lvKq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }
    void addControls()
    {
        btn_Artist = (Button) findViewById(R.id.btn1);
        btn_Album = (Button) findViewById(R.id.btn2);
        btn_playlist = (Button) findViewById(R.id.btn3);
        edtIp = (EditText) findViewById(R.id.edtIp);
        lvKq=(ListView) findViewById(R.id.lvKq);
        textView=(TextView) findViewById(R.id.textView);

    }
    void addEvents()
    {
        btn_Artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://soundiiz.com/data/fileExamples/artistsExport.json";

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Hiển thị 500 ký tự đầu tiên của chuỗi trả về từ api
                        //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        textView.setText("error");
                    }

                });

                queue.add(stringRequest);
            }
        });

        btn_Album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

                String id=edtIp.getText().toString();
                String url = "https://my-json-server.typicode.com/typicode/demo/posts/"+id;

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Hiển thị 500 ký tự đầu tiên của chuỗi trả về từ api
                        //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        textView.setText("error");
                    }

                });

                queue.add(stringRequest);
            }
        });

        btn_playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}