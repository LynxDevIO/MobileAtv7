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

public class FourthActivity extends AppCompatActivity {
    private ListView lv;
    private ArrayAdapter<String> av;
    private List<String> list;
    private Button btnVoltar;
    private Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_four);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.act_four), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        list = new ArrayList<>(){{
            add("Item 1");
            add("Item 2");
            add("Item 3");
            add("Item 4");
            add("Item 5");
        }};

        lv = findViewById(R.id.act_four_list_view);
        btnInicio = findViewById(R.id.act_four_button_inicio);
        btnVoltar = findViewById(R.id.act_four_button_voltar);

        av = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(av);

        btnInicio.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            finish();
            startActivity(intent);
        });

        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(this, ThirdActivity.class);
            finish();
            startActivity(intent);
        });
    }
}