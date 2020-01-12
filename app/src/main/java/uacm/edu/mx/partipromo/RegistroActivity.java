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
    private EditText nombre, apellido, edad, email;
    private StorageReference mStorageRef;
    private Bitmap imageBitmap = null;

    private DatabaseReference myref;

    private CheckBox checkB;
    private Boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        imageFoto = (ImageView) findViewById(R.id.imageFoto);
        checkB = (CheckBox) findViewById(R.id.checkBox);
        nombre = (EditText) findViewById(R.id.edtxtNombre);
        apellido = (EditText) findViewById(R.id.editTextApellidos);
        edad = (EditText) findViewById(R.id.editTextEdad);
        email = (EditText) findViewById(R.id.editTextEmail);

        mStorageRef = FirebaseStorage.getInstance().getReference();
        myref = FirebaseDatabase.getInstance().getReference();

        addListenerOnChkIos();
    }

    public void addListenerOnChkIos() {
        checkB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    check = true;
                } else {
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

    public void enviar_datos(View v) {

        if (check) {
            //Esto solo lo puse de prueba, solo es poner el metodo de subirFoto y el registro  y yaestaria algo funcional
            String nombreU = nombre.getText().toString();
            String apellidoU = apellido.getText().toString();
            String emailU = email.getText().toString();
            String edadU = edad.getText().toString();

            registrarUsuario(nombreU, apellidoU, edadU, emailU);

        } else {
            Toast.makeText(getBaseContext(), "ACEPTA TERMINOS :(", Toast.LENGTH_LONG).show();
        }
    }

    public void subirFoto() {

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

    public void registrarUsuario(String nombreU, String apellidoU, String edadU, String emailU) {

        if (nombreU.equals("")) {
            Toast.makeText(getBaseContext(), "ERROR FALTA NOMBRE :(", Toast.LENGTH_LONG).show();
        } else if (apellidoU.equals("")) {
            Toast.makeText(getBaseContext(), "ERROR FALTA APELLIDO :(", Toast.LENGTH_LONG).show();
        } else if (edadU.equals("")) {
            Toast.makeText(getBaseContext(), "ERROR FALTA EDAD :(", Toast.LENGTH_LONG).show();
        } else if (emailU.equals("")) {
            Toast.makeText(getBaseContext(), "ERROR FALTA EMAIL :(", Toast.LENGTH_LONG).show();
        } else if (imageBitmap == null) {
            Toast.makeText(getBaseContext(), "ERROR FALTA IMAGEN :(", Toast.LENGTH_LONG).show();
        } else {
            DatabaseReference usersRef = myref.child("users");
            usersRef.push().setValue(new Participante(nombreU, apellidoU, edadU, emailU));
            subirFoto();

            Toast.makeText(getBaseContext(), "Registrada promocion:)", Toast.LENGTH_LONG).show();
        }
    }

}
