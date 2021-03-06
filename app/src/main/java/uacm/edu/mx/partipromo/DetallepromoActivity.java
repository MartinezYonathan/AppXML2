package uacm.edu.mx.partipromo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import uacm.edu.mx.partipromo.domain.Promocion;

public class DetallepromoActivity extends AppCompatActivity {

    Button btnEnviarRegistro;

    TextView tituloPromo,descripPromo;

    ImageView imagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallepromo);

        Promocion promoBurguer= new Promocion("Hoy rica hamburguesa","Sòlo por llevate una rica hamburguesa,con papas y refresco");
        Promocion promoStarbucks= new Promocion("Martes de Cafe","Sòlo por llevate una rica hamburguesa,con papas y refresco");
        Promocion promoPizza= new Promocion("Pizza de peperoni","Pizza con dos ingredientes mediana para dos personas");
        Promocion promoMacdonals= new Promocion("Mc trio","Hamburguesa con tocino y refresco para 5 personas");


        btnEnviarRegistro=(Button) findViewById(R.id.btnContinuar);

        tituloPromo=(TextView) findViewById(R.id.txtTituloPromo);
        descripPromo=(TextView) findViewById(R.id.txtDescripcionPromo);
        imagen=(ImageView) findViewById(R.id.imageView5);

        String nombre=getIntent().getStringExtra("EnviaPromo");
        tituloPromo.setText(nombre);

        if(tituloPromo.getText().toString().equals("dominos")){

            tituloPromo.setText(promoPizza.getTituloPromoción());
            descripPromo.setText(promoPizza.getDescripcionPromo());
            //imagen=(ImageView) findViewById(R.id.imageView5);
            imagen.setImageDrawable(getResources().getDrawable(R.drawable.detalledominos,getApplicationContext().getTheme()));


        }

        if(tituloPromo.getText().toString().equals("star")){

            tituloPromo.setText(promoStarbucks.getTituloPromoción());
            descripPromo.setText(promoStarbucks.getDescripcionPromo());
            imagen.setImageDrawable(getResources().getDrawable(R.drawable.detallestarbucks,getApplicationContext().getTheme()));



        }
        if(tituloPromo.getText().toString().equals("burguer")){

            tituloPromo.setText(promoBurguer.getTituloPromoción());
            descripPromo.setText(promoBurguer.getDescripcionPromo());
            imagen.setImageDrawable(getResources().getDrawable(R.drawable.detallebk,getApplicationContext().getTheme()));


        }
        if(tituloPromo.getText().toString().equals("donal")){

            tituloPromo.setText(promoMacdonals.getTituloPromoción());
            descripPromo.setText(promoMacdonals.getDescripcionPromo());
            imagen.setImageDrawable(getResources().getDrawable(R.drawable.detallemc,getApplicationContext().getTheme()));


        }

        btnEnviarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),RegistroActivity.class);
                //intent.putExtra("EnviaPromo","burguer");
                startActivityForResult(intent, 0);
            }
        });


    }
}
