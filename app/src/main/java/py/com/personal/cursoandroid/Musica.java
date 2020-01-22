package py.com.personal.cursoandroid;


import android.content.Intent;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Musica extends Fragment {

    private boolean encendida;
    private ImageView botonmusica;

    public Musica() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        encendida=false;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmento= inflater.inflate(R.layout.fragment_musica, container, false);

        botonmusica=(ImageView) fragmento.findViewById(R.id.musica);

        botonmusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(encendida){
                    apagaMusica();
                }else{
                    enciendeMusica();
                }
            }
        });

        return fragmento;
    }


    public void enciendeMusica(){
        botonmusica.setImageResource(R.drawable.musica2);
        boolean val=!encendida;
        Intent mireproductor=new Intent(getActivity(),ServicioMusica.class);
        getActivity().startService(mireproductor);
        encendida= val;

    }

    public void apagaMusica(){
        botonmusica.setImageResource(R.drawable.musica);
        boolean val=!encendida;
        Intent mireproductor=new Intent(getActivity(),ServicioMusica.class);
        getActivity().stopService(mireproductor);
        encendida= val;
    }

}

