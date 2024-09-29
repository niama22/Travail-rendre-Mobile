package ma.ensa.navigation2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nom, phone, email, adresse;
    private Spinner villeSpinner;
    private Button envoyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        nom = findViewById(R.id.editTextText);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        adresse = findViewById(R.id.editTextText4);
        villeSpinner = findViewById(R.id.spinner2);
        envoyer = findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.villes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        villeSpinner.setAdapter(adapter);

        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(nom.getText().toString().trim()) ||
                        TextUtils.isEmpty(phone.getText().toString().trim()) ||
                        TextUtils.isEmpty(email.getText().toString().trim()) ||
                        TextUtils.isEmpty(adresse.getText().toString().trim())) {
                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String selectedVille = villeSpinner.getSelectedItem().toString();

                String result = "Nom et prenom : " + nom.getText() + "\n" +
                        "Phone : " + phone.getText() + "\n" +
                        "Email : " + email.getText() + "\n" +
                        "Adresse : " + adresse.getText() + "\n" +
                        "Ville : " + selectedVille;

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("rslt", result);
                startActivity(intent);
                finish();
            }
        });
    }
}
