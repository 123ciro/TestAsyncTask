package py.com.personal.testasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        resultado= findViewById(R.id.txtMensaje);

        String nombre = getIntent().getStringExtra("usuario");

        resultado.setText("Bienvenido " + nombre);
    }
}
