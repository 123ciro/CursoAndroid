package py.com.personal.cursoandroid;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;

public class ActividadHerramientas extends AppCompatActivity implements ComunicaMenu,ManejaFlashCamara {

    private Fragment[] misfragmentos;
    private CameraManager micamara;
    private String idCamara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_herramientas);

        misfragmentos= new Fragment[3];


        misfragmentos[0]=new Linterna();
        misfragmentos[1] = new Nivel();
        misfragmentos[2] = new Musica();

        Bundle extras=getIntent().getExtras();
        menu(extras.getInt("BOTONPULSADO"));

        micamara = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try{
            idCamara=micamara.getCameraIdList()[0];
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void menu(int boton) {

        FragmentManager miManejador=getFragmentManager();
        FragmentTransaction miTransaccion=miManejador.beginTransaction();

        Fragment menu_iluminado= new Menu();

        Bundle datos=new Bundle();
        datos.putInt("BOTONPULSADO",boton);

        menu_iluminado.setArguments(datos);

        miTransaccion.replace(R.id.menu,menu_iluminado);


        //parametros -> (contenedor,fragmento)
        miTransaccion.replace(R.id.herramientas,misfragmentos[boton]);

        //comienza la transaccion
        miTransaccion.commit();

    }

    @TargetApi(25)
    @Override
    public void enciendeApaga(boolean estadoFlash) {

        try{
            if(estadoFlash){
                //flash apagado
                micamara.setTorchMode(idCamara,false);

            }else{
                //flash encendido

                micamara.setTorchMode(idCamara,true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
