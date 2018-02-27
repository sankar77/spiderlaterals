package com.example.dell.settingsapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MyPreferencesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Preference p=findPreference("downloadType");
        //      ListPreference l=(ListPreference) p;
        //Toast.makeText(getActivity(),l.getEntry(), Toast.LENGTH_SHORT).show();
        //
        //  if (prefman.getSharedPreferences().getString("downloadType","0").equals("All Data")){
        //    f.setBackgroundColor(Color.YELLOW);
        //} /else{
        //   f.setBackgroundColor(Color.WHITE);
        // }
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();

    }


    public static class MyPreferenceFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);

            Preference pref = findPreference("username");
            if (pref instanceof EditTextPreference) {
                EditTextPreference etp = (EditTextPreference) pref;
                pref.setSummary(etp.getText());

            }

            PreferenceManager prefman = getPreferenceManager();
            Preference p = findPreference("bgcolour");
            ListPreference l = (ListPreference) p;

            Toast.makeText(getActivity(), l.getEntry(), Toast.LENGTH_SHORT).show();
            //if (prefman.getSharedPreferences().getString("downloadType", "DEFAULT").equals("All Data")) {
            if (l.getEntry().equals("Blue")) {
                Toast.makeText(getActivity(), "hi", Toast.LENGTH_SHORT).show();
                //View v=getView();
                Intent i = new Intent(getActivity(), Main2Activity.class);
                startActivity(i);
                //v.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                //onViewCreated(getView(),savedInstanceState);
                //Intent i=new Intent(getActivity(),MainActivity.class);
                //startActivity(i);

                //        } else{
                //          f.setBackgroundColor(Color.WHITE);
            }
            if (l.getEntry().equals("Green")) {
                Toast.makeText(getActivity(), "hi", Toast.LENGTH_SHORT).show();
                //View v=getView();
                Intent i = new Intent(getActivity(), Main3Activity.class);
                startActivity(i);
                //v.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                //onViewCreated(getView(),savedInstanceState);
                //Intent i=new Intent(getActivity(),MainActivity.class);
                //startActivity(i);

                //        } else{
                //          f.setBackgroundColor(Color.WHITE);
            }
            if (l.getEntry().equals("Yellow")) {
                Toast.makeText(getActivity(), "hi", Toast.LENGTH_SHORT).show();
                //View v=getView();
                Intent i = new Intent(getActivity(), Main4Activity.class);
                startActivity(i);
                //v.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                //onViewCreated(getView(),savedInstanceState);
                //Intent i=new Intent(getActivity(),MainActivity.class);
                //startActivity(i);

                //        } else{
                //          f.setBackgroundColor(Color.WHITE);
            }

        }

        //public void onViewCreated(View view, Bundle savedInstanceState) {
        //  super.onViewCreated(view, savedInstanceState);
        // view.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        //}
        private void setColor(String myColor){
            Activity activity=getActivity();
            //findViewById(android.R.id.content)
            activity.findViewById(android.R.id.content).setBackgroundColor(Color.BLACK);
        }
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
            Preference pref = findPreference(s);
            Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();
            //if (pref instanceof ListPreference) {
            //  ListPreference etp = (ListPreference) pref;
            //String x = etp.getEntry().toString();
            //if (x.equals("All Data")) {
            //  Intent i = new Intent(getActivity(), MainActivity.class);
            //i.putExtra("res",x);
            //startActivity(i);
            //if (pref instanceof ListPreference) {

              //  setColor(sharedPreferences.getString("downloadType", "1"));
            //}


        }
    }
}

