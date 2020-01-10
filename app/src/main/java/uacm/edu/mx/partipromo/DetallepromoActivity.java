package uacm.edu.mx.partipromo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetallepromoActivity extends AppCompatActivity {

    Button btnEnviarRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallepromo);

        btnEnviarRegistro=(Button) findViewById(R.id.btnContinuar);

        btnEnviarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_registro);
            }
        });


    }
}
