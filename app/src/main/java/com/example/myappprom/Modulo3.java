package com.example.myappprom;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Modulo3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Modulo3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button btnModulo3;

    Button btnPromFinal;

    double prom1, prom2, prom3;

    public Modulo3() {

        prom1 = prom2 = prom3 = 0;
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Modulo3.
     */
    // TODO: Rename and change types and number of parameters
    public static Modulo3 newInstance(String param1, String param2) {
        Modulo3 fragment = new Modulo3();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modulo3, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnModulo3 = view.findViewById(R.id.btnModulo3);
        btnPromFinal = view.findViewById(R.id.btnPromFinal);

        btnModulo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pa6 = ((EditText) view.findViewById(R.id.txtPa6)).getText().toString();
                String pa7 = ((EditText) view.findViewById(R.id.txtPa7)).getText().toString();
                String ef = ((EditText) view.findViewById(R.id.txtExamenParcialIII)).getText().toString();

                prom3 = calcularPromedioUnidad3(
                        Double.parseDouble(pa6),
                        Double.parseDouble(pa7),
                        Double.parseDouble(ef));


                DecimalFormat df = new DecimalFormat("#0.0");

                ((TextView) view.findViewById(R.id.vResultadoUnidad3)).setText("El promedio de la Unidad III es: " + String.valueOf(df.format(prom3)));

                // Toast.makeText(requireContext(), String.valueOf(prom2), Toast.LENGTH_SHORT).show();

            }
        });


        btnPromFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().setFragmentResultListener("U1", Modulo3.this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        prom1 = result.getDouble("U1");
                    }

                });

                getParentFragmentManager().setFragmentResultListener("U2", Modulo3.this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        prom2 = result.getDouble("U2");
                    }

                });

                if (prom1 != 0 &&  prom2 !=0 && prom3 !=0) {
                    double pf = Math.ceil(calcularPromedioFinal(prom1, prom2, prom3));


                    if (pf >= 11) {
                        Toast.makeText(requireContext(), "Está aprobado. Su promedio es de: " + String.valueOf(pf), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(requireContext(), "Está desaprobado. Su promedio es de: " + String.valueOf(pf), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(requireContext(), "Primero debe calcular el promedio de las 3 unidades", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    public double calcularPromedioUnidad3(double pa6, double pa7, double ef) {
        return (pa6 * 0.30) + (pa7 * 0.40) + (ef * 0.30);
    }

    public double calcularPromedioFinal(double n1, double n2, double n3) {
        return (n1 * 0.30) + (n2 * 0.30) + (n3 * 0.40);
    }

}