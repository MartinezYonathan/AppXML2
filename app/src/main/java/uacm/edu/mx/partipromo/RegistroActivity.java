package uacm.edu.mx.partipromo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import android.view.View.OnClickListener;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import uacm.edu.mx.partipromo.domain.Participante;

public class RegistroActivity extends AppCompatActivity {


    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView imageFoto;
    private EditText nombre, apellido,edad,email;
    private StorageReference mStorageRef;
    Bitmap imageBitmap;
    String nombreU, apellidoU,edadU,emailU;

    private DatabaseReference myref;
    Button btnEnvioDatosUser;


    private CheckBox checkB;
    private Boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        imageFoto = (ImageView) findViewById(R.id.imageFoto);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        checkB = (CheckBox) findViewById(R.id.checkBox);
        nombre= (EditText) findViewById(R.id.edtxtNombre);
        apellido= (EditText) findViewById(R.id.editTextApellidos);
        edad= (EditText) findViewById(R.id.editTextEdad);
        email= (EditText) findViewById(R.id.editTextEmail);
        btnEnvioDatosUser=(Button) findViewById(R.id.btnEnviarEmail);

        myref= FirebaseDatabase.getInstance().getReference();







        addListenerOnChkIos();

      btnEnvioDatosUser.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View view) {

              nombreU=nombre.getText().toString();
              apellidoU=apellido.getText().toString();
              emailU=email.getText().toString();
              edadU=edad.getText().toString();




              Participante p1= new Participante(nombreU,apellidoU,edadU,emailU);

              if(p1!=null){

                  registrarUsuario();

              }
              else
              {
                  Toast.makeText(getBaseContext(),"debe ingresar datos para registrarlos", Toast.LENGTH_LONG).show();
              }

              DatabaseReference usuRef=myref.child("p1");
              usuRef.setValue(p1);

          }
      });
    }


    public void addListenerOnChkIos() {
        checkB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(getBaseContext(),"Bro, si Android :)", Toast.LENGTH_LONG).show();
                    check = true;
                }else{
                    Toast.makeText(getBaseContext(), "Bro, no Android", Toast.LENGTH_LONG);
                    check = false;
                }
            }
        });
    }

    public void tamarFoto(View v) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void enviarDatos(View v) {
        if (check){
            //Esto solo lo puse de prueba, solo es poner el metodo de subirFoto y el registro  y yaestaria algo funcional
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
        /*StringBuffer result = new StringBuffer();
        result.append("\nWindows Mobile check :").append(checkB.isChecked());

        Toast.makeText(getBaseContext(), result.toString(), Toast.LENGTH_LONG);*/
    }

    public void subirFoto(View v) {

        String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());


        // Creamos una referencia a la carpeta y el nombre de la imagen donde se guardara
        StorageReference imagenRef = mStorageRef.child("camara/" + timeStamp + ".jpg");

        //Pasamos la imagen a un array de byte
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] datas = baos.toByteArray();

        // Empezamos con la subida a Firebase
        UploadTask uploadTask = imagenRef.putBytes(datas);
        uploadTask.addOnFailureListener(new OnFailureListener() {

            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(getBaseContext(), "Hubo un error", Toast.LENGTH_LONG);
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getBaseContext(), "Subida con exito", Toast.LENGTH_LONG);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            imageFoto.setImageBitmap(imageBitmap);
        }
    }

    public void registrarUsuario(){


    }

}
