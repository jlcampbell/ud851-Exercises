package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;

import com.example.android.waitlist.R;

import org.w3c.dom.Text;

// c (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {
    // c (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"

    // c (3) Create a static final int called DATABASE_VERSION and set it to 1

    // c (4) Create a Constructor that takes a context and calls the parent constructor

    static final String DATABASE_NAME = "waitlist.db";
    static final int DATABASE_VERSION = 1;



    public WaitlistDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // c (5) Override the onCreate method
        String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE "
                + WaitlistContract.WaitlistEntry.TABLE_NAME + " ( "
                + WaitlistContract.WaitlistEntry.COLUMN_GUEST_NAME + " Text "
                + WaitlistContract.WaitlistEntry.COLUMN_PARTY_SIZE + " Text "
                + WaitlistContract.WaitlistEntry.COLUMN_TIMESTAMP + " Text " + ")";
        // TODO (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table
        db.execSQL(SQL_CREATE_WAITLIST_TABLE);
        // TODO (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO (8) Override the onUpgrade method
    db.execSQL("DROP TABLE " + WaitlistContract.WaitlistEntry.TABLE_NAME);
        // TODO (9) Inside, execute a drop table query, and then call onCreate to re-create it
    }







}