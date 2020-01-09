package uacm.edu.mx.partipromo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView bgapp, clover,campana;
    LinearLayout textsplash, texthome, menus;
    Animation frombottom;
    Button btnRegistrar;



    private TextView txtMenu;
    private TextView txtDescrip;
    private TextView txtInicio;
    private TextView txtNombre;

    private Typeface Abigail;
    private Typeface April;
    private Typeface kabouter;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        cambiarFont();

        bgapp = (ImageView) findViewById(R.id.bgapp);

        campana=(ImageView) findViewById(R.id.campana);


        clover = (ImageView) findViewById(R.id.clover);
        textsplash = (LinearLayout) findViewById(R.id.textsplash);
        texthome = (LinearLayout) findViewById(R.id.texthome);
        menus = (LinearLayout) findViewById(R.id.menus);

        bgapp.animate().translationY(-2100).setDuration(2000).setStartDelay(1000);
        clover.animate().alpha(0).setDuration(2000).setStartDelay(1000);
        textsplash.animate().translationY(140).alpha(0).setDuration(2000).setStartDelay(1000);

        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);


        campana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              setContentView(R.layout.activity_registro);


            }
        });





    }

    public void cambiarFont(){
        String fuente1 = "fonts/WhiteSmith.otf";
        this.Abigail = Typeface.createFromAsset(getAssets(),fuente1);
        txtMenu = (TextView) findViewById(R.id.txtMenu);
        txtMenu.setTypeface(Abigail);

        String fuente2 = "fonts/April.otf";
        this.April = Typeface.createFromAsset(getAssets(),fuente2);
        txtDescrip = (TextView) findViewById(R.id.txtDescrip);
        txtDescrip.setTypeface(April);

        String fuente3 = "fonts/Kabouter.otf";
        txtInicio = (TextView) findViewById(R.id.txtInicio);
        txtInicio.setTypeface(Abigail);

        this.kabouter = Typeface.createFromAsset(getAssets(),fuente3);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtNombre.setTypeface(kabouter);

    }
}
