package com.example.utp.loginporniveles;

import android.app.Activity;
import android.content.Intent;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class LoginActivity extends Activity {

    EditText edtUsuario,edtPassword;
    Button btnIngresar;
    Spinner spinner;

    static final String USU_ADMIN = "brandon";
    static final String PASS_ADMIN = "123";

    static final String USU_GERENTE = "paolo";
    static final String PASS_GERENTE = "123";

    static final String USU_PERSONAL = "diego";
    static final String PASS_PERSONAL = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        spinner = (Spinner)findViewById(R.id.spinner);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ValidarCredenciales(ObtenerUsuario(),ObtenerPassword(),ObtenerNivel());

            }
        });

    }

    public String ObtenerUsuario()
    {
        String usuario;
        usuario = edtUsuario.getText().toString().trim();
        edtUsuario.setText("");
        return usuario;
    }

    public String ObtenerPassword()
    {
        String password;
        password = edtPassword.getText().toString().trim();
        edtPassword.setText("");
        return password;
    }

    public String ObtenerNivel()
    {
        return spinner.getSelectedItem().toString();
    }

    public void ValidarCredenciales(String usuario, String password,String Nivel)
    {
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        intent.putExtra("NIVEL",Nivel);

        switch (Nivel)
        {

            case "ADMINISTRADOR":{

                if(usuario.equals(USU_ADMIN) && password.equals(PASS_ADMIN))
                {

                        startActivity(intent);
                }else
                    {
                        Toast.makeText(this, "La contraseña o cuenta  de administrador no es la correcta.", Toast.LENGTH_SHORT).show();
                    }

                break;}
            case "GERENTE":{

                if(usuario.equals(USU_GERENTE) && password.equals(PASS_GERENTE))
                {

                    startActivity(intent);
                }else
                {
                    Toast.makeText(this, "La contraseña o cuenta de gerente no es la correcta.", Toast.LENGTH_SHORT).show();
                }

                break;}
            case "PERSONAL":{

                if(usuario.equals(USU_PERSONAL) && password.equals(PASS_PERSONAL))
                {

                    startActivity(intent);
                }else
                {
                    Toast.makeText(this, "La contraseña o cuenta de personal no es la correcta.", Toast.LENGTH_SHORT).show();
                }

                break;}
            default:{
                        Toast.makeText(this, "PROBLEMA DE VALIDACIÓN. Intente de nuevo.", Toast.LENGTH_SHORT).show();
                break;}
        }


           /* if(true)
            {

            }else if(true)
            {

            }else if(true)
            {

            }else
                {

                }*/
    }

}
