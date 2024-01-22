package com.example.fragments;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public class DatabaseSqlite extends SQLiteOpenHelper {
    public static final String Database_Name = "Database_Tarek";
    public static final int Version = 2;
    public DatabaseSqlite(@Nullable Context context) {
        super(context, Database_Name, null, Version);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase  ) {
        sqLiteDatabase.execSQL("create table If NOT EXISTS Customers (id INTEGER primary key autoincrement , name TEXT, email TEXT,password TEXT)");
        sqLiteDatabase.execSQL("create table If NOT EXISTS Booking (id INTEGER primary key autoincrement , Firstname TEXT,LastName TEXT,Email TEXT,NumberGuest INTEGER,Date TEXT,Time TEXT,Reservation TEXT,Phone INTEGER unique )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Customers");
        onCreate(sqLiteDatabase);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Booking");
        onCreate(sqLiteDatabase);
    }
    public String update_Password(String n , String p)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("password",p);
        String args [] = {n};
        long result = sqLiteDatabase.update("Customers",values,"name=?",args);
           if(result == 0)
             {
                  return "NotDone";
             }
           else
           {
                  return "Done";
           }
    }
    public String Insert_Data(String n , String e,String p )
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",n);
        values.put("email",e);
        values.put("password",p);
        long result = sqLiteDatabase.insert("Customers",null,values);
        if (result == -1)
        {
            return "Faild ";
        }
        else
        {
            return "Welcome,In our Restaurant";
        }
    }
    public String Check( String n , String p)
    {
        SQLiteDatabase sqlite = this.getWritableDatabase();
        Cursor cursor =sqlite.rawQuery("Select * from Customers where name= ? and password = ? ",new String[] {n,p});
        if (cursor.getCount()>0)
        {
            return "Found";
        }
        else
        {
            return "Not Found";
        }
    }
    public String Check_Username (String n)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from Customers where name= ?",new String[] {n});
        if (cursor.getCount()>0)
        {
            return "Found";
        }
        else
        {
            return "Not Found";
        }
    }
    public String book(String fn ,String ln,String em,int NG ,String d ,String t ,String R ,int ph )
    {
        SQLiteDatabase sqLiteDb = this.getWritableDatabase();
        ContentValues Values = new ContentValues();
        Values.put("Firstname",fn);
        Values.put("LastName",ln);
        Values.put("Email",em);
        Values.put("NumberGuest",NG);
        Values.put("Date",d);
        Values.put("Time",t);
        Values.put("Reservation",R);
        Values.put("Phone",ph);
        long result = sqLiteDb.insert("Booking",null,Values);
        if (result == -1)
        {
            return "Not DONE";
        }
        else
        {
            return "Thanks,you are welcome " ;

        }
    }
    public String Update_Book(String fn , String ln, String em, int NG , String d , String t , String R , int ph  )
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues  values = new ContentValues();
        values.put("Firstname",fn);
        values.put("LastName",ln);
        values.put("Email",em);
        values.put("NumberGuest",NG);
        values.put("Date",d);
        values.put("Time",t);
        values.put("Reservation",R);
        values.put("Phone",ph);
        String[] args ={String.valueOf(ph)};
       long Result= sqLiteDatabase.update("Booking",values,"Phone=?",args);
       if (Result == 0)
       {
           return "Faild Update";
       }
       else
       {
           return "Sucess Update";
       }
    }
    public String Delete_Book(int p)
    {
     SQLiteDatabase sqLiteDatabase = getWritableDatabase();
     String[] args ={String.valueOf(p)};
     long Result = sqLiteDatabase.delete("Booking","Phone=?",args);
     if (Result==0)
     {
         return "Not Deleted";
     }
     else
     {
         return "Deleted Done";
     }
    }
    public ArrayList<String> get_booking (String p)
    {
        ArrayList<String> arrayList = null;
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Booking where Phone = ?",new String[]{p});
       if(cursor.moveToFirst())
       {
           do
           {
               String fname = cursor.getString(1);
               String lname = cursor.getString(2);
               String email = cursor.getString(3);
               int number=cursor.getInt(4);
               String date = cursor.getString(5);
               String time = cursor.getString(6);
               String reservation = cursor.getString(7);
               int phone = cursor.getInt(8);
               arrayList = new ArrayList<String>(Arrays.asList(fname,lname,email,String.valueOf(number),date,time,reservation,String.valueOf(phone)));
           }
               while(cursor.moveToNext());
       }
       return arrayList;
    }


}
