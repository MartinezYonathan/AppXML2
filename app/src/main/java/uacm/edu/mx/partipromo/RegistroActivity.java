package uacm.edu.mx.partipromo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RegistroActivity extends AppCompatActivity {


    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

    }

    public void foto(View view) {

            Intent tomarFoto= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            if(tomarFoto.resolveActivity(getPackageManager())!=null)
            {
                startActivityForResult(tomarFoto,REQUEST_IMAGE_CAPTURE);


            }

        }

}
