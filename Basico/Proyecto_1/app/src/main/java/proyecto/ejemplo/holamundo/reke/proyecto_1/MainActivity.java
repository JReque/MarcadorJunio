package proyecto.ejemplo.holamundo.reke.proyecto_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    Button incrementar, incrementar2, incrementar3, incrementarv, incrementarv2, incrementarv3, decrementa, resetea;
    public int contadorl, contadorv, cache;
    public boolean local, undo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementar = (Button) findViewById(R.id.bincrementa);
        incrementar2 = (Button) findViewById(R.id.bl2);
        incrementar3 = (Button) findViewById(R.id.bl3);
        incrementarv = (Button) findViewById(R.id.bv1);
        incrementarv2 = (Button) findViewById(R.id.bv2);
        incrementarv3 = (Button) findViewById(R.id.bv3);
        decrementa = (Button) findViewById(R.id.bdeshacer);
        resetea = (Button) findViewById(R.id.bresetea);

        incrementar.setOnClickListener(this);
        incrementar2.setOnClickListener(this);
        incrementar3.setOnClickListener(this);
        incrementarv.setOnClickListener(this);
        incrementarv2.setOnClickListener(this);
        incrementarv3.setOnClickListener(this);
        decrementa.setOnClickListener(this);
        resetea.setOnClickListener(this);
    }

    public void showRes(){
        TextView showLocal=(TextView) findViewById(R.id.contadorLocal);
        TextView showVisitante=(TextView) findViewById(R.id.contadorVisitante);
        showLocal.setText(""+contadorl);
        showVisitante.setText(""+contadorv);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bincrementa:
                contadorl++;
                cache=1;
                undo=false;
                local =true;
                showRes();
                break;
            case R.id.bl2:
                contadorl+=2;
                cache=2;
                undo=false;
                local =true;
                showRes();
                break;
            case  R.id.bl3:
                contadorl+=3;
                cache=3;
                undo=false;
                local =true;
                showRes();
                break;
            case R.id.bv1:
                contadorv++;
                cache=1;
                undo=false;
                local =false;
                showRes();
                break;
            case R.id.bv2:
                contadorv+=2;
                undo=false;
                local =false;
                cache=2;
                showRes();
                break;
            case  R.id.bv3:
                contadorv+=3;
                cache=3;
                undo=false;
                local =false;
                showRes();
                break;
            case R.id.bdeshacer:
                if (local== true && undo== false && contadorl>=0 ){
                    contadorl-=cache;
                    undo=true;
                }else if (local== false && undo== false && contadorv>=0){
                    contadorv-=cache;
                    undo=true;
                }
                showRes();
                break;
            case R.id.bresetea:
                contadorl=0;
                contadorv=0;
                showRes();
                break;
        }
    }
}