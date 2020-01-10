package uacm.edu.mx.partipromo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PromoprincipalActivity extends AppCompatActivity {

    ImageView dominos, star, burguer,donal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promoprincipal);

        dominos = (ImageView) findViewById(R.id.imageView3);
        star = (ImageView) findViewById(R.id.imageView2);
        burguer = (ImageView) findViewById(R.id.imageView4);
        donal= (ImageView) findViewById(R.id.mcdonal);

        dominos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetallepromoActivity.class);
                intent.putExtra("EnviaPromo","dominos");
                startActivityForResult(intent, 0);
            }
        });

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DetallepromoActivity.class);
                intent.putExtra("EnviaPromo","star");
                startActivityForResult(intent, 0);
            }
        });

        burguer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DetallepromoActivity.class);
                intent.putExtra("EnviaPromo","burguer");
                startActivityForResult(intent, 0);
            }
        });

       donal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DetallepromoActivity.class);
                intent.putExtra("EnviaPromo","donal");
                startActivityForResult(intent, 0);
            }
        });

    }

    public void enviaMsj(String mensaje, String llaveMsj, Class activity) {
        Intent intent = new Intent(this, activity);
        intent.putExtra(llaveMsj, mensaje);
        startActivity(intent);
    }
}
