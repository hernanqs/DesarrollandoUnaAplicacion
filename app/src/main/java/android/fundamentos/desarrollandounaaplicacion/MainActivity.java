package android.fundamentos.desarrollandounaaplicacion;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {
    android.support.design.widget.TextInputEditText inputNombre;
    android.support.design.widget.TextInputEditText inputTelefono;
    android.support.design.widget.TextInputEditText inputEmail;
    android.support.design.widget.TextInputEditText inputDescripcion;

    DatePicker inputNacimiento;

    String nombre;
    String telefono;
    String email;
    String descripcion;
    int diaNacimiento;
    int mesNacimiento;
    int anioNacimiento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            android.content.Intent i = getIntent();
            Bundle datosDeUsuario = getIntent().getExtras();

            inputNombre = findViewById(R.id.input_nombre);
            inputTelefono = findViewById(R.id.input_telefono);
            inputEmail = findViewById(R.id.input_email);
            inputDescripcion = findViewById(R.id.input_descripcion);
            inputNacimiento = findViewById(R.id.input_nacimiento);

            nombre = datosDeUsuario.getString(getResources().getString(R.string.extra_nombre));
            telefono = datosDeUsuario.getString(getResources().getString(R.string.extra_telefono));
            email = datosDeUsuario.getString(getResources().getString(R.string.extra_email));
            descripcion = datosDeUsuario.getString(getResources().getString(R.string.extra_descripcion));
            diaNacimiento = datosDeUsuario.getInt(getResources().getString(R.string.extra_dia_nacimiento));
            mesNacimiento = datosDeUsuario.getInt(getResources().getString(R.string.extra_mes_nacimiento));
            anioNacimiento = datosDeUsuario.getInt(getResources().getString(R.string.extra_anio_nacimiento));

            inputNombre.setText(nombre);
            inputTelefono.setText(telefono);
            inputEmail.setText(email);
            inputDescripcion.setText(descripcion);

            inputNacimiento.updateDate(anioNacimiento, mesNacimiento, diaNacimiento);

        } catch (Exception e) {
            e.printStackTrace();
        }


        agregarClickListenerABotonSiguiente();
    }

    public void agregarClickListenerABotonSiguiente() {
        Button botonSiguiente = (Button) findViewById(R.id.boton_siguiente);
        botonSiguiente.setOnClickListener(
                new android.view.View.OnClickListener() {
                    public void onClick(android.view.View boton) {
                        inputNombre = findViewById(R.id.input_nombre);
                        String nombre = inputNombre.getText().toString();
                        inputTelefono = findViewById(R.id.input_telefono);
                        String telefono = inputTelefono.getText().toString();
                        inputEmail = findViewById(R.id.input_email);
                        String email = inputEmail.getText().toString();
                        inputDescripcion = findViewById(R.id.input_descripcion);
                        String descripcion = inputDescripcion.getText().toString();

                        inputNacimiento = findViewById(R.id.input_nacimiento);
                        diaNacimiento = inputNacimiento.getDayOfMonth();
                        mesNacimiento = inputNacimiento.getMonth();
                        anioNacimiento = inputNacimiento.getYear();

                        android.content.Intent intentSiguiente = new android.content.Intent(MainActivity.this, ConfirmarDatos.class);
                        intentSiguiente.putExtra(getResources().getString(R.string.extra_nombre), nombre);
                        intentSiguiente.putExtra(getResources().getString(R.string.extra_telefono), telefono);
                        intentSiguiente.putExtra(getResources().getString(R.string.extra_email), email);
                        intentSiguiente.putExtra(getResources().getString(R.string.extra_descripcion), descripcion);
                        intentSiguiente.putExtra(getResources().getString(R.string.extra_dia_nacimiento), diaNacimiento);
                        intentSiguiente.putExtra(getResources().getString(R.string.extra_mes_nacimiento), mesNacimiento);
                        intentSiguiente.putExtra(getResources().getString(R.string.extra_anio_nacimiento), anioNacimiento);

                        startActivity(intentSiguiente);
                    }
                }
        );
    }
}