package py.com.personal.cursoandroid;


import android.app.Activity;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu extends Fragment {

    //Array para guardar los id de los botones
    private final int[] BOTONESMENU={R.id.linterna,R.id.nivel,R.id.musica};
    private final int [] BOTONESILUMINADOS={R.drawable.linterna2,R.drawable.nivel2,R.drawable.musica2};

    private int boton;

    public Menu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mimenu= inflater.inflate(R.layout.fragment_menu, container, false);


        boton=-1;

        if (getArguments() != null) {
            boton=getArguments().getInt("BOTONPULSADO");
        }




        ImageButton botonmenu;

        for(int i=0;i<BOTONESMENU.length;i++){
            botonmenu=(ImageButton) mimenu.findViewById(BOTONESMENU[i]);


            if(boton==i){
                botonmenu.setImageResource(BOTONESILUMINADOS[i]);
            }

            //guardamos el boton que se pulso
            final int queBoton=i;

            //Evento onclick de android
            botonmenu.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v){

                    //clase activity y usamos el metodo getActivity
                    Activity estaActividad=getActivity();

                    //Casteo de la interfaz
                    ((ComunicaMenu)estaActividad).menu(queBoton);

                }


            });
        }

        return mimenu;
    }

}
