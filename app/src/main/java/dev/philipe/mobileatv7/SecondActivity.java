package dev.philipe.mobileatv7;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import dev.philipe.mobileatv7.data.ListaGlobal;

public class SecondActivity extends AppCompatActivity {
    private ListView lv;
    private ArrayAdapter<String> av;
    private Button btnProximo;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_two);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.act_two), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lv = findViewById(R.id.act_two_list_view);
        btnVoltar = findViewById(R.id.act_two_button_voltar);
        btnProximo = findViewById(R.id.act_two_button_proximo);

        av = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListaGlobal.getInstance().getLista());
        lv.setAdapter(av);

        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            finish();
            startActivity(intent);
        });

        btnProximo.setOnClickListener(v -> {
            Intent intent = new Intent(this, ThirdActivity.class);
            finish();
            startActivity(intent);
        });
    }
}