package com.charlscode.mascotasrecyclerview;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.sql.DataSource;
import javax.mail.PasswordAuthentication;


public class ActivityContacto extends AppCompatActivity {

    private EditText etEmail;
    private EditText etNombreCompleto;
    private EditText etMensaje;
    String email;
    String nombre;
    String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_contacto );

        Button btEnviarComentarios = (Button) findViewById( R.id.btnEnviar );
        btEnviarComentarios.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etEmail = (EditText) findViewById( R.id.eTMail );
                etNombreCompleto = (EditText) findViewById( R.id.eTNombre );
                etMensaje = (EditText) findViewById( R.id.eTDescripcion );
                email = etEmail.getText().toString();
                nombre = etNombreCompleto.getText().toString();
                mensaje = etMensaje.getText().toString();
                Toast.makeText( getBaseContext(), "Enviando mensaje", Toast.LENGTH_LONG ).show();
                Intent sendIntent = new Intent( (Intent.ACTION_SEND) );
                sendIntent.setType( "plain/text" );
                sendIntent.putExtra( Intent.EXTRA_EMAIL, new String[]{email} );
                sendIntent.putExtra( Intent.EXTRA_TEXT, mensaje );
                sendIntent.putExtra( Intent.EXTRA_SUBJECT, "Mensaje enviado por " + nombre );
                startActivity( Intent.createChooser( sendIntent, "Enviar mail atraves de " ) );
            }
        } );

    }

    public void irBack(View a) {
        finish();
    }
}





