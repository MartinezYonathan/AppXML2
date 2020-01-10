package uacm.edu.mx.partipromo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PromoprincipalActivity extends AppCompatActivity {

    ImageView dominos, star, burguer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promoprincipal);

        dominos = (ImageView) findViewById(R.id.imageView3);
        star = (ImageView) findViewById(R.id.imageView2);
        burguer = (ImageView) findViewById(R.id.imageView4);

        Toast.makeText (getApplicationContext (), "Hola Javatpoint2" , Toast.LENGTH_SHORT) .show ();


        dominos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hola Javatpoint", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), RegistroActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_detallepromo);
            }
        });

        burguer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_detallepromo);
            }
        });

    }

    public void enviaMsj(String mensaje, String llaveMsj, Class activity) {
        Intent intent = new Intent(this, activity);
        intent.putExtra(llaveMsj, mensaje);
        startActivity(intent);
    }
}
