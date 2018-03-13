package info.dicj.distributeur;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

import info.dicj.distributeur.Distributeur.Distributeur;
import info.dicj.distributeur.Distributeur.Exception.AucunDistribuableException;
import info.dicj.distributeur.Distributeur.Exception.AucunMelangeException;
import info.dicj.distributeur.Distributeur.Exception.DebordementMelangeException;
import info.dicj.distributeur.Distributeur.Recette;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    private Distributeur distributeur;
    private Notification not;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((RadioGroup)findViewById(R.id.group)).setOnCheckedChangeListener(this);
        ((CheckBox)findViewById(R.id.check)).setOnCheckedChangeListener(this);


        distributeur = new Distributeur(this);
        not = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.ic_menu_save)
                .setContentTitle("test")
                .setContentText("test description")
                .setPriority(Notification.PRIORITY_LOW)
                .build();

        Log.i("DICJ", "MainActivity.oncreate");
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        compoundButton = (CheckBox) findViewById(R.id.check);
        View button = findViewById(R.id.reverser);

        if(compoundButton.isChecked())
            button.setVisibility(View.GONE);
        else
            button.setVisibility(View.VISIBLE);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId){
        TextView adore = new TextView(this);
        LinearLayout layout = (LinearLayout) findViewById(R.id.linear1);
        EditText nom = (EditText) findViewById(R.id.nom);

        switch(checkedId)
        {
            case R.id.adore:
                adore.setText(getString(R.string.adore_1) + nom.getText() + getString(R.string.adore_2));
                adore.setTextSize(12);
                adore.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                layout.addView(adore, layout.indexOfChild(group)+1);
                break;
            case R.id.adorepas:
                adore.setText(getString(R.string.adorepas_1) + nom.getText() + getString(R.string.adorepas_2));
                adore.setTextSize(12);
                adore.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                layout.addView(adore, layout.indexOfChild(group)+1);
                break;
        }

        for(int i = 0; i < group.getChildCount(); i++)
            group.getChildAt(i).setEnabled(false);
    }

    public void reverser(View view) {

        Log.i("DICJ", "MainActivity.reverser");

        try {
            distributeur.dupliquerMelange();
            verser(view);
        } catch (AucunMelangeException e) {
            e.printStackTrace();
        } catch (AucunDistribuableException e) {
            e.printStackTrace();
        } catch (DebordementMelangeException e) {
            e.printStackTrace();
        }
    }

    public void verser(View view) {

        Log.i("DICJ", "MainActivity.verser");

        NotificationManager notMan = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notMan.notify(0, not);

        try {
            afficherRecette(distributeur.melangerRecette());

        } catch (AucunMelangeException AME) {
            AME.printStackTrace();
        }

    }

    public void ajouterSaveur(View view) {

        Log.i("DICJ", "MainActivity.ajouterSaveur");

        try {
            switch(view.getId()){

                case R.id.sEpice:       distributeur.ajouterSaveur("EPICE");
                                        break;
                case R.id.sGingembre:   distributeur.ajouterSaveur("GINGEMBRE");
                                        break;
                case R.id.sBacon:       distributeur.ajouterSaveur("BACON");
                                        break;
            }
        } catch (AucunDistribuableException ADE) {
            ADE.printStackTrace();
        } catch (DebordementMelangeException DME) {
            DME.printStackTrace();
        }

    }

    public void ajouterBoisson(View view) {

        Log.i("DICJ", "MainActivity.ajouterBoisson");


        try {
            switch(view.getId()){
                case R.id.bPepsi:       distributeur.ajouterBoisson("PEPSI");
                                        break;
                case R.id.bOrangeade:   distributeur.ajouterBoisson("ORANGEADE");
                                        break;
                case R.id.bRacinette:   distributeur.ajouterBoisson("RACINETTE");
                                        break;
                case R.id.bFraise:      distributeur.ajouterBoisson("FRAISE");
                                        break;
            }
        }
        catch (AucunMelangeException AME) {
            AME.printStackTrace();
        }
        catch (DebordementMelangeException DME) {
            DME.printStackTrace();
        }

    }

    public void nouveau(View view) {

        Log.i("DICJ", "MainActivity.nouveau");

        distributeur.nouveauMelange();
    }


    public void afficherRecette(Recette recette){


        Context context = getApplicationContext();
        CharSequence information = recette.getInformation();
        int duree = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, information, duree);
        toast.show();
    }
}
