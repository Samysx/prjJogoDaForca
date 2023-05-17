package com.example.prjjogodaforca;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    //criando os objetos
    Button btnJogar, btnIniciar;
    ImageView imgCabeca, imgPernas, imgCorpo;
    TextView txtNome, lbl1, lbl2, lbl3;
    int Erros = 0; // declarção de variavel
    String palavra = "AMR";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instancia os obj (liga um obj a alguma coisa)
        btnJogar = findViewById(R.id.btnJogar); // nesse caso está ligando o obj btnJogar com o botão id jogar
        btnIniciar = findViewById(R.id.btnIniciar);
        imgCabeca = findViewById(R.id.imgCabeca);
        imgPernas = findViewById(R.id.imgPernas);
        imgCorpo = findViewById(R.id.imgCorpo);
        txtNome = findViewById(R.id.txtNome);
        lbl1 = findViewById(R.id.lbl1);
        lbl2 = findViewById(R.id.lbl2);
        lbl3 = findViewById(R.id.lbl3);

        //criando um evento de clique no botão jogar (clicklistener - ouvinte de clique)
        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sim = txtNome.getText().toString().toUpperCase();
                // tudo que estiver na text box vai ficar em maiusculo.
                /*
                try catch: ao clicar no botão ou realizar qualquer ação o codigo dentro do try
                será testado (try= tentar) se der erro em alguma parte do codigo dentro do try
                a linha de codigo será redirecionada ao catch(catch= pegar) onde realizara
                um codigo de mediação pode ser tanto um return (return = o codigo irá parar)
                quanto um aviso.
                 */
                try {
                    Erros = 0;
                    if(sim==""){
                        txtNome.setText("insira 3 letras");
                    }else {
                        char a = palavra.charAt(0);
                        char b = palavra.charAt(1);
                        char c = palavra.charAt(2);

                        char d = sim.charAt(0);
                        char e = sim.charAt(1);
                        char f = sim.charAt(2);

                        if (a != d){
                            lbl1.setText("?");
                            Erros++;
                        }
                        else {
                            lbl1.setText(""+d);
                        }
                        if (b != e){
                            lbl2.setText("?");
                            Erros++;
                        }
                        else {
                            lbl2.setText(""+e);
                        }
                        if (c != f){
                            lbl3.setText("?");
                            Erros++; // contagem de erro
                        }
                        else {
                            lbl3.setText(""+f);
                        }
                        if(Erros==1){
                            imgCabeca.setImageResource(R.drawable.kyoka); //definição de img
                        } else if (Erros==2) {
                            imgCorpo.setImageResource(R.drawable.tronco);
                        } else if (Erros==3) {
                            imgPernas.setImageResource(R.drawable.pernas);
                        }
                    }
                }
                catch (Exception e){
                    txtNome.setText("insira EXATAMENTE 3 letras");
                }
                btnIniciar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lbl1.setText(""); // set = definir
                        lbl2.setText("");
                        lbl3.setText("");
                        imgCabeca.setImageResource(0); // quando é img coloca 0
                        imgCorpo.setImageResource(0);
                        imgPernas.setImageResource(0);
                    }
                });
            }
        });

    }
}