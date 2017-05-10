package com.project.impacta.ibvn.handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.project.impacta.ibvn.model.Login;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matheuscatossi on 5/10/17.
 */

public class DatabaseHandlerLogin extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "loginsManager";

    private static final String TABLE_CONTACTS = "logins";

    private static final String KEY_ID = "id";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_CPF = "cpf";
    private static final String KEY_CELULA = "celula";

    public DatabaseHandlerLogin(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_EMAIL + " TEXT," + KEY_CPF + " TEXT,"
                + KEY_CELULA + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        onCreate(db);
    }

    public void addLogin(Login login) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, login.getEmail());
        values.put(KEY_CPF, login.getCpf());
        values.put(KEY_CELULA, login.getCelula());

        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    Login getLogin(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_CPF, KEY_EMAIL, KEY_CELULA }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Login login = new Login(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));
        return login;
    }

    public List<Login> getAllLogins() {
        List<Login> loginList = new ArrayList<Login>();
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Login login = new Login();
                login.setId(Integer.parseInt(cursor.getString(0)));
                login.setEmail(cursor.getString(1));
                login.setCpf(cursor.getString(2));
                login.setCelula(cursor.getString(3));

                loginList.add(login);
            } while (cursor.moveToNext());
        }

        return loginList;
    }

    public int updateLogin(Login login) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, login.getEmail());
        values.put(KEY_CPF, login.getCpf());
        values.put(KEY_CELULA, login.getCelula());

        return db.update(TABLE_CONTACTS, values, KEY_EMAIL + " = ?",
                new String[] { String.valueOf(login.getEmail()) });
    }

    public void deleteLogin(Login login) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(login.getId()) });
        db.close();
    }


    public int getLoginsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

}
