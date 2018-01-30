package com.example.dell.contactsapp;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
//import android.os.Bundle;
//import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {
    private SimpleCursorAdapter adapter;
    public static final int CONTACT_LOADER_ID = 78;
    private static final String SELECTION =
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                    ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + " LIKE ?" :
                    ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + " LIKE ?";
    //private static final String SELECTION = ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + " LIKE ?";
    // Defines a variable for the search string
    //private String mSearchString="'A' + '%' OR 'B'+ '%'";
    private String mSearchString;
    //private String mSearchString1="B + %";
    //private String[] mSelectionArgs=new String[2];
    // Defines the array to hold values that replace the ?
    private String[] mSelectionArgs = { mSearchString };

    //private String[] mSelectionArgs;
    //private static final String ASSETS_DIR = "drawable/";
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupCursorAdapter();
        ListView lvContacts = (ListView) findViewById(R.id.lv);
        lvContacts.setAdapter(adapter);
        getSupportLoaderManager().initLoader(CONTACT_LOADER_ID,
                new Bundle(), contactsLoader);
    }
    private void setupCursorAdapter() {
        // Column data from cursor to bind views from
      String[] uiBindFrom = { ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.PHOTO_URI };
        //String[] uiBindFrom = { ContactsContract.Contacts.DISPLAY_NAME};
       // String imgFilePath = ASSETS_DIR;
        //try {
          //  Bitmap bitmap = BitmapFactory.decodeStream(this.context.getResources().getAssets()
            //        .open(imgFilePath));
            //ImageView iv=(ImageView) findViewById(R.id.ivImage);
            //iv.setImageBitmap(bitmap);
        //} catch (IOException e) {
          //  e.printStackTrace();
        //}
        // View IDs which will have the respective column data inserted
        int[] uiBindTo = { R.id.tvName,R.id.ivImage};
        //int[] uiBindTo = { R.id.tvName};
        // Create the simple cursor adapter to use for our list
        // specifying the template to inflate (item_contact),
        adapter = new SimpleCursorAdapter(
                this, R.layout.mylist,
                null, uiBindFrom, uiBindTo,
                0);
/*        adapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
                if (view.getId() == R.id.ivImage) {
                    ImageView IV=(ImageView) view;
      //              int resID = getApplicationContext().getResources().getIdentifier(cursor.getString(columnIndex), "drawable",  getApplicationContext().getPackageName());
                    IV.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_launcher));
                    return true;
                }
                return false;
            }
        });
  */  }
    private LoaderManager.LoaderCallbacks<Cursor> contactsLoader =
            new LoaderManager.LoaderCallbacks<Cursor>() {
                // Create and return the actual cursor loader for the contacts data
                @Override
                public Loader<Cursor> onCreateLoader(int id, Bundle args) {
                    // Define the columns to retrieve
                    String[] projectionFields = new String[] { ContactsContract.Contacts._ID,
                            ContactsContract.Contacts.DISPLAY_NAME,
                            ContactsContract.Contacts.PHOTO_URI };
                    //String[] projectionFields = new String[] {
                        //    ContactsContract.Contacts.DISPLAY_NAME,
                          //  ContactsContract.Contacts.PHOTO_URI };
                    //String mSearchString =  "mSelectionArgs[0]='A + %' OR mSelectionArgs[0]='B + %' OR mSelectionArgs[0]='C + %' OR mSelectionArgs[0]='D + %' OR mSelectionArgs[0]='E + %' ";
                    String s1 = "A";
                    String s2 = "B";
                    String s3 = "C";
                    String s4 = "D";
                    String s5 = "E";

                    //String[] mSelectionArgs = {s1};
                    //String[] ar={"A","B"};
                    //mSelectionArgs[0]= Arrays.toString(ar) +"%";
                    mSelectionArgs[0]="A" + "%";

                    //mSelectionArgs[2]="C" + "%";
                    //mSelectionArgs[3]="D" + "%";
                    //mSelectionArgs[4]="E" + "%";
                    // Construct the loader
                    //mSelectionArgs[0]="A" + "%";
                   // String selectionArgs[] = {"8","50"};
                    //mSelectionArgs=new String[]{"Amma","Corp"};
                    //String pattern = "(?i)(\\s|^)[a][A-Za-z]+(\\s|$)";
                    //Pattern pattern = Pattern.compile("(?<=\\()[^\\)]+|((?<=<)[^>]+)");
                    //mSelectionArgs[0]= String.valueOf(Pattern.compile(pattern));
                    //selection = selection.substring(0, selection.length() - 2) + ")";
                    CursorLoader cursorLoader = new CursorLoader(MainActivity.this,
                            ContactsContract.Contacts.CONTENT_URI, // URI
                            projectionFields, // projection fields
                            SELECTION, // the selection criteria
                            mSelectionArgs, // the selection args
                            null // the sort order
                    );
                    // Return the loader for use
                    return cursorLoader;
                }

                // When the system finishes retrieving the Cursor through the CursorLoader,
                // a call to the onLoadFinished() method takes place.
                @Override
                public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
                    // The swapCursor() method assigns the new Cursor to the adapter
                    adapter.swapCursor(cursor);
                }

                // This method is triggered when the loader is being reset
                // and the loader data is no longer available. Called if the data
                // in the provider changes and the Cursor becomes stale.
                @Override
                public void onLoaderReset(Loader<Cursor> loader) {
                    // Clear the Cursor we were using with another call to the swapCursor()
                    adapter.swapCursor(null);
                }
            };
}
