package py.com.personal.testasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Button btnValidar;
    private EditText usuario,clave;
    private ProgressBar progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnValidar = findViewById(R.id.btnValidar);
        usuario = findViewById(R.id.user);
        clave = findViewById(R.id.pass);
        progreso= findViewById(R.id.progressBar1);


        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task1().execute(usuario.getText().toString());
            }
        });
    }


    public class Task1 extends AsyncTask<String,Void,String> {

        @Override
        protected void onPreExecute() {

            progreso.setVisibility(View.VISIBLE);
            btnValidar.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(5000);

            }catch (InterruptedException e){
                e.printStackTrace();
            }

            return  strings[0];
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progreso.setVisibility(View.INVISIBLE);
            btnValidar.setEnabled(true);

            Intent inte = new Intent(MainActivity.this,ResultadoActivity.class);
            inte.putExtra("usuario",usuario.getText().toString());
            startActivity(inte);

        }

    }


}
