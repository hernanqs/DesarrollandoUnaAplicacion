package android.fundamentos.desarrollandounaaplicacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ConfirmarDatos extends AppCompatActivity {
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
        setContentView(R.layout.activity_confirmar_datos);

        Bundle datosDeUsuario = getIntent().getExtras();

        nombre = datosDeUsuario.getString(getResources().getString(R.string.extra_nombre));
        android.widget.TextView textview_nombre = findViewById(R.id.nombre);
        textview_nombre.setText(nombre);

        diaNacimiento = datosDeUsuario.getInt(getResources().getString(R.string.extra_dia_nacimiento));
        mesNacimiento = datosDeUsuario.getInt(getResources().getString(R.string.extra_mes_nacimiento));
        anioNacimiento = datosDeUsuario.getInt(getResources().getString(R.string.extra_anio_nacimiento));
        android.widget.TextView textview_nacimiento = findViewById(R.id.fecha_nacimiento);
        textview_nacimiento.setText(diaNacimiento + "/" + (mesNacimiento+1) + "/" + anioNacimiento);

        telefono = datosDeUsuario.getString(getResources().getString(R.string.extra_telefono));
        android.widget.TextView textview_telefono = findViewById(R.id.telefono);
        textview_telefono.setText("Tel: " + telefono);

        email = datosDeUsuario.getString(getResources().getString(R.string.extra_email));
        android.widget.TextView textview_email = findViewById(R.id.email);
        textview_email.setText("Email: "+ email);

        descripcion = datosDeUsuario.getString(getResources().getString(R.string.extra_descripcion));
        android.widget.TextView textview_descripcion = findViewById(R.id.descripcion);
        textview_descripcion.setText("Descripción: " + descripcion);

        agregarClickListenerABotonEditar();

    }

    public void agregarClickListenerABotonEditar() {
        Button botonEditar = (Button) findViewById(R.id.boton_editar);
        botonEditar.setOnClickListener(
                new android.view.View.OnClickListener() {
                    //@override
                    public void onClick(android.view.View boton) {
                        android.content.Intent intentEditar = new android.content.Intent(ConfirmarDatos.this, MainActivity.class);
                        intentEditar.putExtra(getResources().getString(R.string.extra_nombre), nombre);
                        intentEditar.putExtra(getResources().getString(R.string.extra_telefono), telefono);
                        intentEditar.putExtra(getResources().getString(R.string.extra_email), email);
                        intentEditar.putExtra(getResources().getString(R.string.extra_descripcion), descripcion);
                        intentEditar.putExtra(getResources().getString(R.string.extra_dia_nacimiento), diaNacimiento);
                        intentEditar.putExtra(getResources().getString(R.string.extra_mes_nacimiento), mesNacimiento);
                        intentEditar.putExtra(getResources().getString(R.string.extra_anio_nacimiento), anioNacimiento);

                        startActivity(intentEditar);
                    }
                }
        );
    }

}