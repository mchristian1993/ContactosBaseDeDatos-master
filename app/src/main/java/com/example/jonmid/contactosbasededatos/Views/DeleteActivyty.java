package com.example.jonmid.contactosbasededatos.Views;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonmid.contactosbasededatos.ContactsActivity;
import com.example.jonmid.contactosbasededatos.Helpers.SqliteHelper;
import com.example.jonmid.contactosbasededatos.Models.Contact;
import com.example.jonmid.contactosbasededatos.R;
import com.example.jonmid.contactosbasededatos.Utilities.Constants;

public class DeleteActivyty extends AppCompatActivity {

    TextView txt_id, txt_name, txt_phone, txt_email;
public Integer id;
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_activyty);
        txt_id = (TextView) findViewById(R.id.txt_id);
        txt_name = (TextView) findViewById(R.id.txt_name);
        txt_phone = (TextView) findViewById(R.id.txt_phone);
        txt_email = (TextView) findViewById(R.id.txt_email);

        sqliteHelper = new SqliteHelper(this, "db_contacts", null, 1);



        txt_id.setText(Integer.toString(getIntent().getExtras().getInt("id")));
    txt_name.setText(getIntent().getExtras().getString("name"));
        txt_phone.setText(getIntent().getExtras().getString("phone"));
        txt_email.setText(getIntent().getExtras().getString("email"));


    }



    public void regresar(View view) {


        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);


        // /String valor = Integer.toString(albumModelList.get(getLayoutPosition()).getId());
        // Toast.makeText(contextItem, valor, Toast.LENGTH_SHORT).show();

    }

    public void delete(View view) {
        id = Integer.parseInt(txt_id.getText().toString());
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();


        db.execSQL("delete from users where id ="+id);

        Toast.makeText(this, "contacto eliminado", Toast.LENGTH_SHORT).show();


        regresar(view);


    }

}
