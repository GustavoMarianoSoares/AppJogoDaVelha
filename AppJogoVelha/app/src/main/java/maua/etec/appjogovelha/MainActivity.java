package maua.etec.appjogovelha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt8;
    Button bt9;

    TextView txtPlacarBolinha;
    TextView txtPlacarXizinho;

    boolean jogada = true;
    boolean fimJogo = false;
    String vencedor;
    int placarX = 0;
    int placarO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPlacarBolinha = (TextView) findViewById(R.id.txtPlacarBolinha);
        txtPlacarXizinho = (TextView) findViewById(R.id.txtPlacarXizinho);

        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_item_novo)
        {
            novoJogo();
        }
        if(item.getItemId()==R.id.menu_item_reset)
        {
            txtPlacarBolinha.setText("0");
            txtPlacarXizinho.setText("0");
            placarO= 0;
            placarX= 0;
            novoJogo();
        }
        if(item.getItemId()==R.id.menu_item_sair)
        {
            this.finish();
        }

        return true;
    }

    private void novoJogo() {
        bt1.setText("");
        bt2.setText("");
        bt3.setText("");
        bt4.setText("");
        bt5.setText("");
        bt6.setText("");
        bt7.setText("");
        bt8.setText("");
        bt9.setText("");
        fimJogo = false;
    }

    @Override
    public void onClick(View v) {

        Button bt = (Button) v;

        if (bt.getText().toString() == "" && !fimJogo) {
            if (jogada) {
                bt.setText("X");
            } else {
                bt.setText("O");
            }

            jogada = !jogada;
            verificaFimJogo();
        }


    }

    private void verificaFimJogo() {

        if (bt1.getText().toString()==bt2.getText().toString() &&
                bt2.getText().toString()== bt3.getText().toString() &&
                bt1.getText().toString()!=""

                )
        {
            fimJogo = true;
            vencedor=bt1.getText().toString();
            atualizarPlacar();
        }
        else if (bt4.getText().toString()==bt5.getText().toString() &&
                bt5.getText().toString()== bt6.getText().toString() &&
                bt4.getText().toString()!=""

                )
        {
            fimJogo = true;
            vencedor=bt4.getText().toString();
            atualizarPlacar();
        }

        else if (bt7.getText().toString()==bt8.getText().toString() &&
                bt8.getText().toString()== bt9.getText().toString() &&
                bt7.getText().toString()!=""

                )
        {
            fimJogo = true;
            vencedor=bt7.getText().toString();
            atualizarPlacar();
        }

        else if (bt1.getText().toString()==bt4.getText().toString() &&
                bt4.getText().toString()== bt7.getText().toString() &&
                bt1.getText().toString()!=""

                )
        {
            fimJogo = true;
            vencedor=bt1.getText().toString();
            atualizarPlacar();
        }

        else if (bt2.getText().toString()==bt5.getText().toString() &&
                bt5.getText().toString()== bt8.getText().toString() &&
                bt2.getText().toString()!=""

                )
        {
            fimJogo = true;
            vencedor=bt2.getText().toString();
            atualizarPlacar();
        }

        else if (bt3.getText().toString()==bt6.getText().toString() &&
                bt6.getText().toString()== bt9.getText().toString() &&
                bt3.getText().toString()!=""

                )
        {
            fimJogo = true;
            vencedor=bt3.getText().toString();
            atualizarPlacar();
        }

        else if (bt1.getText().toString()==bt5.getText().toString() &&
                bt5.getText().toString()== bt9.getText().toString() &&
                bt1.getText().toString()!=""

                )
        {
            fimJogo = true;
            vencedor=bt1.getText().toString();
            atualizarPlacar();
        }

        else if (bt3.getText().toString()==bt5.getText().toString() &&
                bt5.getText().toString()== bt7.getText().toString() &&
                bt3.getText().toString()!=""

                )
        {
            fimJogo = true;
            vencedor=bt3.getText().toString();
            atualizarPlacar();
        }
        else if(bt1.getText().toString()!=""
                && bt2.getText().toString()!=""
                && bt3.getText().toString()!=""
                && bt4.getText().toString()!=""
                && bt5.getText().toString()!=""
                && bt6.getText().toString()!=""
                && bt7.getText().toString()!=""
                && bt8.getText().toString()!=""
                && bt9.getText().toString()!=""

        )

        {
            fimJogo = true;
            vencedor = "VELHA";
            Toast.makeText(this, "Deu velha!!!", Toast.LENGTH_LONG).show();
        }


    }

    private void atualizarPlacar() {
        if(vencedor=="X")
        {
            placarX++;
        }
        else
        {
            placarO++;
        }
        Toast.makeText(this, "O vencedor foi:" + vencedor, Toast.LENGTH_LONG).show();

        txtPlacarXizinho.setText(String.valueOf(placarX));
        txtPlacarBolinha.setText(String.valueOf(placarO));

    }
}


