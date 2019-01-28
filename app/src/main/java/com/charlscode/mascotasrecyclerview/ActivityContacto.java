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

  /*  public DataHandler(DataSource ds) throws MessagingException {
        return DataSourc

        public void sendEmail () throws AddressException, MessagingException {
            String host = "smtp.gmail.com";
            String address = "address@gmail.com";
            String from = "fromaddress@gmail.com";
            String pass = "password";
            String to = "toaddress@gmail.com";
            Multipart multiPart;
            String finalString = "";

            Properties props = System.getProperties();
            props.put( "mail.smtp.starttls.enable", "true" );
            props.put( "mail.smtp.host", host );
            props.put( "mail.smtp.user", address );
            props.put( "mail.smtp.password", pass );
            props.put( "mail.smtp.port", "587" );
            props.put( "mail.smtp.auth", "true" );
            Log.i( "Check", "done pops" );
            Session session = Session.getDefaultInstance( props, null );
            DataHandler handler = new DataHandler( new ByteArrayDataSource( finalString.getBytes(), "text/plain" ) );
            MimeMessage message = new MimeMessage( session );
            message.setFrom( new InternetAddress( from ) );
            message.setDataHandler( handler );
            Log.i( "Check", "done sessions" );

            multiPart = new MimeMultipart();

            InternetAddress toAddress;
            toAddress = new InternetAddress( to );
            message.addRecipient( Message.RecipientType.TO, toAddress );
            Log.i( "Check", "added recipient" );
            message.setSubject( "Send Auto-Mail" );
            message.setContent( multiPart );
            message.setText( "Demo For Sending Mail in Android Automatically" );
            Log.i( "check", "transport" );
            Transport transport = session.getTransport( "smtp" );
            Log.i( "check", "connecting" );
            transport.connect( host, address, pass );
            Log.i( "check", "wana send" );
            transport.sendMessage( message, message.getAllRecipients() );
            transport.close();
            Log.i( "check", "sent" );
        }
        */





