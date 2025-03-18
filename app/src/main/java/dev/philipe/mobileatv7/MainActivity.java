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

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private ArrayAdapter<String> av;
    private List<String> list;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
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

        ListaGlobal.getInstance().setLista(list);

        lv = findViewById(R.id.ma_list_view);
        button = findViewById(R.id.ma_button);

        av = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(av);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            finish();
            startActivity(intent);
        });
    }
}