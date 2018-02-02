package com.example.fcamacho.tarea1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected AutoCompleteTextView textView;
    protected EditText nombre;
    protected EditText phone;
    protected Spinner educacion;
    protected RadioGroup genero;
    protected RadioButton hombre;
    protected RadioButton mujer;
    protected CheckBox check;
    protected Button limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.main_activity_autocomplete);
        String[] lfavoritos = getResources().getStringArray(R.array.string_libros);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lfavoritos);
        textView.setAdapter(adapter);
        limpiar = findViewById(R.id.main_activity_btn_limpiar);

    }
    public void resetAll(View v){
        AlertDialog.Builder clean_dialog = new AlertDialog.Builder(this);
        clean_dialog.setMessage(R.string.dialog_message);
        clean_dialog.setTitle(R.string.dialog_title);
        clean_dialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                borrar();
            }
        });
        clean_dialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog dialogoBorrar = clean_dialog.create();
        dialogoBorrar.show();

    }
    public void borrar(){
        finds();
        nombre.setText("");
        phone.setText("");
        genero.clearCheck();
        textView.setText("");
        educacion.setSelection(0);
        check.setChecked(false);
        mujer.setChecked(false);
        Toast.makeText(this,R.string.delete_content,Toast.LENGTH_LONG).show();
    }
    // menu
    // metodo para mostrar el menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu, menu); //mi.inflate(R.menu.xml del menu, menu)
        return true;

    }
    // acciones para los items del menu
    Alumno alumno = new Alumno();
   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item01:
                Toast.makeText(this,assigns(),Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public String assigns(){
        finds();
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre.getText().toString());
        alumno.setTelefono(phone.getText().toString());
        alumno.setEducacion(educacion.getSelectedItem().toString());
        alumno.setLibro(textView.getText().toString());
        alumno.setHombre(hombre.isChecked());
        alumno.setCheckBox(check.isChecked());
        return alumno.ToString();
    }
    public void finds(){
        nombre = findViewById(R.id.main_activity_nombre);
        phone = findViewById(R.id.main_activity_telefono);
        educacion = findViewById(R.id.main_activity_spinner);
        genero = findViewById(R.id.main_activity_radio_group);
        hombre = findViewById(R.id.main_activity_radio_hombre);
        mujer = findViewById(R.id.main_activity_radio_mujer);
        check = findViewById(R.id.main_activity_checkbox);
    }
}
