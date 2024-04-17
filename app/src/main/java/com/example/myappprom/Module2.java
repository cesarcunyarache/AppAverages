package com.example.myappprom;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Module2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Module2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private Button btnModulo2;

    private Button btnPromFinal;

    private double prom2;
    private double prom1 = 0;

    // onCreateView y otros métodos aquí...


    public Module2() {


        // Required empty public constructo
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Module2.
     */
    // TODO: Rename and change types and number of parameters
    public Module2 newInstance(String param1, String param2) {
        Module2 fragment = new Module2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_module2, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnModulo2 = view.findViewById(R.id.btnModulo2);


        btnModulo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pa4 = ((EditText) view.findViewById(R.id.txtPa4)).getText().toString();
                String pa5 = ((EditText) view.findViewById(R.id.txtPa5)).getText().toString();

                String ef = ((EditText) view.findViewById(R.id.txtExamenFinal)).getText().toString();

                prom2 = calcularPromedioUnidad2(
                        Double.parseDouble(pa4),
                        Double.parseDouble(pa5),
                        Double.parseDouble(ef));

                DecimalFormat df = new DecimalFormat("#0.0");

                ((TextView) view.findViewById(R.id.vResultadoUnidad2)).setText("El promedio de la Unidad II es: " + String.valueOf(df.format(prom2)));

                // Toast.makeText(requireContext(), String.valueOf(prom2), Toast.LENGTH_SHORT).show();

                Bundle bundle = new Bundle();
                bundle.putDouble("U2", prom2);
                getParentFragmentManager().setFragmentResult("U2", bundle);
            }
        });



    }

    public double calcularPromedioUnidad2(double pa4, double pa5, double ef) {
        return (pa4 * 0.30) + (pa5 * 0.40) + (ef * 0.30);
    }


}