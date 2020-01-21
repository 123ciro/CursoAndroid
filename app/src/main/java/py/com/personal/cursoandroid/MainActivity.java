package py.com.personal.cursoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ComunicaMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void menu(int boton) {


        Intent in=new Intent(this,ActividadHerramientas.class);
        in.putExtra("BOTONPULSADO",boton);
        Toast.makeText(getApplicationContext(),"Boton Pulsado" + boton,Toast.LENGTH_SHORT).show();
        startActivity(in);


    }
}
