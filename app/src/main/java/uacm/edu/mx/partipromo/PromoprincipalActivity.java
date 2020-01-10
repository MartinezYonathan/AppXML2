package uacm.edu.mx.partipromo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PromoprincipalActivity extends AppCompatActivity {

    ImageView dominos,star,burguer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promoprincipal);

        dominos=(ImageView) findViewById(R.id.imageView3);
        star=(ImageView) findViewById(R.id.imageView2);
        burguer=(ImageView) findViewById(R.id.imageView4);

        dominos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_detallepromo);
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
}
