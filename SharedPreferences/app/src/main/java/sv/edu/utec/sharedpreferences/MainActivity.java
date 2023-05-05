package sv.edu.utec.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import sv.edu.utec.sharedpreferences.Helper.AdminSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {
EditText txtcodClient, txtNomClient, txtApeClient, txtDirec, txtCiudad;
Button btnInserts, btnUpdates, btnDeletes;
    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "parcial3", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtcodClient=findViewById(R.id.editTextTextPersonName);
        txtNomClient=findViewById(R.id.editTextTextPersonName3);
        txtApeClient=findViewById(R.id.editTextTextPersonName4);
        txtDirec=findViewById(R.id.editTextTextPersonName5);
        txtCiudad=findViewById(R.id.editTextTextPersonName7);
        btnInserts=findViewById(R.id.btnInsert);
        btnUpdates=findViewById(R.id.btnUpdate);
        btnDeletes=findViewById(R.id.btnDelete);

        btnInserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               SQLiteDatabase bd= admin.getWritableDatabase();
               String cod=txtcodClient.getText().toString();
               String nom=txtNomClient.getText().toString();
               String ape=txtApeClient.getText().toString();
               String dir=txtDirec.getText().toString();
               String ciu=txtCiudad.getText().toString();

                ContentValues informacion = new ContentValues();
                informacion.put("ID_Cliente", cod);
                informacion.put("sNombreCliente", nom);
                informacion.put("sApellidosCliente", ape);
                informacion.put("sDireccionCleinte", dir);
                informacion.put("sCiudadCliente", ciu);

                bd.insert("MD_Clientes", null, informacion);
                bd.close();

            }
        });
    }
}