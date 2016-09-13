package id.sch.smktelkom_mlg.tugas01.xirpl1032.form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etuser, etpass, etnama, etemail, etno;
    RadioGroup rgkelamin;
    CheckBox cbBNI, cbBRI, cbBCA;
    Spinner spasal;
    Button bOK;
    TextView tvhasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etuser = (EditText) findViewById(R.id.editTextUser);
        etpass = (EditText) findViewById(R.id.editTextPassword);
        etnama = (EditText) findViewById(R.id.editTextNama);
        etemail = (EditText) findViewById(R.id.editTextEmail);
        etno = (EditText) findViewById(R.id.editTextNo);
        rgkelamin = (RadioGroup) findViewById(R.id.radioGroupKelamin);
        cbBRI = (CheckBox) findViewById(R.id.checkBoxBRI);
        cbBNI = (CheckBox) findViewById(R.id.checkBoxBNI);
        cbBCA = (CheckBox) findViewById(R.id.checkBoxBCA);
        spasal = (Spinner) findViewById(R.id.spinner);
        bOK = (Button) findViewById(R.id.buttonOk);
        tvhasil = (TextView) findViewById(R.id.textViewHasil);

        findViewById(R.id.buttonOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String rekening = "Rekening anda :\n";
        String nama = etnama.getText().toString();
        String asal = spasal.getSelectedItem().toString();
        String email = etemail.getText().toString();
        String no = etno.getText().toString();
        String user = etuser.getText().toString();
        String pass = etpass.getText().toString();

        int ltpas = pass.length();
        int startlen = rekening.length();
        if (cbBRI.isChecked()) rekening += cbBRI.getText() + "\n";
        if (cbBNI.isChecked()) rekening += cbBNI.getText() + "\n";
        if (cbBCA.isChecked()) rekening += cbBCA.getText() + "\n";

        if (isValid()) {
            String kelamin = null;
            if (rgkelamin.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton) findViewById(rgkelamin.getCheckedRadioButtonId());
                kelamin = rb.getText().toString();
            }
            if (kelamin == null) {
                tvhasil.setText("Belum memilih Jenis Kelamin");
            } else if (rekening.length() == startlen) {
                tvhasil.setText("Belum memilih rekening\n");
            } else if (asal.contains("--Silahkan Pilih--")) {
                tvhasil.setText("Belum memilih Asal");
            } else {
                tvhasil.setText("          Selamat Bergabung !!\n\n\n" +
                        "Nama : " + nama + "\n\nEmail: " + email + "\n\nNo HP: " + no + "\n\nUsername: " + user + "\n\nPassword: " + ltpas + "char" +
                        "\n\nJenis Kelamin: " + kelamin + "\n\n" + rekening + "\nAsal Kota: " + asal);
            }
        }

    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etnama.getText().toString();
        String email = etemail.getText().toString();
        String no = etno.getText().toString();
        String user = etuser.getText().toString();
        String pass = etpass.getText().toString();

        if (nama.isEmpty()) {
            etnama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etnama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etnama.setError(null);
        }
        if (email.isEmpty()) {
            etemail.setError("Email belum diisi");
            valid = false;
        } else {
            etemail.setError(null);
        }
        if (no.isEmpty()) {
            etno.setError("No HP belum diisi");
            valid = false;
        } else if (no.length() < 11) {
            etno.setError("Pastikan format no HP anda benar");
            valid = false;
        } else {
            etno.setError(null);
        }
        if (user.isEmpty()) {
            etuser.setError("Username belum diisi");
            valid = false;
        } else if (user.length() < 4) {
            etuser.setError("Username minimal 4 karakter");
            valid = false;
        } else {
            etuser.setError(null);
        }
        if (pass.isEmpty()) {
            etpass.setError("Password belum diisi");
            valid = false;
        } else if (pass.length() < 6) {
            etpass.setError("Password minimal 6 karakter");
            valid = false;
        } else {
            etpass.setError(null);
        }
        return valid;
    }
}
